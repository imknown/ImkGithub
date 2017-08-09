package net.imknown.imkgithub.web.url

import io.reactivex.Observable
import retrofit2.http.GET

/**
 * @author imknown on 8/9/17.
 */
interface OtherMiscUrl {
    @GET("zen")
    fun getZen(): Observable<String>
}