package com.example.networking.services

import com.example.data.networkingservices.PlaneNetworkingService
import com.example.domain.di.Dispatcher
import com.example.domain.di.DispatcherType
import com.example.domain.models.Plane
import com.example.domain.utils.Mapper
import com.example.networking.endpoints.Endpoints
import com.example.networking.models.PlaneNetworking
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DefaultPlaneNetworkingService @Inject constructor(
    @Dispatcher(DispatcherType.IO) private val dispatcher: CoroutineDispatcher,
    private val fakeEndpoints: Endpoints,
    private val planeNetworkingToDomainMapper: Mapper<PlaneNetworking, Plane>, // We might inject that via Multibinding
    private val planeDomainToNetworkingMapper: Mapper<Plane, PlaneNetworking>, // We might inject that via Multibinding
) : PlaneNetworkingService {

    override suspend fun getListOfPlane(): List<Plane> = withContext(dispatcher) {
        fakeEndpoints.getListOfPlane()
            .run(planeNetworkingToDomainMapper::mapAll)
            .toList()
    }

    override suspend fun insertPlane(model: Plane): List<Plane> = withContext(dispatcher) {
        val planeNetworking: PlaneNetworking = planeDomainToNetworkingMapper.map(model)
        fakeEndpoints.addPlane(planeNetworking)
            .run(planeNetworkingToDomainMapper::mapAll)
            .toList()
    }
}
