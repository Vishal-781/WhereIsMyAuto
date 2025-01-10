package com.example.whereismyauto.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.sp
import com.example.whereismyauto.R




private val Poppins = FontFamily(
    Font(R.font.poppins_regular, FontWeight.Normal),
    Font(R.font.poppins_light, FontWeight.Light),
    Font(R.font.poppins_medium, FontWeight.Medium),
    Font(R.font.poppins_semi_bold, FontWeight.SemiBold),
    Font(R.font.poppins_bold, FontWeight.Bold),
)

val defaultTextStyle = TextStyle(
    fontFamily = Poppins,
    lineHeightStyle = LineHeightStyle(
        alignment = LineHeightStyle.Alignment.Center,
        trim = LineHeightStyle.Trim.None
    )
)

val typography = Typography(
    headlineLarge = defaultTextStyle.copy(
        fontSize = 64.sp,
        fontWeight = FontWeight.Normal,
        color = color_black
    ),
    headlineMedium = defaultTextStyle.copy(
        fontSize = 36.sp,
        fontWeight = FontWeight.Normal,
        color = color_black
    ),
    headlineSmall = defaultTextStyle.copy(
        fontSize = 28.sp,
        fontWeight = FontWeight.SemiBold,
        color = color_black
    ),
    titleLarge = defaultTextStyle.copy(
        fontSize = 24.sp,
        fontWeight = FontWeight.Normal,
        color = color_black
    ),
    titleMedium = defaultTextStyle.copy(
        fontSize = 20.sp,
        fontWeight = FontWeight.Normal,
        color = color_black
    ),
    titleSmall = defaultTextStyle.copy(
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal,
        color = color_black
    ),
    bodyLarge = defaultTextStyle.copy(
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal,
        color = color_black
    ),
    bodyMedium = defaultTextStyle.copy(
        fontSize = 16.sp,
        fontWeight = FontWeight.Light,
        color = color_black
    ),
)
