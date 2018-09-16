package net.imknown.imkgithub.web

import com.facebook.stetho.okhttp3.StethoInterceptor
import com.google.gson.Gson
import com.readystatesoftware.chuck.ChuckInterceptor
import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import net.imknown.imkgithub.global.MyApplication
import net.imknown.imkgithub.web.converter.StringConverterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitFactory {
    companion object {
        const val URL_API_GITHUB = "https://api.github.com/"

        inline fun <reified T> create(converterFactoryType: Any = Gson::class): T {
            val loggingInterceptor = HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }

            val client = OkHttpClient.Builder()
                    .addInterceptor(loggingInterceptor)
                    .addInterceptor(ChuckInterceptor(MyApplication.sApplication))
                    .addNetworkInterceptor(StethoInterceptor())
                    .connectTimeout(15, TimeUnit.SECONDS)
                    .readTimeout(20, TimeUnit.SECONDS)
                    .writeTimeout(20, TimeUnit.SECONDS)
                    .retryOnConnectionFailure(true)
                    .build()

            val retrofit = Retrofit.Builder()
                    .baseUrl(URL_API_GITHUB)
                    .client(client)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(when (converterFactoryType) {
                        Gson::class -> GsonConverterFactory.create()
                        String::class -> StringConverterFactory.create()
                        else -> throw IllegalArgumentException("ConverterFactory type is not supported now.")
                    })
                    .build()

            return retrofit.create(T::class.java)
        }

        fun <T> ioToMain(): ObservableTransformer<T, T> = ObservableTransformer { upstream ->
            upstream.subscribeOn(Schedulers.io())
                    .unsubscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
        }
    }
}
