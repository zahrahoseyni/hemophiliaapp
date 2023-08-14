package zahra.hosseini.hemophiliaapp.main.training.presentation

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
fun SecondTrainingBlogScreen() {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .background(color = MaterialTheme.hemophiliaColors.designSystem.Neutral00)
            .verticalScroll(state = scrollState)
            .fillMaxWidth()
            .fillMaxHeight()
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
                        painter = painterResource(id = R.drawable.blogimg21),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                    )

                    Text(
                        text = stringResource(id = R.string.training_second_blog_title),
                        style = MaterialTheme.hemophiliaTypography.text12Bold,
                        color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                        textAlign = TextAlign.Justify,
                    )

                    Text(
                        text = stringResource(id = R.string.training_second_blog_text1),
                        style = MaterialTheme.hemophiliaTypography.text12,
                        color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                        textAlign = TextAlign.Justify,
                    )

                    Text(
                        text = stringResource(id = R.string.training_second_blog_text2),
                        style = MaterialTheme.hemophiliaTypography.text12Bold,
                        color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                        textAlign = TextAlign.Justify,
                    )
                    Image(
                        modifier = Modifier
                            .wrapContentSize()
                            .wrapContentHeight(),
                        painter = painterResource(id = R.drawable.blogimg22),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        alignment = Alignment.Center
                    )

                    Text(
                        text = stringResource(id = R.string.training_second_blog_text3),
                        style = MaterialTheme.hemophiliaTypography.text12,
                        color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                        textAlign = TextAlign.Justify,
                    )


                    Text(
                        text = stringResource(id = R.string.training_second_blog_text4),
                        style = MaterialTheme.hemophiliaTypography.text12Bold,
                        color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                        textAlign = TextAlign.Justify,
                    )

                    Image(
                        modifier = Modifier
                            .wrapContentSize()
                            .wrapContentHeight(),
                        painter = painterResource(id = R.drawable.blogimg23),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        alignment = Alignment.Center
                    )
                    Image(
                        modifier = Modifier
                            .wrapContentSize()
                            .wrapContentHeight(),
                        painter = painterResource(id = R.drawable.blogimg24),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        alignment = Alignment.Center
                    )


                    Text(
                        text = stringResource(id = R.string.training_second_blog_text5),
                        style = MaterialTheme.hemophiliaTypography.text12,
                        color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                        textAlign = TextAlign.Justify,
                    )

                    Text(
                        text = stringResource(id = R.string.training_second_blog_text6),
                        style = MaterialTheme.hemophiliaTypography.text12Bold,
                        color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                        textAlign = TextAlign.End,
                    )


                    Image(
                        modifier = Modifier
                            .wrapContentSize()
                            .wrapContentHeight(),
                        painter = painterResource(id = R.drawable.blogimg25),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        alignment = Alignment.Center
                    )
                    Image(
                        modifier = Modifier
                            .wrapContentSize()
                            .wrapContentHeight(),
                        painter = painterResource(id = R.drawable.blogimg26),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        alignment = Alignment.Center
                    )

                    Text(
                        text = stringResource(id = R.string.training_second_blog_text7),
                        style = MaterialTheme.hemophiliaTypography.text12,
                        color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                        textAlign = TextAlign.Justify,
                    )
                }

            }
        }
    }
}