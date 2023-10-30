package zahra.hosseini.hemophiliaapp.main.reminder.presentation

import android.app.TimePickerDialog
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import zahra.hosseini.hemophiliaapp.R
import zahra.hosseini.hemophiliaapp.core.extension.formatDate
import zahra.hosseini.hemophiliaapp.core.extension.formatTime
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.component.DefaultButton
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.component.PickerItem
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.component.RtlLabelInOutlineTextField
import zahra.hosseini.hemophiliaapp.main.reminder.ReminderViewModel
import java.util.*

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DoctorAppointmentReminderScreen(
    reminderViewModel: ReminderViewModel = hiltViewModel(),
    navigateToReminder: () -> Unit,
) {
    val scrollState = rememberScrollState()
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .padding(20.dp)
            .verticalScroll(state = scrollState),
        verticalArrangement = Arrangement.spacedBy(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val (doctor, setDoctor) = remember { mutableStateOf("") }
        val showDialog = remember { mutableStateOf(-1) }
        var showTimeDialog = remember { mutableStateOf(-1) }
        val rememberPersianDatePicker = rememberPersianDatePicker()
        rememberPersianDatePicker.updateDate(timestamp = Date().time)

        rememberPersianDatePicker.updateMaxYear(1420)
        rememberPersianDatePicker.updateMinYear(1350)

        rememberPersianDatePicker.updateYearRange(1)
        rememberPersianDatePicker.updateDisplayMonthNames(true)

        var lastDate by remember { mutableStateOf("") }
        var nextDate by remember { mutableStateOf("") }

        var appointmentTime by remember { mutableStateOf("") }
        var reminderTime by remember { mutableStateOf("") }

        // Declaring and initializing a calendar
        val mCalendar = Calendar.getInstance()
        val mHour = mCalendar[Calendar.HOUR_OF_DAY]
        val mMinute = mCalendar[Calendar.MINUTE]

        // Creating a TimePicker dialog
        val mTimePickerDialog = TimePickerDialog(
            context, R.style.TimePickerTheme, { _, mHour: Int, mMinute: Int ->
                if (showTimeDialog.value == 1)
                    appointmentTime = "${mHour}:${mMinute}".formatTime()
                else reminderTime = "${mHour}:${mMinute}".formatTime()
            }, mHour, mMinute, false
        )

        if (showDialog.value != -1) {
            PersianDatePickerDialog(rememberPersianDatePicker,
                Modifier.fillMaxWidth(),
                onDismissRequest = { showDialog.value = -1 },
                onDateChanged = { year, month, day ->
                    if (showDialog.value == 1)
                        lastDate = "$year/$month/$day".formatDate()
                    else nextDate = "$year/$month/$day".formatDate()
                })
        }

        RtlLabelInOutlineTextField(
            label = stringResource(id = R.string.doctor_name),
            inputType = KeyboardType.Text,
            value = doctor,
            setValue = setDoctor,
            inputLength = 50
        )

        PickerItem(lastDate, stringResource(id = R.string.last_date)) {
            showDialog.value = 1
        }

        PickerItem(nextDate, stringResource(id = R.string.next_date)) {
            showDialog.value = 2
        }

        PickerItem(appointmentTime, stringResource(id = R.string.appointment_time)) {
            showTimeDialog.value = 1
            mTimePickerDialog.show()
        }

        PickerItem(reminderTime, stringResource(id = R.string.reminder_time)) {
            showTimeDialog.value = 2
            mTimePickerDialog.show()
        }


        DefaultButton(text = stringResource(id = R.string.continue_btn)) {
            if (lastDate.isNotEmpty() && nextDate.isNotEmpty() && doctor.isNotEmpty() && reminderTime.isNotEmpty() && appointmentTime.isNotEmpty()) {
                setReminder(
                    reminderTime.split(":")[0].toInt(),
                    reminderTime.split(":")[1].toInt(),
                    context,
                    context.getString(R.string.reminder_text2),
                    reminderViewModel,
                    "$doctor / $appointmentTime"
                )
                navigateToReminder()
            } else Toast.makeText(context, "اطلاعات وارد شده کامل نیست", Toast.LENGTH_LONG).show()
        }

    }
}