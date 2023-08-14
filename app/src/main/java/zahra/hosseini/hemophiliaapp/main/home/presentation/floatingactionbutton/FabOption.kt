package zahra.hosseini.hemophiliaapp.main.home.presentation.floatingactionbutton

import android.annotation.SuppressLint
import androidx.compose.material3.MaterialTheme
import androidx.compose.material.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.Color
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.theme.hemophiliaColors

@Immutable
interface FabOption {
    @Stable val iconTint: Color
    @Stable val backgroundTint: Color
    @Stable val showLabel: Boolean
}

private class FabOptionImpl(
    override val iconTint: Color,
    override val backgroundTint: Color,
    override val showLabel: Boolean
) : FabOption

@SuppressLint("ComposableNaming")
@Composable
fun FabOption(
    backgroundTint: Color = MaterialTheme.hemophiliaColors.designSystem.Primary,
    iconTint: Color = contentColorFor(backgroundColor = backgroundTint),
    showLabel: Boolean = false
): FabOption = FabOptionImpl(iconTint, backgroundTint, showLabel)

















