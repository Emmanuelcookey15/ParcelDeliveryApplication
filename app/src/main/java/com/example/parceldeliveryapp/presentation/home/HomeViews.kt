package com.example.parceldeliveryapp.presentation.home


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import com.example.parceldeliveryapp.R
import com.example.parceldeliveryapp.presentation.utility_views.ImageWithTitleSubtitle
import com.example.parceldeliveryapp.presentation.utility_views.SmallTitleLargeSubtitle
import com.example.parceldeliveryapp.ui.theme.Dimen.Dimen_12
import com.example.parceldeliveryapp.ui.theme.Dimen.Dimen_16
import com.example.parceldeliveryapp.ui.theme.Dimen.Dimen_2
import com.example.parceldeliveryapp.ui.theme.Dimen.Dimen_200
import com.example.parceldeliveryapp.ui.theme.Dimen.Dimen_4
import com.example.parceldeliveryapp.ui.theme.Dimen.Dimen_5
import com.example.parceldeliveryapp.ui.theme.Dimen.Dimen_60
import com.example.parceldeliveryapp.ui.theme.Dimen.Dimen_8
import com.example.parceldeliveryapp.data.vehicleList
import com.example.parceldeliveryapp.presentation.home.model.TrackingInformation


@Composable
fun TrackingScreen(trackingInformation: TrackingInformation) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        Spacer(modifier = Modifier.height(Dimen_16))

        // Tracking details
        TrackingDetailsCardField(trackingInformation)

        Spacer(modifier = Modifier.height(Dimen_16))

        // Available vehicles section
        VehiclesSectionDetailsField()
    }
}


@Composable
private fun TrackingDetailsCardField(trackingInformation: TrackingInformation) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(Dimen_5),
    ) {
        Column(modifier = Modifier.padding(Dimen_16)) {
            Text(
                text = stringResource(id = R.string.tracking),
                color = Color.Gray,
                fontSize = 14.sp
            )

            Spacer(modifier = Modifier.height(Dimen_8))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Column {
                    Text(
                        text = "Shipment Number",
                        color = Color.Gray,
                        fontSize = 12.sp
                    )
                    Text(
                        text = trackingInformation.trackingNumber,
                        color = Color.DarkGray,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                }

                Image(
                    painter = painterResource(id = R.drawable.box), // Replace with actual image resource
                    contentDescription = stringResource(R.string.profile_picture),
                    modifier = Modifier
                        .size(Dimen_60)
                        .clip(RoundedCornerShape(Dimen_16))
                )

            }


            Spacer(modifier = Modifier.height(Dimen_16))

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start) {
                ImageWithTitleSubtitle(
                    stringResource(id = R.string.sender),
                    color = Color.Gray,
                    fontSize = 12.sp,
                    trackingInformation.senderLocation,
                    colorTwo = Color.DarkGray,
                    fontSizeTwo = 16.sp,
                    painterResource(id = R.drawable.box)
                )

                Spacer(
                    modifier = Modifier.width(Dimen_12)
                )

                SmallTitleLargeSubtitle(
                    stringResource(id = R.string.time),
                    color = Color.Gray,
                    fontSize = 12.sp,
                    trackingInformation.time,
                    colorTwo = Color.DarkGray,
                    fontSizeTwo = 16.sp,
                )
            }

            Spacer(
                modifier = Modifier.height(Dimen_16)
            )

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start) {

                ImageWithTitleSubtitle(
                    stringResource(id = R.string.receiver),
                    color = Color.Gray,
                    fontSize = 12.sp,
                    trackingInformation.recieverLocation,
                    colorTwo = Color.DarkGray,
                    fontSizeTwo = 16.sp,
                    painterResource(id = R.drawable.box)
                )
                Spacer(
                    modifier = Modifier.width(Dimen_12)
                )
                SmallTitleLargeSubtitle(
                    stringResource(id = R.string.status),
                    color = Color.Gray,
                    fontSize = 12.sp, trackingInformation.status,
                    colorTwo = Color.DarkGray,
                    fontSizeTwo = 16.sp,
                )

            }

            Spacer(modifier = Modifier.height(Dimen_16))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
            ) {
                TextButton(onClick = { /* Handle add stop action */ }) {
                    Text(text = "+ Add Stop", color = colorResource(id = R.color.orange))
                }
            }

        }
    }
}





@Composable
private fun VehiclesSectionDetailsField() {
    Text(
        text = stringResource(R.string.available_vehicles),
        color = Color.Black,
        style = MaterialTheme.typography.titleLarge,
        fontWeight = FontWeight.Bold
    )

    Spacer(modifier = Modifier.height(Dimen_16))

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            itemsIndexed(vehicleList) { index, vehicle ->
                VehicleOption(
                    title = vehicle.name,
                    subtitle = vehicle.vehicleReach,
                    image = painterResource(id = vehicle.image)
                )

                Spacer(modifier = Modifier.width(Dimen_8))
            }
        }
    }
}





@Composable
fun VehicleOption(title: String, subtitle: String, image: Painter) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(Dimen_2),
    ) {
        Column(
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.headlineMedium,
                color = Color.DarkGray,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = subtitle,
                style = MaterialTheme.typography.bodyLarge,
                color = Color.Gray
            )
            Spacer(modifier = Modifier.height(Dimen_4))
            Image(
                painter = image,
                contentDescription = null,
                modifier = Modifier.size(Dimen_200),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(Dimen_4))
        }
    }
}


