package zahra.hosseini.hemophiliaapp.main.home.presentation.floatingactionbutton

import androidx.annotation.DrawableRes

data class MultiFabItem(
    val id: Int,
    @DrawableRes val iconRes: Int,
    val label: String = ""
)
