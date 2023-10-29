package zahra.hosseini.hemophiliaapp.main.home.presentation

import android.annotation.SuppressLint
import androidx.activity.compose.BackHandler
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import zahra.hosseini.hemophiliaapp.R
import zahra.hosseini.hemophiliaapp.core.presentation.MainActivity
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.component.ListItemComponent
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.component.TableHeader
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.theme.hemophiliaColors
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.theme.hemophiliaTypography
import zahra.hosseini.hemophiliaapp.main.bleeding.BleedingViewModel
import zahra.hosseini.hemophiliaapp.main.home.data.ReportModel
import zahra.hosseini.hemophiliaapp.main.home.presentation.floatingactionbutton.FabIcon
import zahra.hosseini.hemophiliaapp.main.home.presentation.floatingactionbutton.FabOption
import zahra.hosseini.hemophiliaapp.main.home.presentation.floatingactionbutton.MultiFabItem
import zahra.hosseini.hemophiliaapp.main.home.presentation.floatingactionbutton.MultiFloatingActionButton
import zahra.hosseini.hemophiliaapp.main.injection.InjectionViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "StateFlowValueCalledInComposition")
@OptIn(ExperimentalAnimationApi::class)
@Composable
fun HomeScreen(
    injectionViewModel: InjectionViewModel = hiltViewModel(),
    bleedingViewModel: BleedingViewModel = hiltViewModel(),
    navigateToRegisterBleeding: () -> Unit,
    navigateToRegisterInjection: () -> Unit,
    navigateToRegisterNotInjection: () -> Unit,
    navigateToDoctors: () -> Unit,
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
                ),
                MultiFabItem(
                    id = 4,
                    iconRes = R.drawable.ic_call,
                    label = stringResource(R.string.doctor_appointment)
                )
            ),
            fabIcon = FabIcon(iconRes = R.drawable.ic_edit, iconRotate = 45f),
            onFabItemClicked = {
                when (it.id) {
                    1 -> navigateToRegisterInjection()
                    2 -> navigateToRegisterNotInjection()
                    3 -> navigateToRegisterBleeding()
                    4 -> navigateToDoctors()
                }
            },
            fabOption = FabOption(
                iconTint = Color.White,
                showLabel = true
            )
        )
    }) {
        bleedingViewModel.getAllBleedingList()
        injectionViewModel.getAllInjectionList()
        injectionViewModel.getAllNotInjectionList()

        val notInjectionList = injectionViewModel.notInjectionList.value
        val injectionList = injectionViewModel.injectionList.value
        val bleedingList = bleedingViewModel.bleedingList.value

        val reportList = ArrayList<ReportModel>()

        if (notInjectionList.isNotEmpty()) {
            notInjectionList.forEach { entity ->
                reportList.add(ReportModel(date = entity.notInjectionDate, injection = "نداشتم"))
            }
        }

        if (injectionList.isNotEmpty()) {
            injectionList.forEach { entity ->
                reportList.add(ReportModel(date = entity.injectionDate, injection = "داشتم"))
            }
        }

        if (bleedingList.isNotEmpty()) {
            bleedingList.forEach { entity ->
                reportList.add(
                    ReportModel(
                        date = entity.bleedingDate,
                        bleeding = "داشتم",
                        bleedingReason = entity.bleedingReason
                    )
                )
            }
        }

        if (reportList.isNotEmpty()) {
            LazyColumn(
                modifier = Modifier.padding(
                    top = 30.dp, bottom = 100.dp
                )
            ) {
                item {
                    TableHeader(
                        modifier = Modifier,
                        title1 = stringResource(id = R.string.injection),
                        title2 = stringResource(id = R.string.bleeding),
                        title3 = stringResource(id = R.string.date)
                    )
                }

                reportList.forEach { reportModel ->
                    item {
                        ListItemComponent(modifier = Modifier, reportModel)
                    }
                }

            }
        } else {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(), contentAlignment = Alignment.Center
            ) {
                Text(
                    text = stringResource(id = R.string.no_data),
                    style = MaterialTheme.hemophiliaTypography.text20Medium,
                    color = MaterialTheme.hemophiliaColors.designSystem.Neutral30,
                    textAlign = TextAlign.Center,
                )
            }
        }

    }

    BackHandler(enabled = true) {
        (context as MainActivity).onBackPress()
    }

}

