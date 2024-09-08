package com.example.parceldeliveryapp.presentation.shipment

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.parceldeliveryapp.R
import com.example.parceldeliveryapp.presentation.shipment.model.Shipment
import com.example.parceldeliveryapp.presentation.shipment.model.TabItem
import com.example.parceldeliveryapp.ui.theme.Dimen.Dimen_100
import com.example.parceldeliveryapp.ui.theme.Dimen.Dimen_12
import com.example.parceldeliveryapp.ui.theme.Dimen.Dimen_16
import com.example.parceldeliveryapp.ui.theme.Dimen.Dimen_2
import com.example.parceldeliveryapp.ui.theme.Dimen.Dimen_4
import com.example.parceldeliveryapp.ui.theme.Dimen.Dimen_6
import com.example.parceldeliveryapp.ui.theme.Dimen.Dimen_8
import com.example.parceldeliveryapp.data.shipments


@Composable
fun TabLayoutScreen(navController: NavHostController, tabItems: MutableList<TabItem>) {
    Column(
        modifier = Modifier
            .fillMaxSize())
    {
        var selectedTabIndex by rememberSaveable {
            mutableStateOf(0)
        }
        val pagerState = rememberPagerState {
            tabItems.size
        }
        LaunchedEffect(key1 = selectedTabIndex) {
            pagerState.animateScrollToPage(selectedTabIndex)

        }
        LaunchedEffect(key1 = pagerState.currentPage, pagerState.isScrollInProgress) {
            if (!pagerState.isScrollInProgress) {
                selectedTabIndex = pagerState.currentPage
            }

        }
        ScrollableTabRow(
            selectedTabIndex = selectedTabIndex,
            modifier = Modifier
                .fillMaxWidth(),
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    Modifier
                        .tabIndicatorOffset(tabPositions[selectedTabIndex])
                        .height(Dimen_4)
                        .background(colorResource(id = R.color.orange))
                )
            },
            containerColor = colorResource(id = R.color.purple_500),
            contentColor = Color.White
        ) {

            tabItems.forEachIndexed { index, tabItem ->
                val count = if (tabItems[index].title == stringResource(id = R.string.all)){
                    shipments.size
                }else {
                    shipments.filter { it.deliveryStatus.title == tabItems[index].title }.size
                }
                Tab(
                    selected = selectedTabIndex == index,
                    onClick = { selectedTabIndex = index  },
                    text = {
                        Row {
                            Text(
                                text = tabItem.title,
                                color = if (selectedTabIndex == index) Color.White else Color.LightGray,
                                fontWeight = FontWeight.Bold
                            )
                            Spacer(modifier = Modifier.width(Dimen_8))
                            Box(
                                modifier = Modifier
                                    .background(
                                        color = if (selectedTabIndex == index) colorResource(id = R.color.orange) else colorResource(
                                            id = R.color.purple_700
                                        ),
                                        shape = RoundedCornerShape(Dimen_12)
                                    )
                                    .padding(horizontal = Dimen_6, vertical = Dimen_2)
                            ) {
                                Text(
                                    text = "$count",
                                    color = Color.White,  // Orange text for the count
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    },
                    modifier = Modifier.padding(vertical = Dimen_8)
                )
            }

        }

        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) { index ->
            if (tabItems[index].title == stringResource(id = R.string.all)){
                ShipmentView(shipments.toMutableList())
            }else {
                ShipmentView(
                    shipments
                        .filter { it.deliveryStatus.title == tabItems[index].title }
                        .toMutableList()
                )
            }
        }
    }
}


@Composable
fun ShipmentView(
    shipments: MutableList<Shipment>
){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(Dimen_8)
    ) {
        Text(
            text = stringResource(id = R.string.shipment),
            style = MaterialTheme.typography.titleLarge,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(Dimen_16))
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(Dimen_16)
        ) {
            items(shipments.size) { index ->
                ShipmentCard(shipments[index])
            }
        }
    }

}



@Composable
fun ShipmentCard(shipment: Shipment) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(Dimen_16)
            .background(Color.White)
            .wrapContentHeight(),
        shape = RoundedCornerShape(Dimen_8),
        elevation = CardDefaults.cardElevation(Dimen_4)
    ) {
        Row(
            modifier = Modifier
                .background(Color.White)
                .padding(Dimen_16)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = shipment.arrivalDay,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
                Text(
                    text = "Your delivery, ${shipment.deliveryName}, is arriving today!",
                    fontSize = 14.sp,
                    color = Color.Gray
                )
                Spacer(modifier = Modifier.width(Dimen_4))
                Row {
                    Text(text = shipment.amount, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    Spacer(modifier = Modifier.width(Dimen_4))
                    Text(text = "-", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    Spacer(modifier = Modifier.width(Dimen_4))
                    Text(text = shipment.deliveryTime, fontSize = 12.sp, color = Color.Gray)
                }

            }

            Image(
                painter = painterResource(id = R.drawable.box), // Replace with your drawable
                contentDescription = "Shipment Image",
                modifier = Modifier
                    .size(Dimen_100) // Adjust size as needed
                    .padding(start = Dimen_16),
                contentScale = ContentScale.Fit
            )

        }
    }
}

