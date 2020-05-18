package com.sokhibdzhon.livedota.ui.matches

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sokhibdzhon.livedota.data.Status
import com.sokhibdzhon.livedota.data.local.entity.ProMatches
import com.sokhibdzhon.livedota.data.repository.DotaRepositoryImpl
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject

@ExperimentalCoroutinesApi
class MatchesViewModel @Inject constructor(val dotaRepositoryImpl: DotaRepositoryImpl) :
    ViewModel() {
    private val _proMatchesLiveData: MutableLiveData<MatchesFragmentViewState> = MutableLiveData()
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
    @ExperimentalCoroutinesApi
    fun loadProMatches() {
        dotaRepositoryImpl.fetchProMatches()
            .combine(favoritedMatches, ::combineFavorites)
            .onEach {
                if (it.status == Status.SUCCESS) {
                    _proMatchesLiveData.value = MatchesFragmentViewState(it)
                }
            }.launchIn(viewModelScope)
    }

    suspend fun isFavorited(proMatch: ProMatches): Boolean {
        return withContext(viewModelScope.coroutineContext) {
            dotaRepositoryImpl.isFavorited(proMatch.matchId)
        }
    }

    fun removeFromFavorites(proMatch: ProMatches) {
        viewModelScope.launch {
            try {
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
