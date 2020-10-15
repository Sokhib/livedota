package com.sokhibdzhon.livedota.ui.main

import android.os.Bundle
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.sokhibdzhon.livedota.R
import com.sokhibdzhon.livedota.base.BaseActivity
import com.sokhibdzhon.livedota.databinding.ActivityMainBinding
import com.sokhibdzhon.livedota.util.extensions.dismissRecreation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

//    override fun getLayoutRes(): Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        NavigationUI.setupWithNavController(binding.bottomNavView, navController)
        binding.bottomNavView.dismissRecreation()

    }
}
