package com.aa.android.pokedex.repository.secondRepository

import com.aa.android.pokedex.api.PokemonApi
import com.aa.android.pokedex.api.entity.PokemonDTO
import com.aa.android.pokedex.model.secondModel.SecondScreenResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.Response
import javax.inject.Inject

class SecondRepositoryImpl @Inject constructor(val api: PokemonApi) : SecondRepository {
    override suspend fun getPokemonInfo(id: Int): PokemonDTO = withContext(Dispatchers.IO) {
        api.getPokemon(id)
    }




}