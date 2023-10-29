import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import zahra.hosseini.hemophiliaapp.core.datastore.DataStoreManager
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.component.DefaultButton
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.theme.hemophiliaColors
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.theme.hemophiliaTypography
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.theme.regularFont

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordSettingScreen(navigateToProfileScreen: () -> Unit) {
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    val context = LocalContext.current
    val dataStoreManager = DataStoreManager(context)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        // Password input field
        CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {

            OutlinedTextField(
                value = password,
                onValueChange = {
                    password = it
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
                textStyle = androidx.compose.ui.text.TextStyle(
                    fontFamily = regularFont,
                    letterSpacing = 5.sp,
                    fontSize = 14.sp, color = MaterialTheme.hemophiliaColors.designSystem.Neutral30,
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp, start = 16.dp, end = 16.dp, bottom = 8.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = MaterialTheme.hemophiliaColors.designSystem.Neutral25,
                    unfocusedBorderColor = MaterialTheme.hemophiliaColors.designSystem.Neutral30
                )
            )


            // Confirm password input field
            OutlinedTextField(
                value = confirmPassword,
                onValueChange = {
                    confirmPassword = it
                },
                label = {
                    Text(
                        text = "تایید رمز ورود",
                        style = MaterialTheme.hemophiliaTypography.text12,
                        color = MaterialTheme.hemophiliaColors.designSystem.Neutral30
                    )
                },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Password
                ),
                visualTransformation = PasswordVisualTransformation(),
                textStyle = androidx.compose.ui.text.TextStyle(
                    fontFamily = regularFont,
                    letterSpacing = 5.sp,
                    fontSize = 14.sp, color = MaterialTheme.hemophiliaColors.designSystem.Neutral30,
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

        // Password setting button
        DefaultButton(
            text = "ایجاد رمز",
            onClick = {
                if (password.length >= 4) {
                    if (password == confirmPassword) {
                        // Passwords match, save the password to your database or perform desired action
                        // For example, you can use a ViewModel to handle saving the password securely.
                        // ViewModel.savePassword(password)
                        // Then, navigate to another screen or perform any other action.
                        CoroutineScope(Dispatchers.IO).launch {
                            dataStoreManager.storePassword(password = password)
                        }

                        Toast.makeText(context, "رمز با موفقیت ایجاد شد", Toast.LENGTH_LONG)
                            .show()

                        navigateToProfileScreen()
                    } else {
                        // Passwords do not match, show an error message or take appropriate action.
                        // For example, display a snackbar with an error message.

                        Toast.makeText(context, "رمزهای وارد شده مطابقت ندارند", Toast.LENGTH_LONG)
                            .show()
                    }

                } else {
                    Toast.makeText(
                        context,
                        "حداقل تعداد کارکترهای وارد شده برای رمز عبور ۴ عدد می باشد.",
                        Toast.LENGTH_LONG
                    )
                        .show()
                }
            })
    }
}