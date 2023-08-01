package zahra.hosseini.hemophiliaapp.core.presentation.design_system.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import zahra.hosseini.hemophiliaapp.core.extension.toPersianNumber
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.theme.hemophiliaColors
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.theme.hemophiliaTypography

@Composable
fun NumberButton(
    number: Int,
    modifier: Modifier = Modifier,
    isSelected: Boolean,
    onButtonClicked: () -> Unit
) {

    Button(
        onClick = {
            onButtonClicked()
        }, modifier = modifier
            .wrapContentHeight()
            .wrapContentWidth()
            .padding(3.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.hemophiliaColors.designSystem.OnPrimary,
            disabledContainerColor = MaterialTheme.hemophiliaColors.designSystem.Neutral30
        ),
        border = BorderStroke(1.dp, MaterialTheme.hemophiliaColors.designSystem.Neutral30),
        shape = androidx.compose.material.MaterialTheme.shapes.medium,
        enabled = !isSelected
    ) {
        Text(
            number.toString().toPersianNumber(),
            style = MaterialTheme.hemophiliaTypography.text12,
            color = if (!isSelected)
                MaterialTheme.hemophiliaColors.designSystem.PrimaryText
            else MaterialTheme.hemophiliaColors.designSystem.OnPrimary,
        )
    }

    // return ""
}

