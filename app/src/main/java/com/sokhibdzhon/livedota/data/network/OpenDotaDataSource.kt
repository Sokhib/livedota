package com.sokhibdzhon.livedota.data.network

import com.sokhibdzhon.livedota.data.Resource
import com.sokhibdzhon.livedota.data.network.model.ProMatches
import kotlinx.coroutines.flow.Flow


//TODO:May Create Impl class of it later.
//TODO:Provide ApiServiceProvider by cons and later by DI

interface OpenDotaDataSource {

    fun fetchProMatches(): Flow<Resource<List<ProMatches>>>
}