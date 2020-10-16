package com.sokhibdzhon.livedota.ui.matches

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.sokhibdzhon.livedota.R
import com.sokhibdzhon.livedota.base.BaseFragment
import com.sokhibdzhon.livedota.data.model.LeagueName
import com.sokhibdzhon.livedota.data.model.MatchId
import com.sokhibdzhon.livedota.databinding.MatchesFragmentBinding
import com.sokhibdzhon.livedota.ui.common.MatchesAdapter
import com.sokhibdzhon.livedota.util.extensions.toast
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MatchesFragment : BaseFragment<MatchesFragmentBinding>(R.layout.matches_fragment) {

    private val viewModel: MatchesViewModel by viewModels()

    @Inject
    lateinit var matchesAdapter: MatchesAdapter

    override fun init() {
        binding.swipeRefresh.setOnRefreshListener {
            viewModel.loadProMatches()
            binding.swipeRefresh.isRefreshing = false
        }

        binding.recyclerMatches.apply {
            adapter = matchesAdapter
            setHasFixedSize(true)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        observeMatches()
        onMatchClick()
        onFavoriteClick()
    }

    private fun onFavoriteClick() {
        matchesAdapter.onFavoriteClicked = { position, proMatch ->
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
            matchesAdapter.notifyItemChanged(position)
        }
    }

    private fun onMatchClick() {
        matchesAdapter.onMatchItemClicked = { matchId, leagueName ->
            navigateToMatchDetails(matchId, leagueName)
        }
    }

    private fun observeMatches() {
        viewModel.proMatchesLiveData.observe(viewLifecycleOwner, Observer {
            matchesAdapter.setMatchList(it.getProMatches())
            binding.viewState = it
            binding.executePendingBindings()

        })
    }

    private fun navigateToMatchDetails(matchId: MatchId, leagueName: LeagueName) {
        val direction =
            MatchesFragmentDirections.actionMatchesFragmentToMatchDetailsFragment(
                matchId.value,
                leagueName.value
            )
        navigate(direction)
    }
}
