package com.aa.android.pokedex.repository.firstRepository

import com.aa.android.pokedex.api.PokemonApi
import com.aa.android.pokedex.model.firstModel.FirstScreenResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(private val api: PokemonApi) : PokemonRepository {

    override suspend fun getAllPokemon(): FirstScreenResponse = withContext(Dispatchers.IO) {
            api.getAllPokemon()
    }
}

