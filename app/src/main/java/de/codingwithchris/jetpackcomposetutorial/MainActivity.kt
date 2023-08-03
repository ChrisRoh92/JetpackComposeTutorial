package de.codingwithchris.jetpackcomposetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
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
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun MyApp()
{
    // No State Hoisting:
    SimpleStateComponent()

    // State Hoisting
    // var counter by remember {
    //        mutableStateOf(0)
    // }
    // HoistedStateComponent(counter = counter, onCounterChange = { newCount ->
    //        counter = newCount
    // })
}

@Composable
fun SimpleStateComponent()
{
    var counter by remember {
        mutableStateOf(0)
    }
    Button(onClick = { counter++ }) {
        Text("Counter is: $counter")
    }
}

@Composable
fun HoistedStateComponent(counter: Int, onCounterChange: (Int)-> Unit)
{
    Button(onClick = { onCounterChange(counter + 1) }) {
        Text("Counter is: $counter")
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposeTutorialTheme {
        MyApp()
    }
}