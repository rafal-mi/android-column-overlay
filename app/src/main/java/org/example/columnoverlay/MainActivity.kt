package org.example.columnoverlay

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import org.example.columnoverlay.ui.theme.ColumnOverlayTheme
import kotlin.time.Duration.Companion.milliseconds

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ColumnOverlayTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var showOverlay by remember { mutableStateOf(true) }

    LaunchedEffect(key1 = Unit) {
        while(true) {
            delay(1000.milliseconds)
            showOverlay = !showOverlay
        }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .weight(1.0f)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Yellow.copy(green = 0.5f))
                ,
                contentAlignment = Alignment.Center
            ) {
                Column(
                ) {
                    Row() {
                        Box(
                            modifier = Modifier
                                .padding(start = 12.dp, end = 12.dp, bottom = 24.dp, top = 24.dp)
                                .background(Color.Yellow.copy(green = 0.66f))

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
                            // Overlay
                            if(showOverlay) {
                                Box(
                                    modifier = Modifier
                                        .matchParentSize()
                                        .background(Color.Black.copy(alpha = 0.5f))
                                )
                            }
                        }
                    }

                    Row() {
                        Box(
                            modifier = Modifier
                                .height(200.dp)
                                .padding(start = 12.dp, end = 12.dp, bottom = 24.dp, top = 24.dp)
                                .background(Color.Yellow.copy(green = 0.66f))

                        ) {
                            Text(
                                modifier = Modifier
                                    .background(Color.Yellow.copy(green = 0.33f))
                                    .padding(
                                        start = 12.dp,
                                        end = 12.dp,
                                        bottom = 24.dp,
                                        top = 24.dp
                                    )
                                    .align(Alignment.BottomCenter)
                                ,
                                text = "Hello $name",
                                color = Color.White
                            )
                        }
                    }

                }

            }
        }

        Row(
            modifier = Modifier
                .background(Color.Yellow.copy(green = 0.2f))
        ) {
            Text(
                color = Color.White,
                text = stringResource(R.string.lyrics),
                textAlign = TextAlign.Center
            )
        }

        Row(
            modifier = Modifier
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Red.copy(red=0.8f))
                    .padding(bottom = 24.dp, top = 24.dp)
                ,
                contentAlignment = Alignment.Center
            ) {
                Button(
                    onClick = {  },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Red,    // Changes the button background
                        contentColor = Color.White        // Changes text and icon colors inside
                    )
                ) {
                    Text("Nice")
                }

            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ColumnOverlayTheme {
        Greeting("Android")
    }
}