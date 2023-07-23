package de.codingwithchris.jetpackcomposetutorial

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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

data class ListItem(val id: Int, val title: String, val description: String)

fun getSampleData(num: Int = 10): List<ListItem>
{
    var data = arrayListOf<ListItem>()
    for (i in 0..num)
    {
        data.add(
            ListItem(i, "Item $i", "Description of Item $i")
        )
    }
    return data
}


@Composable
fun MyApp()
{
    LazyColumnAppView()
    //LazyRowAppView()

}

@Composable
fun LazyColumnAppView()
{
    val sampleData = getSampleData(50)
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp),
    ){
        items(sampleData) { item ->
            ListItemView(item = item) {
                println("Clicked Item with Id: ${item.id}")
            }
        }
    }
}

@Composable
fun LazyRowAppView()
{
    val sampleData = getSampleData(50)
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ){
        items(sampleData) { item ->
            ListItemView(item = item) {
                println("Clicked Item with Id: ${item.id}")
            }
        }
    }
}

@Composable
internal fun ListItemView(
    item: ListItem,
    onClick: () -> Unit)
{
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable {
                onClick()
            },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ){
        Text(
            text = item.title,
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = item.description,
            style = MaterialTheme.typography.bodySmall,
            color = Color.Gray
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposeTutorialTheme {
        MyApp()
    }
}