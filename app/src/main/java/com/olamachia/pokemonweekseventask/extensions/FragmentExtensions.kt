package com.olamachia.pokemonweekseventask.extensions

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

fun<VM: ViewModel> Fragment.viewModel(
    key:String? = null,
    factory :() -> VM
): VM{


    val factoryViewModel = factory()
    val viewModelProviderFactory = object: ViewModelProvider.Factory{
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return factoryViewModel  as T
        }

    }

    return if(key!=null){
        ViewModelProvider(requireActivity(),viewModelProviderFactory).get(key, factoryViewModel::class.java)
    }
    else{
        ViewModelProvider(requireActivity(),viewModelProviderFactory).get(factoryViewModel::class.java)
    }


}