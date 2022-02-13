package me.sankalpchauhan.learncrypto.domain.dto

import com.google.gson.annotations.SerializedName

data class CoinDto (
    val id: String,
    val isActive: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
)