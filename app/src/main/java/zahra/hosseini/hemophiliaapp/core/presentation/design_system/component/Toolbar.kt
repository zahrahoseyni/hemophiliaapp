package zahra.hosseini.hemophiliaapp.core.presentation.design_system.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.theme.hemophiliaColors
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.theme.hemophiliaTypography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Toolbar(header: String, showBackBtn: Boolean, onBackButtonClick: () -> Unit) {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {

        CenterAlignedTopAppBar(
            title = {
                Text(
                    text = header, style = MaterialTheme.hemophiliaTypography.text16Medium,
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
                                .wrapContentWidth()
                                .wrapContentHeight(),
                            tint = MaterialTheme.hemophiliaColors.designSystem.OnPrimary
                        )
                    }
            },
            colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = MaterialTheme.hemophiliaColors.designSystem.Primary),
            modifier = Modifier.fillMaxWidth()
        )
    }
}