package me.sankalpchauhan.learncrypto.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import me.sankalpchauhan.learncrypto.common.Constants
import me.sankalpchauhan.learncrypto.data.network.CoinPaprikaAPI
import me.sankalpchauhan.learncrypto.data.repository.CoinRepositoryImpl
import me.sankalpchauhan.learncrypto.domain.repository.CoinRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun providePaprikaApi(): CoinPaprikaAPI{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: CoinPaprikaAPI):CoinRepository{
        return CoinRepositoryImpl(api)
    }
}