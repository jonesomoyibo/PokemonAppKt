package com.olamachia.pokemonweekseventask.ui.viewmodels


import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.rxjava3.cachedIn
import com.olamachia.pokemonweekseventask.repositories.PokemonRepository
import com.olamachia.pokemonweekseventask.ui.states.PokemonListViewState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

class PokemonViewModel  @Inject constructor(private val pokemonRepository: PokemonRepository): ViewModel() {


    private  val networkState = pokemonRepository.getPokeMons(limit = 20)

    lateinit var viewState: PokemonListViewState


    fun retryAddPokeMonsToList() {

    }


//    @ExperimentalCoroutinesApi
//    fun getPokeMons(limit:Int=20) = pokemonRepository.getPokeMons(limit).cachedIn(viewModelScope)
//
//}
}