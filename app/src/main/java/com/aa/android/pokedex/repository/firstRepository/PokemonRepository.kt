package com.aa.android.pokedex.repository.firstRepository

import com.aa.android.pokedex.model.firstModel.FirstScreenResponse
import com.aa.android.pokedex.model.secondModel.SecondScreenResponse

interface PokemonRepository {

    suspend fun getAllPokemon() : FirstScreenResponse
}

