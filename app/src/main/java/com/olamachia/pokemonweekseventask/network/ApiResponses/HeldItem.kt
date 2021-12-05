package com.olamachia.pokemonweekseventask.network.ApiResponses

data class HeldItem(
    val item: Item,
    val version_details: List<VersionDetail>
)