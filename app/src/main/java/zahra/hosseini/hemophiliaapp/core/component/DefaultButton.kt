package zahra.hosseini.hemophiliaapp.core.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DefaultButton(
    text: String, onClick: () -> Unit
) {
    Button(
        onClick = onClick, modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .padding(16.dp)
            .background(shape = MaterialTheme.shapes.medium, color = MaterialTheme.colors.primary)
    ) {
        Text(text, fontSize = 18.sp, color = MaterialTheme.colors.onPrimary)
    }
}