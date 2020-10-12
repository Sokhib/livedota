package com.sokhibdzhon.livedota.ui.matches

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.sokhibdzhon.livedota.R
import com.sokhibdzhon.livedota.databinding.MatchesFragmentBinding
import com.sokhibdzhon.livedota.ui.common.MatchesAdapter
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
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
            Timber.d("${proMatch.isFavorited}")
            when (proMatch.isFavorited) {
                true -> {

                    viewModel.removeFromFavorites(proMatch)
                    Toast.makeText(
                        requireActivity(),
                        "Successfully Removed from Favorites",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                false -> {

                    Toast.makeText(
                        requireActivity(),
                        "Successfully Added to Favorites",
                        Toast.LENGTH_SHORT
                    ).show()
                    viewModel.addToFavorites(proMatch)
                }
            }
            matchesAdapter.notifyDataSetChanged()
        }
    }

    private fun navigateToMatchDetails(matchId: Long, leagueName: String) {
        val direction =
            MatchesFragmentDirections.actionMatchesFragmentToMatchDetailsFragment(
                matchId,
                leagueName
            )
        this.findNavController().navigate(direction)
    }
}
