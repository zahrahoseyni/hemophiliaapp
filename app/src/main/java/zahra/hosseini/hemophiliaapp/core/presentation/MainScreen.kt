package zahra.hosseini.hemophiliaapp.main.ui

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.os.Build
import androidx.activity.OnBackPressedCallback
import androidx.activity.compose.BackHandler
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import zahra.hosseini.hemophiliaapp.core.navigation.NavGraph
import androidx.compose.material.*
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import zahra.hosseini.hemophiliaapp.R
import zahra.hosseini.hemophiliaapp.core.navigation.BottomBarNav
import zahra.hosseini.hemophiliaapp.core.navigation.NavRoute
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.component.Toolbar
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.theme.AppTheme


@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    val context = LocalContext.current
    AppTheme {
        val navController = rememberNavController()
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        val header = when (currentRoute) {
            NavRoute.Login.path -> stringResource(id = R.string.login_with_number)
            NavRoute.Home.path -> stringResource(id = R.string.self_care_report)
            NavRoute.Profile.path -> stringResource(id = R.string.user_profile)
            NavRoute.Register.path -> stringResource(id = R.string.register)
            NavRoute.RegisterBleeding.path -> stringResource(id = R.string.register_bleeding)
            NavRoute.RegisterNotInjection.path -> stringResource(id = R.string.register_not_injection)
            NavRoute.RegisterInjection.path -> stringResource(id = R.string.register_injection)
            NavRoute.DoctorsPage.path -> stringResource(id = R.string.doctor_contact)
            NavRoute.Training.path -> stringResource(id = R.string.training)
            NavRoute.Reminder.path -> stringResource(id = R.string.reminder)
            NavRoute.FirstTrainingBlog.path -> stringResource(id = R.string.training_card_title1)
            NavRoute.SecondTrainingBlog.path -> stringResource(id = R.string.training_card_title2)
            NavRoute.ThirdTrainingBlog.path -> stringResource(id = R.string.training_card_title3)
            NavRoute.AboutUs.path -> stringResource(id = R.string.about_us)
            else -> {
                stringResource(id = R.string.app_name)
            }
        }
        val showBackIcon = when (currentRoute) {
            NavRoute.Home.path,
            NavRoute.Profile.path,
            NavRoute.Training.path,
            NavRoute.Reminder.path,
            NavRoute.Login.path,
            -> false
            NavRoute.Register.path,
            NavRoute.RegisterBleeding.path,
            NavRoute.RegisterInjection.path,
            NavRoute.RegisterNotInjection.path,
            NavRoute.FirstTrainingBlog.path,
            NavRoute.SecondTrainingBlog.path,
            NavRoute.ThirdTrainingBlog.path,
            NavRoute.AboutUs.path,
            NavRoute.DoctorsPage.path,
            -> true
            else -> {
                false
            }
        }

        Scaffold(topBar = {
            if (currentRoute == NavRoute.Splash.path) return@Scaffold
            else Toolbar(header = header, showBackBtn = showBackIcon) {
                if (currentRoute != null) {
                    handleBackPress(currentRoute, navController)
                }
            }
        }, bottomBar = { BottomBarNav(navController = navController) }

        ) {
            NavGraph(
                navController = navController
            )
        }
    }

}

fun handleBackPress(currentRoute: String, navController: NavHostController) {
    when (currentRoute) {
        NavRoute.FirstTrainingBlog.path,
        NavRoute.SecondTrainingBlog.path,
        NavRoute.ThirdTrainingBlog.path,
        NavRoute.Register.path,
        NavRoute.RegisterBleeding.path,
        NavRoute.RegisterInjection.path,
        NavRoute.RegisterNotInjection.path,
        NavRoute.DoctorsPage.path,
        NavRoute.AboutUs.path,
        -> navController.popBackStack()
    }
}


