package com.example.whereismyauto.core.network

import kotlinx.coroutines.flow.Flow

interface ApiService {
    suspend fun <T> get(endpoint: String, typeToken: TypeToken<T>): ApiResponse<T>
    suspend fun <T> post(endpoint: String, body: Any, typeToken: TypeToken<T>): ApiResponse<T>
    fun <T> observeWebSocket(endpoint: String, typeToken: TypeToken<T>): Flow<ApiResponse<T>>
}
