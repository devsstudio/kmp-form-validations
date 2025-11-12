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
import pe.devs.kmp.formvalidations.util.TimeUtil
import pe.devs.kmp.formvalidations.composableUtils.ComposableDateUtil
import kotlin.time.Clock
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalMaterial3Api::class, ExperimentalTime::class)
@Composable
fun DevsDatePicker(
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
    var showDialog by remember { mutableStateOf(false) }
    val nowMillis = remember { Clock.System.now().toEpochMilliseconds() }
    var selectedDate by remember { mutableStateOf(TimeUtil.parseIsoToUtcMillis(value) ?: nowMillis) }
    val formattedDate = if (value.isNotBlank()) ComposableDateUtil.formatDate(selectedDate, zoneId) else ""

    val interactionSource = remember { MutableInteractionSource() }
    val focusRequester = remember { FocusRequester() }

    val errorMessage = error?.invoke()

    LaunchedEffect(interactionSource) {
        interactionSource.interactions.collect { interaction ->
            when (interaction) {
                is FocusInteraction.Focus -> {
                    showDialog = true
                    if (onFocus != null) {
                        onFocus()
                    }
                }

                is PressInteraction.Press -> {
                    showDialog = true
                    if (onFocus != null) {
                        onFocus()
                    }
                }

                is FocusInteraction.Unfocus -> {
                    if (onBlur != null) {
                        onBlur()
                    }
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

    //Text("selectedDate: $selectedDate")
    //Text("value (UTC): $value")

    if (showDialog) {
        Surface(
            modifier = Modifier.width(400.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                // Show the DatePickerDialog when showDialog is true

                val limaOffsetMillis = TimeUtil.getCurrentOffset(zoneId)
                val adjustedMillis = selectedDate + limaOffsetMillis

                val datePickerState = rememberDatePickerState(
                    initialSelectedDateMillis = adjustedMillis,
                    initialDisplayedMonthMillis = adjustedMillis,
                )
                DatePickerDialog(
                    onDismissRequest = { showDialog = false },
                    confirmButton = {
                        TextButton(
                            onClick = {
                                if (datePickerState.selectedDateMillis != null) {
                                    val newDate = datePickerState.selectedDateMillis!! - limaOffsetMillis
                                    selectedDate = newDate
                                    onValueChange(TimeUtil.parseMillisToIso(newDate))
                                } else {
                                    onValueChange("")
                                }
                                showDialog = false
                            }
                        ) {
                            Text("OK", color = MaterialTheme.colorScheme.primary)
                        }
                    },
                    dismissButton = {
                        TextButton(
                            onClick = { showDialog = false }
                        ) {
                            Text("Cancel", color = MaterialTheme.colorScheme.primary)
                        }
                    }
                ) {
                    DatePicker(
                        state = datePickerState,
                        // Make DatePicker smaller
                        modifier = Modifier.sizeIn(maxWidth = 350.dp),
                    )
                }
            }
        }
    }
}