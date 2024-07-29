package pe.devs.kmp.formvalidations.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.AlertDialog
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource
import pe.devs.kmp.formvalidations.formvalidations.generated.resources.Res
import pe.devs.kmp.formvalidations.formvalidations.generated.resources.labels_cancel
import pe.devs.kmp.formvalidations.formvalidations.generated.resources.labels_confirm
import pe.devs.kmp.formvalidations.formvalidations.generated.resources.labels_ok


//https://medium.com/@dheerubhadoria/jetpack-compose-ui-alert-dialog-example-code-26240fc19811
@Composable
fun DevsConfirmDialog(
    dialogTitle: StringResource,
    dialogText: String,
    icon: ImageVector? = null, // Parámetro opcional para el icono
    onConfirmation: () -> Unit,
    onDismissRequest: () -> Unit,
) {
    AlertDialog(
        title = {
            Text(text = stringResource(dialogTitle))
        },
        text = {
            Row {
                if (icon != null) {
                    Icon(
                        imageVector = icon,
                        contentDescription = null,
                        modifier = Modifier.size(24.dp), // Tamaño del icono
                    )
                }
                Text(text = dialogText)
            }
        },
        onDismissRequest = {
            onDismissRequest()
        },
        confirmButton = {
            TextButton(
                onClick = {
                    onConfirmation()
                }
            ) {
                Text(text = stringResource(Res.string.labels_confirm))
            }
        },
        dismissButton = {
            TextButton(
                onClick = {
                    onDismissRequest()
                }
            ) {
                Text(text = stringResource(Res.string.labels_cancel))
            }
        }
    )
}

@Composable
fun DevsAlertDialog(
    dialogTitle: StringResource,
    dialogText: String,
    icon: ImageVector? = null, // Parámetro opcional para el icono
    onDismissRequest: () -> Unit,
) {
    AlertDialog(
        title = {
            Row(Modifier.fillMaxWidth()) {
                Spacer(modifier = Modifier.padding(5.dp))
                if (icon != null) {
                    Icon(
                        imageVector = icon,
                        contentDescription = null,
                        modifier = Modifier.size(24.dp), // Tamaño del icono
                    )
                }
                Text(text = stringResource(dialogTitle))
            }
        },
        text = {
            Column(Modifier.fillMaxWidth()) {

                Text(text = dialogText)
            }
        },
        onDismissRequest = {
            onDismissRequest()
        },
        confirmButton = {
            TextButton(
                onClick = {
                    onDismissRequest()
                }
            ) {
                Text(text = stringResource(Res.string.labels_ok))
            }
        },
        dismissButton = null
    )
}