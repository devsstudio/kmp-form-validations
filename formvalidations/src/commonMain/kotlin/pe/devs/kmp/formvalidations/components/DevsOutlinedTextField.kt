package pe.devs.kmp.formvalidations.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun DevsOutlinedTextField(
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
    var focusInCount by remember { mutableStateOf(0) }
    val errorMessage = error?.invoke()

    Column {
        OutlinedTextField(
            modifier = modifier
                .onFocusChanged {
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
            value = value,
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
            onValueChange = {
                onValueChange(it)
            },
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

}