package zahra.hosseini.hemophiliaapp.authentication.register

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import zahra.hosseini.hemophiliaapp.R
import zahra.hosseini.hemophiliaapp.core.component.DefaultButton
import zahra.hosseini.hemophiliaapp.core.component.LargeDropdownMenu
import zahra.hosseini.hemophiliaapp.core.component.RtlLabelInOutlineTextField
import zahra.hosseini.hemophiliaapp.core.theme.Text20Bold

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

        val sexOptions = listOf("زن", "مرد")
        var sexSelectedIndex by remember { mutableStateOf(-1) }

        val familyHistoryOptions = listOf("دارم", "ندارم")
        var familyHistorySelectedIndex by remember { mutableStateOf(-1) }

        Text(
            text = stringResource(id = R.string.enter_your_data),
            style = Text20Bold,
            color = MaterialTheme.colors.secondary,
            modifier = Modifier.padding(top = 20.dp, bottom = 10.dp)
        )


        LargeDropdownMenu(
            label = stringResource(id = R.string.sex),
            items = sexOptions,
            selectedIndex = sexSelectedIndex,
            onItemSelected = { index, _ -> sexSelectedIndex = index },
        )

        RtlLabelInOutlineTextField(
            label = stringResource(id = R.string.weight), inputType = KeyboardType.NumberPassword
        )

        RtlLabelInOutlineTextField(
            label = stringResource(id = R.string.height), inputType = KeyboardType.NumberPassword
        )

        RtlLabelInOutlineTextField(
            label = stringResource(id = R.string.age), inputType = KeyboardType.NumberPassword
        )

        LargeDropdownMenu(
            label = stringResource(id = R.string.family_history),
            items = familyHistoryOptions,
            selectedIndex = familyHistorySelectedIndex,
            onItemSelected = { index, _ -> familyHistorySelectedIndex = index },
        )

        RtlLabelInOutlineTextField(
            label = stringResource(id = R.string.timeـofـdiagnosis),
            inputType = KeyboardType.NumberPassword
        )

        Spacer(modifier = Modifier.padding(16.dp))

        DefaultButton(text = stringResource(id = R.string.submit)) {}


    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RegisterScreen()

}