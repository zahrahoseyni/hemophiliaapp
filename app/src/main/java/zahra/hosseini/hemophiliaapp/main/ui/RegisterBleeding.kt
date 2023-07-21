package zahra.hosseini.hemophiliaapp.main.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import zahra.hosseini.hemophiliaapp.R
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.component.DefaultButton
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.component.LargeDropdownMenu

@Composable
fun RegisterBleeding() {

    Column(
        modifier = Modifier.padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val reasonOptions = listOf(
            stringResource(R.string.injury),
            stringResource(R.string.spontaneity),
            stringResource(R.string.follow_up_dose),
            stringResource(R.string.period),
            stringResource(R.string.after_physical_action),
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

        val bleedingTopicOptions = listOf(
            stringResource(R.string.wrist),
            stringResource(R.string.arm),
        )
        var bleedingTopicSelectedIndex by remember { mutableStateOf(-1) }

        LargeDropdownMenu(
            label = stringResource(id = R.string.bleeding_topic),
            items = bleedingTopicOptions,
            selectedIndex = bleedingTopicSelectedIndex,
            onItemSelected = { index, _ -> bleedingTopicSelectedIndex = index },
        )

        val intensityOptions = listOf(
            stringResource(R.string.acute),
            stringResource(R.string.medium),
            stringResource(R.string.weak),
        )
        var intensitySelectedIndex by remember { mutableStateOf(-1) }

        LargeDropdownMenu(
            label = stringResource(id = R.string.intensity),
            items = intensityOptions,
            selectedIndex = intensitySelectedIndex,
            onItemSelected = { index, _ -> intensitySelectedIndex = index },
        )
        DefaultButton(text = stringResource(id = R.string.submit)) {}

    }
}