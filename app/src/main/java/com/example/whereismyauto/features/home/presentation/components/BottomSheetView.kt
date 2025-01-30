package com.example.whereismyauto.features.home.presentation.components


import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp

@Composable
fun BottomSheetView(
    content : @Composable () -> Unit,
    visible: Boolean,
    onDismiss : () -> Unit,
    onClickAuto : () -> Unit,
) {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.toFloat()

    var offsetY = remember{
       Animatable(screenHeight)
    }

    LaunchedEffect(visible){
        if(visible){
            offsetY.animateTo(
                targetValue = screenHeight / 2,
                animationSpec = tween(
                    durationMillis = 300,
                    easing = FastOutSlowInEasing
                )
            )
        }else{
            offsetY.animateTo(
                targetValue =  screenHeight,
                animationSpec = tween(
                    durationMillis = 300,
                    easing = FastOutSlowInEasing
                )
            )
        }
    }

}