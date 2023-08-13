package zahra.hosseini.hemophiliaapp.core.presentation

import android.app.Activity
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.runtime.getValue
import androidx.navigation.NavGraph
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import ir.ayantech.ayannotif.NotificationBridge
import zahra.hosseini.hemophiliaapp.authentication.AuthenticationViewModel
import zahra.hosseini.hemophiliaapp.core.navigation.NavRoute
import zahra.hosseini.hemophiliaapp.main.ui.MainScreen

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val channel = "channel"
    var pressedTime: Long = 0

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

    fun onBackPress() {
        if (pressedTime + 2000 > System.currentTimeMillis()) {
            // if time is greater than 2 sec we are closing the application.
            finish()
        } else {
            // in else condition displaying a toast message.
            Toast.makeText(baseContext, "برای خروج دوباره روی دکمه برگشت بزنید", Toast.LENGTH_SHORT)
                .show();
        }
        // on below line initializing our press time variable
        pressedTime = System.currentTimeMillis();
    }
}

