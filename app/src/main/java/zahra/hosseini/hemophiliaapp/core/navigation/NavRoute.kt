package zahra.hosseini.hemophiliaapp.core.navigation

sealed class NavRoute(val path: String) {

    object Splash : NavRoute("splash")
    object Login : NavRoute("login")
    object Register : NavRoute("register")
    object Home : NavRoute("home")
    object Profile : NavRoute("profile")
    object Training : NavRoute("training")
    object Reminder : NavRoute("reminder")
    object RegisterBleeding : NavRoute("register_bleeding")
    object RegisterInjection : NavRoute("register_injection")
    object RegisterNotInjection : NavRoute("register_not_injection")
}