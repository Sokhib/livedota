package com.sokhibdzhon.livedota.ui.matches

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.sokhibdzhon.livedota.BaseApplication
import com.sokhibdzhon.livedota.R
import com.sokhibdzhon.livedota.databinding.MatchesFragmentBinding
import javax.inject.Inject

//TODO: Fix recyclerView margin + wrap content ile nasil duzgun hale getirilir(weight??)?
//TODO: ViewState'i alarak degil de Resource'u alarak burda yapmak ne kadar dogru Status. check ederek?
//TODO: Her bir match icin request gondererek ayni anda gelen response'lar icin gostermek gerekirse nasil yapilir?
//TODO: Check if theme or style overrides any other in views
class MatchesFragment : Fragment() {


    private lateinit var binding: MatchesFragmentBinding
    private lateinit var viewModel: MatchesViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var matchesAdapter: MatchesAdapter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity!!.applicationContext as BaseApplication).appGraph.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.matches_fragment, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.swipeRefresh.setOnRefreshListener {
            viewModel.loadProMatches()
            binding.swipeRefresh.isRefreshing = false
        }

        binding.recyclerMatches.adapter = matchesAdapter
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProvider(this, viewModelFactory).get(MatchesViewModel::class.java)

        viewModel.proMatchesLiveData.observe(viewLifecycleOwner, Observer {
            matchesAdapter.setMatchList(it.getProMatches())
            binding.viewState = it
            binding.executePendingBindings()

        })
        matchesAdapter.onMatchItemClicked = { matchId ->
            navigateToMatchDetails(matchId)
        }
    }

    private fun navigateToMatchDetails(matchId: Long) {
        val direction =
            MatchesFragmentDirections.actionMatchesFragmentToMatchDetailsFragment(matchId)
        this.findNavController().navigate(direction)
    }
}
