package zahra.hosseini.hemophiliaapp.authentication.login.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import zahra.hosseini.hemophiliaapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen() {

    Column(
        modifier = Modifier.padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val phoneNumber = remember { mutableStateOf(TextFieldValue()) }

        Text(
            text = stringResource(R.string.app_name),
            style = TextStyle(fontSize = 18.sp, color = Color.Red)
        )

        TextField(
            label = { Text(text = stringResource(R.string.phone_number)) },
            value = phoneNumber.value,
            onValueChange = { phoneNumber.value = it })

        Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {
            Button(
                onClick = { },
                shape = RoundedCornerShape(50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text(
                    text = stringResource(R.string.login),
                    style = TextStyle(fontSize = 16.sp, color = Color.White)
                )
            }
        }

        Text(
            text = stringResource(R.string.register_description),
            style = TextStyle(fontSize = 12.sp, color = Color.Black)
        )

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LoginScreen()

}