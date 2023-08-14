package de.codingwithchris.jetpackcomposetutorial.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import de.codingwithchris.jetpackcomposetutorial.ui.screens.DetailsScreen
import de.codingwithchris.jetpackcomposetutorial.ui.screens.HomeScreen
import kotlinx.coroutines.CoroutineScope

@Composable
fun AppNavigation(
    navController: NavHostController,
    scope: CoroutineScope,
    modifier: Modifier = Modifier
)
{
    NavHost(navController, startDestination = Home.route, modifier) {
        composable(Home.route) {
            HomeScreen(scope)
        }
        composable(Details.route) {
            DetailsScreen(scope)
        }
    }
}