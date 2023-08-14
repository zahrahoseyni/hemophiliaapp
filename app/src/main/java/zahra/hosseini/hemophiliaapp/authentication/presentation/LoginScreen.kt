package zahra.hosseini.hemophiliaapp.authentication.presentation

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import zahra.hosseini.hemophiliaapp.R
import zahra.hosseini.hemophiliaapp.authentication.AuthenticationViewModel
import zahra.hosseini.hemophiliaapp.core.datastore.DataStoreManager
import zahra.hosseini.hemophiliaapp.core.extension.showMessage
import zahra.hosseini.hemophiliaapp.core.presentation.MainActivity
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.component.DefaultButton
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.component.RtlLabelInOutlineTextField
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.theme.hemophiliaColors
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.theme.hemophiliaTypography
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.theme.regularFont

@Composable
fun LoginScreen(
    authenticationViewModel: AuthenticationViewModel = hiltViewModel(),
    navigateToHome: () -> Unit,
    navigateToRegister: () -> Unit,
) {

    val context = LocalContext.current
    val dataStoreManager = DataStoreManager(context)

    Column(
        modifier = Modifier.padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val (phoneNumber, setPhoneNumber) = remember {
            mutableStateOf("")
        }
        var enabled by remember { mutableStateOf(true) }

        Spacer(modifier = Modifier.padding(50.dp))

        Text(
            text = stringResource(R.string.app_name),
            style = MaterialTheme.hemophiliaTypography.text20Medium,
            color = MaterialTheme.hemophiliaColors.designSystem.Primary,
        )

        Spacer(modifier = Modifier.padding(50.dp))

        RtlLabelInOutlineTextField(
            label = stringResource(id = R.string.phone_number),
            inputType = KeyboardType.NumberPassword,
            value = phoneNumber,
            setValue = setPhoneNumber,
            11
        )

        Spacer(modifier = Modifier.padding(10.dp))

        DefaultButton(text = stringResource(id = R.string.login)) {
            if (phoneNumber.isNotEmpty()) {
                if (authenticationViewModel.userDetails.value.phoneNumber == "" || authenticationViewModel.userDetails.value.phoneNumber != phoneNumber)
                    context.showMessage(context.getString(R.string.invalid_phone_number_message))
                else {
                    CoroutineScope(Dispatchers.IO).launch {
                        dataStoreManager.storePhoneNumber(phoneNumber = phoneNumber)
                        dataStoreManager.storeUserLogin(true)
                    }

                    navigateToHome()
                }


            } else {
                context.showMessage(context.getString(R.string.wrong_phone_number_message))
            }
        }

        Spacer(modifier = Modifier.padding(5.dp))

        ClickableText(
            style = TextStyle(
                color = MaterialTheme.hemophiliaColors.designSystem.PrimaryText,
                fontFamily = regularFont,
                fontSize = 14.sp,
            ),
            text = AnnotatedString(stringResource(R.string.register_description)),
            onClick = {
                if (enabled) {
                    enabled = false
                    navigateToRegister()
                }
            })

    }

    BackHandler(enabled = true) {
        (context as MainActivity).finish()
    }

}
