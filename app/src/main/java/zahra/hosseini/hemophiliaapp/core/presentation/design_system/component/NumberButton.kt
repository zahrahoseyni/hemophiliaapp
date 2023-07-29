package zahra.hosseini.hemophiliaapp.core.presentation.design_system.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.theme.hemophiliaColors
import zahra.hosseini.hemophiliaapp.core.presentation.design_system.theme.hemophiliaTypography

@Composable
fun NumberButton(number: Int) {
    Button(
        onClick = { /*TODO*/ }, modifier = Modifier
            .wrapContentHeight()
            .wrapContentWidth()
            .padding(8.dp),
        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.hemophiliaColors.designSystem.OnPrimary),
        shape = MaterialTheme.shapes.medium
    ) {
        Text(
            number.toString(), style = MaterialTheme.hemophiliaTypography.text16Medium,
            color = MaterialTheme.hemophiliaColors.designSystem.PrimaryText,
        )
    }

   // return ""
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NumberButton(1)

}
