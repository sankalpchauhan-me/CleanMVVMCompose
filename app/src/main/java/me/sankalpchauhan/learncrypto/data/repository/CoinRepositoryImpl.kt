package me.sankalpchauhan.learncrypto.data.repository

import me.sankalpchauhan.learncrypto.data.network.CoinPaprikaAPI
import me.sankalpchauhan.learncrypto.data.network.model.Coin
import me.sankalpchauhan.learncrypto.data.network.model.CoinDetail
import me.sankalpchauhan.learncrypto.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(private val api:CoinPaprikaAPI):CoinRepository {
    override suspend fun getCoins(): List<Coin> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetail {
        return api.getCoinById(coinId)
    }
}