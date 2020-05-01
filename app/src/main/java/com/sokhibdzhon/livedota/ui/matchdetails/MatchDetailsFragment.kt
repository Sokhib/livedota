package com.sokhibdzhon.livedota.ui.matchdetails

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
import androidx.navigation.fragment.navArgs
import com.sokhibdzhon.livedota.BaseApplication
import com.sokhibdzhon.livedota.R
import com.sokhibdzhon.livedota.data.Status
import com.sokhibdzhon.livedota.databinding.MatchDetailsFragmentBinding
import kotlinx.coroutines.InternalCoroutinesApi
import timber.log.Timber
import javax.inject.Inject


class MatchDetailsFragment : Fragment() {

    private lateinit var viewModel: MatchDetailsViewModel
    private lateinit var binding: MatchDetailsFragmentBinding
    private var matchId: Long = 0

    @Inject
    internal lateinit var matchDetailsViewModelFactory: ViewModelProvider.Factory

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity!!.applicationContext as BaseApplication).appGraph.inject(this)
    }

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
    }

    @InternalCoroutinesApi
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(
            this,
            matchDetailsViewModelFactory
        ).get(MatchDetailsViewModel::class.java)
        viewModel.loadMatchDetails(matchId)
        viewModel.matchDetailsLiveData.observe(viewLifecycleOwner, Observer {
            when (it.matchDetailsResource.status) {
                Status.SUCCESS -> {
                    binding.viewState = it
                }
                Status.ERROR -> {
                    //TODO: Show error dialog.
                    Timber.d("ERROR...")
                    Toast.makeText(activity, "Error fetching match details", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        })

        viewModel.radiantTeamLogoId.observe(viewLifecycleOwner, Observer {
            if (it != null)
                viewModel.getTeamLogo(it, "radiant")
        })
        viewModel.direTeamLogoId.observe(viewLifecycleOwner, Observer {
            if (it != null)
                viewModel.getTeamLogo(it, "dire")
        })

        viewModel.radiantTeamLogo.observe(viewLifecycleOwner, Observer {
            when (it.teamLogo.status) {
                Status.SUCCESS -> {
                    binding.radiantState = it
                }
                Status.ERROR -> {
                    //TODO: Show error dialog.
                    Timber.d("ERROR...")
                    Toast.makeText(activity, "No Radiant Logo", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        })
        viewModel.direTeamLogo.observe(viewLifecycleOwner, Observer {
            when (it.teamLogo.status) {
                Status.SUCCESS -> {
                    binding.direState = it
                }
                Status.ERROR -> {
                    //TODO: Show error dialog.
                    Timber.d("ERROR...")
                    Toast.makeText(activity, "No Dire Logo", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        })

    }

}
