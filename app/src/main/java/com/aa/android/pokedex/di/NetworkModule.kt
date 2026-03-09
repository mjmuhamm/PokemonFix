package com.aa.android.pokedex.di

import com.aa.android.pokedex.api.PokemonApi
import com.aa.android.pokedex.repository.firstRepository.PokemonRepository
import com.aa.android.pokedex.repository.firstRepository.PokemonRepositoryImpl
import com.aa.android.pokedex.repository.secondRepository.SecondRepository
import com.aa.android.pokedex.repository.secondRepository.SecondRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    const val BASE_URL = "https://pokeapi.co/api/v2/"

    @Provides
    @Singleton
    fun provideApi(): PokemonApi =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(PokemonApi::class.java)


    @Provides
    @Singleton
    fun provideFirstRepository(api: PokemonApi) : PokemonRepository = PokemonRepositoryImpl(api)

    @Provides
    @Singleton
    fun provideSecondRepository(api: PokemonApi) : SecondRepository = SecondRepositoryImpl(api)


}