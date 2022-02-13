package me.sankalpchauhan.learncrypto.presentation.coin_list

import me.sankalpchauhan.learncrypto.domain.dto.CoinDto

data class CoinListState (
    val isLoading:Boolean = false,
    val coins: List<CoinDto> = emptyList(),
    val error: String = ""
)