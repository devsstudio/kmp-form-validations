package pe.devs.kmp.formvalidations.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource
import pe.devs.kmp.formvalidations.icons.MaterialSymbols
import pe.devs.kmp.formvalidations.validation.exception.ValidationException
import pe.devs.kmp.formvalidations.formvalidations.generated.resources.Res
import pe.devs.kmp.formvalidations.formvalidations.generated.resources.labels_hide_password
import pe.devs.kmp.formvalidations.formvalidations.generated.resources.labels_show_password

@Composable
fun DevsPasswordField (
    modifier: Modifier = Modifier.Companion,
    value: String,
    labelResource: StringResource,
    //labelColor: Color = Color.Unspecified,
    //textStyle: TextStyle = LocalTextStyle.current,
    //placeholderColor: Color = Color.Unspecified,
    colors: TextFieldColors = TextFieldDefaults.textFieldColors(),
    singleLine: Boolean = true,
    enabled: Boolean = true,
    iconColor: Color = Color.Unspecified,
    leadingIcon: ImageVector? = null,
    error: ValidationException? = null,
    onValueChange: (String) -> Unit,
    onFocus: (() -> Unit)? = null,
    onBlur: (() -> Unit)? = null,
) {
    var systemPasswordVisible by remember { mutableStateOf(false) }
    var focusInCount by remember { mutableStateOf(0) }

    Column {
        TextField(
            modifier = modifier
                .onFocusChanged {
                    if(it.hasFocus) {
                        focusInCount++
                    }
                    if (focusInCount > 0) {
                        if(it.hasFocus) {
                            if(onFocus != null) {
                                onFocus()
                            }
                        }else{
                            if(onBlur != null) {
                                onBlur()
                            }
                        }
                    }
                },
            value = value,
            //label = { Text(text = stringResource(resource = labelResource), color = labelColor) },
            label = {
                Text(
                    text = stringResource(resource = labelResource),
                    color = if (error == null) Color.Unspecified else MaterialTheme.colors.error
                )
            },
            //textStyle = textStyle,
            singleLine = singleLine,
            enabled = enabled,
            //placeholder = { Text(text = "e.g. *******", color = placeholderColor) },
            placeholder = { Text(text = "e.g. *******") },
            colors = colors,
            isError = error != null,
            visualTransformation = if (systemPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
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
                val image = if (systemPasswordVisible)
                    MaterialSymbols.Normal.rememberVisibility()
                else MaterialSymbols.Normal.rememberVisibilityOff()

                // Localized description for accessibility services
                val description =
                    if (systemPasswordVisible) Res.string.labels_hide_password else Res.string.labels_show_password

                // Toggle button to hide or display password
                IconButton(
                    modifier = Modifier.pointerHoverIcon(PointerIcon.Hand),
                    onClick = { systemPasswordVisible = !systemPasswordVisible }
                ) {
                    Icon(
                        imageVector = image,
                        contentDescription = stringResource(resource = description),
                        modifier = Modifier.width(16.dp),
                        tint = if (error == null) iconColor else MaterialTheme.colors.error
                    )
                }
            },
            onValueChange = {
                onValueChange(it)
            },
        )
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