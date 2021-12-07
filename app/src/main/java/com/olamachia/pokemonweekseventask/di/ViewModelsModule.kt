package com.olamachia.pokemonweekseventask.di

import androidx.fragment.app.Fragment
import com.olamachia.pokemonweekseventask.extensions.viewModel
import com.olamachia.pokemonweekseventask.repositories.PokemonRepository
import com.olamachia.pokemonweekseventask.ui.viewmodels.PokemonViewModel
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class ViewModelsModule( val fragment: Fragment) {


    @Provides
    @Singleton
    fun providesPokemonViewModels(pokemonRepository: PokemonRepository) = fragment.viewModel {
       PokemonViewModel(pokemonRepository)
    }
}