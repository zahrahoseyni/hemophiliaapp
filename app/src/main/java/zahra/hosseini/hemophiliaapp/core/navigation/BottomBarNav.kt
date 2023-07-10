package zahra.hosseini.hemophiliaapp.core.bottomnav

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import zahra.hosseini.hemophiliaapp.core.navigation.NavRoute

@Composable
fun BottomBarNav(navController: NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    if (currentRoute == null || currentRoute == NavRoute.Login.path) {
        return
    }

    BottomNavigation {

        val homeSelected = currentRoute == NavRoute.Home.path
        BottomNavigationItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = NavRoute.Home.path
                )
            },
            selected = homeSelected,
            onClick = {
                if(!homeSelected) {
                    navController.navigate(NavRoute.Home.path) {
                        popUpTo(NavRoute.Home.path) { inclusive = true }
                    }
                }
            },
            label = {Text(NavRoute.Home.path)}
        )

        val profileSelected = currentRoute == NavRoute.Profile.path
        BottomNavigationItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = NavRoute.Profile.path
                )
            },
            selected = profileSelected,
            onClick = {
                if(!profileSelected) {
                    navController.navigate(NavRoute.Profile.path) {
                        popUpTo(NavRoute.Profile.path) { inclusive = true }
                    }
                }
            },
            label = {Text(NavRoute.Profile.path)}
        )
    }
}