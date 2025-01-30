package com.example.whereismyauto.features.home.data.datasources.remote.api

import com.example.whereismyauto.features.home.data.model.AutoLocationDto
import kotlinx.coroutines.flow.Flow

class AutoLocationApiImpl: AutoLocationApi {
    override suspend fun getAutoLocations(): List<AutoLocationDto> {
        TODO("Not yet implemented")
    }

    override fun observeAutoLocations(): Flow<List<AutoLocationDto>> {
        TODO("Not yet implemented")
    }
}