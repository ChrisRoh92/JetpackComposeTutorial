package de.codingwithchris.jetpackcomposetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.codingwithchris.jetpackcomposetutorial.ui.theme.JetpackComposeTutorialTheme
import kotlinx.coroutines.launch

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
//    ScaffoldWithNavigationDrawer()
    ScaffoldWithNavigationDrawer()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldWithNavigationDrawer()
{
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    var selectedIndex by remember { mutableStateOf(-1)}
    ModalNavigationDrawer(
        drawerState = drawerState,
        gesturesEnabled = true,
        drawerContent = {
            NavigationDrawerContent(selectedIndex){ newIndex ->
                selectedIndex = newIndex
                scope.launch {
                    drawerState.apply {
                        if (isClosed) open() else close()
                    }
                }
            }
        },
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Navigation Drawer") },
                    navigationIcon = {
                        IconButton(onClick = {
                            scope.launch {
                                drawerState.apply {
                                    if (isClosed) open() else close()
                                }
                            } }) {
                            Icon(Icons.Default.Menu, contentDescription = "Open Menu")
                        }
                    }
                )
            }
        ) { contentPadding ->
            // Screen content
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(contentPadding),
                contentAlignment = Alignment.Center
            ){
                Text("Hallo")
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun NavigationDrawerContent(selectedIndex: Int, onClick: (index: Int) -> Unit)
{
    ModalDrawerSheet(
    ) {
        Text("Awesome App", modifier = Modifier.padding(16.dp))
        for (i in 0..5)
        {
            NavigationDrawerItem(
                modifier = Modifier.padding(horizontal = 8.dp).height(48.dp),
                label = { Text(text = "Drawer Item $i") },
                selected = i == selectedIndex,
                onClick = { onClick(i) },
                icon = { Icon(Icons.Default.Add, contentDescription = null)},
                badge = {Text(" - ")}
            )
        }

        Divider(modifier = Modifier.padding(top = 8.dp, start = 16.dp, end = 8.dp))
        Text("Awesome Settings" , modifier = Modifier.padding(16.dp))
        // ...other drawer items
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposeTutorialTheme {
        MyApp()
    }
}