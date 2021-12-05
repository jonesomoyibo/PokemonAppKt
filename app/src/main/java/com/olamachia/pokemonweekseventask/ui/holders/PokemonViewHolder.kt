package com.olamachia.pokemonweekseventask.ui.holders

import android.view.LayoutInflater
import com.olamachia.pokemonweekseventask.databinding.PokemonListItemBinding
import com.olamachia.pokemonweekseventask.network.ApiResponses.PokeMonDetails
import com.olamachia.pokemonweekseventask.ui.base.BaseViewHolder

class PokemonViewHolder(inflater :LayoutInflater):BaseViewHolder<PokemonListItemBinding>(
    binding = PokemonListItemBinding.inflate(inflater)
) {

    fun bind(pokemon:PokeMonDetails){
        binding.pokemonItem = pokemon
        binding.executePendingBindings()
    }
}