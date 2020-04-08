package com.sokhibdzhon.livedota.ui.match_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.sokhibdzhon.livedota.R
import com.sokhibdzhon.livedota.databinding.MatchDetailsFragmentBinding

class MatchDetailsFragment : Fragment() {

    private lateinit var viewModel: MatchDetailsViewModel
    private lateinit var binding: MatchDetailsFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.match_details_fragment, container, false)


        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MatchDetailsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
