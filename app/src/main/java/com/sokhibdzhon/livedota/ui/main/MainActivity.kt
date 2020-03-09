package com.sokhibdzhon.livedota.ui.main

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.sokhibdzhon.livedota.BaseApplication
import com.sokhibdzhon.livedota.R
import com.sokhibdzhon.livedota.data.network.OpenDotaDataSource
import com.sokhibdzhon.livedota.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var dataSourceImpl: OpenDotaDataSource
    override fun onCreate(savedInstanceState: Bundle?) {
        // DI'de dogrusu nasil olmali applicationContext, Context, Application ??
        (applicationContext as BaseApplication).appGraph.inject(this)


        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        NavigationUI.setupWithNavController(binding.bottomNavView, navController)

        GlobalScope.launch(Dispatchers.IO) {
            dataSourceImpl.fetchProMatches().collect {

                Log.d("MainActivity", "${it.status}")
                Log.d("MainActivity", "${it.data}")
            }
        }

    }
}
