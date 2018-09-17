package net.imknown.imkgithub.di.module

import android.app.Application
import dagger.Module

@Module
class ApplicationModule(val mApplication: Application) {
//    @Provides
//    @Singleton
//    fun provideRetrofit(baseUrl: String, okHttpClient: Lazy<OkHttpClient>, converterFactoryType: KClass<Any>): Retrofit = Retrofit.Builder()
//            .baseUrl(baseUrl)
//            .client(okHttpClient.get())
//            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//            .addConverterFactory(when (converterFactoryType) {
//                Gson::class -> GsonConverterFactory.create()
//                String::class -> StringConverterFactory.create()
//                else -> throw IllegalArgumentException("ConverterFactory type is not supported now.")
//            })
//            .build()
//
//    @Provides
//    @Singleton
//    fun provideRetrofitBaseUrl() = RetrofitFactory.URL_API_GITHUB
//
//    @Provides
//    @Singleton
//    fun provideOkHttpClient(): OkHttpClient = OkHttpClient.Builder()
//            .addInterceptor(HttpLoggingInterceptor().apply {
//                level = HttpLoggingInterceptor.Level.BODY
//            })
//            .addInterceptor(ChuckInterceptor(MyApplication.application))
//            .addNetworkInterceptor(StethoInterceptor())
//            .connectTimeout(15, TimeUnit.SECONDS)
//            .readTimeout(20, TimeUnit.SECONDS)
//            .writeTimeout(20, TimeUnit.SECONDS)
//            .retryOnConnectionFailure(true)
//            .build()
//
//    @Provides
//    @Singleton
//    inline fun <reified T> provideRetrofitFactory(retrofit: Retrofit): T {
//        return retrofit.create(T::class.java)
//    }
}
