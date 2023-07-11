package zahra.hosseini.hemophiliaapp.main.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import zahra.hosseini.hemophiliaapp.core.theme.AppTheme

@Composable
fun HomeScreen() {

    Column(
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.End
    ) {

        FloatingActionButton(
            onClick = {
                //OnClick Method
            },
            containerColor = MaterialTheme.colors.primary,
            shape = RoundedCornerShape(50.dp),
            modifier = Modifier.padding(end = 18.dp, bottom = 66.dp)
        ) {
            Icon(
                imageVector = Icons.Rounded.Add,
                contentDescription = "Add FAB",
                tint = MaterialTheme.colors.onPrimary,
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    AppTheme(useSystemUiController = false) {
        Surface(
            modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
        ) {
            HomeScreen()
        }
    }
}