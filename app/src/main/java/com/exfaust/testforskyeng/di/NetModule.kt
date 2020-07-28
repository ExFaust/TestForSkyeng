package com.exfaust.testforskyeng.di

import android.content.Context
import com.exfaust.testforskyeng.api.ApiConstants
import com.exfaust.testforskyeng.api.TranslationApi
import com.exfaust.testforskyeng.utils.NetHelper
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetModule{

    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return loggingInterceptor
    }

    @Provides
    fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        val builder = OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(httpLoggingInterceptor)

       return builder
            .build()
    }

    @Provides
    fun provideApi(retrofitBuilder: Retrofit.Builder): TranslationApi {
        return retrofitBuilder
            .baseUrl(ApiConstants.baseUrl)
            .build()
            .create(TranslationApi::class.java)
    }

    @Provides
    fun provideRetrofitBuilder(client: OkHttpClient): Retrofit.Builder {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(client)
    }

    @Provides
    fun provideNetHelper(context: Context): NetHelper {
        return NetHelper(context)
    }
}