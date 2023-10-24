package zahra.hosseini.hemophiliaapp.main.reminder.presentation

import android.annotation.SuppressLint
import android.app.Activity
import android.app.TimePickerDialog
import android.content.Context
import android.os.Build
import androidx.activity.compose.BackHandler
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.AlertDialog
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ir.ayantech.ayannotif.NotificationBridge
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import zahra.hosseini.hemophiliaapp.R
import zahra.hosseini.hemophiliaapp.core.datastore.DataStoreManager
import zahra.hosseini.hemophiliaapp.core.extension.formatTime
import zahra.hosseini.hemophiliaapp.core.extension.showMessage
import zahra.hosseini.hemophiliaapp.core.presentation.MainActivity
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.component.*
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.theme.hemophiliaColors
import zahra.hosseini.hemophiliaapp.main.bleeding.data.model.BleedingEntity
import zahra.hosseini.hemophiliaapp.main.injection.InjectionViewModel
import zahra.hosseini.hemophiliaapp.main.reminder.ReminderViewModel
import zahra.hosseini.hemophiliaapp.main.reminder.data.model.ReminderEntity
import java.time.Duration
import java.time.LocalDateTime
import java.time.LocalTime
import java.util.*
import kotlin.properties.Delegates

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("StateFlowValueCalledInComposition")
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ReminderScreen(
    reminderViewModel: ReminderViewModel = hiltViewModel(),
) {

    val context = LocalContext.current
    reminderViewModel.getAllReminders()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = MaterialTheme.hemophiliaColors.designSystem.Neutral00)
            .padding(top = 30.dp, bottom = 70.dp, start = 16.dp, end = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        var selectedTime by remember { mutableStateOf("") }
        var notificationTitle by remember { mutableStateOf("") }

        val openDialog = remember { mutableStateOf(false) }
        val (reminderDescription, setReminderDescription) = remember { mutableStateOf("") }

        if (openDialog.value) {

            NoPaddingAlertDialog(
                title = {
                    Surface(
                        color = MaterialTheme.hemophiliaColors.designSystem.Primary,
                        contentColor = MaterialTheme.hemophiliaColors.designSystem.Neutral50,
                        modifier = Modifier
                            .fillMaxWidth()

                    ) {
                        Text(
                            text = " جزییات یادآور را وارد کنید️",
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 8.dp, vertical = 16.dp),
                        )
                    }
                },
                text = {
                    Column(Modifier.fillMaxWidth()) {
                        RtlLabelInOutlineTextField(
                            value = reminderDescription,
                            setValue = setReminderDescription,
                            label = stringResource(id = R.string.description),
                            inputLength = 30,
                            inputType = KeyboardType.Text
                        )
                    }
                },
                onDismissRequest = { /*TODO*/ },
                confirmButton = {
                    DefaultButton(text = stringResource(id = R.string.continue_btn), onClick = {
                        openDialog.value = false
                        setReminder(
                            selectedTime.split(":")[0].toInt(),
                            selectedTime.split(":")[1].toInt(),
                            context,
                            notificationTitle,
                            reminderViewModel,
                            reminderDescription
                        )
                        setReminderDescription("")
                    })
                }
            )
        }


        // Declaring and initializing a calendar
        val mCalendar = Calendar.getInstance()
        val mHour = mCalendar[Calendar.HOUR_OF_DAY]
        val mMinute = mCalendar[Calendar.MINUTE]

        // Creating a TimePicker dialog
        val mTimePickerDialog = TimePickerDialog(
            context, R.style.TimePickerTheme, { _, mHour: Int, mMinute: Int ->
                selectedTime = "${mHour}:${mMinute}".formatTime()
                openDialog.value = true
            }, mHour, mMinute, false
        )

        ReminderCard(
            title = stringResource(id = R.string.reminder_text1),
        ) {
            notificationTitle = context.getString(R.string.reminder_text1)
            mTimePickerDialog.show()
        }

        ReminderCard(
            title = stringResource(id = R.string.reminder_text2),
        ) {
            notificationTitle = context.getString(R.string.reminder_text2)
            mTimePickerDialog.show()
        }

        ReminderCard(
            title = stringResource(id = R.string.reminder_text3),
        ) {
            notificationTitle = context.getString(R.string.reminder_text3)
            mTimePickerDialog.show()
        }

        val reminderList = reminderViewModel.reminderList.value

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp),
            horizontalAlignment = Alignment.End
        ) {

            item {
                TableHeader(
                    modifier = Modifier,
                    title1 = stringResource(id = R.string.time),
                    title2 = stringResource(id = R.string.reminder_type),
                    title3 = stringResource(id = R.string.reminder)
                )
            }

            if (reminderList.isNotEmpty()) {
                reminderList.forEach {
                    item {
                        ReminderItemComponent(modifier = Modifier, it)
                    }
                }

            }
        }
    }
    BackHandler(enabled = true) {
        (context as MainActivity).onBackPress()
    }
}

@RequiresApi(Build.VERSION_CODES.O)
fun setReminder(
    mHour: Int,
    mMinute: Int,
    context: Context,
    notificationTitle: String,
    reminderViewModel: ReminderViewModel,
    reminderDescription: String,
) {

    val channel = "channel"
    val duration = calculateDuration(mHour, mMinute)
    val dataStoreManager = DataStoreManager(context)
    var notificationId by Delegates.notNull<Int>()

    CoroutineScope(Dispatchers.IO).launch {

        reminderViewModel.insertReminder(
            reminderEntity = ReminderEntity(
                reminderDescription = reminderDescription,
                reminderTime = "${mHour}:${mMinute}",
                reminderType = notificationTitle,
            )
        )
        dataStoreManager.getNotificationId.collectLatest { it ->
            NotificationBridge(context as Activity).SetNotification(
                it,
                duration,
                notificationTitle,
                reminderDescription,
                100,
                2,
                "",
                "",
                "${R.mipmap.ic_launcher}",
                "${R.mipmap.ic_launcher}",
                "#FF141414",
                channel,
                "#FFB2B2B2"
            )

            notificationId = it
        }

        dataStoreManager.storeNotificationId(notificationId + 1)

    }

    context.showMessage(" $notificationTitle تنظیم شد")


}

@RequiresApi(Build.VERSION_CODES.O)
fun calculateDuration(mHour: Int, mMinute: Int): Long {
    val selectedTime = LocalTime.of(mHour, mMinute)
    val currentDate = LocalDateTime.now().toLocalDate()
    val selectedDateTime = LocalDateTime.of(currentDate, selectedTime)
    return Duration.between(LocalDateTime.now(), selectedDateTime).toMillis()
}