package me.sankalpchauhan.learncrypto.routes

sealed class Routes(val route: String) {
    object CoinListRoute: Routes("/coin_list")
    object CoinDetailRoute: Routes("/coin_list")
}