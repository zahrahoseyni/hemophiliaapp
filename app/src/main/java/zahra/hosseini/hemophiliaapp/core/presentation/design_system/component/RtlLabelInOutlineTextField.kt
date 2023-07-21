package zahra.hosseini.hemophiliaapp.core.presentation.design_system.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.theme.hemophiliaColors
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.theme.hemophiliaTypography
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.theme.regularFont

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RtlLabelInOutlineTextField(label: String, inputType: KeyboardType) {
    val (digit1, setDigit1) = remember {
        mutableStateOf("")
    }
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        OutlinedTextField(
            value = digit1,
            onValueChange = {
                setDigit1(it)
            },
            label = {
                Text(
                    text = label,
                    style = MaterialTheme.hemophiliaTypography.text14,
                    color = MaterialTheme.hemophiliaColors.designSystem.Neutral30,
                )
            },
            textStyle = androidx.compose.ui.text.TextStyle(
                fontFamily = regularFont,
                fontSize = 14.sp, color = MaterialTheme.hemophiliaColors.designSystem.PrimaryText,
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = inputType,
                imeAction = ImeAction.Next,
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp, start = 16.dp, end = 16.dp, bottom = 8.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = MaterialTheme.hemophiliaColors.designSystem.Neutral25,
                unfocusedBorderColor = MaterialTheme.hemophiliaColors.designSystem.Neutral30
            )
        )
    }
}