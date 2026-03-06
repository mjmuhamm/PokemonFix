package com.aa.android.pokedex.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.aa.android.pokedex.viewmodel.SecondViewModel

@Composable
fun SecondScreen(id: String, viewModel: SecondViewModel, navController: NavController) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 25.dp, top = 10.dp)
    ) {
        Box(modifier = Modifier) {

            Text(
                "<",
                color = Color.Gray,
                fontSize = 50.sp,
                fontWeight = FontWeight.Light,
                modifier = Modifier
                    .padding(0.dp, 0.dp, 20.dp, 0.dp)
                    .clickable(onClick = { navController.popBackStack() })

            )

            Text(
                "Second Page",
                color = Color.Black,
                fontSize = 30.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center,


                modifier = Modifier.padding(100.dp, 13.dp, 0.dp, 0.dp)
            )
        }
    }
}