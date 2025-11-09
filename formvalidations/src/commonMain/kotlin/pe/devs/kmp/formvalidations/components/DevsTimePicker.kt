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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DevsTimePicker(
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
    val nowTri = remember { TimeUtil.getCurrentLocalTimeTri(zoneId) }
    var selectedTri by remember { mutableStateOf(TimeUtil.parseIsoTimeToTri(value) ?: nowTri) }
    val formattedDate = if (value.isNotBlank()) TimeUtil.formatTo12Hour(value) ?: "" else ""

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

    //Text("selectedTime: $selectedTri")
    //Text("value (HH:MM): $value")

    if (showDialog) {
        Surface(
            modifier = Modifier.width(400.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                val is24Hour = false
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
                        showDialog = false
                    },
                    confirmButton = {
                        TextButton(
                            onClick = {
                                selectedTri = Triple(timePickerState.hour, timePickerState.minute, 0)
                                val newIso = TimeUtil.parseTriToIsoTime(selectedTri)
                                onValueChange(newIso)
                                showDialog = false
                            }
                        ) {
                            Text("OK", color = MaterialTheme.colorScheme.primary)
                        }
                    },
                    dismissButton = {
                        TextButton(
                            onClick = {
                                showDialog = false
                            }
                        ) {
                            Text("Cancel", color = MaterialTheme.colorScheme.primary)
                        }
                    }
                ) {
                    Text(
                        text = "Selecciona hora",
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

// Format selected time for display
fun formatTime2(hour: Int, minute: Int): String {
    val hourFormatted = hour.toString().padStart(2, '0')
    val minuteFormatted = minute.toString().padStart(2, '0')
    return "$hourFormatted:$minuteFormatted"
}