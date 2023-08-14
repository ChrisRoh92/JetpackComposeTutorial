package de.codingwithchris.jetpackcomposetutorial.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@Composable
fun DetailsScreen(scope: CoroutineScope, modifier: Modifier = Modifier)
{
    val context = LocalContext.current

    Column(
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Text("Details Screen")
        Spacer(Modifier.height(16.dp))
        Button(onClick = {
            scope.launch {
                Toast.makeText(context, "This is the Details screen", Toast.LENGTH_SHORT).show()
            }
        }) {
            Text("Click Me")
        }
    }
}