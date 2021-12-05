package com.olamachia.pokemonweekseventask.network.ApiResponses

import com.google.gson.annotations.SerializedName

data class PokeMons(
    val count: Int,
    val next: String?,
    val previous: Any?,
    @SerializedName("results")
    val pokeMonItems: List<PokemonItem>
)