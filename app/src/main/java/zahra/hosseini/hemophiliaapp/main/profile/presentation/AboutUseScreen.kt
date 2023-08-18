package zahra.hosseini.hemophiliaapp.main.profile.presentation

import android.graphics.Typeface
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.StyleSpan
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import zahra.hosseini.hemophiliaapp.R
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.theme.hemophiliaColors
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.theme.hemophiliaTypography

@Composable
fun AboutUseScreen(modifier: Modifier = Modifier) {

    val scrollState = rememberScrollState()
    val context = LocalContext.current

    Column(
        modifier = modifier
            //.background(color = MaterialTheme.hemophiliaColors.designSystem.Neutral00)
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
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        text = buildAnnotatedString {
                            append(stringResource(id = R.string.about_us_text1))
                            withStyle(
                                style = SpanStyle(
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.hemophiliaColors.designSystem.PrimaryText
                                )
                            ) {
                                append(stringResource(id = R.string.about_us_name))
                            }
                            append(stringResource(id = R.string.about_us_text2))


                        },
                        style = MaterialTheme.hemophiliaTypography.text14,
                        color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                        textAlign = TextAlign.Justify,
                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = stringResource(id = R.string.contact_us),
                        style = MaterialTheme.hemophiliaTypography.text14Medium,
                        color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                        textAlign = TextAlign.Start,
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Image(
                        modifier = Modifier
                            .wrapContentSize()
                            .wrapContentHeight(),
                        painter = painterResource(id = R.drawable.university_of_tehran_logo),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                    )

                }

            }
        }
    }
}

/*
fun String.changeStyleOfString(): String {
    val str = SpannableStringBuilder(this)
    str.setSpan(StyleSpan(Typeface.BOLD_ITALIC), 133, 146, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
    return str.toString()
}*/
