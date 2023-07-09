package zahra.hosseini.hemophiliaapp.authentication.register

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import zahra.hosseini.hemophiliaapp.R
import zahra.hosseini.hemophiliaapp.core.component.DefaultButton
import zahra.hosseini.hemophiliaapp.core.component.RtlLabelInOutlineTextField

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen() {

    Column(
        modifier = Modifier.padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        var sex by remember { mutableStateOf("") }
        var weight by remember { mutableStateOf("") }
        var height by remember { mutableStateOf("") }
        var age by remember { mutableStateOf("") }
        var familyHistory by remember { mutableStateOf("") }
        var timeOfDiagnosis by remember { mutableStateOf("") }

        RtlLabelInOutlineTextField(
            label = stringResource(id = R.string.weight),
            inputType = KeyboardType.NumberPassword
        )

        RtlLabelInOutlineTextField(
            label = stringResource(id = R.string.height),
            inputType = KeyboardType.NumberPassword
        )

        RtlLabelInOutlineTextField(
            label = stringResource(id = R.string.age),
            inputType = KeyboardType.NumberPassword
        )

        RtlLabelInOutlineTextField(
            label = stringResource(id = R.string.timeـofـdiagnosis),
            inputType = KeyboardType.NumberPassword
        )

        Spacer(modifier = Modifier.padding(16.dp))

        DefaultButton(text = stringResource(id = R.string.submit)) {
        }


    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RegisterScreen()

}