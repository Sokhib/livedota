package com.sokhibdzhon.livedota.data.network

import com.sokhibdzhon.livedota.data.Resource
import com.sokhibdzhon.livedota.data.network.model.ProMatches
import kotlinx.coroutines.flow.Flow


interface DotaDataSource {

    fun fetchProMatches(): Flow<Resource<List<ProMatches>>>
}