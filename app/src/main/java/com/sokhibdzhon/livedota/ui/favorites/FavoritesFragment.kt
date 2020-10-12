package com.sokhibdzhon.livedota.ui.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.sokhibdzhon.livedota.R
import com.sokhibdzhon.livedota.data.model.LeagueName
import com.sokhibdzhon.livedota.data.model.MatchId
import com.sokhibdzhon.livedota.databinding.FavoritesFragmentBinding
import com.sokhibdzhon.livedota.ui.common.MatchesAdapter
import com.sokhibdzhon.livedota.util.extensions.toast
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import javax.inject.Inject


@AndroidEntryPoint
class FavoritesFragment : Fragment() {

    private lateinit var binding: FavoritesFragmentBinding

    private val viewModel: FavoritesViewModel by viewModels()

    @Inject
    lateinit var matchesAdapter: MatchesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.favorites_fragment, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.recyclerFavorites.apply {
            adapter = matchesAdapter
            setHasFixedSize(true)
        }

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        lifecycleScope.launchWhenCreated {
            viewModel.getFavoredMatches()
        }
        viewModel.favoredMatchesLiveData.observe(requireActivity(), Observer {
            matchesAdapter.setMatchList(it.getProMatches())
            binding.viewState = it
            binding.executePendingBindings()

        })
        matchesAdapter.onMatchItemClicked = { matchId, leagueName ->
            navigateToMatchDetails(matchId, leagueName)
        }
        matchesAdapter.onFavoriteClicked = { proMatch ->
            Timber.d("${proMatch.isFavorited}")
            when (proMatch.isFavorited) {
                true -> {
                    viewModel.removeFromFavorites(proMatch)
                    toast(requireActivity(), getString(R.string.successfully_removed))
                }
            }
            matchesAdapter.notifyDataSetChanged()
        }

    }

    private fun navigateToMatchDetails(matchId: MatchId, leagueName: LeagueName) {
        val direction =
            FavoritesFragmentDirections.actionFavoritesFragmentToMatchDetailsFragment2(
                matchId.value,
                leagueName.value
            )
        this.findNavController().navigate(direction)
    }

}
