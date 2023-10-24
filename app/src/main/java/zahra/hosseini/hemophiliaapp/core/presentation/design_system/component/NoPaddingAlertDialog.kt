package zahra.hosseini.hemophiliaapp.core.presentation.design_system.component

import android.graphics.Color
import androidx.compose.foundation.layout.*
import androidx.compose.material.ContentAlpha
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.ProvideTextStyle
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItemDefaults.contentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.theme.hemophiliaColors
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.theme.hemophiliaTypography
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.theme.regularFont

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoPaddingAlertDialog(
    onDismissRequest: () -> Unit,
    modifier: Modifier = Modifier,
    title: @Composable (() -> Unit)? = null,
    text: @Composable (() -> Unit)? = null,
    confirmButton: @Composable () -> Unit,
    dismissButton: @Composable (() -> Unit)? = null,
    shape: Shape = MaterialTheme.shapes.medium,
    properties: DialogProperties = DialogProperties(),
) {
    Dialog(
        onDismissRequest = onDismissRequest,
        properties = properties
    ) {
        Surface(
            modifier = modifier,
            shape = shape,
            color = MaterialTheme.hemophiliaColors.designSystem.OnPrimary,
            contentColor = MaterialTheme.hemophiliaColors.designSystem.Neutral50
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                title?.let {
                    CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.high) {
                        ProvideTextStyle(
                            TextStyle(
                                color = MaterialTheme.hemophiliaColors.designSystem.OnPrimary,
                                fontFamily = regularFont,
                                fontSize = 12.sp
                            ), it
                        )
                    }
                }
                text?.let {
                    CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.high) {
                        val textStyle = MaterialTheme.typography.labelMedium
                        ProvideTextStyle(textStyle, it)
                    }
                }
                Box(
                    Modifier
                        .fillMaxWidth()
                        .padding(all = 8.dp)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.End,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        dismissButton?.invoke()
                        confirmButton()
                    }
                }
            }
        }
    }
}