package zahra.hosseini.hemophiliaapp.core.presentation.design_system.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.theme.hemophiliaColors
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.theme.hemophiliaTypography

@Composable
fun ProfileRowItem(
    modifier: Modifier = Modifier, label: String, @DrawableRes iconRes: Int,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight().padding(16.dp)
    ) {

        Box(Modifier.fillMaxWidth().padding(8.dp)) {
            Text(
                text = label, style = MaterialTheme.hemophiliaTypography.text16Medium,
                color = MaterialTheme.hemophiliaColors.designSystem.Neutral40,
                modifier = Modifier.align(Alignment.Center)
            )

            Icon(
                painter = painterResource(id = iconRes),
                contentDescription = "Icon",
                tint = MaterialTheme.hemophiliaColors.designSystem.Neutral40,
                modifier = Modifier.align(Alignment.CenterEnd)
            )
        }

        Divider(color = MaterialTheme.hemophiliaColors.designSystem.Neutral25, thickness = 1.dp)
    }
}