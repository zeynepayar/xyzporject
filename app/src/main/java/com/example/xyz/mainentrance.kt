package com.example.xyz


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition

@Composable
fun AnaGirisSayfasi(navController: NavHostController) {

    // Arka planda dönecek resimlerin listesi
    val imageList = listOf(
        R.drawable.arkaplan1,
        R.drawable.arkaplan2,
        R.drawable.arkaplan3,
        R.drawable.arkaplan4,
        R.drawable.arkaplan5
    )
    // Mevcut resim indeksini saklayan değişken
    var currentImageIndex by remember { mutableStateOf(0) }
    // Resmi her 3 saniyede bir değiştirmek için LaunchedEffect kullanımı
    LaunchedEffect(Unit) {
        while (true) {
            kotlinx.coroutines.delay(5000) // 3 saniye bekle
            currentImageIndex = (currentImageIndex + 1) % imageList.size // Resmi değiştir
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // Arka plan resmi
        Image(
            painter = painterResource(id = imageList[currentImageIndex]),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        // Şeffaf kart ile login formu
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Card(
                modifier = Modifier
                    .width(400.dp) // Kartın genişliğini ayarlayın
                    .height(500.dp) // Kartın yüksekliğini ayarlayın
                    .fillMaxWidth(0.8f)
                    .padding(16.dp),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White.copy(alpha = 0.5f)
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {


                    Text(
                        text = "\uD835\uDC7E\uD835\uDC6C\uD835\uDC73\uD835\uDC6A\uD835\uDC76\uD835\uDC74\uD835\uDC6C",
                        style = MaterialTheme.typography.titleLarge,
                        fontSize = 35.sp,
                        fontStyle = FontStyle.Italic,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF8b5a2b),
                        modifier = Modifier.padding(bottom = 16.dp)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Let's discover Turkey's magical history",
                        style = MaterialTheme.typography.titleLarge,
                        fontSize = 15.sp,
                        fontStyle = FontStyle.Italic,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF8b5a2b),
                        modifier = Modifier.padding(bottom = 16.dp)
                    )

                    Spacer(modifier = Modifier.height(28.dp))
                    Button(
                        onClick = {  navController.navigate("login") },
                        modifier = Modifier
                            .width(250.dp) // genişlik
                            .height(65.dp) //yükseklik
                            .shadow(elevation = 8.dp, shape = RoundedCornerShape(32.dp)) // Gölge efekti
                            .padding(vertical = 8.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF800000), // Arka plan rengi
                            contentColor = Color.White // Metin rengi
                        )
                    ) {
                        Text(text = "LOG IN")
                    }

                    // Hesap Oluştur Butonu
                    Button(
                        onClick = { navController.navigate("newaccount") },
                        modifier = Modifier
                            .width(250.dp) // genişlik
                            .height(65.dp) //yükseklik
                            .shadow(elevation = 8.dp, shape = RoundedCornerShape(32.dp)) // Gölge efekti
                            .padding(vertical = 8.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF800000), // Arka plan rengi
                            contentColor = Color.White // Metin rengi
                        )
                    ) {
                        Text(text = "SIGN UP")
                    }


                }
            }
        }
    }
}




