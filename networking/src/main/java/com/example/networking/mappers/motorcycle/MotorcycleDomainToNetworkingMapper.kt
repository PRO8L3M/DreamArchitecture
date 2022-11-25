package com.example.networking.mappers.motorcycle

import com.example.domain.models.Motorcycle
import com.example.domain.utils.Mapper
import com.example.networking.models.MotorcycleNetworking
import javax.inject.Inject

class MotorcycleDomainToNetworkingMapper @Inject constructor() : Mapper<Motorcycle, MotorcycleNetworking> {

    override fun map(source: Motorcycle): MotorcycleNetworking = MotorcycleNetworking(
        id = source.id,
        make = source.make,
        model = source.model,
        imageUrl = source.imageUrl,
    )
}
