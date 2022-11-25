package com.example.networking.mappers.motorcycle

import com.example.domain.models.Motorcycle
import com.example.domain.utils.Mapper
import com.example.networking.models.MotorcycleNetworking
import javax.inject.Inject

class MotorcycleNetworkingToDomainMapper @Inject constructor() : Mapper<MotorcycleNetworking, Motorcycle> {

    override fun map(source: MotorcycleNetworking): Motorcycle = Motorcycle(
        id = source.id,
        make = source.make,
        model = source.model,
        imageUrl = source.imageUrl,
    )
}
