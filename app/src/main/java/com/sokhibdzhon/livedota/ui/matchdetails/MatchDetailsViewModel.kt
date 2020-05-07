package com.sokhibdzhon.livedota.ui.matchdetails

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sokhibdzhon.livedota.data.Resource
import com.sokhibdzhon.livedota.data.Status
import com.sokhibdzhon.livedota.data.network.model.heroes.Heroes
import com.sokhibdzhon.livedota.data.network.model.matchdetails.*
import com.sokhibdzhon.livedota.data.network.opendota.OpenDotaDataSourceImpl
import com.sokhibdzhon.livedota.data.network.steam.SteamDataSourceImpl
import com.sokhibdzhon.livedota.util.enums.Teams
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class MatchDetailsViewModel @Inject constructor(
    private val steamDataSourceImpl: SteamDataSourceImpl,
    private val openDotaDataSourceImpl: OpenDotaDataSourceImpl
) :
    ViewModel() {
    private val _matchDetailsLiveData: MutableLiveData<MatchDetailsViewState> = MutableLiveData()
    val matchDetailsLiveData
        get() = _matchDetailsLiveData

    private val heroes: Flow<Resource<Heroes>> = openDotaDataSourceImpl.fetchHeroes()

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

    private val _playerIds: MutableLiveData<List<Player>> = MutableLiveData()
    val playerIds
        get() = _playerIds

    private val _players: MutableLiveData<List<Resource<PlayerInfo>>> = MutableLiveData()
    val players
        get() = _players

    //Solve this matchId problem onConfigChange it fetches more than once
    @ExperimentalCoroutinesApi
    fun loadMatchDetails(matchId: Long) {
        steamDataSourceImpl.fetchMatchDetails(matchId)
            .combine(heroes, ::combineHeroesWithPicksBans)
            .map {
                if (it.status == Status.SUCCESS) {
                    _radiantTeamLogoId.value = it.data?.getRadiantLogo()
                    _direTeamLogoId.value = it.data?.getDireLogo()
                    _playerIds.value = it.data?.getPlayers()
                }
                it
            }
            .onEach {
                _matchDetailsLiveData.value = MatchDetailsViewState(it)
            }.launchIn(viewModelScope)


    }

    fun getTeamLogo(logoId: Long, team: Teams) {
        steamDataSourceImpl.fetchTeamLogo(logoId)
            .onEach {
                when (team) {
                    Teams.RADIANT -> _radiantTeamLogo.value = TeamViewState(it)
                    else -> _direTeamLogo.value = TeamViewState(it)
                }
            }.launchIn(viewModelScope)
    }

    fun getPlayers(playerIds: List<Player>) {
        val listOfPlayers = mutableListOf<Resource<PlayerInfo>>()
        openDotaDataSourceImpl.fetchPlayer(playerIds)
            .onEach {
                if (it.status == Status.SUCCESS) {
                    listOfPlayers.add(it)
                    _players.value = listOfPlayers
                }

            }.launchIn(viewModelScope)
    }
}
