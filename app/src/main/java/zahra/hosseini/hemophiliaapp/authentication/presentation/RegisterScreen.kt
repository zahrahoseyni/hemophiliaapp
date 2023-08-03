package zahra.hosseini.hemophiliaapp.authentication.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import zahra.hosseini.hemophiliaapp.R
import zahra.hosseini.hemophiliaapp.authentication.AuthenticationViewModel
import zahra.hosseini.hemophiliaapp.core.datastore.DataStoreManager
import zahra.hosseini.hemophiliaapp.core.datastore.UserInfo
import zahra.hosseini.hemophiliaapp.core.extension.showMessage
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.component.DefaultButton
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.component.LargeDropdownMenu
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.component.RtlLabelInOutlineTextField
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.theme.hemophiliaColors
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.theme.hemophiliaTypography

@Composable
fun RegisterScreen(
    viewModel: AuthenticationViewModel = hiltViewModel(),
    navigateToHome: () -> Unit,
) {
    val context = LocalContext.current

    Column(
        modifier = Modifier.padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val (weight, setWeight) = remember { mutableStateOf("") }
        val (height, setHeight) = remember { mutableStateOf("") }
        val (age, setAge) = remember { mutableStateOf("") }
        val (timeOfDiagnosis, setTimeOfDiagnosis) = remember { mutableStateOf("") }


        val sexOptions =
            listOf(stringResource(id = R.string.woman), stringResource(id = R.string.man))
        var sexSelectedIndex by remember { mutableStateOf(-1) }

        val familyHistoryOptions =
            listOf(stringResource(id = R.string.have), stringResource(id = R.string.have_not))
        var familyHistorySelectedIndex by remember { mutableStateOf(-1) }

        Text(
            text = stringResource(id = R.string.enter_your_data),
            style = MaterialTheme.hemophiliaTypography.text18Medium,
            color = MaterialTheme.hemophiliaColors.designSystem.PrimaryText,
            modifier = Modifier.padding(top = 20.dp, bottom = 10.dp)
        )


        LargeDropdownMenu(
            label = stringResource(id = R.string.sex),
            items = sexOptions,
            selectedIndex = sexSelectedIndex,
            onItemSelected = { index, _ -> sexSelectedIndex = index },
        )

        RtlLabelInOutlineTextField(
            label = stringResource(id = R.string.weight),
            inputType = KeyboardType.NumberPassword,
            value = weight,
            setValue = setWeight,
            3
        )

        RtlLabelInOutlineTextField(
            label = stringResource(id = R.string.height),
            inputType = KeyboardType.NumberPassword,
            value = height,
            setValue = setHeight,
            3
        )

        RtlLabelInOutlineTextField(
            label = stringResource(id = R.string.age),
            inputType = KeyboardType.NumberPassword,
            value = age,
            setValue = setAge,
            3
        )

        LargeDropdownMenu(
            label = stringResource(id = R.string.family_history),
            items = familyHistoryOptions,
            selectedIndex = familyHistorySelectedIndex,
            onItemSelected = { index, _ -> familyHistorySelectedIndex = index },
        )

        RtlLabelInOutlineTextField(
            label = stringResource(id = R.string.timeـofـdiagnosis),
            inputType = KeyboardType.NumberPassword,
            value = timeOfDiagnosis,
            setValue = setTimeOfDiagnosis,
            3
        )

        Spacer(modifier = Modifier.padding(16.dp))

        DefaultButton(text = stringResource(id = R.string.submit)) {
            if (weight.isEmpty() || height.isEmpty() || age.isEmpty()
                || timeOfDiagnosis.isEmpty() || sexSelectedIndex == -1 || familyHistorySelectedIndex == -1
            ) {
                context.showMessage(context.getString(R.string.un_complete_form_message))

            } else {
                CoroutineScope(Dispatchers.IO).launch {
                    val familyHistory = when (familyHistoryOptions[familyHistorySelectedIndex]) {
                        context.resources.getString(R.string.have) -> true
                        context.resources.getString(R.string.have_not) -> false
                        else -> {}
                    }
                    /*     dataStoreManager.storeUserInfo(
                             userInfo = UserInfo(
                                 age = age,
                                 weight = weight,
                                 height = height,
                                 sex = sexOptions[sexSelectedIndex],
                                 family_history = familyHistory as Boolean,
                                 timeOfDiagnosis = timeOfDiagnosis
                             )
                         )*/
                }
                navigateToHome()
            }
        }


    }
}

