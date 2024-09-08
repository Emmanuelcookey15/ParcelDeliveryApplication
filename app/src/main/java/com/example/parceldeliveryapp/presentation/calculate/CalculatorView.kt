package com.example.parceldeliveryapp.presentation.calculate

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.input.KeyboardType
import androidx.navigation.NavHostController
import com.example.parceldeliveryapp.R
import com.example.parceldeliveryapp.navigation.ScreenB
import com.example.parceldeliveryapp.ui.theme.Dimen.Dimen_12
import com.example.parceldeliveryapp.ui.theme.Dimen.Dimen_16
import com.example.parceldeliveryapp.ui.theme.Dimen.Dimen_2
import com.example.parceldeliveryapp.ui.theme.Dimen.Dimen_4
import com.example.parceldeliveryapp.ui.theme.Dimen.Dimen_5
import com.example.parceldeliveryapp.ui.theme.Dimen.Dimen_8


@Composable
fun ScrollContent(navController: NavHostController, categories: List<String>) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(Dimen_16),
        verticalArrangement = Arrangement.spacedBy(Dimen_8)
    ) {

        DesitinationViewField()

        Spacer(modifier = Modifier.height(Dimen_16))

        PackagingViewField(categories)

        Spacer(modifier = Modifier.height(Dimen_16))


        CategoryViewField(categories)

        Spacer(modifier = Modifier.height(Dimen_8))


        Button(
            onClick = {navController.navigate(ScreenB)},
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.orange))
        ) {
            Text(stringResource(R.string.calculate), color = Color.White)
        }
    }
}



@Composable
private fun DesitinationViewField() {
    Text(
        text = stringResource(R.string.destination),
        fontWeight = FontWeight.Bold,
        style = MaterialTheme.typography.titleLarge,
        color = Color.Black
    )

    Spacer(modifier = Modifier.height(Dimen_2))

    Card(
        modifier = Modifier
            .background(
                Color.White,
                RoundedCornerShape(Dimen_8)
            )
            .padding(Dimen_12),
        elevation = CardDefaults.cardElevation(Dimen_5),
    ){

        Column(
            modifier = Modifier
                .background(
                    Color.White
                )

        ) {
            OutlinedTextField(
                value = "",
                onValueChange = {},
                label = { Text(stringResource(R.string.sender_location)) },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.AccountBox,
                        contentDescription = stringResource(R.string.search_icon)
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        Color.White,
                        RoundedCornerShape(Dimen_12)
                    )
            )

            Spacer(modifier = Modifier.height(Dimen_5))

            OutlinedTextField(
                value = "",
                onValueChange = {},
                label = { Text(stringResource(R.string.receiver_location)) },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.AccountBox,
                        contentDescription = "Search Icon"
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        Color.White,
                        RoundedCornerShape(Dimen_12)
                    )
            )

            Spacer(modifier = Modifier.height(Dimen_5))

            OutlinedTextField(
                value = "",
                onValueChange = {},
                label = { Text(stringResource(R.string.approx_weight)) },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        Color.White,
                        RoundedCornerShape(Dimen_12)
                    ),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.DateRange,
                        contentDescription = "Search Icon"
                    )
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
        }

    }

}

@Composable
private fun PackagingViewField(categories: List<String>) {
    Text(
        text = stringResource(R.string.packaging),
        fontWeight = FontWeight.Bold,
        style = MaterialTheme.typography.titleLarge,
        color = Color.Black
    )
    Text(
        text = stringResource(R.string.what_are_you_sending),
        style = MaterialTheme.typography.titleMedium,
        color = Color.Gray
    )

    Card(
        modifier = Modifier
            .background(
                Color.White,
                RoundedCornerShape(Dimen_8)
            )
            .padding(Dimen_12),
        elevation = CardDefaults.cardElevation(Dimen_5),
    ) {
        var expanded by remember { mutableStateOf(false) }
        var selectedPackaging by remember { mutableStateOf(categories[0]) }
        Box(
            modifier = Modifier
                .background(Color.White, RoundedCornerShape(Dimen_8))
                .fillMaxWidth()
                .clickable { expanded = true }
                .border(
                    width = 1.dp,
                    color = Color.Gray,
                    shape = RoundedCornerShape(Dimen_8)
                )
                .padding(Dimen_16)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row {
                    Icon(
                        imageVector = Icons.Default.DateRange,
                        contentDescription = "Search Icon"
                    )
                    VerticalDivider(
                        modifier = Modifier
                            .padding(Dimen_2),
                        thickness = Dimen_4,
                        color = Color.Black
                    )
                    Text(text = selectedPackaging)
                }

                Icon(
                    Icons.Filled.ArrowDropDown,
                    contentDescription = stringResource(R.string.dropdown_arrow)
                )
            }

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                categories.forEach { category ->
                    DropdownMenuItem(
                        text = { Text(category) },
                        onClick = {
                            selectedPackaging = category
                            expanded = false
                        })
                }
            }
        }
    }
}



@Composable
@OptIn(ExperimentalLayoutApi::class)
private fun CategoryViewField(categories: List<String>) {
    Text(
        text = stringResource(R.string.categories),
        fontWeight = FontWeight.Bold,
        style = MaterialTheme.typography.titleLarge,
        color = Color.Black
    )

    Text(
        text = stringResource(R.string.what_are_you_sending),
        style = MaterialTheme.typography.titleMedium,
        color = Color.Gray
    )
    var selectedCategories = remember { mutableStateListOf<String>() }

    Card(
        modifier = Modifier
            .background(
                Color.White,
                RoundedCornerShape(Dimen_5)
            )
            .padding(Dimen_2),
    ) {

        FlowRow(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    Color.White
                )
                .padding(Dimen_5),
            verticalArrangement = Arrangement.Center,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            categories.forEach { category ->
                FilterChip(
                    selected = selectedCategories.contains(category),
                    onClick = {
                        if (selectedCategories.contains(category)) {
                            selectedCategories.remove(category)
                        } else {
                            selectedCategories.add(category)
                        }
                    },
                    label = { Text(category) }
                )
            }
        }
    }
}



