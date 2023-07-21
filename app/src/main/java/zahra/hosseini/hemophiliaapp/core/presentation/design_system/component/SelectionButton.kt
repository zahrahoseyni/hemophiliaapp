package zahra.hosseini.hemophiliaapp.core.presentation.design_system.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SelectionButton(
    text: String, onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .padding(16.dp),
        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colors.onPrimary),
        border = BorderStroke(1.dp, MaterialTheme.colors.secondary),
        shape = MaterialTheme.shapes.medium

    ) {
        Text(
            text,
            modifier = Modifier.fillMaxWidth(),
            fontSize = 18.sp,
            color = MaterialTheme.colors.secondary,
            textAlign = TextAlign.Right
        )
    }
}