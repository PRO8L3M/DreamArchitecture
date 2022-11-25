package com.example.networking.mappers.plane

import com.example.domain.models.Plane
import com.example.domain.utils.Mapper
import com.example.networking.models.PlaneNetworking
import javax.inject.Inject

class PlaneNetworkingToDomainMapper @Inject constructor() : Mapper<PlaneNetworking, Plane> {

    override fun map(source: PlaneNetworking): Plane = Plane(
        id = source.id,
        company = source.company,
        model = source.model,
        imageUrl = source.imageUrl,
    )
}
