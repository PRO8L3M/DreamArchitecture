package com.example.data.networkingservices

import com.example.domain.models.Car

interface CarNetworkingService {

    suspend fun getListOfCar(): List<Car>

    suspend fun insertCar(model: Car): List<Car>
}
