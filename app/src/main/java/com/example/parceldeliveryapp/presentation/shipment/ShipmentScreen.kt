package com.example.parceldeliveryapp.presentation.shipment

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.example.parceldeliveryapp.R
import com.example.parceldeliveryapp.presentation.shipment.model.TabItem

@Composable
fun ShipmentScreen(navController: NavHostController, tabItems: MutableList<TabItem>) {
    TopBarWithBackArrow(navController, stringResource(id = R.string.shipment), tabItems)

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarWithBackArrow(navController: NavHostController, text: String, tabItems: MutableList<TabItem>) {
    val  scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    val state = rememberScrollState()
    LaunchedEffect(Unit) { state.animateScrollTo(100) }
    Scaffold(
        modifier = Modifier
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colorResource(R.color.purple_500),
                    titleContentColor = Color.White,
                ),
                title = {
                    Text(text)
                },
                navigationIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowLeft,
                            contentDescription = "Go Back",
                            tint = Color.White
                        )
                    }
                },
                scrollBehavior = scrollBehavior,
            )
        },

        ) { paddingValues ->
        Column (
            modifier = Modifier
                .padding(paddingValues),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){

            TabLayoutScreen(navController, tabItems)

        }

    }
}