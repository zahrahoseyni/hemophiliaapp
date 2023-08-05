package zahra.hosseini.hemophiliaapp.splashscreen.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import zahra.hosseini.hemophiliaapp.R
import zahra.hosseini.hemophiliaapp.core.datastore.DataStoreManager
import kotlin.time.Duration.Companion.seconds

@Composable
fun SplashScreen(navigateToLogin: () -> Unit, navigateToHome: () -> Unit) {
    val context = LocalContext.current
    val dataStoreManager = DataStoreManager(context)

    LaunchedEffect(Unit) {
        delay(1.seconds)
        dataStoreManager.isUserLogin.collect { isUserLogin ->
            if (isUserLogin) navigateToHome()
            else navigateToLogin()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id = R.drawable.logo), contentDescription = "Logo"
        )


    }

}