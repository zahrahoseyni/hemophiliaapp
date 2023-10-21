package zahra.hosseini.hemophiliaapp.core.presentation.design_system.component

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.theme.hemophiliaColors
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.theme.hemophiliaTypography
import zahra.hosseini.hemophiliaapp.main.reminder.data.model.ReminderEntity

@Composable
fun ReminderItemComponent(modifier: Modifier = Modifier, reminderModel: ReminderEntity) {

    Column(verticalArrangement = Arrangement.Center, modifier = modifier.fillMaxWidth()) {

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 16.dp,
                    end = 16.dp,
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
/*            Text(
                text = reportModel.bleedingReason.ifEmpty { "ــ" },
                style = MaterialTheme.hemophiliaTypography.text14,
                color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                textAlign = TextAlign.End
            )*/
            Text(
                text = reminderModel.reminderTime,
                style = MaterialTheme.hemophiliaTypography.text14,
                color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                textAlign = TextAlign.Justify
            )
            Text(
                text = reminderModel.reminderType,
                style = MaterialTheme.hemophiliaTypography.text14,
                color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                textAlign = TextAlign.Justify
            )
            Text(
                text = reminderModel.reminderTitle,
                style = MaterialTheme.hemophiliaTypography.text14,
                color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                textAlign = TextAlign.Justify
            )
        }

        Divider(
            color = MaterialTheme.hemophiliaColors.designSystem.Neutral10,
            thickness = 1.dp,
            modifier = Modifier.padding(top = 12.dp, bottom = 12.dp)
        )
    }
}