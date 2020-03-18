package com.sokhibdzhon.livedota.ui.matches

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sokhibdzhon.livedota.data.Resource
import com.sokhibdzhon.livedota.data.network.OpenDotaDataSourceImpl
import com.sokhibdzhon.livedota.data.network.model.ProMatches
import javax.inject.Inject

class MatchesViewModel @Inject constructor(val openDotaDataSourceImpl: OpenDotaDataSourceImpl) :
    ViewModel() {
    init {
        loadProMatches()
    }

    private val _proMatchesLiveData: MutableLiveData<Resource<List<ProMatches>>> =
        MutableLiveData()
    val proMatchesLiveData: LiveData<Resource<List<ProMatches>>>
        get() = _proMatchesLiveData

    fun loadProMatches() {
        //TODO: Get and work on data
    }


}
