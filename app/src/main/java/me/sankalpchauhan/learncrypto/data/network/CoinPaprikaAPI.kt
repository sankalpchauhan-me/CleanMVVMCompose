package me.sankalpchauhan.learncrypto.data.network

import me.sankalpchauhan.learncrypto.data.network.model.Coin
import me.sankalpchauhan.learncrypto.data.network.model.CoinDetail
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaAPI {
    @GET("/v1/coins")
    suspend fun getCoins(): List<Coin>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId:String) : CoinDetail
}