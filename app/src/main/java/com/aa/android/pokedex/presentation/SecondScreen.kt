package com.aa.android.pokedex.presentation

import android.R
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.aa.android.pokedex.model.Type
import com.aa.android.pokedex.viewmodel.SecondViewModel

@Composable
fun SecondScreen(id: String, viewModel: SecondViewModel, navController: NavController) {

    LaunchedEffect(Unit) {
        viewModel.getPokemonInfo(id.toInt())
    }
    val state = viewModel.state.collectAsStateWithLifecycle()
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 25.dp, top = 10.dp)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, top = 10.dp)
        ) {
            Box(modifier = Modifier) {

                Text(
                    "<",
                    color = Color.Gray,
                    fontSize = 35.sp,
                    fontWeight = FontWeight.Light,
                    modifier = Modifier
                        .padding(0.dp, 0.dp, 20.dp, 0.dp)
                        .clickable(onClick = { navController.popBackStack() })

                )

                Text(
                    "Pokemon Detail",
                    color = Color.Black,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Center,


                    modifier = Modifier.padding(100.dp, 10.dp, 0.dp, 0.dp)
                )

//            HorizontalDivider(
//                modifier = Modifier.padding(top = 10.dp),
//                thickness = 0.8.dp,
//                color = Color.Gray
//            )


            }
        }

        Row() {
            Column() {
                Text("Image", modifier = Modifier.padding(top = 16.dp, start = 16.dp))
                AsyncImage(
                    model = state.value.sprites?.defaultFront,
                    contentDescription = "",
                    modifier = Modifier.size(75.dp)
                )
            }
            Column() {
            Text("Name", modifier = Modifier.padding(top = 16.dp, start = 16.dp))
            Text(state.value.name.uppercase(), modifier = Modifier.padding(start = 16.dp, top = 6.dp))
            }
        }


        Text("Height", modifier = Modifier.padding(top = 16.dp, start = 16.dp))
        Text("${(state.value.height.toDouble() * 10)} cm", modifier = Modifier.padding(start = 16.dp, top = 6.dp))

        Text("Weight", modifier = Modifier.padding(top = 16.dp, start = 16.dp))
        Text("${(state.value.weight.toDouble() / 10)} kg", modifier = Modifier.padding(start = 16.dp, top = 6.dp))

        Text("Types", modifier = Modifier.padding(top = 16.dp, start = 16.dp))

        for (i in 0..< state.value.types.size) {
            val name = state.value.types[i].type.name.uppercase()
            Text("- ${name.lowercase()}", modifier = Modifier.padding(start = 18.dp, top = 6.dp), color = Type.getColor(name))
        }
        Text("Stats", modifier = Modifier.padding(top = 16.dp, start = 16.dp))
        for (i in 0..< state.value.stats.size) {
            Text(state.value.stats[i].stat.name, modifier = Modifier.padding(start = 16.dp, top = 6.dp))
            Text("${state.value.stats[0].baseStat}", modifier = Modifier.padding(start = 16.dp, top = 6.dp))
        }


    }
}