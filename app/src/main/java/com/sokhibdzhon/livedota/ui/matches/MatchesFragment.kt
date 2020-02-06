package com.sokhibdzhon.livedota.ui.matches

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.sokhibdzhon.livedota.R

class MatchesFragment : Fragment() {

    companion object {
        fun newInstance() = MatchesFragment()
    }

    private lateinit var viewModel: MatchesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.matches_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MatchesViewModel::class.java)


    }

}
