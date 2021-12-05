package com.olamachia.pokemonweekseventask.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.olamachia.pokemonweekseventask.network.ApiResponses.PokeMonDetails
import com.olamachia.pokemonweekseventask.ui.base.BaseListAdapter
import com.olamachia.pokemonweekseventask.ui.holders.ErrorViewHolder
import com.olamachia.pokemonweekseventask.ui.holders.LoadingViewHolder
import com.olamachia.pokemonweekseventask.ui.holders.PokemonViewHolder
import com.olamachia.pokemonweekseventask.ui.states.PokemonListAdapterState
import com.olamachia.pokemonweekseventask.ui.viewmodels.PokemonViewModel


internal enum class ItemView(val type: Int) {

    POKEMON(type = 0),
    LOADING(type = 1),
    ERROR(type = 2);

    companion object {
        fun valueOf(type: Int): ItemView = values().first {
            it.type == type
        }
    }
}


class PokemonAdapter(
    private val viewModel: PokemonViewModel
) : BaseListAdapter<PokeMonDetails>(
    itemsSame = { old, new -> old.id == new.id },
    contentsSame = { old, new -> old == new }
) {


    private var state: PokemonListAdapterState = PokemonListAdapterState.AddedItem


    override fun onCreateViewHolder(
        parent: ViewGroup,
        inflater: LayoutInflater,
        viewType: Int
    ): RecyclerView.ViewHolder =
        when (ItemView.valueOf(viewType)) {
            ItemView.POKEMON -> PokemonViewHolder(inflater)
            ItemView.LOADING -> LoadingViewHolder(inflater)
            else -> ErrorViewHolder(inflater)
        }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItemView(position)) {
            ItemView.POKEMON ->
                getItem(position)?.let {
                    if (holder is PokemonViewHolder) {
                        holder.bind(it)
                    }

                }
            ItemView.ERROR -> if (holder is ErrorViewHolder) holder.bind(viewModel)


            else -> {
            }
        }
    }


    override fun getItemViewType(position: Int) = getItemView(position).type

    private fun getItemView(position: Int) =
        if (state.hasExtraRow && position == itemCount - 1) {
            if (state.isAddError()) ItemView.ERROR
            else ItemView.LOADING

        } else ItemView.POKEMON


    override fun getItemCount() = if (state.hasExtraRow) super.getItemCount() + 1
    else super.getItemCount()


    override fun getItemId(position: Int): Long = when (getItemView(position)) {
        ItemView.POKEMON -> getItem(position)?.id?.toLong() ?: -3L
        ItemView.LOADING -> -1L
        ItemView.ERROR -> -2L
    }

    fun submitState(newState: PokemonListAdapterState) {
        val oldState = state
        state = newState
        if (newState.hasExtraRow && oldState != newState) notifyItemChanged(itemCount - 1)

    }
}