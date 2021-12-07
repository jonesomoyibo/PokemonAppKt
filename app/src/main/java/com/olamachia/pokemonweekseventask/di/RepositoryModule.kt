package com.olamachia.pokemonweekseventask.di

import com.olamachia.pokemonweekseventask.network.services.PokemonApiService
import com.olamachia.pokemonweekseventask.paging.PokemonListPagedSource
import com.olamachia.pokemonweekseventask.repositories.PokemonRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class RepositoryModule {


    @Provides
    @Singleton
    fun providesPokemonListPagedDataSource(apiService: PokemonApiService) =
        PokemonListPagedSource(apiService)


    @Provides
    @Singleton
    fun providesPokemonRepository(pokemonListPagedSource: PokemonListPagedSource) =
        PokemonRepository(pokemonListPagedSource)
}