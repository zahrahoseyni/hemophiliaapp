package zahra.hosseini.hemophiliaapp.main.ui.root

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import zahra.hosseini.hemophiliaapp.R
import zahra.hosseini.hemophiliaapp.core.presentation.MainActivity
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.component.TrainingCard
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.theme.hemophiliaColors

@Composable
fun TrainingScreen(
    navigateToFirstTrainingBlog: () -> Unit,
    navigateToSecondTrainingBlog: () -> Unit,
    navigateToThirdTrainingBlog: () -> Unit,
) {
    val scrollState = rememberScrollState()
    val context = LocalContext.current

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
            .background(color = MaterialTheme.hemophiliaColors.designSystem.Neutral05)
            .verticalScroll(state = scrollState)
            .fillMaxWidth()
            .padding(top = 16.dp, bottom = 70.dp, start = 16.dp, end = 16.dp)

    ) {
        TrainingCard(
            stringResource(id = R.string.training_card_title1),
            painterResource(id = R.drawable.image1)
        ) {
            navigateToFirstTrainingBlog()
        }

        TrainingCard(
            stringResource(id = R.string.training_card_title2),
            painterResource(id = R.drawable.image2)
        ) {
            navigateToSecondTrainingBlog()
        }

        TrainingCard(
            stringResource(id = R.string.training_card_title3),
            painterResource(id = R.drawable.image3)
        ) {
            navigateToThirdTrainingBlog()
        }

    }

    BackHandler(enabled = true) {
        (context as MainActivity).onBackPress()
    }
}