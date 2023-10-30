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
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import zahra.hosseini.hemophiliaapp.R
import zahra.hosseini.hemophiliaapp.core.navigation.NavRoute
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.theme.hemophiliaColors
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.theme.hemophiliaTypography

@Composable
fun ThirdTrainingBlogScreen() {
    val scrollState = rememberScrollState()
    val uriHandler = LocalUriHandler.current
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
                            .height(200.dp)
                            .width(300.dp),
                        painter = painterResource(id = R.drawable.blogimg31),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                    )

                    Text(
                        text = stringResource(id = R.string.training_third_blog_title),
                        style = MaterialTheme.hemophiliaTypography.text14Bold,
                        color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                        textAlign = TextAlign.Justify,
                    )

                    Text(
                        text = stringResource(id = R.string.training_third_blog_text1),
                        style = MaterialTheme.hemophiliaTypography.text14,
                        color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                        textAlign = TextAlign.Justify,
                    )

                    Text(
                        text = stringResource(id = R.string.training_third_blog_text2),
                        style = MaterialTheme.hemophiliaTypography.text14Bold,
                        color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                        textAlign = TextAlign.Justify,
                    )
                    Image(
                        modifier = Modifier
                            .height(200.dp)
                            .width(300.dp),
                        painter = painterResource(id = R.drawable.blogimg32),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        alignment = Alignment.Center
                    )

                    Text(
                        text = stringResource(id = R.string.training_third_blog_text3),
                        style = MaterialTheme.hemophiliaTypography.text14,
                        color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                        textAlign = TextAlign.Justify,
                    )


                    Text(
                        text = stringResource(id = R.string.training_third_blog_text4),
                        style = MaterialTheme.hemophiliaTypography.text14Bold,
                        color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                        textAlign = TextAlign.Justify,
                    )

                    Image(
                        modifier = Modifier
                            .height(200.dp)
                            .width(200.dp),
                        painter = painterResource(id = R.drawable.blogimg33),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        alignment = Alignment.Center
                    )

                    Text(
                        text = stringResource(id = R.string.training_third_blog_text00),
                        style = MaterialTheme.hemophiliaTypography.text14,
                        color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                        textAlign = TextAlign.Justify,
                    )

                    Text(
                        text = stringResource(id = R.string.training_third_blog_text01),
                        style = MaterialTheme.hemophiliaTypography.text14Bold,
                        color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                        textAlign = TextAlign.Justify,
                    )

                    Text(
                        text = stringResource(id = R.string.training_third_blog_text5),
                        style = MaterialTheme.hemophiliaTypography.text14,
                        color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                        textAlign = TextAlign.Justify,
                    )


                    Text(
                        text = stringResource(id = R.string.training_third_blog_text02),
                        style = MaterialTheme.hemophiliaTypography.text14,
                        color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                        textAlign = TextAlign.Justify,
                    )
                    Text(
                        text = stringResource(id = R.string.training_third_blog_text03),
                        style = MaterialTheme.hemophiliaTypography.text14,
                        color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                        textAlign = TextAlign.Justify,
                    )
                    Text(
                        text = stringResource(id = R.string.training_third_blog_text04),
                        style = MaterialTheme.hemophiliaTypography.text14,
                        color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                        textAlign = TextAlign.Justify,
                    )
                    Text(
                        text = stringResource(id = R.string.training_third_blog_text05),
                        style = MaterialTheme.hemophiliaTypography.text14,
                        color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                        textAlign = TextAlign.Justify,
                    )
                    Text(
                        text = stringResource(id = R.string.training_third_blog_text06),
                        style = MaterialTheme.hemophiliaTypography.text14,
                        color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                        textAlign = TextAlign.Justify,
                    )
                    Text(
                        text = stringResource(id = R.string.training_third_blog_text07),
                        style = MaterialTheme.hemophiliaTypography.text14,
                        color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                        textAlign = TextAlign.Justify,
                    )
                    Text(
                        text = stringResource(id = R.string.training_third_blog_text08),
                        style = MaterialTheme.hemophiliaTypography.text14,
                        color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                        textAlign = TextAlign.Justify,
                    )

                    Text(
                        text = stringResource(id = R.string.training_third_blog_text09),
                        style = MaterialTheme.hemophiliaTypography.text14,
                        color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                        textAlign = TextAlign.Justify,
                    )

                    Text(
                        text = stringResource(id = R.string.training_third_blog_text6),
                        style = MaterialTheme.hemophiliaTypography.text14Bold,
                        color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                        textAlign = TextAlign.End,
                    )


                    Image(
                        modifier = Modifier
                            .height(200.dp)
                            .width(400.dp),
                        painter = painterResource(id = R.drawable.blogimg34),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        alignment = Alignment.Center
                    )


                    Text(
                        text = stringResource(id = R.string.training_third_blog_text7),
                        style = MaterialTheme.hemophiliaTypography.text14,
                        color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                        textAlign = TextAlign.Justify,
                    )

                    Text(
                        text = stringResource(id = R.string.training_third_blog_text10),
                        style = MaterialTheme.hemophiliaTypography.text14Bold,
                        color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                        textAlign = TextAlign.Justify,
                    )
                    Text(
                        text = stringResource(id = R.string.training_third_blog_text11),
                        style = MaterialTheme.hemophiliaTypography.text14,
                        color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                        textAlign = TextAlign.Justify,
                    )
                    Text(
                        text = stringResource(id = R.string.training_third_blog_text12),
                        style = MaterialTheme.hemophiliaTypography.text14,
                        color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                        textAlign = TextAlign.Justify,
                    )
                    Text(
                        text = stringResource(id = R.string.training_third_blog_text13),
                        style = MaterialTheme.hemophiliaTypography.text14,
                        color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                        textAlign = TextAlign.Justify,
                    )
                    Text(
                        text = stringResource(id = R.string.training_third_blog_text15),
                        style = MaterialTheme.hemophiliaTypography.text14,
                        color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                        textAlign = TextAlign.Justify,
                    )
                    Text(
                        text = stringResource(id = R.string.training_third_blog_text16),
                        style = MaterialTheme.hemophiliaTypography.text14,
                        color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                        textAlign = TextAlign.Justify,
                    )
                    Text(
                        text = stringResource(id = R.string.training_third_blog_text17),
                        style = MaterialTheme.hemophiliaTypography.text14,
                        color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                        textAlign = TextAlign.Justify,
                    )
                    Text(
                        text = stringResource(id = R.string.training_third_blog_text18),
                        style = MaterialTheme.hemophiliaTypography.text14,
                        color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                        textAlign = TextAlign.Justify,
                    )
                    Text(
                        text = stringResource(id = R.string.training_third_blog_text19),
                        style = MaterialTheme.hemophiliaTypography.text14,
                        color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                        textAlign = TextAlign.Justify,
                    )
                    Text(
                        text = stringResource(id = R.string.training_third_blog_text20),
                        style = MaterialTheme.hemophiliaTypography.text14,
                        color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                        textAlign = TextAlign.Justify,
                    )
                    Text(
                        text = stringResource(id = R.string.training_third_blog_text21),
                        style = MaterialTheme.hemophiliaTypography.text14,
                        color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                        textAlign = TextAlign.Justify,
                    )
                    Text(
                        text = stringResource(id = R.string.training_third_blog_text22),
                        style = MaterialTheme.hemophiliaTypography.text14,
                        color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                        textAlign = TextAlign.Justify,
                    )
                    Text(
                        text = stringResource(id = R.string.training_third_blog_text23),
                        style = MaterialTheme.hemophiliaTypography.text14,
                        color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                        textAlign = TextAlign.Justify,
                    )
                    Text(
                        text = stringResource(id = R.string.training_third_blog_text24),
                        style = MaterialTheme.hemophiliaTypography.text14,
                        color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                        textAlign = TextAlign.Justify,
                    )
                    Text(
                        text = stringResource(id = R.string.training_third_blog_text25),
                        style = MaterialTheme.hemophiliaTypography.text14,
                        color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                        textAlign = TextAlign.Justify,
                    )
                    Text(
                        text = stringResource(id = R.string.training_third_blog_text26),
                        style = MaterialTheme.hemophiliaTypography.text14,
                        color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                        textAlign = TextAlign.Justify,
                    )
                    Text(
                        text = stringResource(id = R.string.training_third_blog_text27),
                        style = MaterialTheme.hemophiliaTypography.text14,
                        color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                        textAlign = TextAlign.Justify,
                    )
                    Text(
                        text = stringResource(id = R.string.training_third_blog_text28),
                        style = MaterialTheme.hemophiliaTypography.text14,
                        color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                        textAlign = TextAlign.Justify,
                    )
                    Text(
                        text = stringResource(id = R.string.training_third_blog_text29),
                        style = MaterialTheme.hemophiliaTypography.text14,
                        color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                        textAlign = TextAlign.Justify,
                    )
                    Text(
                        text = stringResource(id = R.string.training_third_blog_text30),
                        style = MaterialTheme.hemophiliaTypography.text14,
                        color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                        textAlign = TextAlign.Justify,
                    )
                    Text(
                        text = stringResource(id = R.string.training_third_blog_text31),
                        style = MaterialTheme.hemophiliaTypography.text14,
                        color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                        textAlign = TextAlign.Justify,
                    )

                    Text(
                        text = stringResource(id = R.string.training_third_blog_text32),
                        style = MaterialTheme.hemophiliaTypography.text14,
                        color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                        textAlign = TextAlign.Justify,
                    )

                    Text(
                        text = stringResource(id = R.string.training_third_blog_text33),
                        style = MaterialTheme.hemophiliaTypography.text14,
                        color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                        textAlign = TextAlign.Justify,
                    )
                    Text(
                        text = stringResource(id = R.string.training_third_blog_text34),
                        style = MaterialTheme.hemophiliaTypography.text14,
                        color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                        textAlign = TextAlign.Justify,
                    )
                    Text(
                        text = stringResource(id = R.string.training_third_blog_text35),
                        style = MaterialTheme.hemophiliaTypography.text14,
                        color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                        textAlign = TextAlign.Justify,
                    )

                    Text(
                        text = stringResource(id = R.string.references_title),
                        style = MaterialTheme.hemophiliaTypography.text16Bold,
                        color = MaterialTheme.hemophiliaColors.designSystem.Neutral50,
                        textAlign = TextAlign.Justify,
                    )

                    Text(
                        text = stringResource(id = R.string.references_text31),
                        style = MaterialTheme.hemophiliaTypography.text14Medium,
                        color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                        textAlign = TextAlign.Justify,
                        textDecoration = TextDecoration.Underline,
                    )

                    Text(
                        text = stringResource(id = R.string.references_text32),
                        style = MaterialTheme.hemophiliaTypography.text14Medium,
                        color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                        textAlign = TextAlign.Start,
                        textDecoration = TextDecoration.Underline,
                        modifier = Modifier.clickable {
                            uriHandler.openUri("https://namazi.sums.ac.ir/page-Behdasht/fa/86/dorsaetoolsenews/57768-G0/%D8%AE%D9%88%D8%AF%D9%85%D8%B1%D8%A7%D9%82%D8%A8%D8%AA%DB%8C-%D8%AF%D8%B1-%D9%87%D9%85%D9%88%D9%81%DB%8C%D9%84%DB%8C")
                        }
                    )

                    Text(
                        text = stringResource(id = R.string.references_text33),
                        style = MaterialTheme.hemophiliaTypography.text14Medium,
                        color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                        textAlign = TextAlign.Start,
                    )
                }

            }
        }
    }
}