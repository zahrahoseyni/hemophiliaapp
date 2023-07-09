package zahra.hosseini.hemophiliaapp.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import zahra.hosseini.hemophiliaapp.authentication.login.ui.LoginScreen
import zahra.hosseini.hemophiliaapp.authentication.register.RegisterScreen
import zahra.hosseini.hemophiliaapp.main.ui.HomeScreen
import zahra.hosseini.hemophiliaapp.splashscreen.ui.SplashScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "splash"
    ) {
        addSplashScreen(navController, this)

        addLoginScreen(navController, this)

        addRegisterScreen(navController, this)

        addHomeScreen(navController, this)
    }
}

private fun addLoginScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(route = NavRoute.Login.path) {
        LoginScreen(
            navigateToHome = {
                navController.navigate(NavRoute.Home.path)
            },
            navigateToRegister = {
                navController.navigate(NavRoute.Register.path)
            }
        )
    }
}

private fun addSplashScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(route = NavRoute.Splash.path) {
        SplashScreen(
            navigateToLogin = {
                navController.navigate(NavRoute.Login.path)
            }
        )
    }
}

private fun addHomeScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(route = NavRoute.Home.path) {
        HomeScreen(
        )
    }
}

private fun addRegisterScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(route = NavRoute.Register.path) {
        RegisterScreen(
        )
    }
}