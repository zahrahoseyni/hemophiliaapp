package zahra.hosseini.hemophiliaapp.main.ui.root

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import zahra.hosseini.hemophiliaapp.R
import zahra.hosseini.hemophiliaapp.main.ui.floatingactionbutton.FabIcon
import zahra.hosseini.hemophiliaapp.main.ui.floatingactionbutton.FabOption
import zahra.hosseini.hemophiliaapp.main.ui.floatingactionbutton.MultiFabItem
import zahra.hosseini.hemophiliaapp.main.ui.floatingactionbutton.MultiFloatingActionButton

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@OptIn(ExperimentalAnimationApi::class)
@Composable
fun HomeScreen() {

    val context = LocalContext.current

    Scaffold(floatingActionButton = {
        MultiFloatingActionButton(
            modifier = Modifier.padding(bottom = 60.dp),
            items = listOf(
                MultiFabItem(
                    id = 1,
                    iconRes = R.drawable.ic_outline_person_add_24,
                    label = "Add User"
                ),
                MultiFabItem(
                    id = 2,
                    iconRes = R.drawable.ic_outline_group_add_24,
                    label = "Create Group"
                ),
                MultiFabItem(
                    id = 3,
                    iconRes = R.drawable.ic_outline_video_call_24,
                    label = "Video Call"
                )
            ),
            fabIcon = FabIcon(iconRes = R.drawable.ic_baseline_add_24, iconRotate = 45f),
            onFabItemClicked = {
                Toast.makeText(context, it.label, Toast.LENGTH_SHORT).show()
            },
            fabOption = FabOption(
                iconTint = Color.White,
                showLabel = true
            )
        )
    }) {}
}

