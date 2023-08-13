package zahra.hosseini.hemophiliaapp.main.ui.root

import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.coroutines.launch
import zahra.hosseini.hemophiliaapp.R
import zahra.hosseini.hemophiliaapp.authentication.AuthenticationViewModel
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.component.LargeDropdownMenu
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.component.RtlLabelInOutlineTextField
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.theme.hemophiliaColors
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.theme.hemophiliaTypography

@Composable
fun ProfileScreen(
    viewModel: AuthenticationViewModel = hiltViewModel(),
    navigateToAboutUs: () -> Unit,
    navigateToLogin: () -> Unit,
) {
    val scrollState = rememberScrollState()
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()

    val (phoneNumber, setPhoneNumber) = remember { mutableStateOf("") }
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

    LaunchedEffect(Unit) {
        coroutineScope.launch {
            viewModel.getUserDetails()
            viewModel.userDetails.collect { user ->
                setPhoneNumber(user.phoneNumber)
                setWeight(user.weight)
                setHeight(user.height)
                setAge(user.age)
                setTimeOfDiagnosis(user.timeOfDiagnosis)
                sexSelectedIndex = when (user.sex) {
                    "مرد" -> 0
                    "زن" -> 1
                    else -> {
                        -1
                    }
                }
                familyHistorySelectedIndex = when (user.familyHistory) {
                    true -> 0
                    false -> 1
                }
            }

        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(state = scrollState)
            .fillMaxHeight()
            .background(color = MaterialTheme.hemophiliaColors.designSystem.Neutral00)
            .padding(top = 30.dp, bottom = 70.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        Image(
            painter = painterResource(R.drawable.ic_profile),
            contentDescription = "avatar",
            contentScale = ContentScale.Crop,            // crop the image if it's not a square
            modifier = Modifier
                .size(64.dp)
                .clip(CircleShape)                       // clip to the circle shape
                .border(
                    2.dp,
                    MaterialTheme.hemophiliaColors.designSystem.Neutral30,
                    CircleShape
                )
        )

        Spacer(
            Modifier
                .fillMaxWidth()
                .height(30.dp)
        )

        RtlLabelInOutlineTextField(
            label = stringResource(id = R.string.phone_number),
            inputType = KeyboardType.Number,
            value = phoneNumber,
            setValue = setPhoneNumber,
            11
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

        OutlinedCard(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = MaterialTheme.hemophiliaColors.designSystem.Neutral00)
                .padding(16.dp),
            border = BorderStroke(
                width = 1.dp,
                color = MaterialTheme.hemophiliaColors.designSystem.Neutral20
            ),
        ) {
            CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    verticalArrangement = Arrangement.spacedBy(5.dp)
                ) {
                    Text(
                        modifier = Modifier
                            .padding(
                                start = 12.dp,
                                end = 12.dp,
                                top = 8.dp,
                                bottom = 16.dp
                            )
                            .clickable {
                                navigateToAboutUs()
                            },
                        text = stringResource(id = R.string.about_us),
                        style = MaterialTheme.hemophiliaTypography.text14Medium,
                        color = MaterialTheme.hemophiliaColors.designSystem.Neutral50,
                    )

                    Text(
                        modifier = Modifier
                            .padding(
                                start = 12.dp,
                                end = 12.dp,
                                top = 8.dp,
                                bottom = 16.dp
                            )
                            .clickable {

                            },
                        text = stringResource(id = R.string.log_out),
                        style = MaterialTheme.hemophiliaTypography.text14Medium,
                        color = MaterialTheme.hemophiliaColors.designSystem.Neutral50,
                    )
                }
            }
        }
    }

}
