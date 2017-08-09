package net.imknown.imkgithub.web.url

import com.google.gson.annotations.SerializedName
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * @author imknown on 8/9/17.
 */
interface UserUrl {
    @GET("users/{user}")
    fun getUserInfo(@Path("user") user: String = "imknown"): Observable<UserInfo>

    data class UserInfo(
            @SerializedName("avatar_url") val avatarUrl: String,
            @SerializedName("html_url") val htmlUrl: String,
            @SerializedName("followers_url") val followersUrl: String,
            @SerializedName("following_url") val followingUrl: String,
            val name: String,
            val location: String,
            val bio: String
    )
}