package com.example.whereismyauto.features.home.presentation.model

import androidx.compose.ui.geometry.Offset

data class AutoStation(
    val id: String,
    val name: String,
    val position: Offset,
    val isInterchange: Boolean = false,
    val routes: List<Int> = listOf()
)