package com.olamachia.pokemonweekseventask.network.services

import com.olamachia.pokemonweekseventask.network.ApiResponses.PokeMonDetails
import com.olamachia.pokemonweekseventask.network.ApiResponses.PokeMons
import com.olamachia.pokemonweekseventask.network.ApiResponses.PokemonItem
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonApiService {



    //Returns the page of pokemons
    @GET("/pokemon")
    fun getPokeMons(
      @Query("offset") offset:Int = 0,
      @Query("limit") limit:Int
    ): Single<PokeMons>



   //Returns pokemon using the Name
    @GET("/pokemon/{pokemonName}")
    fun getPokemonByName(
        @Path("pokemonName") pokemonName:String
    ):Single<PokemonItem>



    //Returns the details of the pokemon with the Id supplied
    @GET("/pokemon/{id}")
    fun getPokeMonDetails(
        @Path("id") id:Int
    ):PokeMonDetails
}