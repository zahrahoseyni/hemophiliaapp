package zahra.hosseini.hemophiliaapp.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import zahra.hosseini.hemophiliaapp.authentication.presentation.LoginScreen
import zahra.hosseini.hemophiliaapp.authentication.presentation.RegisterScreen
import zahra.hosseini.hemophiliaapp.main.ui.*
import zahra.hosseini.hemophiliaapp.main.ui.root.HomeScreen
import zahra.hosseini.hemophiliaapp.main.ui.root.ProfileScreen
import zahra.hosseini.hemophiliaapp.splashscreen.ui.SplashScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = NavRoute.Splash.path
    ) {
        addSplashScreen(navController, this)

        addLoginScreen(navController, this)

        addRegisterScreen(navController, this)

        addHomeScreen(navController, this)

        addProfileScreen(navController, this)

        addTrainingScreen(navController, this)

        addReminderScreen(navController, this)

        addRegisterBleedingScreen(navController, this)

        addRegisterInjectionScreen(navController, this)
    }
}

private fun addLoginScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder,
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
    navGraphBuilder: NavGraphBuilder,
) {
    navGraphBuilder.composable(route = NavRoute.Splash.path) {
        SplashScreen(
            navigateToLogin = {
                navController.navigate(NavRoute.Login.path)
            },
            navigateToHome = {
                navController.navigate(NavRoute.Home.path)
            }
        )
    }
}

private fun addHomeScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder,
) {
    navGraphBuilder.composable(route = NavRoute.Home.path) {
        HomeScreen(
            navigateToRegisterBleeding = {
                navController.navigate(NavRoute.RegisterBleeding.path)
            },
            navigateToRegisterInjection = {
                navController.navigate(NavRoute.RegisterInjection.path)

            }
        )
    }
}

private fun addProfileScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder,
) {
    navGraphBuilder.composable(route = NavRoute.Profile.path) {
        ProfileScreen(
        )
    }
}


private fun addRegisterScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder,
) {
    navGraphBuilder.composable(route = NavRoute.Register.path) {
        RegisterScreen(
            navigateToHome = {
                navController.navigate(NavRoute.Home.path)
            }
        )
    }
}

private fun addTrainingScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder,
) {
    navGraphBuilder.composable(route = NavRoute.Training.path) {
        TrainingScreen(
        )
    }
}

private fun addReminderScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder,
) {
    navGraphBuilder.composable(route = NavRoute.Reminder.path) {
        ReminderScreen(
        )
    }
}

private fun addRegisterBleedingScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder,
) {
    navGraphBuilder.composable(route = NavRoute.RegisterBleeding.path) {
        RegisterBleeding()
    }
}

private fun addRegisterInjectionScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder,
) {
    navGraphBuilder.composable(route = NavRoute.RegisterInjection.path) {
        RegisterInjection()
    }
}