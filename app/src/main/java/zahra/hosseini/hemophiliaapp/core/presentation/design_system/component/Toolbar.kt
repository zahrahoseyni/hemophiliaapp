package zahra.hosseini.hemophiliaapp.core.presentation.design_system.component

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Backspace
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import zahra.hosseini.hemophiliaapp.R
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.theme.hemophiliaColors
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.theme.hemophiliaTypography

@Composable
fun Toolbar(title: String, showBackBtn: Boolean, onBackButtonClick: () -> Unit) {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {

        TopAppBar(
            title = {
                Text(
                    text = title, style = MaterialTheme.hemophiliaTypography.text16Medium,
                    color = MaterialTheme.hemophiliaColors.designSystem.OnPrimary,
                )
            },
            navigationIcon = {
                if (showBackBtn)
                    IconButton(onClick = { onBackButtonClick() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Back Btn",
                            modifier = Modifier
                                .rotate(180F)
                        )
                    }
            },
            backgroundColor = MaterialTheme.hemophiliaColors.designSystem.Primary,
            contentColor = MaterialTheme.hemophiliaColors.designSystem.OnPrimary,
            elevation = 2.dp,

            )
    }
}