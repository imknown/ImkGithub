package net.imknown.imkgithub.web.url

import io.reactivex.Observable
import retrofit2.http.GET

interface OtherMiscUrl {
    @GET("zen")
    fun getZen(): Observable<String>
}