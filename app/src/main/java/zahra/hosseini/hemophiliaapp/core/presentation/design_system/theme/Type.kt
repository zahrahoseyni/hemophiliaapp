package zahra.hosseini.hemophiliaapp.core.presentation.design_system.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import zahra.hosseini.hemophiliaapp.R

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    headlineLarge = TextStyle(
        fontFamily = FontFamily(Font(R.font.danaextrabold)),
        fontSize = 20.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily(Font(R.font.danaregular)),
        fontSize = 12.sp,
        color = Purple10
    ),
    titleSmall = TextStyle(
        fontFamily = FontFamily(Font(R.font.danabold)),
        fontSize = 12.sp,
        color = Gray25
    ),

)