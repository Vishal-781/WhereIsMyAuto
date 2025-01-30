<<<<<<<< HEAD:app/src/main/java/com/example/whereismyauto/search_dashboard/SearchScreen.kt
package com.example.whereismyauto.search_dashboard
========
package com.example.whereismyauto.features.search_dashboard
>>>>>>>> 063cf69 (Backend Integration Started):app/src/main/java/com/example/whereismyauto/features/search_dashboard/SearchScreen.kt

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.whereismyauto.R
import com.example.whereismyauto.ui.theme.BottomShapes
import com.example.whereismyauto.ui.theme.Shapes
import com.example.whereismyauto.ui.theme.color_background
import com.example.whereismyauto.ui.theme.color_black
import com.example.whereismyauto.ui.theme.color_light_grey
import com.example.whereismyauto.ui.theme.color_primary
import com.example.whereismyauto.ui.theme.color_secondary
import com.example.whereismyauto.ui.theme.color_tool_bar
import com.example.whereismyauto.ui.theme.color_white
import com.example.whereismyauto.ui.theme.typography

@Composable
fun SearchScreen(
    viewModel: SearchViewModel
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color_background),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ){

        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp),
            shape = BottomShapes.small,
            color = MaterialTheme.colorScheme.primary,
            tonalElevation = 4.dp,
            shadowElevation = 4.dp
        ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Dashboard",
                    modifier = Modifier.padding(top = 36.dp, start = 16.dp, bottom = 8.dp),
                    style = typography.titleMedium,
                    color = MaterialTheme.colorScheme.primaryContainer
                )
                Icon(
<<<<<<<< HEAD:app/src/main/java/com/example/whereismyauto/search_dashboard/SearchScreen.kt
                    modifier =Modifier.padding(top = 36.dp, start = 16.dp, bottom = 8.dp, end = 16.dp)
========
                    modifier =Modifier.padding(top = 36.dp, start = 16.dp, bottom = 16.dp, end = 24.dp)
>>>>>>>> 063cf69 (Backend Integration Started):app/src/main/java/com/example/whereismyauto/features/search_dashboard/SearchScreen.kt
                        .height(24.dp)
                        .width(24.dp),
                    painter = painterResource(id = R.drawable.profile_icon),
                    contentDescription = "Profile",
                    tint = MaterialTheme.colorScheme.primaryContainer
                )
            }
        }


         Column(
            modifier = Modifier
                .padding(16.dp)
                .background(color_white, Shapes.medium)
                .fillMaxWidth(),
            horizontalAlignment =  Alignment.CenterHorizontally
        ) {
            FromStopInputField(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .background(color_white, Shapes.medium),
                viewModel = viewModel,
                hint = stringResource(id = R.string.starting_point)
            )
            IconButton(
                onClick = {
                          viewModel.swapStops();
                },
                modifier = Modifier
                    .width(32.dp)
                    .height(32.dp),
                content = {
                    Icon(
                        modifier = Modifier
                            .width(32.dp)
                            .height(32.dp),
                        painter = painterResource(id = R.drawable.baseline_swap_vert_24),
                        contentDescription = "swap_icon",
                        tint = MaterialTheme.colorScheme.primaryContainer

                        )
                }

            )
            ToStopInputField(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .background(color_white),
                viewModel = viewModel,
                hint = stringResource(id = R.string.ending_point),
            )
            TextButton(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .height(50.dp)
                    .border(1.dp, color_white, Shapes.medium),
                colors = ButtonDefaults.buttonColors(
                     MaterialTheme.colorScheme.primary,
                ),
                shape = Shapes.medium,
                onClick = {
                    viewModel.handleFindAuto()
                }
            ) {
                Text(
                    text = "Find Auto",
                    style = typography.titleSmall,
                    color = MaterialTheme.colorScheme.primaryContainer
                )
            }

        }

        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp, start = 16.dp, end = 16.dp, bottom = 8.dp)
                .background(color_white, Shapes.medium),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            SearchInputField(
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth(0.6f)
                    .background(color_white, Shapes.medium),
                viewModel = viewModel,
                hint = stringResource(id = R.string.auto_id)
            )
            IconButton(
                modifier = Modifier
                    .padding(top = 4.dp, bottom = 4.dp, end = 10.dp)
                    .background(MaterialTheme.colorScheme.primary, Shapes.large),
                onClick = { viewModel.handleSearchAuto() }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_search_24),
                    contentDescription = "search_icon",
                    tint = MaterialTheme.colorScheme.primaryContainer
                )
                
            }
        }

        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
<<<<<<<< HEAD:app/src/main/java/com/example/whereismyauto/search_dashboard/SearchScreen.kt
                .background(color_white, Shapes.medium)
                .fillMaxHeight(),
========
                .height(180.dp)
                .background(color_white, Shapes.medium)
>>>>>>>> 063cf69 (Backend Integration Started):app/src/main/java/com/example/whereismyauto/features/search_dashboard/SearchScreen.kt
        ) {
            Text(
                text = "Active Rides",
                modifier = Modifier.padding(16.dp),
                style = typography.titleMedium,
            )
            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                content = {
                items(viewModel.activeRides.size){
                    Text(
                        text = viewModel.activeRides[it],
                        style = typography.titleSmall,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FromStopInputField(
    modifier: Modifier,
    viewModel: SearchViewModel,
    hint: String
){
    val brush = remember {
        Brush.linearGradient(
            colors = listOf(
                color_primary,
                color_tool_bar,
                color_black
            )
        )
    }
    TextField(
        value = viewModel.startingPoint,
        onValueChange = {
            viewModel.updateStartingPoint(it)
        },
        modifier = modifier.background(color_white),
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = color_secondary,
            unfocusedIndicatorColor = color_primary,
            containerColor = color_white
        ),
        placeholder = {
                      Text(
                          text = hint,
                          color = color_light_grey,
                      )
        },
        textStyle = TextStyle(
            brush = brush,
            fontSize = 24.sp
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToStopInputField(
    modifier: Modifier,
    viewModel: SearchViewModel,
    hint : String,
){
    val brush = remember {
        Brush.linearGradient(
            colors = listOf(
                color_primary,
                color_tool_bar,
                color_black
            )
        )
    }
    TextField(
        value = viewModel.destinationPoint,
        onValueChange = {
            viewModel.updateDestinationPoint(it)
        },
        modifier = modifier,
        placeholder = {
            Text(
                text = hint,
                color = color_light_grey
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = color_secondary,
            unfocusedIndicatorColor = color_primary,
            containerColor = color_white
        ),
        textStyle = TextStyle(
            brush = brush,
            fontSize = 24.sp
            )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchInputField(
    modifier: Modifier,
    viewModel: SearchViewModel,
    hint: String
){
    val brush = remember {
        Brush.linearGradient(
            colors = listOf(
                color_primary,
                color_tool_bar,
                color_black
            )
        )
    }
    TextField(
        value = viewModel.searchAutoName,
        onValueChange = {
            viewModel.updateSearchAutoName(it)
        },
        modifier = modifier,
        maxLines = 1,
        placeholder = {
            Text(
                text = hint,
                color = color_light_grey,
                style = typography.titleSmall
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = color_white,
            unfocusedIndicatorColor = color_white,
            containerColor = color_white
        ),
        textStyle = TextStyle(
            brush = brush,
            fontSize = 20.sp
        )
    )
}
@Preview(showBackground = true)
@Composable
fun PreviewDashboard(){
    SearchScreen(SearchViewModel())
}