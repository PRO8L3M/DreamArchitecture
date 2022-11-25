package com.example.domain.repositories

import com.example.domain.models.Car
import com.example.domain.models.wrappers.Result
import kotlinx.coroutines.flow.Flow

interface CarRepository {

    fun getCarList(): Flow<Result<List<Car>>>
    suspend fun sync()

    suspend fun addCar(model: Car): Result<Unit>
}
