package me.sankalpchauhan.learncrypto.domain.use_case.get_coins

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import me.sankalpchauhan.learncrypto.common.RepoResponse
import me.sankalpchauhan.learncrypto.data.network.model.toCoinDto
import me.sankalpchauhan.learncrypto.domain.dto.CoinDto
import me.sankalpchauhan.learncrypto.domain.repository.CoinRepository
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(private val repository: CoinRepository) {
    operator fun invoke(): Flow<RepoResponse<List<CoinDto>>> = flow {
        try{
            emit(RepoResponse.Loading<List<CoinDto>>())
            val coins = repository.getCoins().map { it.toCoinDto() }
            emit(RepoResponse.Success<List<CoinDto>>(coins))
        } catch (e:HttpException){
            emit(RepoResponse.Error<List<CoinDto>>(e.localizedMessage?:"An unexpected error occurred"))
        } catch (e: IOException){
            emit(RepoResponse.Error<List<CoinDto>>("Check Internet Connection"))
        }
    }
}