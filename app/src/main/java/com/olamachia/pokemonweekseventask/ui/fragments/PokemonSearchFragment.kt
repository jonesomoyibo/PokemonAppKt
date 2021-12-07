package com.olamachia.pokemonweekseventask.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedList
import androidx.paging.PagingData
import com.olamachia.pokemonweekseventask.R
import com.olamachia.pokemonweekseventask.databinding.FragmentPokemonListBinding
import com.olamachia.pokemonweekseventask.extensions.gridLayoutManager
import com.olamachia.pokemonweekseventask.network.ApiResponses.PokeMonDetails
import com.olamachia.pokemonweekseventask.ui.adapters.PokemonAdapter
import com.olamachia.pokemonweekseventask.ui.base.BaseFragment
import com.olamachia.pokemonweekseventask.ui.viewmodels.PokemonViewModel
import javax.inject.Inject


class PokemonSearchFragment : BaseFragment<FragmentPokemonListBinding,PokemonViewModel>(R.layout.fragment_pokemon_list) {



    @Inject
    lateinit var adapter:PokemonAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pokemon_list, container, false)
    }

    override fun onInitDataBinding() {
        viewBinding.viewModel = viewModel

        viewBinding.includeList.pokemonList.apply {
            adapter = adapter
            layoutManager = gridLayoutManager
        }
    }


    private fun onViewDataChange(viewData: PagingData<PokeMonDetails>) {
        adapter.submitData(viewLifecycleOwner.lifecycle,viewData)
    }

    override fun onInitDependencyInjection() {
        TODO("Not yet implemented")
    }

}