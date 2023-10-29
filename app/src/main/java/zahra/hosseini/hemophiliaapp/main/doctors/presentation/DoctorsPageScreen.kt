package zahra.hosseini.hemophiliaapp.main.doctors.presentation

import android.annotation.SuppressLint
import android.app.TimePickerDialog
import android.os.Build
import androidx.activity.compose.BackHandler
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
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
import zahra.hosseini.hemophiliaapp.core.navigation.NavRoute
import zahra.hosseini.hemophiliaapp.core.presentation.MainActivity
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.component.*
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.theme.hemophiliaColors
import zahra.hosseini.hemophiliaapp.main.doctors.data.model.DoctorModel
import zahra.hosseini.hemophiliaapp.main.injection.InjectionViewModel
import zahra.hosseini.hemophiliaapp.main.injection.data.model.InjectionEntity
import zahra.hosseini.hemophiliaapp.main.reminder.ReminderViewModel
import zahra.hosseini.hemophiliaapp.main.reminder.presentation.setReminder
import java.util.*

@SuppressLint("StateFlowValueCalledInComposition")
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DoctorsPageScreen(
    navigateToHome: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = MaterialTheme.hemophiliaColors.designSystem.Neutral00)
            .padding(top = 30.dp, bottom = 70.dp, start = 16.dp, end = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        val doctorList = listOf(
            DoctorModel(
                name = "دکتر محمد رضا دبیری",
                expertise = "هموفیلی",
                phoneNumber = " 09173138112"
            ),
            DoctorModel(name = "دکتر غلامرضا توگه", expertise = "هموفیلی", phoneNumber = ""),
            DoctorModel(name = "دکتر امیرحسین امامی", expertise = "هموفیلی", phoneNumber = ""),
            DoctorModel(name = "دکتر مهرزاد میرزانیا", expertise = "هموفیلی", phoneNumber = ""),
            DoctorModel(name = "دکتر فرهاد شاهی", expertise = "هموفیلی", phoneNumber = ""),
            DoctorModel(name = "دکتر سید رضا صفایی", expertise = "هموفیلی", phoneNumber = ""),
            DoctorModel(name = "دکتر محسن اسفندبد", expertise = "هموفیلی", phoneNumber = ""),
            DoctorModel(name = "دکتر کامران رودینی", expertise = "هموفیلی", phoneNumber = ""),
            DoctorModel(name = "دکتر احمد خواجه مهریزی", expertise = "هموفیلی", phoneNumber = ""),
            DoctorModel(name = "دکتر علی مجیدی نژاد", expertise = "هموفیلی", phoneNumber = ""),
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp),
            horizontalAlignment = Alignment.End
        ) {

            item {
                TableHeader(
                    modifier = Modifier,
                    title1 = stringResource(id = R.string.details),
                    title2 = stringResource(id = R.string.doctor_expertise),
                    title3 = stringResource(id = R.string.doctor_name),
                    weight1 = 1.5F
                )

            }

            doctorList.forEach {
                item {
                    DoctorItemComponent(modifier = Modifier, it)
                }
            }
        }
    }
}

