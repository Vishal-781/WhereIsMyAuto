package com.example.whereismyauto.core.data

import com.example.whereismyauto.core.network.ApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map

abstract class BaseRepository<T> (
    protected val apiService: ApiService // inject through constructor
) {
    protected suspend fun <D> executeApi(
        apiCall: suspend () -> D,
        mapSuccess: (D) -> T
    ): Result<T> = try {
        val response = apiCall()
        Result.success(mapSuccess(response))
    } catch (e: Exception) {
        Result.failure(e)
    }

    protected fun <D> observeApi(
        streamCall: () -> Flow<D>,
        mapSuccess: (D) -> T
    ): Flow<Result<T>> = streamCall()
        .map { data -> Result.success(mapSuccess(data)) }
        .catch { e -> emit(Result.failure(e)) }
}