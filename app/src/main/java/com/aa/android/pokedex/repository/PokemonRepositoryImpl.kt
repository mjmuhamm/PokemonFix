package com.aa.android.pokedex.repository

import com.aa.android.pokedex.api.PokemonApi
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(private val api: PokemonApi) : PokemonRepository {

    override suspend fun getAllPokemon(): List<String> {

        val response = api.getAllPokemon()
        if (response.isSuccessful) {
            response.body()?.let {
                return it.results.map { result ->
                    result.name
                }
            }
        }

        return listOf()
    }
}