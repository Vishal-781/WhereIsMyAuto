package com.example.whereismyauto.core.network


import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.WebSocket
import com.example.whereismyauto.core.network.TypeToken

class ApiServiceImpl(
    private val client: OkHttpClient,
    private val baseUrl: String,
    private val json: Json
) : ApiService {
    val jsonParser = GsonParser()
    override  suspend fun <T> get(
        endpoint: String,
        typeToken: TypeToken<T>
    ): ApiResponse<T> {
        return try {
            val response = client.newCall(
                Request.Builder()
                    .url("$baseUrl/$endpoint")
                    .build()
            ).execute()

            if (response.isSuccessful) {
                val body = response.body?.string()
                val data = jsonParser.fromJson(body ?: "", typeToken)
                ApiResponse.Success(data)
            } else {
                ApiResponse.Error("API call failed: ${response.code}")
            }
        } catch (e: Exception) {
            ApiResponse.Error(e.message ?: "Unknown error")
        }
    }

    override suspend fun <T> post(
        endpoint: String,
        body: Any,
        typeToken: TypeToken<T>
    ): ApiResponse<T> {
        // Similar implementation to get()
        TODO("Implement POST method")
    }

    override fun <T> observeWebSocket(
        endpoint: String,
        typeToken: TypeToken<T>
    ): Flow<ApiResponse<T>> = flow {
        TODO( "Implement WebSocket")
    }
}