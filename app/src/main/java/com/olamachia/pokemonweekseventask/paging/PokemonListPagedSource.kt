package com.olamachia.pokemonweekseventask.paging

import androidx.paging.PagingState
import androidx.paging.rxjava3.RxPagingSource
import com.olamachia.pokemonweekseventask.network.ApiResponses.PokeMonDetails
import com.olamachia.pokemonweekseventask.network.ApiResponses.PokeMons
import com.olamachia.pokemonweekseventask.network.services.PokemonApiService
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.HttpException
import java.io.IOException


class PokemonListPagedSource(private val pokemonApiService: PokemonApiService) :
    RxPagingSource<Int, PokeMonDetails>() {




    override fun getRefreshKey(state: PagingState<Int,PokeMonDetails>): Int? =
        state.anchorPosition?.let { 0 }


    override fun loadSingle(params: LoadParams<Int>): Single<LoadResult<Int, PokeMonDetails>> {
        var pokeMons:PokeMons? =  null

        return  pokemonApiService.getPokemons(params.key?:0,params.loadSize)
            .flatMap {
                pokeMons = it
                Single.just(
                    it.pokeMonItems.map { pokeMonItem ->
                        pokemonApiService.getPokeMonDetails(Integer.parseInt(pokeMonItem .url.split("/").last()))
                    }
                )
            }
            .subscribeOn(Schedulers.io())
            .map{
                toLoadResult(pokeMonDetails = it,pokeMons = pokeMons!!)
            }
            .onErrorReturn{
               when(it){
                   is HttpException -> LoadResult.Error(it)
                   is IOException -> LoadResult.Error(it)
                   else -> throw it
               }
            }
    }



    private fun toLoadResult(pokeMonDetails: List<PokeMonDetails>,pokeMons:PokeMons):LoadResult<Int, PokeMonDetails>{

       return  LoadResult.Page(
            data = pokeMonDetails,
            prevKey = Integer.parseInt(
                pokeMons.previous?.let{
                    (it as String).split("&")[0].split("=")[1]
                } ?: "0"
            ),
            nextKey = Integer.parseInt(
                pokeMons.next?.let{
                    it.split("&")[0].split("=")[1]
                } ?: "0"
        ))
    }
}