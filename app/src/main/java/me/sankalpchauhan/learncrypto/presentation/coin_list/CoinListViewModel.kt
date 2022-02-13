package me.sankalpchauhan.learncrypto.presentation.coin_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import me.sankalpchauhan.learncrypto.common.RepoResponse
import me.sankalpchauhan.learncrypto.domain.use_case.get_coin.GetCoinUseCase
import me.sankalpchauhan.learncrypto.domain.use_case.get_coins.GetCoinsUseCase
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(private val getCoinsUseCase: GetCoinsUseCase): ViewModel() {
    private val _state = mutableStateOf(CoinListState())
    val state: State<CoinListState> = _state

    init {
        getCoins()
    }

    private fun getCoins(){
        getCoinsUseCase().onEach { result->
            when(result){
                is RepoResponse.Success->{
                    _state.value = CoinListState(coins = result.data?: emptyList())
                }
                is RepoResponse.Error->{
                    _state.value = CoinListState(
                        error = result.message?:"An unexpected error occured"
                    )
                }
                is RepoResponse.Loading->{
                    _state.value = CoinListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}