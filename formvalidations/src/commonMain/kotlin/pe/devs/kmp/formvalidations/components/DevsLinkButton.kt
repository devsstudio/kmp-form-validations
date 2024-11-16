package pe.devs.kmp.formvalidations.components

import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
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
    onClick: () -> Unit) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Transparent,
            contentColor = color,
            disabledBackgroundColor = Color.Transparent,
            disabledContentColor = color
        ),
        elevation = ButtonDefaults.elevation(
            defaultElevation = 0.dp,
            pressedElevation = 0.dp,
            hoveredElevation = 0.dp,
            focusedElevation = 0.dp
        ),
        contentPadding = ButtonDefaults.ContentPadding,
        modifier = Modifier.pointerHoverIcon(PointerIcon.Hand),
    ) {
        Text(
            text = stringResource(textResource),
            color = color,
            style = TextStyle(
                fontSize = 16.sp
            )
            //textDecoration = TextDecoration.Underline
        )
    }
}