package de.codingwithchris.jetpackcomposetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.OnBackPressedCallback
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import de.codingwithchris.jetpackcomposetutorial.ui.navigation.AppNavigation
import de.codingwithchris.jetpackcomposetutorial.ui.navigation.Destination
import de.codingwithchris.jetpackcomposetutorial.ui.navigation.Details
import de.codingwithchris.jetpackcomposetutorial.ui.navigation.Home
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

    AppNavigator()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavigator() {

    val navController = rememberNavController()
    val scope = rememberCoroutineScope()

    var selectedDestination by remember { mutableStateOf<Destination>(Home) }
    val destinations = mapOf(Home.route to Home, Details.route to Details)

    navController.addOnDestinationChangedListener { _, destination, _ ->
        if (selectedDestination != null && destinations.containsKey(destination.route))
        {
            selectedDestination = destinations.get(destination.route)!!
        }
    }

    Scaffold(
        bottomBar = {
                    AppBottomNavigationBar(destinations, selectedDestination) { newSelectedDestination ->

                        navController.popBackStack(selectedDestination.route, inclusive = false)
                        navController.navigate(newSelectedDestination.route)

                        selectedDestination = newSelectedDestination
                    }
        },
        topBar = {
            TopAppBar(
                title = { Text("Compose Navigation App") },
            )
        },
    ) { innerPadding ->
        AppNavigation(navController, scope, Modifier.padding(innerPadding))
    }
}

@Composable
internal fun AppBottomNavigationBar(items: Map<String, Destination>, selectedDestination: Destination, onSelectClick: (Destination) -> Unit)
{
    NavigationBar {
        items.forEach { entry ->
            NavigationBarItem(
                icon = { Icon(Icons.Filled.Favorite, contentDescription = entry.key) },
                label = { Text(entry.key) },
                selected = selectedDestination == entry.value,
                onClick = { onSelectClick(entry.value) }
            )
        }
    }
}




@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposeTutorialTheme {
        MyApp()
    }
}