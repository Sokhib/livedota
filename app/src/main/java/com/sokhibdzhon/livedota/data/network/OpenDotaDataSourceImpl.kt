package com.sokhibdzhon.livedota.data.network

import com.sokhibdzhon.livedota.data.Resource
import com.sokhibdzhon.livedota.data.network.model.ProMatches
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


/**     I ❤ Code:)
╔═══════════════════════════════════════╗
║  Created by Sokhibdzhon Saidmuratov   ║
╠═══════════════════════════════════════╣
║ sokhibsaid@gmail.com                  ║
╚═══════════════════════════════════════╝
 */

//TODO: Implementation yaratma sebebi farkli API'lerden farkli proMatches'leri almak

class OpenDotaDataSourceImpl @Inject constructor(val openDotaApiServiceProvider: DotaApiServiceProvider) :
    DotaDataSource {
    override fun fetchProMatches(): Flow<Resource<List<ProMatches>>> = flow {
        emit(Resource.loading())
        try {
            val proMatches = openDotaApiServiceProvider.openDotaApiService.getProMatches()
            emit(Resource.success(proMatches))
        } catch (exception: Exception) {
            emit(Resource.error<List<ProMatches>>(exception.message ?: "Error loading Pro Matches"))
        }

    }
}