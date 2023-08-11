package zahra.hosseini.hemophiliaapp.main.ui.root

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.coroutines.launch
import zahra.hosseini.hemophiliaapp.R
import zahra.hosseini.hemophiliaapp.authentication.AuthenticationViewModel
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.component.LargeDropdownMenu
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.component.RtlLabelInOutlineTextField
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.theme.hemophiliaColors

@Composable
fun ProfileScreen(
    viewModel: AuthenticationViewModel = hiltViewModel(),
) {
    val scrollState = rememberScrollState()
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()

    var (phoneNumber, setPhoneNumber) = remember { mutableStateOf("") }
    var (weight, setWeight) = remember { mutableStateOf("") }
    var (height, setHeight) = remember { mutableStateOf("") }
    var (age, setAge) = remember { mutableStateOf("") }
    var (timeOfDiagnosis, setTimeOfDiagnosis) = remember { mutableStateOf("") }

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
            .padding(top = 30.dp, bottom = 60.dp),
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


    }
}

@Preview(showBackground = true)
@Composable
fun BottomNavigationPreview() {
    ProfileScreen()
}