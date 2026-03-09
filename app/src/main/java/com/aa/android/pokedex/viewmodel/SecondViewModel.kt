package com.aa.android.pokedex.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aa.android.pokedex.api.entity.PokemonDTO
import com.aa.android.pokedex.model.secondModel.SecondScreenResponse
import com.aa.android.pokedex.repository.secondRepository.SecondRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SecondViewModel @Inject constructor(val repository: SecondRepository) : ViewModel() {

    private val _state = MutableStateFlow(PokemonDTO())
    val state = _state.asStateFlow()

    fun getPokemonInfo(id: Int) {
        viewModelScope.launch {
            try {
                val data = repository.getPokemonInfo(id)
                _state.value = data
            } catch (e: Exception) {
                Log.i("error", e.toString())
            }

        }
    }
}