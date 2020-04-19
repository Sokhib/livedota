package com.sokhibdzhon.livedota.ui.matchdetails

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sokhibdzhon.livedota.data.network.OpenDotaDataSourceImpl
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class MatchDetailsViewModel @Inject constructor(val openDotaDataSourceImpl: OpenDotaDataSourceImpl) :
    ViewModel() {

    private val _matchDetailsLiveData: MutableLiveData<MatchDetailsViewState> = MutableLiveData()
    val matchDetailsLiveData
        get() = _matchDetailsLiveData

    fun loadMatchDetails(matchId: Long) {
        openDotaDataSourceImpl.fetchMatchDetails(matchId)
            .onEach {
                _matchDetailsLiveData.value = MatchDetailsViewState(it)
            }.launchIn(viewModelScope)
    }
}
