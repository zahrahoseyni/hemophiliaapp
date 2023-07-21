package zahra.hosseini.hemophiliaapp.core.presentation.design_system.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.theme.hemophiliaColors
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.theme.hemophiliaTypography


@Composable
fun DefaultButton(
    text: String, onClick: () -> Unit,
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .padding(16.dp),
        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.hemophiliaColors.designSystem.Primary),
        shape = MaterialTheme.shapes.medium

    ) {
        Text(
            text, style = MaterialTheme.hemophiliaTypography.text18Bold,
            color = MaterialTheme.hemophiliaColors.designSystem.OnPrimary,
        )
    }
}