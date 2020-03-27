package com.sokhibdzhon.livedota.ui.matches

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sokhibdzhon.livedota.data.network.OpenDotaDataSourceImpl
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class MatchesViewModel @Inject constructor(val openDotaDataSourceImpl: OpenDotaDataSourceImpl) :
    ViewModel() {
    private val _proMatchesLiveData: MutableLiveData<MatchesFragmentViewState> = MutableLiveData()

    init {
        loadProMatches()
    }

    val proMatchesLiveData: LiveData<MatchesFragmentViewState>
        get() = _proMatchesLiveData

    //    TODO: Other way to get it which is better ?
//    private val _data =
//        openDotaDataSourceImpl.fetchProMatches().asLiveData(viewModelScope.coroutineContext)
//
//    val data: LiveData<Resource<List<ProMatches>>>
//        get() = _data


    fun loadProMatches() {
        openDotaDataSourceImpl.fetchProMatches()
            .onEach {
                _proMatchesLiveData.value = combineMatches(it)
            }.launchIn(viewModelScope)

    }
    //TODO: What's the problem with this approach?
//    openDotaDataSourceImpl.fetchProMatches()
//    .map {
//        combineMatches(combineMatchSeries(it as Resource<MutableList<ProMatches>>))
//    }
//    .asLiveData()
}
