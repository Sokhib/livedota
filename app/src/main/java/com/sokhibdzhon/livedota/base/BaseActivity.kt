package com.sokhibdzhon.livedota.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding


/**     I ❤ Code:)
╔═══════════════════════════════════════╗
║  Created by Sokhibdzhon Saidmuratov   ║
╠═══════════════════════════════════════╣
║ sokhibsaid@gmail.com                  ║
╚═══════════════════════════════════════╝
 */

abstract class BaseActivity<DB : ViewDataBinding>(@LayoutRes val layout: Int) :
    AppCompatActivity() {

//    @LayoutRes
//    abstract fun getLayoutRes(): Int

    val binding by lazy {
        DataBindingUtil.setContentView(
            this,
            layout
        ) as DB
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpLifeCycleOwner()
    }

    private fun setUpLifeCycleOwner() {
        binding.lifecycleOwner = this
    }
}