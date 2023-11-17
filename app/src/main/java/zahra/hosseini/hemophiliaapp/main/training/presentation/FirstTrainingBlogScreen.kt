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
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.theme.hemophiliaColors
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.theme.hemophiliaTypography

@Composable
fun FirstTrainingBlogScreen() {
    val scrollState = rememberScrollState()
    val uriHandler = LocalUriHandler.current

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
                ) {
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
                            style = MaterialTheme.hemophiliaTypography.text16Bold,
                            color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                            textAlign = TextAlign.Justify,
                        )
                        Text(
                            text = stringResource(id = R.string.training_first_blog_text00),
                            style = MaterialTheme.hemophiliaTypography.text16,
                            color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                            textAlign = TextAlign.Justify,
                        )

                        Text(
                            text = stringResource(id = R.string.training_first_blog_text01),
                            style = MaterialTheme.hemophiliaTypography.text16Bold,
                            color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                            textAlign = TextAlign.Justify,
                            textDecoration = TextDecoration.Underline,
                            modifier = Modifier.clickable {
                                uriHandler.openUri("https://www.aparat.com/v/x9jYc")
                            }
                        )

                        Text(
                            text = stringResource(id = R.string.training_first_blog_text1),
                            style = MaterialTheme.hemophiliaTypography.text16,
                            color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                            textAlign = TextAlign.Justify,
                        )

                        Image(
                            modifier = Modifier
                                .height(200.dp)
                                .width(200.dp),
                            painter = painterResource(id = R.drawable.blogimg13),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                        )

                        Text(
                            text = stringResource(id = R.string.training_first_blog_text02),
                            style = MaterialTheme.hemophiliaTypography.text16Bold,
                            color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                            textAlign = TextAlign.Justify,
                        )

                        Image(
                            modifier = Modifier
                                .height(200.dp)
                                .width(200.dp),
                            painter = painterResource(id = R.drawable.blogimg14),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                        )

                        Text(
                            text = stringResource(id = R.string.training_first_blog_text03),
                            style = MaterialTheme.hemophiliaTypography.text16,
                            color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                            textAlign = TextAlign.Justify,
                        )
                        Text(
                            text = stringResource(id = R.string.training_first_blog_text2),
                            style = MaterialTheme.hemophiliaTypography.text16Bold,
                            color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                            textAlign = TextAlign.Justify,
                        )

                        Text(
                            text = stringResource(id = R.string.training_first_blog_text3),
                            style = MaterialTheme.hemophiliaTypography.text16,
                            color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                            textAlign = TextAlign.Justify,
                        )

                        Text(
                            text = stringResource(id = R.string.training_first_blog_text4),
                            style = MaterialTheme.hemophiliaTypography.text16,
                            color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                            textAlign = TextAlign.Justify,
                        )

                        Text(
                            text = stringResource(id = R.string.training_first_blog_text5),
                            style = MaterialTheme.hemophiliaTypography.text16,
                            color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                            textAlign = TextAlign.Justify,
                        )

                        Text(
                            text = stringResource(id = R.string.training_first_blog_text6),
                            style = MaterialTheme.hemophiliaTypography.text16Bold,
                            color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                            textAlign = TextAlign.Justify,
                        )

                        Image(
                            modifier = Modifier
                                .height(200.dp)
                                .width(200.dp),
                            painter = painterResource(id = R.drawable.blogimg12),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                        )
                        Text(
                            text = stringResource(id = R.string.training_first_blog_text7),
                            style = MaterialTheme.hemophiliaTypography.text16,
                            color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                            textAlign = TextAlign.Justify,
                        )
                        Text(
                            text = stringResource(id = R.string.training_first_blog_text04),
                            style = MaterialTheme.hemophiliaTypography.text16,
                            color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                            textAlign = TextAlign.Justify,
                        )
                        Text(
                            text = stringResource(id = R.string.training_first_blog_text05),
                            style = MaterialTheme.hemophiliaTypography.text16,
                            color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                            textAlign = TextAlign.Justify,
                            textDecoration = TextDecoration.Underline,
                            modifier = Modifier.clickable {
                                uriHandler.openUri("https://www.aparat.com/v/gHxzo")
                            }
                        )
                        Text(
                            text = stringResource(id = R.string.training_first_blog_text8),
                            style = MaterialTheme.hemophiliaTypography.text16Bold,
                            color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                            textAlign = TextAlign.Justify,
                        )
                        Text(
                            text = stringResource(id = R.string.training_first_blog_text9),
                            style = MaterialTheme.hemophiliaTypography.text16,
                            color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                            textAlign = TextAlign.Justify,
                        )

                        Text(
                            text = stringResource(id = R.string.training_first_blog_text06),
                            style = MaterialTheme.hemophiliaTypography.text16,
                            color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                            textAlign = TextAlign.Justify,
                            textDecoration = TextDecoration.Underline,
                            modifier = Modifier.clickable {
                                uriHandler.openUri("https://www.aparat.com/v/EUY7m")
                            }
                        )
                        Text(
                            text = stringResource(id = R.string.training_first_blog_text10),
                            style = MaterialTheme.hemophiliaTypography.text16Bold,
                            color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                            textAlign = TextAlign.Justify,
                        )
                        Text(
                            text = stringResource(id = R.string.training_first_blog_text11),
                            style = MaterialTheme.hemophiliaTypography.text16,
                            color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                            textAlign = TextAlign.Justify,
                        )
                        Text(
                            text = stringResource(id = R.string.training_first_blog_text14),
                            style = MaterialTheme.hemophiliaTypography.text16Bold,
                            color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                            textAlign = TextAlign.Justify,
                        )
                        Text(
                            text = stringResource(id = R.string.training_first_blog_text13),
                            style = MaterialTheme.hemophiliaTypography.text16Bold,
                            color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                            textAlign = TextAlign.Justify,
                        )
                        Text(
                            text = stringResource(id = R.string.training_first_blog_text14),
                            style = MaterialTheme.hemophiliaTypography.text16,
                            color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                            textAlign = TextAlign.Justify,
                        )
                        Text(
                            text = stringResource(id = R.string.training_first_blog_text15),
                            style = MaterialTheme.hemophiliaTypography.text16,
                            color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                            textAlign = TextAlign.Justify,
                        )
                        Text(
                            text = stringResource(id = R.string.training_first_blog_text16),
                            style = MaterialTheme.hemophiliaTypography.text16,
                            color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                            textAlign = TextAlign.Justify,
                        )
                        Text(
                            text = stringResource(id = R.string.training_first_blog_text07),
                            style = MaterialTheme.hemophiliaTypography.text16Bold,
                            color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                            textAlign = TextAlign.Justify,
                        )
                        Text(
                            text = stringResource(id = R.string.training_first_blog_text08),
                            style = MaterialTheme.hemophiliaTypography.text16,
                            color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                            textAlign = TextAlign.Justify,
                        )
                        Text(
                            text = stringResource(id = R.string.training_first_blog_text09),
                            style = MaterialTheme.hemophiliaTypography.text16,
                            color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                            textAlign = TextAlign.Justify,
                            textDecoration = TextDecoration.Underline,
                            modifier = Modifier.clickable {
                                uriHandler.openUri("https://www.aparat.com/v/tONAv")
                            }
                        )

                        Text(
                            text = stringResource(id = R.string.training_first_blog_text17),
                            style = MaterialTheme.hemophiliaTypography.text16Bold,
                            color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                            textAlign = TextAlign.Justify,
                        )

                        Text(
                            text = stringResource(id = R.string.training_first_blog_text177),
                            style = MaterialTheme.hemophiliaTypography.text16,
                            color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                            textAlign = TextAlign.Justify,
                        )
                        Text(
                            text = stringResource(id = R.string.training_first_blog_text18),
                            style = MaterialTheme.hemophiliaTypography.text16Bold,
                            color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                            textAlign = TextAlign.Justify,
                        )
                        Text(
                            text = stringResource(id = R.string.training_first_blog_text19),
                            style = MaterialTheme.hemophiliaTypography.text16,
                            color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                            textAlign = TextAlign.Justify,
                        )

                    }

                    Column(
                        verticalArrangement = Arrangement.spacedBy(5.dp),
                    ) {

                        Text(
                            text = stringResource(id = R.string.references_title),
                            style = MaterialTheme.hemophiliaTypography.text16Bold,
                            color = MaterialTheme.hemophiliaColors.designSystem.Neutral50,
                            textAlign = TextAlign.Justify,
                        )

                        Text(
                            text = stringResource(id = R.string.references_text11),
                            style = MaterialTheme.hemophiliaTypography.text16Medium,
                            color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                            textAlign = TextAlign.End,
                            textDecoration = TextDecoration.Underline,
                            modifier = Modifier.clickable {
                                uriHandler.openUri("https://doi.org/10.1056/nejm200106073442307")
                            }
                        )

                        Text(
                            text = stringResource(id = R.string.references_text12),
                            style = MaterialTheme.hemophiliaTypography.text16Medium,
                            color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                            textAlign = TextAlign.End,
                            textDecoration = TextDecoration.Underline,
                            modifier = Modifier.clickable {
                                uriHandler.openUri("https://doi.org/10.1111/j.1365-2516.2009.02127.x")
                            }
                        )

                        Text(
                            text = stringResource(id = R.string.references_text15),
                            style = MaterialTheme.hemophiliaTypography.text16Medium,
                            color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                            textAlign = TextAlign.End,
                            textDecoration = TextDecoration.Underline,
                            modifier = Modifier.clickable {
                                uriHandler.openUri("https://doi.org/10.2741/4324")
                            }
                        )

                        Text(
                            text = stringResource(id = R.string.references_text16),
                            style = MaterialTheme.hemophiliaTypography.text16Medium,
                            color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                            textAlign = TextAlign.End,
                            textDecoration = TextDecoration.Underline,
                            modifier = Modifier.clickable {
                                uriHandler.openUri("https://www.cdc.gov/ncbddd/hemophilia/facts.html")
                            }
                        )

                        Text(
                            text = stringResource(id = R.string.references_text17),
                            style = MaterialTheme.hemophiliaTypography.text16Medium,
                            color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                            textAlign = TextAlign.End,
                            textDecoration = TextDecoration.Underline,
                            modifier = Modifier.clickable {
                                uriHandler.openUri("https://www.nhs.uk/conditions/haemophilia/")
                            }
                        )

                        Text(
                            text = stringResource(id = R.string.references_text13),
                            style = MaterialTheme.hemophiliaTypography.text16Medium,
                            color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                            textAlign = TextAlign.Start,
                            textDecoration = TextDecoration.Underline,
                            modifier = Modifier.clickable {
                                uriHandler.openUri("https://treatment.thums.ac.ir/%D9%BE%D8%B1%D9%88%D8%AA%DA%A9%D9%84-%D8%AF%D8%B1%D9%85%D8%A7%D9%86-%D9%BE%DB%8C%D8%B4%DA%AF%DB%8C%D8%B1%D8%A7%D9%86%D9%87-%D9%87%D9%85%D9%88%D9%81%DB%8C%D9%84%DB%8C-%D8%B3%D8%A7%D9%84-98")
                            }
                        )

                        Text(
                            text = stringResource(id = R.string.references_text14),
                            style = MaterialTheme.hemophiliaTypography.text16Medium,
                            color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                            textAlign = TextAlign.Start,
                            textDecoration = TextDecoration.Underline,
                            modifier = Modifier.clickable {
                                uriHandler.openUri("https://vc-trethment.kums.ac.ir/fa/treatmentaffairsmanagement/specialdiseasesunit/beimarihaytahtposhesh/hemophilia")
                            }
                        )

                        Text(
                            text = stringResource(id = R.string.references_aparat),
                            style = MaterialTheme.hemophiliaTypography.text16Medium,
                            color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                            textAlign = TextAlign.End,
                            textDecoration = TextDecoration.Underline,
                            modifier = Modifier.clickable {
                                uriHandler.openUri("www.aparat.com")
                            }
                        )

                    }

                }
            }
        }
    }
}