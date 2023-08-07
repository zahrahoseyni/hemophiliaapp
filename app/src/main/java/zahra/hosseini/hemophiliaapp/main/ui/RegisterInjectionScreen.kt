package zahra.hosseini.hemophiliaapp.main.ui

import android.app.TimePickerDialog
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.razaghimahdi.compose_persian_date.PersianDatePickerDialog
import com.razaghimahdi.compose_persian_date.core.rememberPersianDatePicker
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import zahra.hosseini.hemophiliaapp.R
import zahra.hosseini.hemophiliaapp.authentication.AuthenticationViewModel
import zahra.hosseini.hemophiliaapp.core.extension.formatDate
import zahra.hosseini.hemophiliaapp.core.extension.formatTime
import zahra.hosseini.hemophiliaapp.core.extension.showMessage
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.component.DefaultButton
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.component.LargeDropdownMenu
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.component.PickerItem
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.component.RtlLabelInOutlineTextField
import zahra.hosseini.hemophiliaapp.main.InjectionViewModel
import zahra.hosseini.hemophiliaapp.main.data.InjectionEntity
import java.util.*

@Composable
fun RegisterInjectionScreen(
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

        var injectionDate by remember { mutableStateOf("") }

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
                    injectionDate = "$year/$month/$day".formatDate()
                })
        }

        var injectionTime by remember { mutableStateOf("") }

        // Declaring and initializing a calendar
        val mCalendar = Calendar.getInstance()
        val mHour = mCalendar[Calendar.HOUR_OF_DAY]
        val mMinute = mCalendar[Calendar.MINUTE]

        // Creating a TimePicker dialog
        val mTimePickerDialog = TimePickerDialog(
            context, R.style.TimePickerTheme, { _, mHour: Int, mMinute: Int ->
                injectionTime = "${mHour}:${mMinute}".formatTime()
            }, mHour, mMinute, false
        )


        val activeInhibitorOptions =
            listOf(stringResource(R.string.yes), stringResource(R.string.no))
        var activeInhibitorSelectedIndex by remember { mutableStateOf(-1) }

        val treatmentOptions =
            listOf(stringResource(R.string.prophylactic), stringResource(R.string.on_demand))
        var treatmentSelectedIndex by remember { mutableStateOf(-1) }

        val (dosage, setDosage) = remember { mutableStateOf("") }

        val reasonOptions = listOf(
            stringResource(R.string.prophylactic_fa),
            stringResource(R.string.related_to_physical_actions),
            stringResource(R.string.surgery),
            stringResource(R.string.extra),
        )
        var reasonSelectedIndex by remember { mutableStateOf(-1) }

        LargeDropdownMenu(
            label = stringResource(id = R.string.active_inhibitor),
            items = activeInhibitorOptions,
            selectedIndex = activeInhibitorSelectedIndex,
            onItemSelected = { index, _ -> activeInhibitorSelectedIndex = index },
        )

        LargeDropdownMenu(
            label = stringResource(id = R.string.type_of_treatment),
            items = treatmentOptions,
            selectedIndex = treatmentSelectedIndex,
            onItemSelected = { index, _ -> treatmentSelectedIndex = index },
        )

        RtlLabelInOutlineTextField(
            label = stringResource(id = R.string.dosage),
            inputType = KeyboardType.NumberPassword,
            value = dosage,
            setValue = setDosage,
            10
        )


        PickerItem(injectionDate, stringResource(id = R.string.bleeding_date)) {
            showDialog.value = true
        }

        PickerItem(injectionTime, stringResource(id = R.string.bleeding_time)) {
            mTimePickerDialog.show()
        }

        LargeDropdownMenu(
            label = stringResource(id = R.string.injection_reason),
            items = reasonOptions,
            selectedIndex = reasonSelectedIndex,
            onItemSelected = { index, _ -> reasonSelectedIndex = index },
        )

        Spacer(modifier = Modifier.padding(8.dp))

        DefaultButton(text = stringResource(id = R.string.submit)) {
            if (dosage.isEmpty() || injectionDate.isEmpty() || injectionTime.isEmpty()
                || treatmentSelectedIndex == -1 || activeInhibitorSelectedIndex == -1 || reasonSelectedIndex == -1
            ) {
                context.showMessage(context.getString(R.string.un_complete_form_message))

            } else {

                CoroutineScope(Dispatchers.IO).launch {
                    viewModel.insertInjectionDetails(
                        injectionEntity = InjectionEntity(
                            activeInhibitor = activeInhibitorOptions[activeInhibitorSelectedIndex],
                            treatmentType = treatmentOptions[treatmentSelectedIndex],
                            dosage = dosage,
                            injectionDate = injectionDate,
                            injectionTime = injectionTime,
                            injectionReason = reasonOptions[reasonSelectedIndex],
                        )
                    )

                }
                navigateToHome()
            }
        }

    }
}
