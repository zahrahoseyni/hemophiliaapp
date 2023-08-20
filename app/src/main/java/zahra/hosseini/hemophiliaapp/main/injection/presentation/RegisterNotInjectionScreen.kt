package zahra.hosseini.hemophiliaapp.main.injection.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.razaghimahdi.compose_persian_date.PersianDatePickerDialog
import com.razaghimahdi.compose_persian_date.core.rememberPersianDatePicker
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import zahra.hosseini.hemophiliaapp.R
import zahra.hosseini.hemophiliaapp.core.extension.formatDate
import zahra.hosseini.hemophiliaapp.core.extension.showMessage
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.component.DefaultButton
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.component.LargeDropdownMenu
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.component.PickerItem
import zahra.hosseini.hemophiliaapp.main.injection.InjectionViewModel
import zahra.hosseini.hemophiliaapp.main.injection.data.model.NotInjectionEntity
import java.util.*

@Composable
fun RegisterNotInjectionScreen(
    viewModel: InjectionViewModel = hiltViewModel(),
    navigateToHome: () -> Unit
) {

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .padding(20.dp)
            .verticalScroll(state = scrollState),
        verticalArrangement = Arrangement.spacedBy(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val context = LocalContext.current

        val rememberPersianDatePicker = rememberPersianDatePicker()
        val showDialog = remember { mutableStateOf(false) }

        var date by remember { mutableStateOf("") }

        rememberPersianDatePicker.updateDate(timestamp = Date().time)

        rememberPersianDatePicker.updateMaxYear(1420)
        rememberPersianDatePicker.updateMinYear(1350)

        rememberPersianDatePicker.updateYearRange(1)
        rememberPersianDatePicker.updateDisplayMonthNames(true)

        if (showDialog.value) {
            PersianDatePickerDialog(rememberPersianDatePicker,
                Modifier.fillMaxWidth(),
                onDismissRequest = { showDialog.value = false },
                onDateChanged = { year, month, day ->
                    date = "$year/$month/$day".formatDate()
                })
        }


        val reasonOptions = listOf(
            stringResource(R.string.forgetting),
            stringResource(R.string.being_busy),
            stringResource(R.string.inaccessible_treatment),
            stringResource(R.string.modifying_treatment),
            stringResource(R.string.not_feeling_good),
            stringResource(R.string.extra),
        )
        var reasonSelectedIndex by remember { mutableStateOf(-1) }

        LargeDropdownMenu(
            label = stringResource(id = R.string.reason),
            items = reasonOptions,
            selectedIndex = reasonSelectedIndex,
            onItemSelected = { index, _ -> reasonSelectedIndex = index },
        )

        PickerItem(date, stringResource(id = R.string.not_injection_date)) {
            showDialog.value = true
        }

        DefaultButton(text = stringResource(id = R.string.submit)) {
            if (date.isEmpty() || reasonSelectedIndex == -1) {
                context.showMessage(context.getString(R.string.un_complete_form_message))

            } else {
                CoroutineScope(Dispatchers.IO).launch {
                    viewModel.insertNotInjectionDetails(
                        notInjectionEntity = NotInjectionEntity(
                            notInjectionDate = date,
                            injectionReason = reasonOptions[reasonSelectedIndex],
                        )
                    )

                }

                context.showMessage(context.getString(R.string.info_successfully_added))
                navigateToHome()
            }
        }

    }
}
