package zahra.hosseini.hemophiliaapp.core.presentation.design_system.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.theme.hemophiliaColors
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.theme.hemophiliaTypography

@Composable
fun TrainingCard(
    title: String,
    cardBackgroundImg: Painter,
    modifier: Modifier = Modifier,
    onCardClicked: () -> Unit
) {
    OutlinedCard(
        border = BorderStroke(
            width = 1.dp,
            color = MaterialTheme.hemophiliaColors.designSystem.Neutral15
        ),
        modifier = modifier.clickable {
            onCardClicked()
        }
    ) {
        Column(horizontalAlignment = Alignment.End) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(size = 8.dp)),
                painter = cardBackgroundImg,
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
            Text(
                modifier = Modifier.padding(
                    start = 12.dp,
                    end = 12.dp,
                    top = 12.dp,
                    bottom = 16.dp
                ),
                text = title,
                style = MaterialTheme.hemophiliaTypography.text18Medium,
                color = MaterialTheme.hemophiliaColors.designSystem.PrimaryText,
            )
        }
    }

}