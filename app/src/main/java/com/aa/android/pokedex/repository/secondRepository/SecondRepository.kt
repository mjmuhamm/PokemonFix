package com.aa.android.pokedex.repository.secondRepository

import com.aa.android.pokedex.api.entity.PokemonDTO
import com.aa.android.pokedex.api.entity.ResourceDTO
import com.aa.android.pokedex.model.secondModel.SecondScreenResponse
import okhttp3.Response

interface SecondRepository {
    suspend fun getPokemonInfo(id: Int) : PokemonDTO
}