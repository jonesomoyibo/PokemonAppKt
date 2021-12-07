package com.olamachia.pokemonweekseventask.extensions

import androidx.lifecycle.LifecycleOwner
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single

fun <T> LifecycleOwner.subscribe(single: Single<T>, observer: (T) ->Unit){

    single.observeOn(AndroidSchedulers.mainThread())
        .subscribe(observer)
}

fun <T> LifecycleOwner.unSubscribe(single: Single<T>){

    single.unsubscribeOn(AndroidSchedulers.mainThread())
}