package pe.devs.kmp.formvalidations.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource
import pe.devs.kmp.formvalidations.validation.exception.ValidationException

@Composable
fun DevsTextField(
    modifier: Modifier = Modifier.Companion,
    value: String,
    labelResource: StringResource,
    //labelColor: Color = Color.Unspecified,
    //textStyle: TextStyle = LocalTextStyle.current,
    placeholderResource: StringResource? = null,
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
            //label = { Text(text = stringResource(resource = labelResource)) },
            label = {
                Text(
                    text = stringResource(resource = labelResource),
                    color = if (error == null) Color.Unspecified else MaterialTheme.colors.error
                )
            },
            //textStyle = textStyle,
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
            isError = error != null,
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
