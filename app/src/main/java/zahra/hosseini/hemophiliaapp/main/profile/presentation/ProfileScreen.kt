package zahra.hosseini.hemophiliaapp.main.profile.presentation

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import zahra.hosseini.hemophiliaapp.R
import zahra.hosseini.hemophiliaapp.authentication.AuthenticationViewModel
import zahra.hosseini.hemophiliaapp.core.datastore.DataStoreManager
import zahra.hosseini.hemophiliaapp.core.presentation.MainActivity
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.component.LargeDropdownMenu
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.component.RtlLabelInOutlineTextField
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.theme.*

@Composable
fun ProfileScreen(
    viewModel: AuthenticationViewModel = hiltViewModel(),
    navigateToAboutUs: () -> Unit,
    navigateToLogin: () -> Unit,
    navigateToPasswordScreen: () -> Unit,
) {
    val scrollState = rememberScrollState()
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    val logOutDialog = remember { mutableStateOf(false) }
    val dataStoreManager = DataStoreManager(context)

    val (phoneNumber, setPhoneNumber) = remember { mutableStateOf("") }
    val (weight, setWeight) = remember { mutableStateOf("") }
    val (height, setHeight) = remember { mutableStateOf("") }
    val (bmi, setBmi) = remember { mutableStateOf("") }
    val (age, setAge) = remember { mutableStateOf("") }
    val (timeOfDiagnosis, setTimeOfDiagnosis) = remember { mutableStateOf("") }
    val sexOptions = listOf(stringResource(id = R.string.woman), stringResource(id = R.string.man))
    var sexSelectedIndex by remember { mutableStateOf(-1) }

    val familyHistoryOptions =
        listOf(stringResource(id = R.string.have), stringResource(id = R.string.have_not))
    var familyHistorySelectedIndex by remember { mutableStateOf(-1) }


    if (logOutDialog.value) {
        CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl)
        {
            AlertDialog(
                onDismissRequest = {
                    // Dismiss the dialog when the user clicks outside the dialog or on the back button.
                    // If you want to disable that functionality, simply leave this block empty.
                    logOutDialog.value = false
                },
                confirmButton = {
                    TextButton(onClick = {
                        // perform the confirm action and
                        // close the dialog
                        CoroutineScope(Dispatchers.IO).launch {
                            dataStoreManager.storePhoneNumber(phoneNumber = "")
                            dataStoreManager.storeUserLogin(false)
                        }
                        navigateToLogin()
                        logOutDialog.value = false
                    }) {
                        Text(
                            text = stringResource(id = R.string.yes),
                            style = MaterialTheme.hemophiliaTypography.text12Bold,
                            color = MaterialTheme.hemophiliaColors.designSystem.Neutral40
                        )
                    }
                },
                dismissButton = {
                    TextButton(onClick = {
                        // close the dialog
                        logOutDialog.value = false
                    }) {
                        Text(
                            text = stringResource(id = R.string.no),
                            style = MaterialTheme.hemophiliaTypography.text12Bold,
                            color = MaterialTheme.hemophiliaColors.designSystem.Primary
                        )
                    }
                },
                title = {
                    Text(
                        text = stringResource(id = R.string.logout_title),
                        style = MaterialTheme.hemophiliaTypography.text14Medium,
                        color = MaterialTheme.hemophiliaColors.designSystem.PrimaryText,
                        // textAlign = TextAlign.End
                    )
                },
                text = {
                    Text(
                        text = stringResource(id = R.string.logout_description),
                        style = MaterialTheme.hemophiliaTypography.text12,
                        color = MaterialTheme.hemophiliaColors.designSystem.Neutral50,
                        // textAlign = TextAlign.End
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(32.dp),
                shape = RoundedCornerShape(5.dp),
                // backgroundColor = Color.White
            )
        }
    }

    LaunchedEffect(Unit) {
        coroutineScope.launch {
            viewModel.getUserDetails()
            viewModel.userDetails.collect { user ->
                setPhoneNumber(user.phoneNumber)
                setWeight(user.weight)
                setHeight(user.height)
                setBmi(user.bmi)
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
                    2.dp, MaterialTheme.hemophiliaColors.designSystem.Neutral30, CircleShape
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
            inputLength = 11
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
            inputLength = 3
        )

        RtlLabelInOutlineTextField(
            label = stringResource(id = R.string.height),
            inputType = KeyboardType.NumberPassword,
            value = height,
            setValue = setHeight,
            inputLength = 3
        )


        if (bmi.isNotEmpty()) {
            val color = when (bmi.toFloat()) {
                in 0F..18.5F -> Blue
                in 18.6F..24.9F -> Green
                in 25F..29.9F -> Yellow
                in 30F..34.9F -> Orange
                else -> Red
            }
            RtlLabelInOutlineTextField(
                label = stringResource(id = R.string.bmi_title),
                inputType = KeyboardType.NumberPassword,
                value = bmi,
                setValue = setBmi,
                inputLength = 3,
                textColor = color
            )
        }

        RtlLabelInOutlineTextField(
            label = stringResource(id = R.string.age),
            inputType = KeyboardType.NumberPassword,
            value = age,
            setValue = setAge,
            inputLength = 3
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
            inputLength = 3
        )

        OutlinedCard(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = MaterialTheme.hemophiliaColors.designSystem.Neutral00)
                .padding(16.dp),
            border = BorderStroke(
                width = 1.dp, color = MaterialTheme.hemophiliaColors.designSystem.Neutral20
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
                                start = 12.dp, end = 12.dp, top = 8.dp, bottom = 16.dp
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
                                start = 12.dp, end = 12.dp, top = 8.dp, bottom = 16.dp
                            )
                            .clickable {
                                navigateToPasswordScreen()
                            },
                        text = stringResource(id = R.string.password),
                        style = MaterialTheme.hemophiliaTypography.text14Medium,
                        color = MaterialTheme.hemophiliaColors.designSystem.Neutral50,
                    )

                    Text(
                        modifier = Modifier
                            .padding(
                                start = 12.dp, end = 12.dp, top = 8.dp, bottom = 16.dp
                            )
                            .clickable {
                                logOutDialog.value = true
                            },
                        text = stringResource(id = R.string.log_out),
                        style = MaterialTheme.hemophiliaTypography.text14Medium,
                        color = MaterialTheme.hemophiliaColors.designSystem.Neutral50,
                    )
                }
            }
        }
    }


    BackHandler(enabled = true) {
        (context as MainActivity).onBackPress()
    }
}
