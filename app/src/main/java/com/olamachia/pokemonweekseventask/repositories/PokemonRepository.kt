package com.olamachia.pokemonweekseventask.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.rxjava3.flowable
import com.olamachia.pokemonweekseventask.network.ApiResponses.PokeMonDetails
import com.olamachia.pokemonweekseventask.network.ApiResponses.PokemonItem
import com.olamachia.pokemonweekseventask.network.services.PokemonApiService
import com.olamachia.pokemonweekseventask.paging.PokemonListPagedSource
import com.olamachia.pokemonweekseventask.ui.fragments.PokemonDetailsFragment
import io.reactivex.rxjava3.core.Flowable

class PokemonRepository(private val apiService: PokemonApiService) {


    fun getPokeMons(limit: Int): Flowable<PagingData<PokeMonDetails>> =
      Pager(
            PagingConfig(pageSize = limit, enablePlaceholders = false, initialLoadSize = 40),
            pagingSourceFactory = { PokemonListPagedSource(apiService) }
        ).flowable


}