package pe.devs.kmp.formvalidations.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.PopupProperties
import org.jetbrains.compose.resources.*
import pe.devs.kmp.formvalidations.icons.MaterialSymbols
import pe.devs.kmp.formvalidations.validation.exception.ValidationException

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun <T> DevsDropdownMenu(
    modifier: Modifier = Modifier.Companion,
    value: String,
    labelResource: StringResource,
    //labelColor: Color = Color.Unspecified,
    //textStyle: TextStyle = LocalTextStyle.current,
    colors: TextFieldColors = ExposedDropdownMenuDefaults.textFieldColors(),
    enabled: Boolean = true,
    iconColor: Color = Color.Unspecified,
    leadingIcon: ImageVector? = null,
    options: List<T>,
    keyAttr: (T) -> String,
    auxAttr: (T) -> String,
    labelAttr: (T) -> String,
    prependImage: ((T) -> DrawableResource)? = null,
    error: ValidationException? = null,
    onChange: (T) -> Unit,
    onFocus: (() -> Unit)? = null,
    onBlur: (() -> Unit)? = null,
) {
    var filterText by rememberSaveable { mutableStateOf(get(value, options, keyAttr, auxAttr)) }
    var lastValue by rememberSaveable { mutableStateOf(value) }
    var lastAux by rememberSaveable { mutableStateOf(filterText) }
    var expanded by remember { mutableStateOf(false) }
    var focusInCount by remember { mutableStateOf(0) }

    //Para cuando se setea el valor directamente
    if(value != lastValue) {
        filterText = get(value, options, keyAttr, auxAttr)
        lastValue = value
        lastAux = filterText
    }

    /*if (!expanded && lastValue != value) {
        filterText = getLabel(value, options, keyAttr, labelAttr)
    }*/

    // Effect to reset form when the screen is popped
    DisposableEffect(Unit) {
        onDispose {
            filterText = ""
            lastValue = ""
            lastAux = ""
            expanded = false
        }
    }

    Column {
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = {
                expanded = !expanded
                if (expanded) {
                    filterText = ""
                }
            },
        ) {
            TextField(
                modifier = modifier
                    .onFocusChanged {
                        //Si se hace click fuera sin seleccionar nada, o sin resultados
                        if (!it.hasFocus && options.find { x -> labelAttr(x) == filterText } == null) {
                            filterText = lastAux
                        }
                        if (it.hasFocus) {
                            focusInCount++
                        }
                        if (focusInCount > 0) {
                            if (it.hasFocus) {
                                if (onFocus != null) {
                                    onFocus()
                                }
                            } else {
                                if (onBlur != null) {
                                    onBlur()
                                }
                            }
                        }
                    },
                //label = { Text(text = stringResource(resource = labelResource), color = labelColor) },
                label = {
                    Text(
                        text = stringResource(resource = labelResource),
                        color = if (error == null) Color.Unspecified else MaterialTheme.colors.error
                    )
                },
                //textStyle = textStyle,
                enabled = enabled,
                colors = colors,
                value = filterText,
                readOnly = !expanded,
                singleLine = true,
                isError = error != null,
                onValueChange = {
                    filterText = it
                },
                leadingIcon =
                if (leadingIcon != null) {
                    {
                        Icon(
                            imageVector = leadingIcon,
                            contentDescription = null,
                            modifier = Modifier.size(24.dp),
                            tint = if (error == null) iconColor else MaterialTheme.colors.error
                        )
                    }
                } else null,
                trailingIcon = {
                    val imageVector = if (expanded) {
                        MaterialSymbols.Normal.rememberArrowDropUp()
                    } else {
                        MaterialSymbols.Normal.rememberArrowDropDown()
                    }

                    Icon(
                        imageVector = imageVector,
                        contentDescription = null,
                        tint = if (error == null) iconColor else MaterialTheme.colors.error
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

            DropdownMenu(
                expanded = expanded,
                properties = PopupProperties(focusable = false),
                modifier = modifier.exposedDropdownSize(),
                onDismissRequest = {
                    expanded = false
                },
            ) {
                filteredOptions.forEach { option ->
                    DropdownMenuItem(
                        content = {
                            prependImage?.let {
                                Image(
                                    painter = painterResource(prependImage(option)),
                                    contentDescription = null,
                                )
                                Spacer(modifier = Modifier.width(4.dp))
                            }
                            Text(
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
        error?.let {
            Text(
                error.resolveMessage(),
                color = MaterialTheme.colors.error,
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