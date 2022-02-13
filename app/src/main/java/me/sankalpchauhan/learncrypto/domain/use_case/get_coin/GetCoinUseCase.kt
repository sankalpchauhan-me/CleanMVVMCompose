package me.sankalpchauhan.learncrypto.domain.use_case.get_coin

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import me.sankalpchauhan.learncrypto.common.RepoResponse
import me.sankalpchauhan.learncrypto.data.network.model.CoinDetail
import me.sankalpchauhan.learncrypto.data.network.model.toCoinDetailDto
import me.sankalpchauhan.learncrypto.data.network.model.toCoinDto
import me.sankalpchauhan.learncrypto.domain.dto.CoinDetailDto
import me.sankalpchauhan.learncrypto.domain.dto.CoinDto
import me.sankalpchauhan.learncrypto.domain.repository.CoinRepository
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(private val repository: CoinRepository) {
    operator fun invoke(coinId: String): Flow<RepoResponse<CoinDetailDto>> = flow {
        try{
            emit(RepoResponse.Loading<CoinDetailDto>())
            val coin = repository.getCoinById(coinId).toCoinDetailDto()
            emit(RepoResponse.Success<CoinDetailDto>(coin))
        } catch (e:HttpException){
            emit(RepoResponse.Error<CoinDetailDto>(e.localizedMessage?:"An unexpected error occurred"))
        } catch (e: IOException){
            emit(RepoResponse.Error<CoinDetailDto>("Check Internet Connection"))
        }
    }
}