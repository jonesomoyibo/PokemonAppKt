package com.olamachia.pokemonweekseventask.network


import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.olamachia.pokemonweekseventask.network.services.PokemonApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private var httpLoggingInterceptor: HttpLoggingInterceptor = HttpLoggingInterceptor()
    private var okHttpClient: OkHttpClient
    private var gson: Gson = GsonBuilder().create()
    private var retrofit: Retrofit

    init {

        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        okHttpClient = OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build()
        retrofit = Retrofit.Builder()
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(" https://pokeapi.co/api/v2/")
            .client(okHttpClient)
            .build()
    }


    fun pokemonService() = retrofit.create(PokemonApiService::class.java)


}