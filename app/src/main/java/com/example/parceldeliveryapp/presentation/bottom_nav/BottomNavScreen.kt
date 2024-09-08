package com.example.parceldeliveryapp.presentation.bottom_nav

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.parceldeliveryapp.presentation.calculate.CalculateScreen
import com.example.parceldeliveryapp.presentation.home.HomeScreen
import com.example.parceldeliveryapp.presentation.shipment.ShipmentScreen
import com.example.parceldeliveryapp.data.bottomNavItems
import com.example.parceldeliveryapp.data.categories
import com.example.parceldeliveryapp.data.tabItems
import com.example.parceldeliveryapp.presentation.home.SearchScreen
import com.example.parceldeliveryapp.presentation.home.model.TrackingInformation

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNavScreen(navController: NavHostController, trackingInformation: TrackingInformation) {
    var selectedItemIndex by rememberSaveable { mutableStateOf(0) }
    Scaffold(
        Modifier,
        bottomBar = {
            NavigationBar {
                bottomNavItems.forEachIndexed { index, bottomNavItem ->
                    NavigationBarItem(
                        selected = selectedItemIndex == index,
                        onClick = { selectedItemIndex = index },
                        label = { Text(text = bottomNavItem.title) },
                        icon = {
                            BadgedBox(
                                badge = {
                                    if (index == selectedItemIndex) {
                                        Badge()
                                    }
                                }
                            ) {
                                Icon(
                                    imageVector = if (index == selectedItemIndex) {
                                        bottomNavItem.selectedIcon
                                    } else bottomNavItem.unselectedIcon,
                                    contentDescription = bottomNavItem.title
                                )
                            }
                        }
                    )
                }
            }
        }
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            when (selectedItemIndex) {
                0 -> HomeScreen(navController, trackingInformation)
                1 -> CalculateScreen(navController, categories)
                2 -> ShipmentScreen(navController, tabItems)
                // Add more screen composable functions here based on currentRoute
            }
        }

    }

}




@Composable
fun ScreenOne(paddingValues: PaddingValues) {
    Box(modifier = Modifier.padding(paddingValues)) {
        Text(text = "Screen One")
    }
}