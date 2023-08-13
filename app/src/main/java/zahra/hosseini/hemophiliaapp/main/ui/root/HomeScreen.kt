package zahra.hosseini.hemophiliaapp.main.ui.root

import android.annotation.SuppressLint
import android.app.Activity
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.coroutines.launch
import zahra.hosseini.hemophiliaapp.R
import zahra.hosseini.hemophiliaapp.authentication.AuthenticationViewModel
import zahra.hosseini.hemophiliaapp.core.presentation.MainActivity
import zahra.hosseini.hemophiliaapp.main.InjectionViewModel
import zahra.hosseini.hemophiliaapp.main.ui.BleedingViewModel
import zahra.hosseini.hemophiliaapp.main.ui.floatingactionbutton.FabIcon
import zahra.hosseini.hemophiliaapp.main.ui.floatingactionbutton.FabOption
import zahra.hosseini.hemophiliaapp.main.ui.floatingactionbutton.MultiFabItem
import zahra.hosseini.hemophiliaapp.main.ui.floatingactionbutton.MultiFloatingActionButton
import kotlin.math.log

@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "StateFlowValueCalledInComposition")
@OptIn(ExperimentalAnimationApi::class)
@Composable
fun HomeScreen(
    authenticationViewModel: AuthenticationViewModel = hiltViewModel(),
    injectionViewModel: InjectionViewModel = hiltViewModel(),
    bleedingViewModel: BleedingViewModel = hiltViewModel(),
    navigateToRegisterBleeding: () -> Unit,
    navigateToRegisterInjection: () -> Unit,
    navigateToRegisterNotInjection: () -> Unit,
) {

    val context = LocalContext.current

    Scaffold(floatingActionButton = {
        MultiFloatingActionButton(
            modifier = Modifier.padding(bottom = 60.dp),
            items = listOf(
                MultiFabItem(
                    id = 1,
                    iconRes = R.drawable.ic_injection,
                    label = stringResource(R.string.register_injection)
                ),
                MultiFabItem(
                    id = 2,
                    iconRes = R.drawable.ic_not_injection,
                    label = stringResource(R.string.register_not_injection)
                ),
                MultiFabItem(
                    id = 3,
                    iconRes = R.drawable.ic_bleeding,
                    label = stringResource(R.string.register_bleeding)
                )
            ),
            fabIcon = FabIcon(iconRes = R.drawable.ic_baseline_add_24, iconRotate = 45f),
            onFabItemClicked = {
                when (it.id) {
                    1 -> navigateToRegisterInjection()
                    2 -> navigateToRegisterNotInjection()
                    3 -> navigateToRegisterBleeding()
                }
            },
            fabOption = FabOption(
                iconTint = Color.White,
                showLabel = true
            )
        )
    }) {
/*        injectionViewModel.getAllNotInjectionList()
        if (injectionViewModel.notInjectionList.value.isNotEmpty()) {
            Log.d("jfsd", injectionViewModel.notInjectionList.value[0].injectionReason)
            Log.d("jfsd", injectionViewModel.notInjectionList.value[0].notInjectionId.toString())
            Log.d("jfsd", injectionViewModel.notInjectionList.value[0].injectionDate)
        }*/


    }

    BackHandler(enabled = true) {
        (context as MainActivity).onBackPress()
    }

}

