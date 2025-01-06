package com.example.whereismyauto.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.AlertDialogDefaults.shape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
fun DashboardScreen(
    viewModel: DashboardViewModel
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color_background),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color_tool_bar, BottomShapes.small)
                .height(80.dp)
                .border(1.dp, color_white, BottomShapes.small),
            verticalAlignment = Alignment.CenterVertically,


        ){
            Text(
                text = "Dashboard",
                modifier = Modifier.padding(16.dp),
                style = typography.titleLarge,
                color = color_white
            )
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
                label = "",
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
                        contentDescription = "swap_icon"
                    )
                }

            )
            ToStopInputField(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .background(color_white),
                viewModel = viewModel,
                label = stringResource(id = R.string.ending_point),
            )
            TextButton(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .height(50.dp)
                    .border(1.dp, color_white, Shapes.medium),
                colors = ButtonDefaults.buttonColors(
                     color_primary,
                    color_tool_bar
                ),
                shape = Shapes.medium,
                onClick = {
                    viewModel.handleFindAuto()
                }
            ) {
                Text(
                    text = "Find Auto",
                    style = typography.titleSmall,
                    color = color_white
                )
            }

        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FromStopInputField(
    modifier: Modifier,
    viewModel: DashboardViewModel,
    label : String,
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
        label = { Text(
            label,
            color = color_light_grey
            ) },
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = color_secondary,
            unfocusedIndicatorColor = color_primary,
            containerColor = color_white
        ),
//        placeholder = {
//                      Text(
//                          text = "From",
//                          color = color_light_grey
//                      )
//        },
        textStyle = TextStyle(brush = brush)
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToStopInputField(
    modifier: Modifier,
    viewModel: DashboardViewModel,
    label : String,
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
        label = { Text(
            label,
            color = color_light_grey
        ) },
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = color_secondary,
            unfocusedIndicatorColor = color_primary,
            containerColor = color_white
        ),
        textStyle = TextStyle(brush = brush)
    )
}


@Preview(showBackground = true)
@Composable
fun PreviewDashboard(){
    DashboardScreen(DashboardViewModel())
}