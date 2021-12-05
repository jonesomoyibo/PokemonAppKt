package com.olamachia.pokemonweekseventask.ui.bindings

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.olamachia.pokemonweekseventask.ui.views.RecyclerViewItemDecoration


@BindingAdapter("itemDecorationSpacing")
fun RecyclerView.setItemDecorationSpacing(spacingPx:Float){

    addItemDecoration(
        RecyclerViewItemDecoration(spacingPx.toInt())
    )
}