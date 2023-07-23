package zahra.hosseini.hemophiliaapp.main.ui

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import zahra.hosseini.hemophiliaapp.core.navigation.NavGraph
import androidx.compose.material.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import zahra.hosseini.hemophiliaapp.R
import zahra.hosseini.hemophiliaapp.core.navigation.BottomBarNav
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.theme.AppTheme
import zahra.hosseini.hemophiliaapp.main.ui.floatingactionbutton.FabIcon
import zahra.hosseini.hemophiliaapp.main.ui.floatingactionbutton.FabOption
import zahra.hosseini.hemophiliaapp.main.ui.floatingactionbutton.MultiFabItem
import zahra.hosseini.hemophiliaapp.main.ui.floatingactionbutton.MultiFloatingActionButton

@OptIn(ExperimentalAnimationApi::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen() {

    val context = LocalContext.current

    AppTheme {
        val navController = rememberNavController()

        Scaffold(
            bottomBar = { BottomBarNav(navController = navController) },
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
