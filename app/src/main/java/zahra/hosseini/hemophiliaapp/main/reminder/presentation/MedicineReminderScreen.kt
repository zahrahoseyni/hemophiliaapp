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
fun MedicineReminderScreen(
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
        val showDialog = remember { mutableStateOf(-1) }
        val rememberPersianDatePicker = rememberPersianDatePicker()
        val (medicine, setMedicine) = remember { mutableStateOf("") }
        val (medicineNumber, setMedicineNumber) = remember { mutableStateOf("") }
        rememberPersianDatePicker.updateDate(timestamp = Date().time)

        rememberPersianDatePicker.updateMaxYear(1420)
        rememberPersianDatePicker.updateMinYear(1350)

        rememberPersianDatePicker.updateYearRange(1)
        rememberPersianDatePicker.updateDisplayMonthNames(true)

        var startDate by remember { mutableStateOf("") }
        var endDate by remember { mutableStateOf("") }

        if (showDialog.value != -1) {
            PersianDatePickerDialog(rememberPersianDatePicker,
                Modifier.fillMaxWidth(),
                onDismissRequest = { showDialog.value = -1 },
                onDateChanged = { year, month, day ->
                    if (showDialog.value == 1)
                        startDate = "$year/$month/$day".formatDate()
                    else endDate = "$year/$month/$day".formatDate()
                })
        }

        var medicineTime by remember { mutableStateOf("") }

        // Declaring and initializing a calendar
        val mCalendar = Calendar.getInstance()
        val mHour = mCalendar[Calendar.HOUR_OF_DAY]
        val mMinute = mCalendar[Calendar.MINUTE]

        // Creating a TimePicker dialog
        val mTimePickerDialog = TimePickerDialog(
            context, R.style.TimePickerTheme, { _, mHour: Int, mMinute: Int ->
                medicineTime = "${mHour}:${mMinute}".formatTime()
            }, mHour, mMinute, false
        )
        RtlLabelInOutlineTextField(
            label = stringResource(id = R.string.medicine_name),
            inputType = KeyboardType.Text,
            value = medicine,
            setValue = setMedicine,
            inputLength = 50
        )

        PickerItem(startDate, stringResource(id = R.string.start_date)) {
            showDialog.value = 1
        }

        PickerItem(endDate, stringResource(id = R.string.end_date)) {
            showDialog.value = 2
        }

        RtlLabelInOutlineTextField(
            label = stringResource(id = R.string.number_of_medicine),
            inputType = KeyboardType.Number,
            value = medicineNumber,
            setValue = setMedicineNumber,
            inputLength = 50
        )

        PickerItem(medicineTime, stringResource(id = R.string.medicine_time)) {
            mTimePickerDialog.show()
        }

        DefaultButton(text = stringResource(id = R.string.continue_btn)) {
            if (startDate.isNotEmpty() && endDate.isNotEmpty() && medicine.isNotEmpty() && medicineTime.isNotEmpty()) {
                setReminder(
                    medicineTime.split(":")[0].toInt(),
                    medicineTime.split(":")[1].toInt(),
                    context,
                    context.getString(R.string.reminder_text1),
                    reminderViewModel,
                   " $medicine / $medicineNumber عدد"
                )
                navigateToReminder()
            } else Toast.makeText(context, "اطلاعات وارد شده کامل نیست", Toast.LENGTH_LONG).show()
        }

    }
}