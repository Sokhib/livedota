package com.sokhibdzhon.livedota.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.Navigation


/**     I ❤ Code:)
╔═══════════════════════════════════════╗
║  Created by Sokhibdzhon Saidmuratov   ║
╠═══════════════════════════════════════╣
║ sokhibsaid@gmail.com                  ║
╚═══════════════════════════════════════╝
 */

abstract class BaseFragment<DB : ViewDataBinding>(
    @LayoutRes val layout: Int
) : Fragment() {
    lateinit var binding: DB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        initBinding(inflater, container!!)
        init()
        super.onCreateView(inflater, container, savedInstanceState)
        return binding.root
    }

    open fun navigate(action: Int) {
        view?.let { _view ->
            Navigation.findNavController(_view).navigate(action)
        }
    }

    open fun navigate(action: NavDirections) {
        view?.let { _view ->
            Navigation.findNavController(_view).navigate(action)
        }
    }

    abstract fun init()

    private fun initBinding(layoutInflater: LayoutInflater, container: ViewGroup) {
        binding =
            DataBindingUtil.inflate(layoutInflater, layout, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.unbind()
    }


}