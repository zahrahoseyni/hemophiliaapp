package zahra.hosseini.hemophiliaapp.core.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.NavGraph
import dagger.hilt.android.AndroidEntryPoint
import zahra.hosseini.hemophiliaapp.authentication.AuthenticationViewModel
import zahra.hosseini.hemophiliaapp.main.ui.MainScreen

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val authenticationViewModel:AuthenticationViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}
