package com.sokhibdzhon.livedota.ui.matches

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
import androidx.navigation.fragment.findNavController
import com.sokhibdzhon.livedota.BaseApplication
import com.sokhibdzhon.livedota.R
import com.sokhibdzhon.livedota.databinding.MatchesFragmentBinding
import com.sokhibdzhon.livedota.ui.common.MatchesAdapter
import timber.log.Timber
import javax.inject.Inject

//TODO: Fix recyclerView margin + wrap content ile nasil duzgun hale getirilir(weight??)?
//TODO: What is the best way of implementing db
//TODO: 1 data hazir oldugunda combine beklesin how to do it?
class MatchesFragment : Fragment() {


    private lateinit var binding: MatchesFragmentBinding

    private lateinit var viewModel: MatchesViewModel

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

        viewModel = ViewModelProvider(this, viewModelFactory).get(MatchesViewModel::class.java)

        viewModel.proMatchesLiveData.observe(viewLifecycleOwner, Observer {
            matchesAdapter.setMatchList(it.getProMatches())
            binding.viewState = it
            binding.executePendingBindings()

        })
        matchesAdapter.onMatchItemClicked = { matchId, leagueName ->
            navigateToMatchDetails(matchId, leagueName)
        }
        //TODO: Should it be passed to viewModel and viewModel should handle add and remove ??
        //TODO: fix color changing
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
