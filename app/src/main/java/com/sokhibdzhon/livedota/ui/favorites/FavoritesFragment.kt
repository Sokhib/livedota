package com.sokhibdzhon.livedota.ui.favorites

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.sokhibdzhon.livedota.BaseApplication
import com.sokhibdzhon.livedota.R
import com.sokhibdzhon.livedota.databinding.FavoritesFragmentBinding
import com.sokhibdzhon.livedota.ui.matches.MatchesAdapter
import timber.log.Timber
import javax.inject.Inject

//TODO: Ayni adapter ve ayni viewModel... how to refactor in that side?


class FavoritesFragment : Fragment() {

    private lateinit var binding: FavoritesFragmentBinding

    private lateinit var viewModel: FavoritesViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var matchesAdapter: MatchesAdapter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().applicationContext as BaseApplication).appGraph.inject(this)
    }

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
        viewModel = ViewModelProvider(this, viewModelFactory).get(FavoritesViewModel::class.java)

        lifecycleScope.launchWhenCreated {
            viewModel.getFavoredMatches()
        }
        viewModel.favoredMatchesLiveData.observe(requireActivity(), Observer {
            //TODO: write adapter and  Set binding the list
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
            }
            matchesAdapter.notifyDataSetChanged()
        }

    }

    private fun navigateToMatchDetails(matchId: Long, leagueName: String) {
        val direction =
            FavoritesFragmentDirections.actionFavoritesFragmentToMatchDetailsFragment2(
                matchId,
                leagueName
            )
        this.findNavController().navigate(direction)
    }

}
