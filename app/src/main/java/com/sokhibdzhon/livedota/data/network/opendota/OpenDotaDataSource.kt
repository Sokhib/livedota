package com.sokhibdzhon.livedota.data.network.opendota

import com.sokhibdzhon.livedota.data.Resource
import com.sokhibdzhon.livedota.data.network.model.ProMatches
import kotlinx.coroutines.flow.Flow


interface OpenDotaDataSource {

    fun fetchProMatches(): Flow<Resource<List<ProMatches>>>
}