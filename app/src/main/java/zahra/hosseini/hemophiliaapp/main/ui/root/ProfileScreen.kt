package zahra.hosseini.hemophiliaapp.main.ui.root

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import zahra.hosseini.hemophiliaapp.R
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.component.ProfileRowItem
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.theme.hemophiliaColors

@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.user_avatar),
            contentDescription = "avatar",
            contentScale = ContentScale.Crop,            // crop the image if it's not a square
            modifier = Modifier
                .size(64.dp)
                .clip(CircleShape)                       // clip to the circle shape
                .border(
                    2.dp,
                    MaterialTheme.hemophiliaColors.designSystem.Neutral30,
                    CircleShape
                )
        )

        ProfileRowItem(label = "زن", iconRes = R.drawable.ic_outline_group_add_24)
        ProfileRowItem(label = "25", iconRes = R.drawable.ic_outline_group_add_24)
        ProfileRowItem(label = "60", iconRes = R.drawable.ic_outline_group_add_24)
        ProfileRowItem(label = "160", iconRes = R.drawable.ic_outline_group_add_24)


    }
}

@Preview(showBackground = true)
@Composable
fun BottomNavigationPreview() {
    ProfileScreen()
}