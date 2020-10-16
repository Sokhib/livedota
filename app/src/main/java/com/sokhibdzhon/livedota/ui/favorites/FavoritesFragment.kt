package com.sokhibdzhon.livedota.ui.favorites

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.sokhibdzhon.livedota.R
import com.sokhibdzhon.livedota.base.BaseFragment
import com.sokhibdzhon.livedota.data.model.LeagueName
import com.sokhibdzhon.livedota.data.model.MatchId
import com.sokhibdzhon.livedota.databinding.FavoritesFragmentBinding
import com.sokhibdzhon.livedota.ui.common.MatchesAdapter
import com.sokhibdzhon.livedota.util.extensions.toast
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class FavoritesFragment : BaseFragment<FavoritesFragmentBinding>(R.layout.favorites_fragment) {

    private val viewModel: FavoritesViewModel by viewModels()

    @Inject
    lateinit var matchesAdapter: MatchesAdapter

    override fun init() {
        binding.recyclerFavorites.apply {
            adapter = matchesAdapter
            setHasFixedSize(true)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        getFavoredMatches()
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
            }
            matchesAdapter.notifyItemChanged(position)
        }
    }

    private fun onMatchClick() {
        matchesAdapter.onMatchItemClicked = { matchId, leagueName ->
            navigateToMatchDetails(matchId, leagueName)
        }
    }

    private fun getFavoredMatches() {
        lifecycleScope.launchWhenCreated {
            viewModel.getFavoredMatches()
        }
        viewModel.favoredMatchesLiveData.observe(requireActivity(), Observer {
            matchesAdapter.setMatchList(it.getProMatches())
            binding.viewState = it
            binding.executePendingBindings()

        })
    }

    private fun navigateToMatchDetails(matchId: MatchId, leagueName: LeagueName) {
        val direction =
            FavoritesFragmentDirections.actionFavoritesFragmentToMatchDetailsFragment2(
                matchId.value,
                leagueName.value
            )
        navigate(direction)
    }

}
