package com.sokhibdzhon.livedota.ui.matches

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sokhibdzhon.livedota.data.local.entity.ProMatches
import com.sokhibdzhon.livedota.data.repository.DotaRepositoryImpl
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

class MatchesViewModel @Inject constructor(val dotaRepositoryImpl: DotaRepositoryImpl) :
    ViewModel() {
    private val _proMatchesLiveData: MutableLiveData<MatchesFragmentViewState> = MutableLiveData()

    //Inetten once 1 kere datayi cekiyor...
    private val favoritedMatches =
        dotaRepositoryImpl.getProMatchesFromDb()


    init {
        loadProMatches()
    }

    val proMatchesLiveData: LiveData<MatchesFragmentViewState>
        get() = _proMatchesLiveData

//        TODO: What's the difference between these ways
//    private val data =
//        openDotaDataSourceImpl.fetchProMatches().asLiveData(viewModelScope.coroutineContext)

    //TODO:Check combineMatchSeries
    fun loadProMatches() {
        dotaRepositoryImpl.fetchProMatches()
            .combine(favoritedMatches, ::combineFavorites)
            .onEach {
                _proMatchesLiveData.value = MatchesFragmentViewState(it)

            }.launchIn(viewModelScope)
    }


    fun removeFromFavorites(proMatch: ProMatches) {
        viewModelScope.launch {
            try {
                proMatch.isFavorited = false
                dotaRepositoryImpl.removeMatchFromFavorite(proMatch)
            } catch (e: Exception) {
                Timber.e(e)
            }
        }
    }

    fun addToFavorites(proMatch: ProMatches) {
        viewModelScope.launch {
            try {
                proMatch.isFavorited = true
                dotaRepositoryImpl.addMatchToFavorite(proMatch)
            } catch (e: Exception) {
                Timber.e(e)
            }
        }
    }
}
