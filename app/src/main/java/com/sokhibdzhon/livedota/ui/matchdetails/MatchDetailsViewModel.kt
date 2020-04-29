package com.sokhibdzhon.livedota.ui.matchdetails

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sokhibdzhon.livedota.data.Resource
import com.sokhibdzhon.livedota.data.network.model.Heroes
import com.sokhibdzhon.livedota.data.network.opendota.OpenDotaDataSourceImpl
import com.sokhibdzhon.livedota.data.network.steam.SteamDataSourceImpl
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class MatchDetailsViewModel @Inject constructor(
    val steamDataSourceImpl: SteamDataSourceImpl,
    val openDotaDataSourceImpl: OpenDotaDataSourceImpl
) :
    ViewModel() {
    private val _matchDetailsLiveData: MutableLiveData<MatchDetailsViewState> = MutableLiveData()
    val matchDetailsLiveData
        get() = _matchDetailsLiveData
    private val heroes: Flow<Resource<Heroes>> = openDotaDataSourceImpl.fetchHeroes()

    @ExperimentalCoroutinesApi
    fun loadMatchDetails(matchId: Long) {
        steamDataSourceImpl.fetchMatchDetails(matchId)
            .combine(heroes, ::combineHeroesWithPicksBans)
            .onEach {
                _matchDetailsLiveData.value = MatchDetailsViewState(it)
            }.launchIn(viewModelScope)
    }
}
