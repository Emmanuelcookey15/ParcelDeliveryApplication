package com.example.parceldeliveryapp.presentation.succes_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.parceldeliveryapp.R
import com.example.parceldeliveryapp.navigation.ScreenA
import com.example.parceldeliveryapp.presentation.utility_views.TextWithImageRight
import com.example.parceldeliveryapp.ui.theme.Dimen.Dimen_100
import com.example.parceldeliveryapp.ui.theme.Dimen.Dimen_16
import com.example.parceldeliveryapp.ui.theme.Dimen.Dimen_20
import com.example.parceldeliveryapp.ui.theme.Dimen.Dimen_32
import com.example.parceldeliveryapp.ui.theme.Dimen.Dimen_40
import com.example.parceldeliveryapp.ui.theme.Dimen.Dimen_8

@Composable
fun MoveMateScreen(navController: NavHostController) {
    // Main container for the whole screen
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(Dimen_16),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(Dimen_40))

            // Company Name - MoveMate
            TextWithImageRight(
                text = "MoveMate",
                fontSize = 28.sp,
                color = colorResource(id = R.color.purple_500),
                painter = painterResource(id = R.drawable.box),
                imageSize = Dimen_20
            )

            Spacer(modifier = Modifier.height(Dimen_16))

            // Total Estimated Amount box
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White, shape = RoundedCornerShape(Dimen_16))
                    .padding(Dimen_16),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Product Image (Use any drawable here)
                    Image(
                        painter = painterResource(id = R.drawable.box), // Example image
                        contentDescription = "Delivery Box",
                        modifier = Modifier
                            .size(Dimen_100)
                    )

                    Spacer(modifier = Modifier.height(Dimen_16))

                    // Total Estimated Amount
                    Text(
                        text = "Total Estimated Amount",
                        fontSize = 18.sp,
                        color = Color.Gray
                    )

                    Text(
                        text = "$1460 USD",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )

                    Spacer(modifier = Modifier.height(Dimen_8))

                    // Info text
                    Text(
                        text = "This amount is estimated and may vary if you change your location or weight.",
                        fontSize = 14.sp,
                        color = Color.Gray,
                        textAlign = TextAlign.Center
                    )
                }
            }

            Spacer(modifier = Modifier.height(Dimen_40))

            // Button - Back to Home
            Button(
                onClick = { navController.navigate(ScreenA) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = Dimen_32),
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.orange))
            ) {
                Text(text = "Back to home", color = Color.White)
            }

            Spacer(modifier = Modifier.height(Dimen_20))

        }
    }
}
