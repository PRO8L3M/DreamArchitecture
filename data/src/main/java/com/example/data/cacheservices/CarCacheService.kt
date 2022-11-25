package com.example.data.cacheservices

import com.example.domain.models.Car
import kotlinx.coroutines.flow.Flow

interface CarCacheService {

    fun getListOfCar(): Flow<List<Car>>

    suspend fun insertListOfCar(list: List<Car>)
}
