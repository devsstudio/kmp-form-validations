package pe.devs.kmp.formvalidations.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun DevsLinkButton(
    textResource: StringResource,
    color: Color = Color.Blue,
    onClick: () -> Unit
) {
    androidx.compose.material3.Button(
        onClick = onClick,
        colors = androidx.compose.material3.ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            contentColor = color,
            disabledContainerColor = Color.Transparent,
            disabledContentColor = color
        ),
        elevation = androidx.compose.material3.ButtonDefaults.elevatedButtonElevation(
            defaultElevation = 0.dp,
            pressedElevation = 0.dp,
            hoveredElevation = 0.dp,
            focusedElevation = 0.dp
        ),
        contentPadding = androidx.compose.material3.ButtonDefaults.ContentPadding,
        modifier = Modifier.pointerHoverIcon(PointerIcon.Hand),
    ) {
        androidx.compose.material3.Text(
            text = stringResource(textResource),
            color = color,
            style = TextStyle(
                fontSize = 16.sp
            )
            //textDecoration = TextDecoration.Underline
        )
    }
}