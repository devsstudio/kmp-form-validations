package pe.devs.kmp.formvalidations.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun DevsSwitch(
    modifier: Modifier = Modifier,
    value: String,
    labelResource: StringResource? = null,
    enabled: Boolean = true,
    colors: androidx.compose.material3.SwitchColors = androidx.compose.material3.SwitchDefaults.colors(),
    error: (@Composable () -> String?)? = null,
    onValueChange: ((String) -> Unit),
) {
    val errorMessage = error?.invoke()

    Column {
        Row(modifier = Modifier.padding(vertical = 4.dp)) {
            labelResource?.let {
                androidx.compose.material3.Text(
                    text = stringResource(it),
                    fontSize = 14.sp,
                    color = if (errorMessage == null) Color.Unspecified else MaterialTheme.colorScheme.error,
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 8.dp)
                        .align(Alignment.CenterVertically)

                )
            }

            androidx.compose.material3.Switch(
                checked = value.toBoolean(),
                onCheckedChange = { checked ->
                    onValueChange(checked.toString())
                },
                enabled = enabled,
                colors = colors,
                modifier = modifier.align(Alignment.CenterVertically),
            )
        }
    }
    errorMessage?.let {
        androidx.compose.material3.Text(
            text = it,
            color = MaterialTheme.colorScheme.error,
            fontSize = 12.sp,
            maxLines = 1,
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}