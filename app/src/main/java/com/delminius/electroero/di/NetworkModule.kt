package com.delminius.electroero.di

import com.delminius.electroero.data.remote.HzhbApi
import com.delminius.electroero.domain.repository.RemoteDataSource
import com.delminius.electroero.data.repository.RemoteDataSourceImpl
import com.delminius.electroero.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(15, TimeUnit.SECONDS)
            .connectTimeout(15, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofitInstance(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideHzhbApi(retrofit: Retrofit): HzhbApi {
        return retrofit.create(HzhbApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRemoteDataSource(
        hzhbApi: HzhbApi
    ): RemoteDataSource {
        return RemoteDataSourceImpl(
            hzhbApi = hzhbApi
        )
    }
}