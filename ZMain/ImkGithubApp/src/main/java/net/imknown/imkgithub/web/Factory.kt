package net.imknown.imkgithub.web

import com.google.gson.Gson
import net.imknown.imkgithub.web.converter.ToStringConverterFactory
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @author imknown on 8/9/17.
 */
class Factory {
    companion object {
        const val gankIOUrl = "https://api.github.com/"

        inline fun <reified T> create(converterFactoryType: Any = Gson::class): T {
            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(when (converterFactoryType) {
                        Gson::class -> GsonConverterFactory.create()
                        String::class -> ToStringConverterFactory.create()
                        else -> throw IllegalArgumentException("ConverterFactory type is not supported now.")
                    })
                    .baseUrl(gankIOUrl)
                    .build()

            return retrofit.create(T::class.java)
        }
    }
}
