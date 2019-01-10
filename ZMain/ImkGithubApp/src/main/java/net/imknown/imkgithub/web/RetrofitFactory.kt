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
import retrofit2.create
import java.util.concurrent.TimeUnit
import kotlin.reflect.KClass

object RetrofitFactory {
    const val URL_API_GITHUB = "https://api.github.com/"

    inline fun <reified T> create(converterFactoryType: KClass<*> = Gson::class) =
        createRetrofit(converterFactoryType).create<T>()

    fun createRetrofit(converterFactoryType: Any): Retrofit = Retrofit.Builder()
        .baseUrl(URL_API_GITHUB)
        .client(createOkHttpClient())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(
            when (converterFactoryType) {
                Gson::class -> GsonConverterFactory.create()
                String::class -> StringConverterFactory.create()
                else -> throw IllegalArgumentException("ConverterFactory type is not supported now.")
            }
        )
        .build()

    private fun createOkHttpClient() = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
        .addInterceptor(ChuckInterceptor(MyApplication.application))
        .addNetworkInterceptor(StethoInterceptor())
        .connectTimeout(15, TimeUnit.SECONDS)
        .readTimeout(20, TimeUnit.SECONDS)
        .writeTimeout(20, TimeUnit.SECONDS)
        .retryOnConnectionFailure(true)
        .build()

    fun <T> ioToMain(): ObservableTransformer<T, T> = ObservableTransformer { upstream ->
        upstream.subscribeOn(Schedulers.io())
            .unsubscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}
