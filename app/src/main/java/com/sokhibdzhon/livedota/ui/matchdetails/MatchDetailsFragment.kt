package com.sokhibdzhon.livedota.ui.matchdetails

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.sokhibdzhon.livedota.R
import com.sokhibdzhon.livedota.base.BaseFragment
import com.sokhibdzhon.livedota.data.Status
import com.sokhibdzhon.livedota.data.model.MatchId
import com.sokhibdzhon.livedota.databinding.MatchDetailsFragmentBinding
import com.sokhibdzhon.livedota.util.enums.Teams
import com.sokhibdzhon.livedota.util.extensions.runIfNull
import com.sokhibdzhon.livedota.util.extensions.toast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MatchDetailsFragment :
    BaseFragment<MatchDetailsFragmentBinding>(R.layout.match_details_fragment) {

    private val viewModel: MatchDetailsViewModel by viewModels()
    private var matchId: MatchId = MatchId(0)
    private var leagueName: String = "League Name"

    private val args: MatchDetailsFragmentArgs by navArgs()

    override fun init() {
        matchId = MatchId(args.matchId)
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
        getMatchDetails()
        //Get Radiant Team Logo
        getRadiantTeamLogo()
        //Get Dire Team Logo
        getDireTeamLogo()
        //Get Players
        getPlayers()
        //Set League Name
        setLeagueName()

    }

    private fun setLeagueName() {
        binding.leagueName.text = leagueName
    }

    private fun getPlayers() {
        viewModel.playerIds.observe(viewLifecycleOwner, Observer { playerIdList ->
            playerIdList.let { viewModel.getPlayers(playerIdList) }
        })

        viewModel.players.observe(viewLifecycleOwner, Observer { playersList ->
            when (playersList.size) {
                1 -> toast(requireActivity(), getString(R.string.loading_players))
                10 -> binding.playersState = PlayerViewState(playersList)
            }
        })
    }

    private fun getDireTeamLogo() {
        viewModel.direTeamLogoId.observe(viewLifecycleOwner, Observer { direLogoId ->
            direLogoId.let { viewModel.getTeamLogo(direLogoId, Teams.DIRE) }
        })
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
    }

    private fun getRadiantTeamLogo() {
        viewModel.radiantTeamLogoId.observe(viewLifecycleOwner, Observer { radiantLogoId ->
            radiantLogoId.let { viewModel.getTeamLogo(radiantLogoId, Teams.RADIANT) }
        })

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
    }

    private fun getMatchDetails() {
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
    }


}
