package zahra.hosseini.hemophiliaapp.main.ui

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import zahra.hosseini.hemophiliaapp.core.navigation.NavGraph
import androidx.compose.material.*
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import zahra.hosseini.hemophiliaapp.R
import zahra.hosseini.hemophiliaapp.authentication.AuthenticationViewModel
import zahra.hosseini.hemophiliaapp.core.navigation.BottomBarNav
import zahra.hosseini.hemophiliaapp.core.navigation.NavRoute
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.component.Toolbar
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.theme.AppTheme
import zahra.hosseini.hemophiliaapp.main.ui.floatingactionbutton.FabIcon
import zahra.hosseini.hemophiliaapp.main.ui.floatingactionbutton.FabOption
import zahra.hosseini.hemophiliaapp.main.ui.floatingactionbutton.MultiFabItem
import zahra.hosseini.hemophiliaapp.main.ui.floatingactionbutton.MultiFloatingActionButton

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
            NavRoute.RegisterInjection.path -> stringResource(id = R.string.register_injection)
            NavRoute.Training.path -> stringResource(id = R.string.training)
            NavRoute.Reminder.path -> stringResource(id = R.string.reminder)
            NavRoute.FirstTrainingBlog.path -> stringResource(id = R.string.training_card_title1)
            NavRoute.SecondTrainingBlog.path -> stringResource(id = R.string.training_card_title2)
            NavRoute.ThirdTrainingBlog.path -> stringResource(id = R.string.training_card_title3)
            else -> {
                stringResource(id = R.string.app_name)
            }
        }
        val showBackIcon = when (currentRoute) {
            NavRoute.Home.path,
            NavRoute.Profile.path,
            NavRoute.Training.path,
            NavRoute.Reminder.path,
            -> false
            NavRoute.Register.path,
            NavRoute.RegisterBleeding.path,
            NavRoute.RegisterInjection.path,
            NavRoute.Login.path,
            NavRoute.FirstTrainingBlog.path,
            NavRoute.SecondTrainingBlog.path,
            NavRoute.ThirdTrainingBlog.path,
            -> true
            else -> {
                false
            }
        }

        Scaffold(topBar = {
            if (currentRoute == NavRoute.Splash.path) return@Scaffold
            else Toolbar(header = header, showBackBtn = showBackIcon) {}
        }, bottomBar = { BottomBarNav(navController = navController) }

        ) {
            NavGraph(
                navController = navController
            )
        }
    }

}


