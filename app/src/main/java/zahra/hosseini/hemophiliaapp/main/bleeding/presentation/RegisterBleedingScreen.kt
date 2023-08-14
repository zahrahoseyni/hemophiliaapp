package zahra.hosseini.hemophiliaapp.main.bleeding.presentation

import android.app.TimePickerDialog
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
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
import zahra.hosseini.hemophiliaapp.core.extension.formatDate
import zahra.hosseini.hemophiliaapp.core.extension.formatTime
import zahra.hosseini.hemophiliaapp.core.extension.showMessage
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.component.*
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.theme.hemophiliaColors
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.theme.hemophiliaTypography
import zahra.hosseini.hemophiliaapp.main.bleeding.BleedingViewModel
import zahra.hosseini.hemophiliaapp.main.bleeding.data.model.BleedingEntity
import java.util.*

@Composable
fun RegisterBleedingScreen(
    viewModel: BleedingViewModel = hiltViewModel(), navigateToHome: () -> Unit
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
        val intervalOfNumbers = arrayListOf(1, 2, 3, 4, 5)

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

        val rememberPersianDatePicker = rememberPersianDatePicker()
        val showDialog = remember { mutableStateOf(false) }

        var bleedingDate by remember { mutableStateOf("") }

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
                    bleedingDate = "$year/$month/$day".formatDate()
                })
        }

        var bleedingTime by remember { mutableStateOf("") }

        // Declaring and initializing a calendar
        val mCalendar = Calendar.getInstance()
        val mHour = mCalendar[Calendar.HOUR_OF_DAY]
        val mMinute = mCalendar[Calendar.MINUTE]

        // Creating a TimePicker dialog
        val mTimePickerDialog = TimePickerDialog(
            context, R.style.TimePickerTheme, { _, mHour: Int, mMinute: Int ->
                bleedingTime = "${mHour}:${mMinute}".formatTime()
            }, mHour, mMinute, false
        )

        LargeDropdownMenu(
            label = stringResource(id = R.string.reason),
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

        PickerItem(bleedingDate, stringResource(id = R.string.bleeding_date)) {
            showDialog.value = true
        }

        PickerItem(bleedingTime, stringResource(id = R.string.bleeding_time)) {
            mTimePickerDialog.show()
        }

        val sedativeOptions = listOf(
            stringResource(R.string.yes),
            stringResource(R.string.no),
        )
        var sedativeSelectedIndex by remember { mutableStateOf(-1) }

        Spacer(modifier = Modifier.height(5.dp))

        Text(
            text = stringResource(id = R.string.amount_of_disability),
            style = MaterialTheme.hemophiliaTypography.text12,
            color = MaterialTheme.hemophiliaColors.designSystem.Neutral30,
            modifier = Modifier
                .align(Alignment.End)
                .padding(end = 16.dp)
        )

        var disabilitySelectedIndex by remember { mutableStateOf(-1) }

        LazyRow(
            modifier = Modifier.padding(
                top = 8.dp, start = 16.dp, end = 16.dp, bottom = 8.dp
            ), userScrollEnabled = true

        ) {
            intervalOfNumbers.forEachIndexed { index, number ->
                item {

                    NumberButton(number = number, isSelected = disabilitySelectedIndex == index) {
                        disabilitySelectedIndex = index
                    }
                }

            }
        }

        Spacer(modifier = Modifier.height(5.dp))

        Text(
            text = stringResource(id = R.string.amount_of_pain),
            style = MaterialTheme.hemophiliaTypography.text12,
            color = MaterialTheme.hemophiliaColors.designSystem.Neutral30,
            modifier = Modifier
                .align(Alignment.End)
                .padding(end = 16.dp)
        )

        var painSelectedIndex by remember { mutableStateOf(-1) }

        LazyRow(
            modifier = Modifier.padding(
                top = 8.dp, start = 16.dp, end = 16.dp, bottom = 8.dp
            ), userScrollEnabled = true

        ) {
            intervalOfNumbers.forEachIndexed { index, number ->
                item {

                    NumberButton(number = number, isSelected = painSelectedIndex == index) {
                        painSelectedIndex = index
                    }
                }

            }
        }


        LargeDropdownMenu(
            label = stringResource(id = R.string.question_for_sedative),
            items = sedativeOptions,
            selectedIndex = sedativeSelectedIndex,
            onItemSelected = { index, _ -> sedativeSelectedIndex = index },
        )

        val (sedativeName, setSedativeName) = remember { mutableStateOf("") }

        RtlLabelInOutlineTextField(
            label = stringResource(id = R.string.sedative_name),
            inputType = KeyboardType.Text,
            value = sedativeName,
            setValue = setSedativeName,
            10
        )

        DefaultButton(text = stringResource(id = R.string.submit)) {
            if (reasonSelectedIndex == -1 || bleedingTopicSelectedIndex == -1 || intensitySelectedIndex == -1 || bleedingDate.isEmpty() || bleedingTime.isEmpty() || disabilitySelectedIndex == -1 || painSelectedIndex == -1 || sedativeSelectedIndex == -1) {
                context.showMessage(context.getString(R.string.un_complete_form_message))

            } else {
                CoroutineScope(Dispatchers.IO).launch {
                    viewModel.insertBleedingDetails(
                        bleedingEntity = BleedingEntity(
                            bleedingReason = reasonOptions[reasonSelectedIndex],
                            bleedingTopic = bleedingTopicOptions[bleedingTopicSelectedIndex],
                            bleedingIntensity = intensityOptions[intensitySelectedIndex],
                            bleedingDate = bleedingDate,
                            bleedingTime = bleedingTime,
                            amountOfDisability = disabilitySelectedIndex.toString(),
                            amountOfPain = painSelectedIndex.toString(),
                            usingSedative = sedativeOptions[sedativeSelectedIndex],
                            sedativeName = sedativeName,
                        )
                    )

                }

                navigateToHome()
            }
        }

    }
}
