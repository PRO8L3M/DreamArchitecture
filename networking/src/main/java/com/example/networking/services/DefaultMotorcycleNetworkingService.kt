package com.example.networking.services

import com.example.data.networkingservices.MotorcycleNetworkingService
import com.example.domain.di.Dispatcher
import com.example.domain.di.DispatcherType
import com.example.domain.models.Motorcycle
import com.example.domain.utils.Mapper
import com.example.networking.endpoints.Endpoints
import com.example.networking.models.MotorcycleNetworking
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DefaultMotorcycleNetworkingService @Inject constructor(
    @Dispatcher(DispatcherType.IO) private val dispatcher: CoroutineDispatcher,
    private val endpoints: Endpoints,
    private val motorcycleNetworkingToDomainMapper: Mapper<MotorcycleNetworking, Motorcycle>, // We might inject that via Multibinding
    private val motorcycleDomainToNetworkingMapper: Mapper<Motorcycle, MotorcycleNetworking>, // We might inject that via Multibinding
) : MotorcycleNetworkingService {

    override suspend fun getListOfMotorcycle(): List<Motorcycle> = withContext(dispatcher) {
        endpoints.getListOfMotorcycle()
            .run(motorcycleNetworkingToDomainMapper::mapAll)
            .toList()
    }

    override suspend fun insertMotorcycle(model: Motorcycle): List<Motorcycle> = withContext(dispatcher) {
        val motorcycleNetworking: MotorcycleNetworking = motorcycleDomainToNetworkingMapper.map(model)
        endpoints.addMotorcycle(motorcycleNetworking)
            .run(motorcycleNetworkingToDomainMapper::mapAll)
            .toList()
    }
}
