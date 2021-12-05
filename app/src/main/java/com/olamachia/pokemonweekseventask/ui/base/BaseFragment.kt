package com.olamachia.pokemonweekseventask.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel

abstract class BaseFragment<VB: ViewDataBinding,VM: ViewModel>(
    private val layoutId:Int): Fragment() {


        lateinit var viewModel: VM
        lateinit var viewBinding:VB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = DataBindingUtil.inflate(inflater,layoutId,container,false)
        viewBinding.lifecycleOwner = viewLifecycleOwner
        return viewBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onInitDataBinding()
    }


    abstract fun onInitDataBinding()
}