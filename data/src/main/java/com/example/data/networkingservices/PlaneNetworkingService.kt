package com.example.data.networkingservices

import com.example.domain.models.Plane

interface PlaneNetworkingService {

    suspend fun getListOfPlane(): List<Plane>

    suspend fun insertPlane(model: Plane): List<Plane>
}
