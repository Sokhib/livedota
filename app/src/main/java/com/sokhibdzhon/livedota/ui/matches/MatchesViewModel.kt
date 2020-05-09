package com.sokhibdzhon.livedota.ui.matches

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sokhibdzhon.livedota.data.network.opendota.OpenDotaDataSourceImpl
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@ExperimentalCoroutinesApi
class MatchesViewModel @Inject constructor(val openDotaDataSourceImpl: OpenDotaDataSourceImpl) :
    ViewModel() {
    private val _proMatchesLiveData: MutableLiveData<MatchesFragmentViewState> = MutableLiveData()

    init {
        loadProMatches()
    }

    val proMatchesLiveData: LiveData<MatchesFragmentViewState>
        get() = _proMatchesLiveData

//        TODO: What's the difference between these ways
//    private val data =
//        openDotaDataSourceImpl.fetchProMatches().asLiveData(viewModelScope.coroutineContext)

    //TODO:Check combineMatchSeries
    @ExperimentalCoroutinesApi
    fun loadProMatches() {
        openDotaDataSourceImpl.fetchProMatches()
            .onEach {
                _proMatchesLiveData.value = MatchesFragmentViewState(it)
            }.launchIn(viewModelScope)
    }
}
