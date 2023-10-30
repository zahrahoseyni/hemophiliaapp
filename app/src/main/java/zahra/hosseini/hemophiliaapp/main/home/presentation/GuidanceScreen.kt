package zahra.hosseini.hemophiliaapp.main.home.presentation

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import zahra.hosseini.hemophiliaapp.R
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.theme.hemophiliaColors
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.theme.hemophiliaTypography

@Composable
fun GuidanceScreen(modifier: Modifier = Modifier) {

    val scrollState = rememberScrollState()
    val context = LocalContext.current

    Column(
        modifier = modifier
            .verticalScroll(state = scrollState)
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(16.dp)
    ) {
        Box(
            modifier = Modifier
                .border(
                    width = 1.dp,
                    color = MaterialTheme.hemophiliaColors.designSystem.Neutral10,
                    shape = RoundedCornerShape(16.dp)
                )
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(5.dp),
            contentAlignment = Alignment.CenterEnd
        ) {
            CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {

                Column(
                    verticalArrangement = Arrangement.spacedBy(5.dp),
                ) {

                    Text(
                        text = stringResource(id = R.string.guidance_text1),
                        style = MaterialTheme.hemophiliaTypography.text14,
                        color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                        textAlign = TextAlign.Justify,
                    )

                    Text(
                        text = stringResource(id = R.string.guidance_text2),
                        style = MaterialTheme.hemophiliaTypography.text14Bold,
                        color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                        textAlign = TextAlign.Start,
                    )
                    Text(
                        text = stringResource(id = R.string.guidance_text3),
                        style = MaterialTheme.hemophiliaTypography.text14,
                        color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                        textAlign = TextAlign.Justify,
                    )
                    Text(
                        text = stringResource(id = R.string.guidance_text4),
                        style = MaterialTheme.hemophiliaTypography.text14Bold,
                        color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                        textAlign = TextAlign.Start,
                    )
                    Text(
                        text = stringResource(id = R.string.guidance_text5),
                        style = MaterialTheme.hemophiliaTypography.text14,
                        color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                        textAlign = TextAlign.Justify,
                    )
                    Text(
                        text = stringResource(id = R.string.guidance_text6),
                        style = MaterialTheme.hemophiliaTypography.text14Bold,
                        color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                        textAlign = TextAlign.Start,
                    )
                    Text(
                        text = stringResource(id = R.string.guidance_text7),
                        style = MaterialTheme.hemophiliaTypography.text14,
                        color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                        textAlign = TextAlign.Justify,
                    )
                    Text(
                        text = stringResource(id = R.string.guidance_text8),
                        style = MaterialTheme.hemophiliaTypography.text14Bold,
                        color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                        textAlign = TextAlign.Start,
                    )
                    Text(
                        text = stringResource(id = R.string.guidance_text9),
                        style = MaterialTheme.hemophiliaTypography.text14,
                        color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                        textAlign = TextAlign.Justify,
                    )
                    Text(
                        text = stringResource(id = R.string.guidance_text10),
                        style = MaterialTheme.hemophiliaTypography.text14Bold,
                        color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                        textAlign = TextAlign.Start,
                    )
                    Text(
                        text = stringResource(id = R.string.guidance_text11),
                        style = MaterialTheme.hemophiliaTypography.text14,
                        color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                        textAlign = TextAlign.Justify,
                    )
                    Text(
                        text = stringResource(id = R.string.guidance_text12),
                        style = MaterialTheme.hemophiliaTypography.text14,
                        color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                        textAlign = TextAlign.Justify,
                    )

                }

            }
        }
    }
}
