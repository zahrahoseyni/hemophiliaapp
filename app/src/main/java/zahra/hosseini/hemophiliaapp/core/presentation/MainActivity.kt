package zahra.hosseini.hemophiliaapp.core.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.NavGraph
import dagger.hilt.android.AndroidEntryPoint
import ir.ayantech.ayannotif.NotificationBridge
import zahra.hosseini.hemophiliaapp.authentication.AuthenticationViewModel
import zahra.hosseini.hemophiliaapp.main.ui.MainScreen

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val channel = "channel"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        NotificationBridge(this).createChannel(
            channel, "This is Big Notification", "message", 3,
            1, "#00ff00", 1, null
        )

        NotificationBridge(this).createChannelController(
            channel,
            "This is Big Notification",
            "message",
            3,
            1,
            "#00ff00",
            1,
            null
        )
        setContent {
            MainScreen()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}
