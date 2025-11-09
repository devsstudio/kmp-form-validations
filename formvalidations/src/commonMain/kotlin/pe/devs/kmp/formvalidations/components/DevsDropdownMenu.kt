package pe.devs.kmp.formvalidations.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.PopupProperties
import org.jetbrains.compose.resources.*
import pe.devs.kmp.formvalidations.icons.MaterialSymbols

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun <T> DevsDropdownMenu(
    modifier: Modifier = Modifier,
    value: String,
    labelResource: StringResource? = null,
    //labelColor: Color = Color.Unspecified,
    textStyle: TextStyle = androidx.compose.material3.LocalTextStyle.current,
    colors: TextFieldColors = ExposedDropdownMenuDefaults.textFieldColors(),
    enabled: Boolean = true,
    iconColor: Color = Color.Unspecified,
    leadingIcon: ImageVector? = null,
    options: List<T>,
    keyAttr: (T) -> String,
    auxAttr: (T) -> String,
    labelAttr: (T) -> String,
    prependImage: ((T) -> DrawableResource)? = null,
    error: (@Composable () -> String?)? = null,
    onChange: (T) -> Unit,
    onFocus: (() -> Unit)? = null,
    onBlur: (() -> Unit)? = null,
) {
    var filterText by rememberSaveable { mutableStateOf(get(value, options, keyAttr, auxAttr)) }
    var lastValue by rememberSaveable { mutableStateOf(value) }
    var lastAux by rememberSaveable { mutableStateOf(filterText) }
    var expanded by remember { mutableStateOf(false) }
    var focusInCount by remember { mutableStateOf(0) }

    if (value != lastValue) {
        filterText = get(value, options, keyAttr, auxAttr)
        lastValue = value
        lastAux = filterText
    }

    DisposableEffect(Unit) {
        onDispose {
            filterText = ""
            lastValue = ""
            lastAux = ""
            expanded = false
        }
    }

    val errorMessage = error?.invoke()

    Column {
        androidx.compose.material3.ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = {
                expanded = !expanded
                if (expanded) {
                    filterText = ""
                }
            },
        ) {
            androidx.compose.material3.TextField(
                modifier = modifier
                    .onFocusChanged {
                        if (!it.hasFocus && options.find { x -> labelAttr(x) == filterText } == null) {
                            filterText = lastAux
                        }
                        if (it.hasFocus) {
                            focusInCount++
                        }
                        if (focusInCount > 0) {
                            if (it.hasFocus) {
                                onFocus?.invoke()
                            } else {
                                onBlur?.invoke()
                            }
                        }
                    },
                label = labelResource?.let {
                    {
                        androidx.compose.material3.Text(
                            text = stringResource(resource = it),
                            color = if (errorMessage == null) Color.Unspecified else MaterialTheme.colorScheme.error
                        )
                    }
                },
                textStyle = textStyle,
                enabled = enabled,
                colors = colors,
                value = filterText,
                readOnly = !expanded,
                singleLine = true,
                isError = errorMessage != null,
                onValueChange = {
                    filterText = it
                },
                leadingIcon = leadingIcon?.let {
                    {
                        androidx.compose.material3.Icon(
                            imageVector = it,
                            contentDescription = null,
                            modifier = Modifier.size(24.dp),
                            tint = if (errorMessage == null) iconColor else MaterialTheme.colorScheme.error
                        )
                    }
                },
                trailingIcon = {
                    val imageVector = if (expanded) {
                        MaterialSymbols.Normal.rememberArrowDropUp()
                    } else {
                        MaterialSymbols.Normal.rememberArrowDropDown()
                    }
                    androidx.compose.material3.Icon(
                        imageVector = imageVector,
                        contentDescription = null,
                        tint = if (errorMessage == null) iconColor else MaterialTheme.colorScheme.error
                    )
                },
            )

            val filteredOptions =
                options.filter {
                    labelAttr(it).contains(
                        filterText,
                        ignoreCase = true
                    )
                }

            androidx.compose.material3.DropdownMenu(
                expanded = expanded,
                properties = PopupProperties(focusable = false),
                modifier = modifier.exposedDropdownSize(),
                onDismissRequest = {
                    expanded = false
                },
            ) {
                filteredOptions.forEach { option ->
                    androidx.compose.material3.DropdownMenuItem(
                        text = {
                            prependImage?.let {
                                Image(
                                    painter = painterResource(prependImage(option)),
                                    contentDescription = null,
                                )
                                Spacer(modifier = Modifier.width(4.dp))
                            }
                            androidx.compose.material3.Text(
                                text = labelAttr(option),
                            )
                        },
                        enabled = enabled,
                        onClick = {
                            filterText = auxAttr(option)
                            lastValue = keyAttr(option)
                            lastAux = filterText
                            onChange(option)
                            expanded = false
                        }
                    )
                }
            }
        }
        errorMessage?.let {
            androidx.compose.material3.Text(
                text = it,
                color = MaterialTheme.colorScheme.error,
                fontSize = 12.sp,
                maxLines = 1,
            )
        }
    }
}

fun <T> get(value: String, options: List<T>, keyAttr: (T) -> String, callback: (T) -> String): String {
    val found = options.find { x -> keyAttr(x) == value }
    return if (found != null) {
        callback(found)
    } else {
        ""
    }
}
