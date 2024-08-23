package com.example.xyz

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Close
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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController


@Composable
fun SifremiUnuttum(navController: NavHostController) {
    var email by remember { mutableStateOf("") }
    var showDialog by remember { mutableStateOf(false) }

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
                        text = "Forgot Password",
                        style = MaterialTheme.typography.titleLarge,
                        fontSize = 35.sp,
                        fontStyle = FontStyle.Italic,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF800000),
                        modifier = Modifier.padding(bottom = 16.dp)
                    )
                    Spacer(modifier = Modifier.height(52.dp))
                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
                        label = { Text("Email") },
                        leadingIcon = {
                            Icon(
                                Icons.Default.Email,
                                contentDescription = "Email Icon"
                            )
                        },
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(72.dp))
                    Button(
                        onClick = { showDialog = true },
                        modifier = Modifier
                            .width(250.dp) // genişlik
                            .height(65.dp)//yükseklik
                            .shadow(elevation = 8.dp, shape = RoundedCornerShape(32.dp)) // Gölge efekti
                            .padding(vertical = 8.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF800000), // Arka plan rengi
                            contentColor = Color.White // Metin rengi
                        )
                    ) {
                        Text(text = "Send Mail")
                    }
                }
            }
        }

        // Eğer showDialog true ise, dialog göster
        if (showDialog) {
            AlertDialog(
                onDismissRequest = { showDialog = false }, // Dialog dışında bir yere tıklanırsa kapanır
                title = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "Success")
                        IconButton(onClick = { showDialog = false }) {
                            Icon(
                                imageVector = Icons.Default.Close,
                                contentDescription = "Close Dialog",

                            )
                        }
                    }
                },
                text = {
                    Text(text = "E-mail sent successfully.")
                },
                confirmButton = {}
            )
        }
    }
}


