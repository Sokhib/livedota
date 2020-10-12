package com.sokhibdzhon.livedota.ui.matches

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.sokhibdzhon.livedota.R
import com.sokhibdzhon.livedota.data.model.LeagueName
import com.sokhibdzhon.livedota.data.model.MatchId
import com.sokhibdzhon.livedota.databinding.MatchesFragmentBinding
import com.sokhibdzhon.livedota.ui.common.MatchesAdapter
import com.sokhibdzhon.livedota.util.extensions.toast
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MatchesFragment : Fragment() {


    private lateinit var binding: MatchesFragmentBinding

    private val viewModel: MatchesViewModel by viewModels()

    @Inject
    lateinit var matchesAdapter: MatchesAdapter

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

        binding.recyclerMatches.apply {
            adapter = matchesAdapter
            setHasFixedSize(true)
        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.proMatchesLiveData.observe(viewLifecycleOwner, Observer {
            matchesAdapter.setMatchList(it.getProMatches())
            binding.viewState = it
            binding.executePendingBindings()

        })
        matchesAdapter.onMatchItemClicked = { matchId, leagueName ->
            navigateToMatchDetails(matchId, leagueName)
        }
        matchesAdapter.onFavoriteClicked = { proMatch ->
            when (proMatch.isFavorited) {
                true -> {
                    viewModel.removeFromFavorites(proMatch)
                    toast(requireActivity(), getString(R.string.successfully_removed))
                }
                false -> {
                    toast(requireActivity(), getString(R.string.successfully_added))
                    viewModel.addToFavorites(proMatch)
                }
            }
            matchesAdapter.notifyDataSetChanged()
        }
    }

    private fun navigateToMatchDetails(matchId: MatchId, leagueName: LeagueName) {
        val direction =
            MatchesFragmentDirections.actionMatchesFragmentToMatchDetailsFragment(
                matchId.value,
                leagueName.value
            )
        this.findNavController().navigate(direction)
    }
}
