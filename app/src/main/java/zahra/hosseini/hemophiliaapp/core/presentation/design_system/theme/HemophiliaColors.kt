package zahra.hosseini.hemophiliaapp.core.presentation.design_system.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.ui.graphics.Color


data class HemophiliaColors(
    val material: ColorScheme,
    val designSystem: DesignSystem = DesignSystem(),
    val error: Color = Color.Red,
    val transparent: Color = Transparent,
)

data class DesignSystem(
    val Primary: Color = Purple00,
    val Primary00: Color = Purple00,
    val Primary05: Color = Purple05,
    val Primary10: Color = Purple10,
    val Primary15: Color = Purple15,
    val Primary20: Color = Purple20,
    val Primary25: Color = Purple25,

    val Secondary: Color = Gray40,

    val PrimaryBackground: Color = White,
    val OnPrimary: Color = White,

    val PrimaryIconTintColor: Color = White,

    val DefaultPositive: Color = Green,
    val DefaultNegative: Color = Red,


    val Neutral00: Color = Gray00,
    val Neutral05: Color = Gray05,
    val Neutral10: Color = Gray10,
    val Neutral15: Color = Gray15,
    val Neutral20: Color = Gray20,
    val Neutral25: Color = Gray25,
    val Neutral30: Color = Gray30,
    val Neutral35: Color = Gray35,
    val Neutral40: Color = Gray40,
    val Neutral45: Color = Gray45,
    val Neutral50: Color = Gray50,

    val PrimaryText: Color = Gray50,
    val SecondaryText: Color = Gray30,
    val DisabledText: Color = Gray20,
    val TertiaryText: Color = White,

    val tin: Color = Blue,
    val normal: Color = Green,
    val highWeight: Color = Yellow,
    val overWeight: Color = Orange,
    val fat: Color = Red,

    val action: Color = FunctionalSuccess,


)





