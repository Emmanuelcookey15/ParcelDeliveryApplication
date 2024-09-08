@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.parceldeliveryapp.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.parceldeliveryapp.R
import com.example.parceldeliveryapp.navigation.ScreenA
import com.example.parceldeliveryapp.navigation.ScreenC
import com.example.parceldeliveryapp.presentation.home.model.TrackingInformation
import com.example.parceldeliveryapp.presentation.utility_views.TextWithImageLeft
import com.example.parceldeliveryapp.ui.theme.Dimen.Dimen_10
import com.example.parceldeliveryapp.ui.theme.Dimen.Dimen_12
import com.example.parceldeliveryapp.ui.theme.Dimen.Dimen_16
import com.example.parceldeliveryapp.ui.theme.Dimen.Dimen_20
import com.example.parceldeliveryapp.ui.theme.Dimen.Dimen_40
import com.example.parceldeliveryapp.ui.theme.Dimen.Dimen_55
import com.example.parceldeliveryapp.ui.theme.Dimen.Dimen_8

@Composable
fun HomeScreen(navController: NavHostController, trackingInformation: TrackingInformation) {
    CustomAppBar(navController, trackingInformation)
}

@Composable
private fun CustomAppBar(
    navController: NavHostController,
    trackingInformation: TrackingInformation
){
    val  scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    val state = rememberScrollState()
    LaunchedEffect(Unit) { state.animateScrollTo(100) }
    Scaffold(
        modifier = Modifier
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            Card(
                modifier = Modifier
                    .background(
                        colorResource(R.color.purple_500),
                    )
                    .padding(Dimen_8),
                elevation = CardDefaults.cardElevation(Dimen_10),
            ) {
                Column(
                    modifier = Modifier
                        .background(colorResource(R.color.purple_500))
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Profile picture
                        Image(
                            painter = painterResource(id = R.drawable.profile_picture), // Replace with actual image resource
                            contentDescription = stringResource(R.string.profile_picture),
                            modifier = Modifier
                                .size(Dimen_40)
                                .clip(CircleShape)
                        )
                        Spacer(modifier = Modifier.width(Dimen_8))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column(Modifier.fillMaxWidth(0.8f)){
                                TextWithImageLeft(
                                    text = "Your location",
                                    color = Color.Gray,
                                    fontSize = 12.sp,
                                    painter = rememberVectorPainter(Icons.Default.LocationOn),
                                    imageSize = Dimen_12
                                )
                                Text(
                                    text = "Wertheimer, Illinois",
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 16.sp
                                )
                            }
                            BadgedBox(badge = { Badge() }) {
                                Icon(
                                    imageVector = Icons.Default.Notifications,
                                    tint = Color.Black,
                                    contentDescription = stringResource(id = R.string.notifications)
                                )
                            }
                        }


                    }

                    Spacer(modifier = Modifier.height(Dimen_16))

                    // Search bar
                    val focusRequester = FocusRequester()
                    val interactionSource = remember { MutableInteractionSource() }
                    val isFocused by interactionSource.collectIsFocusedAsState()

                    OutlinedTextField(
                        value = "",
                        onValueChange = { navController.navigate(ScreenC) },
                        modifier = Modifier
                            .focusRequester(focusRequester)
                            .onFocusChanged {
                                if (isFocused) {
                                    navController.navigate(ScreenC)
                                }
                            }
                            .fillMaxWidth()
                            .height(Dimen_55)
                            .background(Color.White, shape = RoundedCornerShape(Dimen_20)),
                        placeholder = { Text(text = stringResource(id = R.string.enter_receipt_number)) },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = stringResource(id = R.string.search_icon)
                            )
                        },
                        trailingIcon = {
                            Icon(
                                imageVector = Icons.Default.Clear,
                                contentDescription = stringResource(id = R.string.clear_icon)
                            )
                        },
                        shape = RoundedCornerShape(Dimen_20),
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.White,
                            unfocusedContainerColor = Color.Transparent,
                            disabledContainerColor = Color.Transparent,
                        )
                    )
                }

            }
        }
    ) { paddingValues ->
        Column (
            modifier = Modifier
                .padding(paddingValues)
                .verticalScroll(state)
                .padding(Dimen_16),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            TrackingScreen(trackingInformation)
        }

    }

}