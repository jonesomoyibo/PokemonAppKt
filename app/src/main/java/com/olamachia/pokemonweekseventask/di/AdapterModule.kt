package com.olamachia.pokemonweekseventask.di

import com.olamachia.pokemonweekseventask.ui.adapters.PokemonAdapter
import com.olamachia.pokemonweekseventask.ui.viewmodels.PokemonViewModel
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class AdapterModule {

    @Provides
    @Singleton
    fun providesAdapter(viewModel: PokemonViewModel) =
        PokemonAdapter(viewModel)
}