package com.aa.android.pokedex.routes

sealed class Routes(val route: String) {
    object Home: Routes("home")
    object Detail : Routes("pokemon/{id}") {
        fun createRoute(id: Int) = "pokemon/$id"
    }
}