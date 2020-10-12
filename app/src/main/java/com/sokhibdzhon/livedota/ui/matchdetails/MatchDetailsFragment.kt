package com.sokhibdzhon.livedota.ui.matchdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.sokhibdzhon.livedota.R
import com.sokhibdzhon.livedota.data.Status
import com.sokhibdzhon.livedota.databinding.MatchDetailsFragmentBinding
import com.sokhibdzhon.livedota.util.enums.Teams
import com.sokhibdzhon.livedota.util.extensions.runIfNull
import com.sokhibdzhon.livedota.util.extensions.toast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MatchDetailsFragment : Fragment() {

    private val viewModel: MatchDetailsViewModel by viewModels()
    private lateinit var binding: MatchDetailsFragmentBinding
    private var matchId: Long = 0
    private var leagueName: String = "League Name"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.match_details_fragment, container, false)
        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }

    private val args: MatchDetailsFragmentArgs by navArgs()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        matchId = args.matchId
        leagueName = args.leagueName
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        savedInstanceState.runIfNull {
            viewModel.loadMatchDetails(matchId)
        }
//      Another alternative
//        lifecycleScope.launchWhenCreated {
//            viewModel.loadMatchDetails(matchId)
//        }

        //Get Match Details
        viewModel.matchDetailsLiveData.observe(viewLifecycleOwner, Observer { matchDetails ->
            when (matchDetails.matchDetailsResource.status) {
                Status.SUCCESS -> {
                    binding.viewState = matchDetails
                }
                Status.ERROR -> {
                    toast(requireActivity(), getString(R.string.error_fetching))
                }
            }
        })
        //Get Radiant Team Logo Id
        viewModel.radiantTeamLogoId.observe(viewLifecycleOwner, Observer { radiantLogoId ->
            radiantLogoId.let { viewModel.getTeamLogo(radiantLogoId, Teams.RADIANT) }
        })
        //Get Dire Team Logo Id
        viewModel.direTeamLogoId.observe(viewLifecycleOwner, Observer { direLogoId ->
            direLogoId.let { viewModel.getTeamLogo(direLogoId, Teams.DIRE) }
        })
        //Get Radiant Team Logo
        viewModel.radiantTeamLogo.observe(viewLifecycleOwner, Observer {
            when (it.teamLogo.status) {
                Status.SUCCESS -> {
                    binding.radiantState = it
                }
                Status.ERROR -> {
                    toast(requireActivity(), getString(R.string.no_radiant_logo))
                }
            }
        })
        //Get Dire Team Logo
        viewModel.direTeamLogo.observe(viewLifecycleOwner, Observer {
            when (it.teamLogo.status) {
                Status.SUCCESS -> {
                    binding.direState = it
                }
                Status.ERROR -> {
                    toast(requireActivity(), getString(R.string.no_dire_logo))
                }
            }
        })

        //Get Players Id
        viewModel.playerIds.observe(viewLifecycleOwner, Observer { playerIdList ->
            playerIdList.let { viewModel.getPlayers(playerIdList) }
        })

        viewModel.players.observe(viewLifecycleOwner, Observer { playersList ->
            when (playersList.size) {
                1 -> toast(requireActivity(), getString(R.string.loading_players))
                10 -> binding.playersState = PlayerViewState(playersList)
            }
        })

        binding.leagueName.text = leagueName
    }


}
