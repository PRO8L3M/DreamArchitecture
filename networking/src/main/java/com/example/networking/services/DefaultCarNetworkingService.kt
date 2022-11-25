package com.example.networking.services

import com.example.data.networkingservices.CarNetworkingService
import com.example.domain.di.Dispatcher
import com.example.domain.di.DispatcherType
import com.example.domain.models.Car
import com.example.domain.utils.Mapper
import com.example.networking.endpoints.Endpoints
import com.example.networking.models.CarNetworking
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DefaultCarNetworkingService @Inject constructor(
    @Dispatcher(DispatcherType.IO) private val dispatcher: CoroutineDispatcher,
    private val endpoints: Endpoints,
    private val carNetworkingToDomainMapper: Mapper<CarNetworking, Car>, // We might inject that via Multibinding
    private val carDomainToNetworkingMapper: Mapper<Car, CarNetworking>, // We might inject that via Multibinding
) : CarNetworkingService {

    override suspend fun getListOfCar(): List<Car> = withContext(dispatcher) {
        endpoints.getListOfCar()
            .run(carNetworkingToDomainMapper::mapAll)
            .toList()
    }

    override suspend fun insertCar(model: Car): List<Car> = withContext(dispatcher) {
        val carNetworking: CarNetworking = carDomainToNetworkingMapper.map(model)
        endpoints.addCar(carNetworking)
            .run(carNetworkingToDomainMapper::mapAll)
            .toList()
    }
}
