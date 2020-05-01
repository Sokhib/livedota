package com.sokhibdzhon.livedota.ui.matchdetails

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sokhibdzhon.livedota.data.Resource
import com.sokhibdzhon.livedota.data.Status
import com.sokhibdzhon.livedota.data.network.model.heroes.Heroes
import com.sokhibdzhon.livedota.data.network.opendota.OpenDotaDataSourceImpl
import com.sokhibdzhon.livedota.data.network.steam.SteamDataSourceImpl
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class MatchDetailsViewModel @Inject constructor(
    private val steamDataSourceImpl: SteamDataSourceImpl,
    openDotaDataSourceImpl: OpenDotaDataSourceImpl
) :
    ViewModel() {
    private val _matchDetailsLiveData: MutableLiveData<MatchDetailsViewState> = MutableLiveData()
    val matchDetailsLiveData
        get() = _matchDetailsLiveData

    private val heroes: Flow<Resource<Heroes>> = openDotaDataSourceImpl.fetchHeroes()

    fun getTeamLogo(logoId: Long, team: String) {
        steamDataSourceImpl.fetchTeamLogo(logoId)
            .onEach {
                if (team == "radiant") {
                    _radiantTeamLogo.value = TeamViewState(it)
                } else {
                    _direTeamLogo.value = TeamViewState(it)
                }
            }.launchIn(viewModelScope)
    }

    private val _radiantTeamLogoId: MutableLiveData<Long> = MutableLiveData()
    val radiantTeamLogoId
        get() = _radiantTeamLogoId

    private val _direTeamLogoId: MutableLiveData<Long> = MutableLiveData()
    val direTeamLogoId
        get() = _direTeamLogoId


    private val _radiantTeamLogo: MutableLiveData<TeamViewState> = MutableLiveData()
    val radiantTeamLogo
        get() = _radiantTeamLogo

    private val _direTeamLogo: MutableLiveData<TeamViewState> = MutableLiveData()
    val direTeamLogo
        get() = _direTeamLogo


    @ExperimentalCoroutinesApi
    fun loadMatchDetails(matchId: Long) {
        steamDataSourceImpl.fetchMatchDetails(matchId)
            .combine(heroes, ::combineHeroesWithPicksBans)
            .map {
                if (it.status == Status.SUCCESS) {
                    _radiantTeamLogoId.value = it.data?.result?.radiantLogo
                    _direTeamLogoId.value = it.data?.result?.direLogo
                }
                it
            }
            .onEach {
                _matchDetailsLiveData.value = MatchDetailsViewState(it)
            }.launchIn(viewModelScope)


    }
}
