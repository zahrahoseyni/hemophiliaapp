package zahra.hosseini.hemophiliaapp.main.ui.root

import android.app.Activity
import android.app.TimePickerDialog
import android.content.Context
import android.os.Build
import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
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
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.component.ReminderCard
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.theme.hemophiliaColors
import java.time.Duration
import java.time.LocalDateTime
import java.time.LocalTime
import java.util.*
import kotlin.properties.Delegates

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ReminderScreen() {

    val context = LocalContext.current

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

        // Declaring and initializing a calendar
        val mCalendar = Calendar.getInstance()
        val mHour = mCalendar[Calendar.HOUR_OF_DAY]
        val mMinute = mCalendar[Calendar.MINUTE]

        // Creating a TimePicker dialog
        val mTimePickerDialog = TimePickerDialog(
            context, R.style.TimePickerTheme, { _, mHour: Int, mMinute: Int ->
                selectedTime = "${mHour}:${mMinute}".formatTime()
                setReminder(mHour, mMinute, context, notificationTitle)
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


    }
    BackHandler(enabled = true) {
        (context as MainActivity).onBackPress()
    }
}

@RequiresApi(Build.VERSION_CODES.O)
fun setReminder(mHour: Int, mMinute: Int, context: Context, notificationTitle: String) {

    val channel = "channel"
    val duration = calculateDuration(mHour, mMinute)
    val dataStoreManager = DataStoreManager(context)
    var notificationId by Delegates.notNull<Int>()

    CoroutineScope(Dispatchers.IO).launch {
        dataStoreManager.getNotificationId.collectLatest { it ->
            NotificationBridge(context as Activity).SetNotification(
                it,
                duration,
                notificationTitle,
                "یادآوری",
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