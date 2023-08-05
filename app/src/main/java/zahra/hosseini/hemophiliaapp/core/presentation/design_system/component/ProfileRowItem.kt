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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import zahra.hosseini.hemophiliaapp.R
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.theme.hemophiliaColors
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.theme.hemophiliaTypography
import zahra.hosseini.hemophiliaapp.main.ui.RegisterBleeding

@Composable
fun ProfileRowItem(
    modifier: Modifier = Modifier, label: String, @DrawableRes iconRes: Int,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        horizontalAlignment = Alignment.End
    ) {

        Row(
            Modifier
                .wrapContentWidth()
                .padding(top = 16.dp, start = 16.dp, end = 16.dp),
            Arrangement.spacedBy(24.dp),
        ) {
            Text(
                text = label, style = MaterialTheme.hemophiliaTypography.text16Medium,
                color = MaterialTheme.hemophiliaColors.designSystem.Neutral40
            )

            Icon(
                painter = painterResource(id = iconRes),
                contentDescription = "Icon",
                tint = MaterialTheme.hemophiliaColors.designSystem.Neutral40,
            )


        }

        Divider(color = MaterialTheme.hemophiliaColors.designSystem.Neutral10, thickness = 1.dp)
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    ProfileRowItem(label = "زن", iconRes = R.drawable.ic_outline_group_add_24)
}