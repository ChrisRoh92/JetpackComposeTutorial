package de.codingwithchris.jetpackcomposetutorial.ui.navigation

interface Destination
{
    val route: String
}

object Home: Destination
{
    override val route: String = "Home"
}

object Details: Destination
{
    override val route: String = "Details"
}