package com.sokhibdzhon.livedota.ui.favorites

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sokhibdzhon.livedota.data.Resource
import com.sokhibdzhon.livedota.data.Status
import com.sokhibdzhon.livedota.data.local.entity.ProMatches
import com.sokhibdzhon.livedota.data.repository.DotaRepositoryImpl
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import timber.log.Timber

class FavoritesViewModel @ViewModelInject constructor(val dotaRepositoryImpl: DotaRepositoryImpl) :
    ViewModel() {

    private val _favoredMatchesLiveData: MutableLiveData<FavoriteMatchesViewState> =
        MutableLiveData()

    val favoredMatchesLiveData: LiveData<FavoriteMatchesViewState>
        get() = _favoredMatchesLiveData


    fun getFavoredMatches() {
        dotaRepositoryImpl.getProMatchesFromDb().onEach { proMatchList ->
            _favoredMatchesLiveData.value = if (proMatchList.isEmpty()) FavoriteMatchesViewState(
                Resource(
                    Status.ERROR, proMatchList,
                    "No favorite matches found"
                )
            )
            else FavoriteMatchesViewState(Resource(Status.SUCCESS, proMatchList, ""))
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

}



