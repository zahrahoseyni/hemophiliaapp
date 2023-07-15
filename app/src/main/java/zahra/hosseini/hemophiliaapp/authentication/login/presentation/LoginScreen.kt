package zahra.hosseini.hemophiliaapp.authentication.login.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import zahra.hosseini.hemophiliaapp.R
import zahra.hosseini.hemophiliaapp.core.component.DefaultButton
import zahra.hosseini.hemophiliaapp.core.component.RtlLabelInOutlineTextField
import zahra.hosseini.hemophiliaapp.core.theme.AppTheme
import zahra.hosseini.hemophiliaapp.core.theme.Text20Bold

@Composable
fun LoginScreen(navigateToHome: () -> Unit, navigateToRegister: () -> Unit) {

    Column(
        modifier = Modifier.padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val phoneNumber = remember { mutableStateOf(TextFieldValue()) }
        var enabled by remember { mutableStateOf(true)}

        Spacer(modifier = Modifier.padding(50.dp))


        Text(
            text = stringResource(R.string.app_name),
            style = Text20Bold,
            color = MaterialTheme.colors.primary,
        )

        Spacer(modifier = Modifier.padding(50.dp))

        RtlLabelInOutlineTextField(
            label = stringResource(id = R.string.phone_number),
            inputType = KeyboardType.NumberPassword
        )

        Spacer(modifier = Modifier.padding(10.dp))

        DefaultButton(text = stringResource(id = R.string.login)) {
            navigateToHome()
        }

        Spacer(modifier = Modifier.padding(5.dp))

        ClickableText(
            text = AnnotatedString(stringResource(R.string.register_description)),
            onClick = {
                if (enabled) {
                    enabled = false
                    navigateToRegister()
                }
            })

    }
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    AppTheme(useSystemUiController = false) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            LoginScreen(
                navigateToHome = {},
                navigateToRegister = {}
            )
        }
    }
}