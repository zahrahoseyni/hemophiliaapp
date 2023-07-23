package zahra.hosseini.hemophiliaapp.main.ui

import android.app.TimePickerDialog
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.razaghimahdi.compose_persian_date.PersianDatePickerDialog
import com.razaghimahdi.compose_persian_date.core.rememberPersianDatePicker
import zahra.hosseini.hemophiliaapp.R
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.component.PickerItem
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.component.DefaultButton
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.component.LargeDropdownMenu
import java.util.*

@Composable
fun RegisterBleeding() {

    Column(
        modifier = Modifier.padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val context = LocalContext.current

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
            PersianDatePickerDialog(
                rememberPersianDatePicker,
                Modifier.fillMaxWidth(),
                onDismissRequest = { showDialog.value = false },
                onDateChanged = { year, month, day ->
                    bleedingDate = "$year/$month/$day"
                })
        }

        var bleedingTime by remember { mutableStateOf("") }

        // Declaring and initializing a calendar
        val mCalendar = Calendar.getInstance()
        val mHour = mCalendar[Calendar.HOUR_OF_DAY]
        val mMinute = mCalendar[Calendar.MINUTE]

        // Creating a TimePicker dialog
        val mTimePickerDialog = TimePickerDialog(
            context,
            R.style.TimePickerTheme,
            { _, mHour: Int, mMinute: Int ->
                bleedingTime = "${mHour}:${mMinute}"
            }, mHour, mMinute, false
        )

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

        PickerItem(bleedingDate, stringResource(id = R.string.bleeding_date)) {
            showDialog.value = true
        }

        PickerItem(bleedingTime, stringResource(id = R.string.bleeding_time)) {
            mTimePickerDialog.show()
        }

        DefaultButton(text = stringResource(id = R.string.submit)) {
        }

    }
}