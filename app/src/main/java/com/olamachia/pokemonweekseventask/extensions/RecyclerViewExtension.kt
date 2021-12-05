package com.olamachia.pokemonweekseventask.extensions

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

val RecyclerView.gridLayoutManager: GridLayoutManager?
    get() = layoutManager as? GridLayoutManager


val RecyclerView.linearLayoutManager: LinearLayoutManager?
    get() = layoutManager as? LinearLayoutManager