package zahra.hosseini.hemophiliaapp.main.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import zahra.hosseini.hemophiliaapp.core.navigation.NavGraph
import zahra.hosseini.hemophiliaapp.core.theme.NavComposeAppTheme

@Composable
fun MainScreen() {
    NavComposeAppTheme {
        val navController = rememberNavController()
        NavGraph(navController)
    }

}