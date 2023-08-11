package zahra.hosseini.hemophiliaapp.main.ui.training

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import zahra.hosseini.hemophiliaapp.R
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.theme.hemophiliaColors
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.theme.hemophiliaTypography

@Composable
fun FirstTrainingBlogScreen() {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .background(color = MaterialTheme.hemophiliaColors.designSystem.Neutral00)
            .verticalScroll(state = scrollState)
            .fillMaxWidth()
            .wrapContentSize(Alignment.CenterEnd)
            .padding(top = 16.dp, bottom = 70.dp, start = 16.dp, end = 16.dp)
    ) {
        Box(
            modifier = Modifier
                .border(
                    width = 1.dp,
                    color = MaterialTheme.hemophiliaColors.designSystem.Neutral10,
                    shape = RoundedCornerShape(16.dp)
                )
                .padding(5.dp),
            contentAlignment = Alignment.CenterEnd
        ) {
            CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(5.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        modifier = Modifier
                            .wrapContentSize()
                            .wrapContentHeight(),
                        painter = painterResource(id = R.drawable.blogimg11),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                    )
                    Text(
                        text = stringResource(id = R.string.training_first_blog_title),
                        style = MaterialTheme.hemophiliaTypography.text12Bold,
                        color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                        textAlign = TextAlign.Justify,
                    )

                    Text(
                        text = stringResource(id = R.string.training_first_blog_text1),
                        style = MaterialTheme.hemophiliaTypography.text12,
                        color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                        textAlign = TextAlign.Justify,
                    )

                    Text(
                        text = stringResource(id = R.string.training_first_blog_text2),
                        style = MaterialTheme.hemophiliaTypography.text12Bold,
                        color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                        textAlign = TextAlign.Justify,
                    )

                    Text(
                        text = stringResource(id = R.string.training_first_blog_text3),
                        style = MaterialTheme.hemophiliaTypography.text12,
                        color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                        textAlign = TextAlign.Justify,
                    )

                    Text(
                        text = stringResource(id = R.string.training_first_blog_text4),
                        style = MaterialTheme.hemophiliaTypography.text12,
                        color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                        textAlign = TextAlign.Justify,
                    )

                    Text(
                        text = stringResource(id = R.string.training_first_blog_text5),
                        style = MaterialTheme.hemophiliaTypography.text12,
                        color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                        textAlign = TextAlign.Justify,
                    )

                    Text(
                        text = stringResource(id = R.string.training_first_blog_text6),
                        style = MaterialTheme.hemophiliaTypography.text12Bold,
                        color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                        textAlign = TextAlign.Justify,
                    )

                    Image(
                        modifier = Modifier
                            .wrapContentSize()
                            .wrapContentHeight(),
                        painter = painterResource(id = R.drawable.blogimg12),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                    )
                    Text(
                        text = stringResource(id = R.string.training_first_blog_text7),
                        style = MaterialTheme.hemophiliaTypography.text12,
                        color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                        textAlign = TextAlign.Justify,
                    )
                    Text(
                        text = stringResource(id = R.string.training_first_blog_text8),
                        style = MaterialTheme.hemophiliaTypography.text12Bold,
                        color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                        textAlign = TextAlign.Justify,
                    )
                    Text(
                        text = stringResource(id = R.string.training_first_blog_text9),
                        style = MaterialTheme.hemophiliaTypography.text12,
                        color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                        textAlign = TextAlign.Justify,
                    )
                    Text(
                        text = stringResource(id = R.string.training_first_blog_text10),
                        style = MaterialTheme.hemophiliaTypography.text12Bold,
                        color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                        textAlign = TextAlign.Justify,
                    )
                    Text(
                        text = stringResource(id = R.string.training_first_blog_text11),
                        style = MaterialTheme.hemophiliaTypography.text12,
                        color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                        textAlign = TextAlign.Justify,
                    )
                    Text(
                        text = stringResource(id = R.string.training_first_blog_text12),
                        style = MaterialTheme.hemophiliaTypography.text12Bold,
                        color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                        textAlign = TextAlign.Justify,
                    )
                    Text(
                        text = stringResource(id = R.string.training_first_blog_text13),
                        style = MaterialTheme.hemophiliaTypography.text12Bold,
                        color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                        textAlign = TextAlign.Justify,
                    )
                    Text(
                        text = stringResource(id = R.string.training_first_blog_text14),
                        style = MaterialTheme.hemophiliaTypography.text12,
                        color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                        textAlign = TextAlign.Justify,
                    )
                    Text(
                        text = stringResource(id = R.string.training_first_blog_text15),
                        style = MaterialTheme.hemophiliaTypography.text12,
                        color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                        textAlign = TextAlign.Justify,
                    )
                    Text(
                        text = stringResource(id = R.string.training_first_blog_text16),
                        style = MaterialTheme.hemophiliaTypography.text12,
                        color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                        textAlign = TextAlign.Justify,
                    )

                    Text(
                        text = stringResource(id = R.string.training_first_blog_text17),
                        style = MaterialTheme.hemophiliaTypography.text12,
                        color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                        textAlign = TextAlign.Justify,
                    )
                    Text(
                        text = stringResource(id = R.string.training_first_blog_text18),
                        style = MaterialTheme.hemophiliaTypography.text12Bold
                        ,
                        color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                        textAlign = TextAlign.Justify,
                    )
                    Text(
                        text = stringResource(id = R.string.training_first_blog_text19),
                        style = MaterialTheme.hemophiliaTypography.text12,
                        color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                        textAlign = TextAlign.Justify,
                    )


                }
            }
        }
    }
}