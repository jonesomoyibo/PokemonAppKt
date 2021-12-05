package com.olamachia.pokemonweekseventask.ui.states

sealed class PokemonListAdapterState(val hasExtraRow: Boolean) {


    object AddedItem : PokemonListAdapterState(hasExtraRow = true)


    object AddLoading: PokemonListAdapterState(hasExtraRow = true)


    object AddError: PokemonListAdapterState(hasExtraRow = true)


    object NoMore: PokemonListAdapterState(hasExtraRow = false)


    object Loading: PokemonListAdapterState(hasExtraRow = false)


    fun isAdded() = this is AddedItem

    fun isAddLoading() = this is AddLoading

    fun isAddError() = this is AddError

    fun isNoMore() = this is NoMore

    fun isLoading() = this is Loading
}