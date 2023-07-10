package zahra.hosseini.hemophiliaapp.main.ui

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import zahra.hosseini.hemophiliaapp.core.navigation.NavGraph
import androidx.compose.material.*
import androidx.compose.ui.tooling.preview.Preview
import zahra.hosseini.hemophiliaapp.core.bottomnav.BottomBarNav
import zahra.hosseini.hemophiliaapp.core.theme.AppTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    AppTheme {
        val navController = rememberNavController()

        Scaffold(
            bottomBar = { BottomBarNav(navController = navController) }
        ) { paddingValues ->
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
