package com.aa.android.pokedex.repository

interface PokemonRepository {

    suspend fun getAllPokemon() : List<String>
}