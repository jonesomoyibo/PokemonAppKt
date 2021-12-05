package com.olamachia.pokemonweekseventask.network.ApiResponses

data class Move(
    val move: MoveX,
    val version_group_details: List<VersionGroupDetail>
)