package pe.devs.kmp.formvalidations.components

import androidx.compose.material.Switch
import androidx.compose.material.SwitchColors
import androidx.compose.material.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.ui.Alignment
import pe.devs.kmp.formvalidations.validation.exception.ValidationException
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
    colors: SwitchColors = SwitchDefaults.colors(),
    error: ValidationException? = null,
    onValueChange: ((String) -> Unit),
) {
    Column {
        Row(modifier = Modifier.padding(vertical = 4.dp)) {
            labelResource?.let {
                Text(
                    text = stringResource(it),
                    fontSize = 14.sp,
                    color = if (error == null) Color.Unspecified else MaterialTheme.colors.error,
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 8.dp)
                        .align(Alignment.CenterVertically)

                )
            }

            Switch(
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
    error?.let {
        Text(
            error.resolveMessage(),
            color = MaterialTheme.colors.error,
            fontSize = 12.sp,
            maxLines = 1,
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}
