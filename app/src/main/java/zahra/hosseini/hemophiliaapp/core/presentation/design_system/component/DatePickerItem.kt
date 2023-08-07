package zahra.hosseini.hemophiliaapp.core.presentation.design_system.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.theme.hemophiliaColors
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.theme.hemophiliaTypography
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.theme.regularFont

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PickerItem(value: String?, label: String, onDateOrTimePickerItemClicked: () -> Unit) {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {

        Box(
            modifier = Modifier
                .height(IntrinsicSize.Min)
                .fillMaxWidth()
                .padding(top = 8.dp, start = 16.dp, end = 16.dp, bottom = 8.dp)
                .clickable(onClick = onDateOrTimePickerItemClicked)
        ) {
            OutlinedTextField(
                label = {
                    Text(
                        text = label,
                        style = MaterialTheme.hemophiliaTypography.text12,
                        color = MaterialTheme.hemophiliaColors.designSystem.Neutral30,
                    )
                },
                value = value ?: "",
                enabled = true,
                textStyle = TextStyle(
                    fontFamily = regularFont,
                    fontSize = 14.sp,
                    letterSpacing = 5.sp,
                    color = MaterialTheme.hemophiliaColors.designSystem.PrimaryText,
                ),
                modifier = Modifier
                    .fillMaxWidth(),
                trailingIcon = {

                },
                onValueChange = { },
                readOnly = true,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = MaterialTheme.hemophiliaColors.designSystem.Neutral25,
                    unfocusedBorderColor = MaterialTheme.hemophiliaColors.designSystem.Neutral30
                )
            )

            // Transparent clickable surface on top of OutlinedTextField
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 8.dp)
                    .clip(MaterialTheme.shapes.extraSmall),
                // .clickable(enabled = enabled) { expanded = true },
                color = Color.Transparent,
            ) {}
        }
    }
}