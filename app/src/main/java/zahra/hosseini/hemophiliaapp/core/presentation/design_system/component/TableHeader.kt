package zahra.hosseini.hemophiliaapp.core.presentation.design_system.component

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import zahra.hosseini.hemophiliaapp.R
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.theme.hemophiliaColors
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.theme.hemophiliaTypography

@Composable
fun TableHeader(modifier: Modifier = Modifier) {

    Column(verticalArrangement = Arrangement.Center, modifier = modifier.fillMaxWidth()) {

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = modifier
                .fillMaxWidth()
                .padding(
                    start = 16.dp,
                    end = 16.dp,
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {

   /*         Text(
                text = stringResource(id = R.string.bleeding_reason),
                style = MaterialTheme.hemophiliaTypography.text16Bold,
                color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
            )*/
            Text(
                text = stringResource(id = R.string.injection),
                style = MaterialTheme.hemophiliaTypography.text16Bold,
                color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
            )
            Text(
                text = stringResource(id = R.string.bleeding),
                style = MaterialTheme.hemophiliaTypography.text16Bold,
                color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
            )
            Text(
                text = stringResource(id = R.string.date),
                style = MaterialTheme.hemophiliaTypography.text16Bold,
                color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
            )
        }

        Divider(
            color = MaterialTheme.hemophiliaColors.designSystem.Neutral10,
            thickness = 1.dp,
            modifier = Modifier.padding(top = 12.dp, bottom = 12.dp)
        )
    }
}