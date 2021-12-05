package com.olamachia.pokemonweekseventask.ui.holders

import android.view.LayoutInflater
import com.olamachia.pokemonweekseventask.databinding.PokemonListItemErrorBinding
import com.olamachia.pokemonweekseventask.ui.base.BaseViewHolder
import com.olamachia.pokemonweekseventask.ui.viewmodels.PokemonViewModel

class ErrorViewHolder(inflater: LayoutInflater) : BaseViewHolder<PokemonListItemErrorBinding>
    (binding = PokemonListItemErrorBinding.inflate(inflater)){


        fun bind (viewModel: PokemonViewModel){
            binding.viewModel = viewModel
            binding.executePendingBindings()
        }
    }