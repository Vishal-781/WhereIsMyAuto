package com.example.whereismyauto.ui.theme

import androidx.compose.ui.unit.dp
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes

val Shapes = Shapes(
    small = RoundedCornerShape(4.dp),
    medium = RoundedCornerShape(6.dp),
    large = RoundedCornerShape(10.dp),
    extraLarge = RoundedCornerShape(20.dp)
)

val TopShapes  = Shapes(
    large = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp),
    medium =  RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp),
    small = RoundedCornerShape(topStart = 6.dp, topEnd = 6.dp),
)

val BottomShapes = Shapes(
    large = RoundedCornerShape(bottomStart = 20.dp, bottomEnd = 20.dp),
    medium =  RoundedCornerShape(bottomStart = 10.dp, bottomEnd = 10.dp),
    small = RoundedCornerShape(bottomStart = 6.dp, bottomEnd = 6.dp),
)