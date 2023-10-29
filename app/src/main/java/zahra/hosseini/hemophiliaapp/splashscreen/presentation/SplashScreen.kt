package zahra.hosseini.hemophiliaapp.splashscreen.presentation

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import zahra.hosseini.hemophiliaapp.R
import zahra.hosseini.hemophiliaapp.core.datastore.DataStoreManager
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.component.DefaultButton
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.theme.hemophiliaColors
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.theme.hemophiliaTypography
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.theme.regularFont
import kotlin.time.Duration.Companion.seconds

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SplashScreen(navigateToLogin: () -> Unit, navigateToHome: () -> Unit) {
    val context = LocalContext.current
    var password by remember { mutableStateOf("") }
    var userInput by remember { mutableStateOf("") }
    val dataStoreManager = DataStoreManager(context)

    LaunchedEffect(Unit) {
        delay(1.seconds)
        dataStoreManager.isUserLogin.collect { isUserLogin ->
            if (isUserLogin) {
                dataStoreManager.getPassword.collect {
                    if (it.isEmpty())
                        navigateToHome()
                    else password = it
                }
            } else navigateToLogin()
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

        if (password.isNotEmpty()) {
            CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {

                OutlinedTextField(
                    value = userInput,
                    onValueChange = {
                        userInput = it
                    },
                    label = {
                        Text(
                            text = "رمز ورود",
                            style = MaterialTheme.hemophiliaTypography.text12,
                            color = MaterialTheme.hemophiliaColors.designSystem.Neutral30
                        )
                    },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Password
                    ),
                    visualTransformation = PasswordVisualTransformation(),
                    textStyle = TextStyle(
                        fontFamily = regularFont,
                        letterSpacing = 5.sp,
                        fontSize = 14.sp,
                        color = MaterialTheme.hemophiliaColors.designSystem.Neutral30,
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp, start = 16.dp, end = 16.dp, bottom = 8.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = MaterialTheme.hemophiliaColors.designSystem.Neutral25,
                        unfocusedBorderColor = MaterialTheme.hemophiliaColors.designSystem.Neutral30
                    )
                )
            }

            DefaultButton(
                text = "ورود",
                onClick = {
                    if (userInput == password)
                        navigateToHome()
                    else Toast.makeText(context, "رمز وارد شده اشتباه هست!", Toast.LENGTH_LONG)
                        .show()
                })
        }

    }

}