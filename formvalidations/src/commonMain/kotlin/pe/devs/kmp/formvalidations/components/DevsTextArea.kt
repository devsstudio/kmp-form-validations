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
fun DevsTextArea(
    modifier: Modifier = Modifier,
    value: String,
    labelResource: StringResource? = null,
    placeholderResource: StringResource? = null,
    textStyle: TextStyle = LocalTextStyle.current,
    colors: TextFieldColors = TextFieldDefaults.colors(),
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
        TextField(
            modifier = modifier.onFocusChanged {
                if (it.hasFocus) {
                    focusInCount++
                    onFocus?.invoke()
                } else if (focusInCount > 0) {
                    onBlur?.invoke()
                }
            },
            value = value,
            onValueChange = onValueChange,
            label = labelResource?.let {
                {
                    Text(
                        text = stringResource(resource = it),
                        color = if (errorMessage == null) Color.Unspecified else MaterialTheme.colorScheme.error
                    )
                }
            },
            placeholder = placeholderResource?.let {
                { Text(text = stringResource(resource = it)) }
            },
            textStyle = textStyle,
            enabled = enabled,
            isError = errorMessage != null,
            singleLine = false, // Aquí lo hacemos multilinea
            maxLines = 6,       // Puedes ajustar este número según lo que necesites
            leadingIcon = leadingIcon?.let {
                {
                    Icon(
                        imageVector = it,
                        contentDescription = null,
                        modifier = Modifier.size(24.dp),
                        tint = if (errorMessage == null) iconColor else MaterialTheme.colorScheme.error
                    )
                }
            },
            colors = colors
        )

        errorMessage?.let {
            Text(
                text = it,
                color = MaterialTheme.colorScheme.error,
                fontSize = 12.sp,
                maxLines = 2,
            )
        }
    }
}
