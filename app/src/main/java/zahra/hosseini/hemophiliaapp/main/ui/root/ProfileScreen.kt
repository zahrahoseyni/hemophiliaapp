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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.coroutines.launch
import zahra.hosseini.hemophiliaapp.R
import zahra.hosseini.hemophiliaapp.authentication.AuthenticationViewModel
import zahra.hosseini.hemophiliaapp.authentication.data.EmptyUserInfoEntity
import zahra.hosseini.hemophiliaapp.authentication.data.UserInfoEntity
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.component.ProfileRowItem
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.theme.hemophiliaColors

@Composable
fun ProfileScreen(
    viewModel: AuthenticationViewModel = hiltViewModel(),
) {

    val scrollState = rememberScrollState()
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    var userInfoEntity by remember { mutableStateOf(EmptyUserInfoEntity()) }

    LaunchedEffect(Unit) {
        coroutineScope.launch {
            viewModel.getUserDetails()
            viewModel.userDetails.collect { user ->
                userInfoEntity = user as EmptyUserInfoEntity
            }

        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(state = scrollState)
            .fillMaxHeight()
            .padding(top = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
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

        val familyHistory = when (userInfoEntity.familyHistory) {
            true -> "سابقه خانوادگی دارم"
            false -> "سابقه خانوادگی ندارم"
            else -> {
                "_"
            }
        }

        ProfileRowItem(label = userInfoEntity.phoneNumber, iconRes = R.drawable.ic_outline_group_add_24)
        ProfileRowItem(label = userInfoEntity.sex, iconRes = R.drawable.ic_outline_group_add_24)
        ProfileRowItem(label = userInfoEntity.weight, iconRes = R.drawable.ic_outline_group_add_24)
        ProfileRowItem(label = userInfoEntity.height, iconRes = R.drawable.ic_outline_group_add_24)
        ProfileRowItem(label = userInfoEntity.age, iconRes = R.drawable.ic_outline_group_add_24)
        ProfileRowItem(label = familyHistory, iconRes = R.drawable.ic_outline_group_add_24)
        ProfileRowItem(label = "${userInfoEntity.timeOfDiagnosis} سالگی", iconRes = R.drawable.ic_outline_group_add_24)


    }
}

@Preview(showBackground = true)
@Composable
fun BottomNavigationPreview() {
    ProfileScreen()
}