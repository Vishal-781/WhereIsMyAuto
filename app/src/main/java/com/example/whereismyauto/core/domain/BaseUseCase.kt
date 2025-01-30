package com.example.whereismyauto.core.domain

import kotlinx.coroutines.flow.Flow

abstract class BaseUseCase<in P, R> {
    abstract suspend operator fun invoke(parameters: P): Result<R>
}

abstract class BaseFlowUseCase<in P, R> {
    abstract operator fun invoke(parameters: P): Flow<Result<R>>
}
