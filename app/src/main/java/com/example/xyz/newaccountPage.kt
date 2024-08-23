package com.example.xyz



import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun YeniUyelik(navController: NavHostController) {
    var name by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }



    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // Arka plan resmi
        Image(
            painter = painterResource(id = R.drawable.indir),
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
                ),
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Join us and start discovering!",
                        style = MaterialTheme.typography.titleLarge,
                        fontSize = 35.sp,
                        fontStyle = FontStyle.Italic,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF800000),
                        modifier = Modifier.padding(bottom = 16.dp)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    OutlinedTextField(
                        value = name,
                        onValueChange = { name = it },
                        label = { Text("Name") },
                        leadingIcon = {
                            Icon(
                                Icons.Default.AccountCircle,
                                contentDescription = "Account Circle"
                            )
                        },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    OutlinedTextField(
                        value = password,
                        onValueChange = { password = it },
                        label = { Text("Password") },
                        visualTransformation = PasswordVisualTransformation(),
                        leadingIcon = {
                            Icon(
                                Icons.Default.Lock,
                                contentDescription = "Password Icon"
                            )
                        },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(32.dp))
                    Button(
                        onClick = { navController.navigate("home") },
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
                        Text(text = "Create Account")
                    }

                    Spacer(modifier = Modifier.height(16.dp))
                    // Çizgi ve "or" metni
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Divider(
                            color = Color.Gray,
                            thickness = 1.dp,
                            modifier = Modifier
                                .weight(1f)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "or",
                            color = Color.Gray,
                            style = MaterialTheme.typography.bodyMedium
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Divider(
                            color = Color.Gray,
                            thickness = 1.dp,
                            modifier = Modifier
                                .weight(1f)
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    // Google ile giriş butonu
                    Button(
                        onClick = { /* Google giriş işlemi buraya gelecek */ },
                        modifier = Modifier
                            .width(250.dp) // genişlik
                            .height(65.dp) //yükseklik
                            .shadow(elevation = 8.dp, shape = RoundedCornerShape(32.dp)) // Gölge efekti

                            .padding(vertical = 8.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.White // Google butonunun arka plan rengi
                        ),
                        elevation = ButtonDefaults.elevatedButtonElevation(8.dp) // Gölge efekti
                    ) {
                        // Google logoyu içeren bir Image
                        Image(
                            painter = painterResource(id = R.drawable.googlelogo),
                            contentDescription = "Google Sign In",
                            modifier = Modifier.size(24.dp) // Google logosunun boyutu
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(text = "Sign in with Google", color = Color.Black)
                    }


                }
            }
        }
    }
}



