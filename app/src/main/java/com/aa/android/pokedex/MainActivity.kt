package com.aa.android.pokedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.aa.android.pokedex.model.UiState
import com.aa.android.pokedex.presentation.Screen
import com.aa.android.pokedex.presentation.SecondScreen
import com.aa.android.pokedex.routes.Routes
import com.aa.android.pokedex.ui.theme.PokedexTheme
import com.aa.android.pokedex.viewmodel.MainViewModel
import com.aa.android.pokedex.viewmodel.SecondViewModel
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.material.placeholder
import com.google.accompanist.placeholder.material.shimmer
import dagger.hilt.android.AndroidEntryPoint
import kotlin.getValue

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            PokedexTheme {
                App()
            }
        }
    }
}

@Composable
fun App() {
    val mainViewModel: MainViewModel = hiltViewModel()
    val secondViewModel: SecondViewModel = hiltViewModel()
    val navHostController = rememberNavController()
    AppNavHost(mainViewModel, secondViewModel, navHostController = navHostController)
}

@Composable
fun AppNavHost(viewModel: MainViewModel, secondViewModel: SecondViewModel, navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = Routes.Home.route
    ) {

        composable(Routes.Home.route) {
            Screen(viewModel.pokemonLiveData, navHostController)

        }

        composable(Routes.Detail.route,
            listOf(
                navArgument("id") {
                    type = NavType.StringType
                }
            )) { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id") ?: "Unknown"
            SecondScreen(id = id, viewModel = secondViewModel, navController = navHostController)

        }
    }
}


