package zahra.hosseini.hemophiliaapp.core.navigation

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import zahra.hosseini.hemophiliaapp.R
import zahra.hosseini.hemophiliaapp.core.navigation.NavRoute
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.theme.hemophiliaColors
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.theme.hemophiliaTypography

@Composable
fun BottomBarNav(navController: NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    if (currentRoute == null || currentRoute == NavRoute.Login.path ||
        currentRoute == NavRoute.Register.path || currentRoute == NavRoute.Splash.path ||
        currentRoute == NavRoute.RegisterInjection.path || currentRoute == NavRoute.RegisterBleeding.path
    ) {
        return
    }

    BottomNavigation(backgroundColor = MaterialTheme.hemophiliaColors.designSystem.Primary) {

        val profileSelected = currentRoute == NavRoute.Profile.path
        BottomNavigationItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = NavRoute.Profile.path
                )
            },
            selected = profileSelected,
            selectedContentColor = MaterialTheme.hemophiliaColors.designSystem.PrimaryIconTintColor,
            unselectedContentColor = MaterialTheme.hemophiliaColors.designSystem.Neutral10,
            onClick = {
                if (!profileSelected) {
                    navController.navigate(NavRoute.Profile.path) {
                        popUpTo(NavRoute.Profile.path) { inclusive = true }
                    }
                }
            },
            label = {
                Text(
                    text = stringResource(id = R.string.profile),
                    style = MaterialTheme.hemophiliaTypography.text12,
                    color = MaterialTheme.hemophiliaColors.designSystem.OnPrimary,
                )
            }
        )

        val trainingSelected = currentRoute == NavRoute.Training.path
        BottomNavigationItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = NavRoute.Training.path
                )
            },
            selected = trainingSelected,
            selectedContentColor = MaterialTheme.hemophiliaColors.designSystem.PrimaryIconTintColor,
            unselectedContentColor = MaterialTheme.hemophiliaColors.designSystem.Neutral10,
            onClick = {
                if (!trainingSelected) {
                    navController.navigate(NavRoute.Training.path) {
                        popUpTo(NavRoute.Training.path) { inclusive = true }
                    }
                }
            },
            label = {
                Text(
                    text = stringResource(id = R.string.training),
                    style = MaterialTheme.hemophiliaTypography.text12,
                    color = MaterialTheme.hemophiliaColors.designSystem.OnPrimary,
                )
            }
        )

        val reminderSelected = currentRoute == NavRoute.Reminder.path
        BottomNavigationItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = NavRoute.Reminder.path
                )
            },
            selected = reminderSelected,
            selectedContentColor = MaterialTheme.hemophiliaColors.designSystem.PrimaryIconTintColor,
            unselectedContentColor = MaterialTheme.hemophiliaColors.designSystem.Neutral10,
            onClick = {
                if (!reminderSelected) {
                    navController.navigate(NavRoute.Reminder.path) {
                        popUpTo(NavRoute.Reminder.path) { inclusive = true }
                    }
                }
            },
            label = {
                Text(
                    text = stringResource(id = R.string.reminder),
                    style = MaterialTheme.hemophiliaTypography.text12,
                    color = MaterialTheme.hemophiliaColors.designSystem.OnPrimary,
                )
            }
        )

        val homeSelected = currentRoute == NavRoute.Home.path
        BottomNavigationItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = NavRoute.Home.path
                )
            },
            selected = homeSelected,
            selectedContentColor = MaterialTheme.hemophiliaColors.designSystem.PrimaryIconTintColor,
            unselectedContentColor = MaterialTheme.hemophiliaColors.designSystem.Neutral10,
            onClick = {
                if (!homeSelected) {
                    navController.navigate(NavRoute.Home.path) {
                        popUpTo(NavRoute.Home.path) { inclusive = true }
                    }
                }
            },
            label = {
                Text(
                    text = stringResource(id = R.string.home),
                    style = MaterialTheme.hemophiliaTypography.text12,
                    color = MaterialTheme.hemophiliaColors.designSystem.OnPrimary,
                )
            }
        )

    }
}