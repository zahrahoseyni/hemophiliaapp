package zahra.hosseini.hemophiliaapp.main.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
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

@Composable
fun RegisterInjection() {
    Column(
        modifier = Modifier.padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val yesOrNoOptions = listOf(stringResource(R.string.yes), stringResource(R.string.no))
        var yesOrNoSelectedIndex by remember { mutableStateOf(-1) }

        LargeDropdownMenu(
            label = stringResource(id = R.string.active_inhibitor),
            items = yesOrNoOptions,
            selectedIndex = yesOrNoSelectedIndex,
            onItemSelected = { index, _ -> yesOrNoSelectedIndex = index },
        )

        val treatmentOptions =
            listOf(stringResource(R.string.prophylactic), stringResource(R.string.on_demand))
        var treatmentSelectedIndex by remember { mutableStateOf(-1) }

        LargeDropdownMenu(
            label = stringResource(id = R.string.type_of_treatment),
            items = treatmentOptions,
            selectedIndex = treatmentSelectedIndex,
            onItemSelected = { index, _ -> treatmentSelectedIndex = index },
        )

        RtlLabelInOutlineTextField(
            label = stringResource(id = R.string.dosage), inputType = KeyboardType.NumberPassword
        )

        val reasonOptions = listOf(
            stringResource(R.string.prophylactic_fa),
            stringResource(R.string.related_to_physical_actions),
            stringResource(R.string.surgery),
            stringResource(R.string.extra),
        )
        var reasonSelectedIndex by remember { mutableStateOf(-1) }

        LargeDropdownMenu(
            label = stringResource(id = R.string.type_of_treatment),
            items = reasonOptions,
            selectedIndex = reasonSelectedIndex,
            onItemSelected = { index, _ -> reasonSelectedIndex = index },
        )

        val sedativeOptions = listOf(
            stringResource(R.string.yes),
            stringResource(R.string.no),
        )
        var sedativeSelectedIndex by remember { mutableStateOf(-1) }

        LargeDropdownMenu(
            label = stringResource(id = R.string.question_for_sedative),
            items = sedativeOptions,
            selectedIndex = sedativeSelectedIndex,
            onItemSelected = { index, _ -> sedativeSelectedIndex = index },
        )

        RtlLabelInOutlineTextField(
            label = stringResource(id = R.string.sedative_name),
            inputType = KeyboardType.Text
        )


        DefaultButton(text = stringResource(id = R.string.submit)) {}

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RegisterInjection()

}