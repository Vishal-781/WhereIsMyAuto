package com.example.whereismyauto.features.home.data.datasources.remote.api

import com.example.whereismyauto.features.home.data.model.AutoLocationDto
import kotlinx.coroutines.flow.Flow

interface AutoLocationApi {
    suspend fun getAutoLocations(): List<AutoLocationDto>
    fun observeAutoLocations(): Flow<List<AutoLocationDto>>
}