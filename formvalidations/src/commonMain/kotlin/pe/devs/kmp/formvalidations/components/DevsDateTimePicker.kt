package pe.devs.kmp.formvalidations.components

import androidx.compose.foundation.interaction.FocusInteraction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.datetime.TimeZone
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource
import pe.devs.kmp.formvalidations.formvalidations.generated.resources.Res
import pe.devs.kmp.formvalidations.formvalidations.generated.resources.label_select_date
import pe.devs.kmp.formvalidations.formvalidations.generated.resources.label_select_hour
import pe.devs.kmp.formvalidations.formvalidations.generated.resources.labels_cancel
import pe.devs.kmp.formvalidations.formvalidations.generated.resources.labels_ok
import pe.devs.kmp.formvalidations.util.TimeUtil
import pe.devs.kmp.formvalidations.composableUtils.ComposableDateUtil

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DevsDateTimePicker(
    modifier: Modifier = Modifier.Companion,
    value: String,
    labelResource: StringResource? = null,
    //labelColor: Color = Color.Unspecified,
    textStyle: TextStyle = LocalTextStyle.current,
    placeholderResource: StringResource? = null,
    //placeholderColor: Color = Color.Unspecified,
    colors: TextFieldColors = TextFieldDefaults.colors(),
    singleLine: Boolean = true,
    enabled: Boolean = true,
    iconColor: Color = Color.Unspecified,
    leadingIcon: ImageVector? = null,
    error: (@Composable () -> String?)? = null,
    onValueChange: (String) -> Unit,
    onFocus: (() -> Unit)? = null,
    onBlur: (() -> Unit)? = null,
) {
    val zoneId = TimeZone.currentSystemDefault().id
    var showDialog1 by remember { mutableStateOf(false) }
    var showDialog2 by remember { mutableStateOf(false) }
    var selectedUtcMillis: Long? by remember { mutableStateOf(null) }

    val limaOffsetMillis = TimeUtil.getCurrentOffset(zoneId)
    //Fecha a mostrar, se calcula directamente del value
    val formattedDate =
        if (value.isNotBlank()) ComposableDateUtil.formatDateTime(
            TimeUtil.parseIsoToUtcMillis(value),
            zoneId
        ) else ""

    val interactionSource = remember { MutableInteractionSource() }
    val focusRequester = remember { FocusRequester() }

    val errorMessage = error?.invoke()

    LaunchedEffect(interactionSource) {
        interactionSource.interactions.collect { interaction ->
            when (interaction) {
                is FocusInteraction.Focus,
                is PressInteraction.Press -> {
                    showDialog1 = true
                    onFocus?.invoke()
                }

                is FocusInteraction.Unfocus -> {
                    onBlur?.invoke()
                }

                else -> {}
            }
        }
    }

    Column {
        TextField(
            modifier = modifier
                .focusRequester(focusRequester),
            value = formattedDate,
            //label = { Text(text = stringResource(resource = labelResource)) },
            label = if (labelResource != null) {
                {
                    Text(
                        text = stringResource(resource = labelResource),
                        color = if (errorMessage == null) Color.Unspecified else MaterialTheme.colorScheme.error
                    )
                }
            } else null,
            textStyle = textStyle,
            /*placeholder = {
                Text(text = placeholderResource?.let { stringResource(resource = it) } ?: "",
                    color = if(isError)MaterialTheme.colors.error else Color.Unspecified )
            },*/
            placeholder = {
                Text(text = placeholderResource?.let { stringResource(resource = it) } ?: "")
            },
            readOnly = true,
            interactionSource = interactionSource,
            singleLine = singleLine,
            enabled = enabled,
            colors = colors,
            isError = errorMessage != null,
            leadingIcon =
                if (leadingIcon != null) {
                    {
                        Icon(
                            imageVector = leadingIcon,
                            contentDescription = null,
                            modifier = Modifier.size(24.dp),
                            tint = if (errorMessage == null) iconColor else MaterialTheme.colorScheme.error
                        )
                    }
                } else null,
            onValueChange = {}
        )
        errorMessage?.let {
            Text(
                text = it,
                color = MaterialTheme.colorScheme.error,
                fontSize = 12.sp,
                maxLines = 1,
            )
        }
    }

    //Text("selectedDate: $selectedUtcMillis")
    //Text("value (UTC): $value")

    if (showDialog1 || showDialog2) {

        Surface(
            modifier = Modifier.width(400.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                // Show the DatePickerDialog when showDialog is true
                if (showDialog1) {
                    //Se calcula directo del value
                    val adjustedMillis =
                        (TimeUtil.parseIsoToUtcMillis(value) ?: TimeUtil.getCurrentUTCMillis()) + limaOffsetMillis

                    val datePickerState = rememberDatePickerState(
                        initialSelectedDateMillis = adjustedMillis,
                        initialDisplayedMonthMillis = adjustedMillis,
                    )
                    DatePickerDialog(
                        onDismissRequest = {
                            showDialog1 = false
                        },
                        confirmButton = {
                            TextButton(
                                onClick = {
                                    datePickerState.selectedDateMillis?.let {
                                        val newDate = it - limaOffsetMillis
                                        selectedUtcMillis = newDate
                                    }
                                    showDialog1 = false
                                    showDialog2 = true
                                }
                            ) {
                                Text(stringResource(Res.string.labels_ok), color = MaterialTheme.colorScheme.primary)
                            }
                        },
                        dismissButton = {
                            TextButton(
                                onClick = {
                                    showDialog1 = false
                                }
                            ) {
                                Text(
                                    stringResource(Res.string.labels_cancel),
                                    color = MaterialTheme.colorScheme.primary
                                )
                            }
                        }
                    ) {
                        DatePicker(
                            title = {
                                Text(
                                    text = stringResource(Res.string.label_select_date),
                                    style = MaterialTheme.typography.labelLarge,
                                    modifier = Modifier.padding(16.dp)
                                )
                            },
                            state = datePickerState,
                            // Make DatePicker smaller
                            modifier = Modifier.sizeIn(maxWidth = 350.dp)
                        )
                    }
                }
                if (showDialog2) {
                    val is24Hour = false
                    //En este punto podemos estar seguros selectedUtcMillis tiene valor porque para que aparezca el dialog2 se debe haber elegido una fecha antes
                    val nowUtcMillis = TimeUtil.getCurrentUTCMillis()
                    var selectedTri = TimeUtil.parseUtcMillisToLocalTimeTri(
                        TimeUtil.parseIsoToUtcMillis(value) ?: nowUtcMillis,
                        zoneId
                    )

                    // State for time picker
                    val timePickerState = rememberTimePickerState(
                        initialHour = selectedTri.first, // Use a value > 12 to test 24-hour format
                        initialMinute = selectedTri.second,
                        is24Hour = is24Hour
                    )

                    // Determine layout type
                    val layoutType = TimePickerLayoutType.Vertical

                    DatePickerDialog(
                        onDismissRequest = {
                            showDialog2 = false
                        },
                        confirmButton = {
                            TextButton(
                                onClick = {
                                    selectedTri = Triple(timePickerState.hour, timePickerState.minute, 0)
                                    val timeInMillis = TimeUtil.parseTriToMillis(selectedTri)
                                    // Sumar el tiempo a la fecha seleccionada
                                    selectedUtcMillis = selectedUtcMillis!! + timeInMillis

                                    // Convertir a formato ISO y propagar el cambio
                                    val newIso = TimeUtil.parseMillisToIso(selectedUtcMillis!!)
                                    onValueChange(newIso)

                                    showDialog2 = false
                                }
                            ) {
                                Text(stringResource(Res.string.labels_ok), color = MaterialTheme.colorScheme.primary)
                            }
                        },
                        dismissButton = {
                            TextButton(
                                onClick = {
                                    showDialog2 = false
                                }
                            ) {
                                Text(
                                    stringResource(Res.string.labels_cancel),
                                    color = MaterialTheme.colorScheme.primary
                                )
                            }
                        }
                    ) {
                        Text(
                            text = stringResource(Res.string.label_select_hour),
                            style = MaterialTheme.typography.labelLarge,
                            modifier = Modifier.padding(16.dp)
                        )
                        TimePicker(
                            state = timePickerState,
                            modifier = Modifier.fillMaxWidth(),
                            layoutType = layoutType
                        )
                    }
                }
            }
        }
    }
}