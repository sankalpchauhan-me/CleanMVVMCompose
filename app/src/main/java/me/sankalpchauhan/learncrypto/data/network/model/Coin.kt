package me.sankalpchauhan.learncrypto.data.network.model


import com.google.gson.annotations.SerializedName
import me.sankalpchauhan.learncrypto.domain.dto.CoinDto

data class Coin(
    @SerializedName("id")
    val id: String,
    @SerializedName("is_active")
    val isActive: Boolean,
    @SerializedName("is_new")
    val isNew: Boolean,
    @SerializedName("name")
    val name: String,
    @SerializedName("rank")
    val rank: Int,
    @SerializedName("symbol")
    val symbol: String,
    @SerializedName("type")
    val type: String
)

fun Coin.toCoinDto() : CoinDto{
    return CoinDto(
        id=id,
        isActive = isActive,
        name = name,
        rank = rank,
        symbol = symbol,
    );
}