package com.sokhibdzhon.livedota.data.network

import com.sokhibdzhon.livedota.data.Resource
import com.sokhibdzhon.livedota.data.network.response.ProMatches
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers


//TODO:May Create Impl class of it later.
//TODO:Provide ApiServiceProvider by cons and later by DI

class OpenDotaDataSource {

    private val openDotaApiServiceProvider = OpenDotaApiServiceProvider()

    fun fetchProMatches(): Observable<Resource<List<ProMatches>>> {
        return Observable.create { emitter ->
            emitter.onNext(Resource.loading())
            openDotaApiServiceProvider
                .getOpenDotaApiService()
                .getProMatches()
                .subscribeOn(Schedulers.io())
                .subscribe(
                    { matchesList ->
                        emitter.onNext(Resource.success(matchesList))
                        emitter.onComplete()
                    }, { error ->
                        //emitter.onError() means stop process or crash app, but we want is continue I'll handle that...
                        emitter.onNext(Resource.error(error.message ?: ""))
                        emitter.onComplete()
                    }

                )
        }
    }
}