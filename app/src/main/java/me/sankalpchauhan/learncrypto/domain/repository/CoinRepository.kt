package me.sankalpchauhan.learncrypto.domain.repository

import me.sankalpchauhan.learncrypto.data.network.model.Coin
import me.sankalpchauhan.learncrypto.data.network.model.CoinDetail

interface CoinRepository {
    suspend fun getCoins(): List<Coin>
    suspend fun getCoinById(coinId: String): CoinDetail
}