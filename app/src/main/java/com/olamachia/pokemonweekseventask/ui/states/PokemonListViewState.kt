package com.olamachia.pokemonweekseventask.ui.states

import com.olamachia.pokemonweekseventask.ui.base.BaseViewState

sealed class PokemonListViewState : BaseViewState {


    object Refreshing : PokemonListViewState()

    object Loaded : PokemonListViewState()

    object Loading : PokemonListViewState()

    object AddLoading : PokemonListViewState()

    object Empty : PokemonListViewState()

    object Error : PokemonListViewState()

    object AddError : PokemonListViewState()

    object NoMoreElements : PokemonListViewState()


    fun isRefreshing() = this is Refreshing

    fun isLoaded() = this is Loaded

    fun isLoading() = this is AddLoading

    fun isAddLoading() = this is AddLoading

    fun isEmpty() = this is Empty

    fun isError() = this is Error

    fun isAddError() = this is AddError

    fun isNoMoreElements() = this is NoMoreElements


}