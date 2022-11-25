package com.example.networking.mappers.plane

import com.example.domain.models.Plane
import com.example.domain.utils.Mapper
import com.example.networking.models.PlaneNetworking
import javax.inject.Inject

class PlaneDomainToNetworkingMapper @Inject constructor() : Mapper<Plane, PlaneNetworking> {

    override fun map(source: Plane): PlaneNetworking = PlaneNetworking(
        id = source.id,
        company = source.company,
        model = source.model,
        imageUrl = source.imageUrl,
    )
}
