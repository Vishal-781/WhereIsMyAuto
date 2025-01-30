package com.example.whereismyauto.features.home.presentation.model

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import com.example.whereismyauto.features.home.presentation.model.AutoStation

data class AutoLine(
    val id: Int,
    val name: String,
    val color: Color,
    val stations: List<AutoStation>,
    val path: List<Offset>
)