package com.example.parceldeliveryapp.presentation.utility_views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.example.parceldeliveryapp.R
import com.example.parceldeliveryapp.ui.theme.Dimen.Dimen_16
import com.example.parceldeliveryapp.ui.theme.Dimen.Dimen_24
import com.example.parceldeliveryapp.ui.theme.Dimen.Dimen_4
import com.example.parceldeliveryapp.ui.theme.Dimen.Dimen_40
import com.example.parceldeliveryapp.ui.theme.Dimen.Dimen_5
import com.example.parceldeliveryapp.ui.theme.Dimen.Dimen_8


@Composable
fun BasicImageView(painter: Painter, contentDescription: String, modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        Image(
            painter = painter,
            contentDescription = contentDescription,
            contentScale = ContentScale.Crop,
        )
    }
}

@Composable
fun SmallTitleLargeSubtitle(title: String, color: Color, fontSize: TextUnit, subtitle: String, colorTwo: Color, fontSizeTwo: TextUnit) {
    Column {
        Text(text = title, color = color, fontSize = fontSize)
        Text(text = subtitle, color =colorTwo, fontSize = fontSizeTwo)
    }
}

@Composable
fun TitleSmallerSubtitle(title: String, subtitle: String, modifier: Modifier = Modifier) {
    Column(modifier = Modifier) {
        Text(
            text = title,
            style = TextStyle(
                Color.Black,
                fontSize = 18.sp,
            )
        )
        Spacer(modifier = Modifier.height(Dimen_5))
        Text(
            text = subtitle,
            style = TextStyle(
                Color.Black,
                fontSize = 12.sp
            )
        )
    }
}


@Composable
fun ImageWithTitleSubtitle(
    titleOne: String,
    color: Color,
    fontSize: TextUnit,
    titleTwo: String,
    colorTwo: Color,
    fontSizeTwo: TextUnit,
    painter: Painter,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
        ) {
        Image(
            painter = painter,
            contentDescription = titleOne,
            modifier = Modifier
                .size(Dimen_40)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.width(Dimen_8))
        Column {
            Text(text = titleOne, color = color, fontSize = fontSize)
            Text(text = titleTwo, color =colorTwo, fontSize = fontSizeTwo)
        }
    }

}

@Composable
fun TextWithImageLeft(
    text: String,
    color: Color,
    fontSize: TextUnit,
    painter: Painter,
    imageSize: Dp
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(Dimen_4),
        verticalAlignment = Alignment.CenterVertically // Aligns image and text in the center vertically
    ) {
        // Image on the left side
        Image(
            painter = painter,
            contentDescription = stringResource(R.string.icon),
            modifier = Modifier.size(imageSize), // Set image size
            contentScale = ContentScale.Fit
        )

        Spacer(modifier = Modifier.width(Dimen_8)) // Space between the image and the text

        // Text on the right side
        Text(
            text = text,
            color = color,
            fontSize = fontSize
        )
    }
}

@Composable
fun TextWithImageRight(
    text: String,
    color: Color,
    fontSize: TextUnit,
    painter: Painter,
    imageSize: Dp
) {
    Row(
        modifier = Modifier
            .padding(Dimen_16),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = text,
            color = color,
            fontSize = fontSize
        )

        Spacer(modifier = Modifier.width(Dimen_8))

        Image(
            painter = painter,
            contentDescription = stringResource(R.string.icon),
            modifier = Modifier.size(imageSize),
            contentScale = ContentScale.Fit
        )


    }
}