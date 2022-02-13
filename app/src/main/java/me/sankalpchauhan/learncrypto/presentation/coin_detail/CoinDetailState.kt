package me.sankalpchauhan.learncrypto.presentation.coin_detail

import me.sankalpchauhan.learncrypto.domain.dto.CoinDetailDto
import me.sankalpchauhan.learncrypto.domain.dto.CoinDto

data class CoinDetailState (
    val isLoading:Boolean = false,
    val coin: CoinDetailDto? = null,
    val error: String = ""
)