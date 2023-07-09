package zahra.hosseini.hemophiliaapp.core.bottomnav

import zahra.hosseini.hemophiliaapp.R

sealed class BottomNavItem(var title: String, var icon: Int, var screen_route: String) {

    object Home : BottomNavItem("Home", R.drawable.ic_home, "home")
    object Profile : BottomNavItem("Profile", R.drawable.ic_home, "profile")
    object Training : BottomNavItem("Training", R.drawable.ic_home, "training")
    object Notification : BottomNavItem("Notification", R.drawable.ic_home, "notification")
}