package me.sankalpchauhan.learncrypto.domain.dto

import me.sankalpchauhan.learncrypto.data.network.model.TeamMember

data class CoinDetailDto(
    val coinId: String,
    val name: String,
    val description: String,
    val symbol: String,
    val rank: Int,
    val isActive: Boolean,
    val tags: List<String>,
    val team: List<TeamMember>
)