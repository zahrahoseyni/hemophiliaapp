package zahra.hosseini.hemophiliaapp.core.presentation.design_system.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import zahra.hosseini.hemophiliaapp.R

val regularFont = FontFamily(Font(R.font.danaregular))
val boldFont = FontFamily(Font(R.font.danabold))
val mediumFont = FontFamily(Font(R.font.danamedium))
val extraBoldFont = FontFamily(Font(R.font.danaextrabold))

data class HemophiliaTypography(
    val material: Typography,
    val text8: TextStyle = TextStyle(
        fontFamily = regularFont,
        fontSize = 8.sp
    ),
    val text10: TextStyle = TextStyle(
        fontFamily = regularFont,
        fontSize = 10.sp
    ),
    val text10Bold: TextStyle = TextStyle(
        fontFamily = boldFont,
        fontSize = 10.sp,
        fontWeight = FontWeight.Bold

    ),
    val text12: TextStyle = TextStyle(
        fontFamily = regularFont,
        fontSize = 12.sp
    ),
    val text12Bold: TextStyle = TextStyle(
        fontFamily = boldFont,
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold
    ),
    val text12Medium: TextStyle = TextStyle(
        fontFamily = mediumFont,
        fontSize = 12.sp,
        fontWeight = FontWeight.Medium
    ),
    val text14: TextStyle = TextStyle(
        fontFamily = regularFont,
        fontSize = 14.sp
    ),
    val text14Bold: TextStyle = TextStyle(
        fontFamily = boldFont,
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold
    ),
    val text14Medium: TextStyle = TextStyle(
        fontFamily = mediumFont,
        fontSize = 14.sp,
        fontWeight = FontWeight.Medium
    ),
    val text16Medium: TextStyle = TextStyle(
        fontFamily = mediumFont,
        fontSize = 16.sp,
        fontWeight = FontWeight.Medium
    ),
    val text16Bold: TextStyle = TextStyle(
        fontFamily = boldFont,
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
    ),
    val text18Bold: TextStyle = TextStyle(
        fontFamily = boldFont,
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold
    ),
    val text18Medium: TextStyle = TextStyle(
        fontFamily = mediumFont,
        fontSize = 18.sp,
        fontWeight = FontWeight.Medium
    ),
    val text18: TextStyle = TextStyle(
        fontFamily = regularFont,
        fontSize = 18.sp,
    ),
    val text20Medium: TextStyle = TextStyle(
        fontFamily = mediumFont,
        fontSize = 20.sp,
        fontWeight = FontWeight.Medium
    ),
    val text22Bold: TextStyle = TextStyle(
        fontFamily = boldFont,
        fontSize = 22.sp,
        fontWeight = FontWeight.Bold
    ),
)
