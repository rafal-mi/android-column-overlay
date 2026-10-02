package org.example.columnoverlay

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.example.columnoverlay.ui.theme.ColumnOverlayTheme

@Composable
fun AnimatedCard(
    name: String = "Android"
) {
    Column(
        modifier = Modifier
            .background(Color.Yellow.copy(green = 0.66f))
            .padding(12.dp)
            .width(IntrinsicSize.Max)
        ,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .alpha(0.5f)
                .fillMaxWidth()
            ,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
        ) {
            TextButton(
                onClick = { },
                enabled = true
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Icon(Icons.Outlined.Edit, "")
                    Spacer(Modifier.width(8.dp))
                    Text("Edit")
                }
            }

        }

        ElevatedCard(
            modifier = Modifier
                .shadow(
                    elevation = 2.dp,
                    shape = MaterialTheme.shapes.medium
                )
            ,
            colors = CardDefaults.elevatedCardColors(
                containerColor = Color.Yellow.copy(green = 0.66f)
            )
        ) {
            Text(
                modifier = Modifier
                    .padding(
                        start = 12.dp,
                        end = 12.dp,
                        bottom = 24.dp,
                        top = 24.dp
                    )
                    .background(Color.Yellow.copy(green = 0.33f))
                ,
                text = "Hello $name",
                color = Color.White
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun AnimatedCardPreview() {
    ColumnOverlayTheme {
        AnimatedCard("Android")
    }
}

