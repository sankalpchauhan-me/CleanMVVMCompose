package me.sankalpchauhan.learncrypto.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import me.sankalpchauhan.learncrypto.presentation.coin_detail.CoinDetailPage
import me.sankalpchauhan.learncrypto.presentation.coin_list.CoinListPage
import me.sankalpchauhan.learncrypto.presentation.ui.theme.LearnCryptoTheme
import me.sankalpchauhan.learncrypto.routes.Routes

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnCryptoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = Routes.CoinListRoute.route){
                        composable(
                            route = Routes.CoinListRoute.route
                        ){
                            CoinListPage(navController)
                        }
                        composable(route = Routes.CoinDetailRoute.route + "/{coinId}")
                        {
                            CoinDetailPage()
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LearnCryptoTheme {
        Greeting("Android")
    }
}