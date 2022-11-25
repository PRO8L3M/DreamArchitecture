package com.example.networking.mappers.car

import com.example.domain.models.Car
import com.example.domain.utils.Mapper
import com.example.networking.models.CarNetworking
import javax.inject.Inject

class CarNetworkingToDomainMapper @Inject constructor() : Mapper<CarNetworking, Car> {

    override fun map(source: CarNetworking): Car = Car(
        id = source.id,
        make = source.make,
        model = source.model,
        imageUrl = source.pictureUrl,
    )
}
