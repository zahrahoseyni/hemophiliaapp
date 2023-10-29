package zahra.hosseini.hemophiliaapp.core.presentation.design_system.component

import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import zahra.hosseini.hemophiliaapp.R
import zahra.hosseini.hemophiliaapp.core.extension.formatTime
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.theme.hemophiliaColors
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.theme.hemophiliaTypography
import zahra.hosseini.hemophiliaapp.main.doctors.data.model.DoctorModel
import zahra.hosseini.hemophiliaapp.main.reminder.data.model.ReminderEntity

@Composable
fun DoctorItemComponent(modifier: Modifier = Modifier, doctor: DoctorModel) {
    val context = LocalContext.current

    Column(verticalArrangement = Arrangement.Center, modifier = modifier.fillMaxWidth()) {

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 16.dp,
                    end = 16.dp,
                ),
            verticalAlignment = Alignment.CenterVertically,
        ) {

            Button(
                onClick = {
                    if (doctor.phoneNumber?.isEmpty() == true) {
                        Toast.makeText(context, "شماره تماس پزشک مورد نظر ثبت نشده است.", Toast.LENGTH_LONG).show()
                    } else {
                        val u = Uri.parse("tel:" + doctor.phoneNumber)

                        val i = Intent(Intent.ACTION_DIAL, u)
                        try {
                            context.startActivity(i)
                        } catch (s: SecurityException) {

                            Toast.makeText(context, "خطایی رخ داده است", Toast.LENGTH_LONG).show()
                        }
                    }

                },
                modifier = Modifier
                    .weight(1.5F)
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.hemophiliaColors.designSystem.action),
                shape = MaterialTheme.shapes.medium

            ) {
                Text(
                    text = stringResource(id = R.string.call),
                    style = MaterialTheme.hemophiliaTypography.text10,
                    color = MaterialTheme.hemophiliaColors.designSystem.OnPrimary,
                )
            }


            Text(
                text = doctor.expertise,
                modifier = modifier.weight(2F),
                style = MaterialTheme.hemophiliaTypography.text14,
                color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                textAlign = TextAlign.Center
            )
            Text(
                text = doctor.name,
                modifier = modifier.weight(2F),
                style = MaterialTheme.hemophiliaTypography.text14,
                color = MaterialTheme.hemophiliaColors.designSystem.Neutral45,
                textAlign = TextAlign.End
            )
        }

        Divider(
            color = MaterialTheme.hemophiliaColors.designSystem.Neutral10,
            thickness = 1.dp,
            modifier = Modifier.padding(top = 12.dp, bottom = 12.dp)
        )
    }
}

