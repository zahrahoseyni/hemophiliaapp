package zahra.hosseini.hemophiliaapp.main.ui

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import zahra.hosseini.hemophiliaapp.core.navigation.NavGraph
import androidx.compose.material.*
import androidx.compose.ui.tooling.preview.Preview
import zahra.hosseini.hemophiliaapp.core.navigation.BottomBarNav
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.theme.AppTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    AppTheme {
        val navController = rememberNavController()

        Scaffold(
            bottomBar = { BottomBarNav(navController = navController) }
        ) {
            NavGraph(
                navController = navController
            )
        }
    }

}


@Preview(showBackground = true)
@Composable
fun BottomNavigationPreview() {
    MainScreen()
}
