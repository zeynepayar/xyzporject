package com.example.xyz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.xyz.ui.theme.XyzTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            XyzTheme {
                // Set up navigation controller
                val navController = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = "mainentrance",
                        Modifier.padding(innerPadding)
                    ) {
                        composable("login") { LoginSayfasi(navController)}
                        composable("home") { HomeScreen() }
                        composable("newaccount") { YeniUyelik(navController )}
                        composable("mainentrance") { AnaGirisSayfasi(navController) }
                        composable("forgotpassword") { SifremiUnuttum(navController) }

                    }
                }
            }
        }
    }
}



@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Home Screen",
            style = MaterialTheme.typography.headlineLarge
        )
    }
}



@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    XyzTheme {
        HomeScreen()
    }
}
