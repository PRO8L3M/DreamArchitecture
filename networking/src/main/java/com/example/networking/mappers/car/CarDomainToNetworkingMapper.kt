package com.example.networking.mappers.car

import com.example.domain.models.Car
import com.example.domain.utils.Mapper
import com.example.networking.models.CarNetworking
import javax.inject.Inject

class CarDomainToNetworkingMapper @Inject constructor() : Mapper<Car, CarNetworking> {

    override fun map(source: Car): CarNetworking = CarNetworking(
        id = source.id,
        make = source.make,
        model = source.model,
        pictureUrl = source.imageUrl,
    )
}
