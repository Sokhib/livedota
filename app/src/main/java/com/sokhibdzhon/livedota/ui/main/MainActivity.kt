package com.sokhibdzhon.livedota.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.sokhibdzhon.livedota.R
import com.sokhibdzhon.livedota.databinding.ActivityMainBinding
import com.sokhibdzhon.livedota.util.extensions.dismissRecreation

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        NavigationUI.setupWithNavController(binding.bottomNavView, navController)
        binding.bottomNavView.dismissRecreation()

    }
}
