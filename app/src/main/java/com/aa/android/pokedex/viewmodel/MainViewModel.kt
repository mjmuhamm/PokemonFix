package com.aa.android.pokedex.viewmodel

import android.util.Log
import androidx.lifecycle.*
import com.aa.android.pokedex.api.entity.ResourceDTO
import com.aa.android.pokedex.model.UiState
import com.aa.android.pokedex.model.firstModel.FirstScreenResponse
import com.aa.android.pokedex.repository.firstRepository.PokemonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import okhttp3.Response
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(val repository: PokemonRepository): ViewModel() {

    private val _state = MutableStateFlow(FirstScreenResponse())
    val state = _state.asStateFlow()

    fun getPokemon() {
        viewModelScope.launch {

        }
    }

    init {
        getPokemonInfo()
    }

    fun getPokemonInfo() {
        viewModelScope.launch {
            try {
                val data = repository.getAllPokemon()
                _state.value = data
            } catch(e: Exception) {
                Log.i("error", "$e")
            }
        }
    }

//    val pokemonLiveData: LiveData<UiState<Response<ResourceDTO>> = liveData(Dispatchers.IO) {
//        emit(UiState.Loading())
//        try {
//            val data = repository.getAllPokemon()
//            emit(UiState.Ready(data))
//        } catch (e: Exception) {
//            Log.e(this@MainViewModel::class.simpleName, e.message, e)
//            emit(UiState.Error(e))
//        }
//    }


}