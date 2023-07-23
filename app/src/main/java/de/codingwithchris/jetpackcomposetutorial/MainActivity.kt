package de.codingwithchris.jetpackcomposetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.tooling.preview.Preview
import de.codingwithchris.jetpackcomposetutorial.ui.theme.JetpackComposeTutorialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTutorialTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyAppWithStates()
                }
            }
        }
    }
}

@Composable
fun MyApp()
{
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Hello, Jetpack Compose",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Black
        )

        Text(
            text = "Hello, Jetpack Compose",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Black
        )

        Text(
            text = "Hello, Jetpack Compose",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Black
        )
    }
}

@Composable
fun MyAppRow()
{
    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ){
        Text(
            text = "Hello, Jetpack Compose",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Black
        )

        Text(
            text = "Hello, Jetpack Compose",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Black
        )

        Text(
            text = "Hello, Jetpack Compose",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Black
        )
    }
}

@Composable
fun MyAppBox()
{
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Hello, Jetpack Compose",
            style = MaterialTheme.typography.bodyLarge,
            color = Color.Black
        )

        Text(
            text = "Hello, Jetpack Compose",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Black
        )
    }
}

@Composable
fun MyAppWithStates()
{
    var counter by remember{
        mutableStateOf(0)
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = "Counter $counter",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Black
        )


        Button(onClick = {
            counter++
        }) {
            Text(text = "Erhöhen")
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposeTutorialTheme {
        MyAppWithStates()
    }
}