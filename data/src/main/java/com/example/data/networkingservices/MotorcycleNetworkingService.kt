package com.example.data.networkingservices

import com.example.domain.models.Motorcycle

interface MotorcycleNetworkingService {

    suspend fun getListOfMotorcycle(): List<Motorcycle>

    suspend fun insertMotorcycle(model: Motorcycle): List<Motorcycle>
}
