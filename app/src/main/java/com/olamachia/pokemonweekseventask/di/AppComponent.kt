package com.olamachia.pokemonweekseventask.di

import com.olamachia.pokemonweekseventask.network.services.PokemonApiService
import com.olamachia.pokemonweekseventask.repositories.PokemonRepository
import com.olamachia.pokemonweekseventask.ui.fragments.PokemonSearchFragment
import com.olamachia.pokemonweekseventask.ui.viewmodels.PokemonViewModel
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [
    NetworkModule::class,
    RepositoryModule::class,
    ViewModelsModule::class,
    AdapterModule::class
])
interface AppComponent {

    fun inject(fragment:PokemonSearchFragment)

}