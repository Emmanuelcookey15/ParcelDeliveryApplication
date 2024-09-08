@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.parceldeliveryapp.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.parceldeliveryapp.R
import com.example.parceldeliveryapp.presentation.home.viewmodel.HomeViewModel
import com.example.parceldeliveryapp.ui.theme.Dimen.Dimen_16
import com.example.parceldeliveryapp.ui.theme.Dimen.Dimen_40
import com.example.parceldeliveryapp.ui.theme.Dimen.Dimen_8
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.parceldeliveryapp.navigation.ScreenA
import com.example.parceldeliveryapp.presentation.home.model.TrackingInformation
import com.example.parceldeliveryapp.ui.theme.Dimen.Dimen_10
import com.example.parceldeliveryapp.ui.theme.Dimen.Dimen_50



@Composable
fun SearchCustomAppBar(navController: NavHostController){
    val  scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    val state = rememberScrollState()
    LaunchedEffect(Unit) { state.animateScrollTo(100) }

    val homeViewModel = viewModel<HomeViewModel>()
    val searchText by homeViewModel.searchText.collectAsState()

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

                Row(
                    modifier = Modifier
                        .background(
                            colorResource(R.color.purple_500),
                        )
                        .padding(Dimen_8),
                ) {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowLeft,
                            contentDescription = "Go Back",
                            tint = colorResource(id = R.color.white)
                        )
                    }
                    
                    Spacer(modifier = Modifier.width(Dimen_8))
                    
                    SeachFieldView(
                        searchText,
                        homeViewModel,
                        stringResource(R.string.enter_receipt_number)
                    )
                }
            }

        }
    ) { paddingValues ->
        Column (
            modifier = Modifier
                .padding(paddingValues)
                .padding(Dimen_16),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            SearchViewScreen(navController, homeViewModel)
        }

    }
    // Top bar with profile picture and location

}


@Composable
fun SearchViewScreen(navController: NavHostController,  homeViewModel: HomeViewModel) {

    val searchTrackingInformations by homeViewModel.searchTrackingInformations.collectAsState()
    val isSeaching by homeViewModel.isSearching.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(Dimen_8),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(Dimen_16))
        if (isSeaching){
            Box(modifier = Modifier.fillMaxSize()){
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        }else{
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                itemsIndexed(searchTrackingInformations) { index, trackingInfo ->
                    SearchItemView(navController, trackingInfo)
                }

            }
        }
    }
}

@Composable
private fun SeachFieldView(
    searchText: String,
    homeViewModel: HomeViewModel,
    hints: String
) {
    OutlinedTextField(
        value = searchText,
        onValueChange = homeViewModel::onSearchTextChange,
        placeholder = { Text(text = hints) },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = stringResource(id = R.string.search_icon)
            )
        },
        trailingIcon = {
            if (searchText.isNotEmpty()) {
                IconButton(onClick = { }) {
                    Icon(
                        imageVector = Icons.Default.Clear,
                        contentDescription = stringResource(id = R.string.clear_icon)
                    )
                }
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(Dimen_50)
            .background(Color.White, shape = RoundedCornerShape(Dimen_50)),
        shape = RoundedCornerShape(Dimen_50),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.Transparent,
            disabledContainerColor = Color.Transparent,
        )
    )
}



@Composable
private fun SearchItemView(navController: NavHostController, trackingInfo: TrackingInformation) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = Dimen_8)
            .clickable(
                onClick = { navController.navigate(ScreenA)}
            ),
    ) {
        // Icon
        Icon(
            painter = painterResource(id = R.drawable.box), // Replace with your icon
            contentDescription = null,// Purple color for the icon
            modifier = Modifier
                .size(Dimen_40)
                .padding(end = Dimen_16)
        )

        // Shipment details
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = trackingInfo.packageName,
                style = MaterialTheme.typography.titleSmall,
                color = Color.Black
            )
            Text(
                text = trackingInfo.trackingNumber,
                style = MaterialTheme.typography.titleSmall,
                color = Color.Gray
            )
            Text(
                text = "${trackingInfo.senderLocation} to ${trackingInfo.recieverLocation}",
                style = MaterialTheme.typography.bodySmall,
                color = Color.Gray
            )
        }
    }
}