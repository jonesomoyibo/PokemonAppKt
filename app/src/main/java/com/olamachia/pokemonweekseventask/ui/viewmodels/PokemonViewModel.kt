package com.olamachia.pokemonweekseventask.ui.viewmodels


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.rxjava3.cachedIn
import com.olamachia.pokemonweekseventask.repositories.PokemonRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi

class PokemonViewModel(private val pokemonRepository: PokemonRepository): ViewModel() {



    private val networkState :


    fun retryAddPokeMonsToList(){

    }


    @ExperimentalCoroutinesApi
    fun getPokeMons(limit:Int=20) = pokemonRepository.getPokeMons(limit).cachedIn(viewModelScope)

}