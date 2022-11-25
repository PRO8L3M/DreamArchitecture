package com.example.networking.di

import com.example.domain.models.Car
import com.example.domain.models.Motorcycle
import com.example.domain.models.Plane
import com.example.domain.utils.Mapper
import com.example.networking.mappers.car.CarDomainToNetworkingMapper
import com.example.networking.mappers.car.CarNetworkingToDomainMapper
import com.example.networking.mappers.motorcycle.MotorcycleDomainToNetworkingMapper
import com.example.networking.mappers.motorcycle.MotorcycleNetworkingToDomainMapper
import com.example.networking.mappers.plane.PlaneDomainToNetworkingMapper
import com.example.networking.mappers.plane.PlaneNetworkingToDomainMapper
import com.example.networking.models.CarNetworking
import com.example.networking.models.MotorcycleNetworking
import com.example.networking.models.PlaneNetworking
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
interface MappersModule {

    @Binds
    fun bindPlaneDomainToNetworkingMapper(mapper: PlaneDomainToNetworkingMapper): Mapper<Plane, PlaneNetworking>

    @Binds
    fun bindPlaneNetworkingToDomainMapper(mapper: PlaneNetworkingToDomainMapper): Mapper<PlaneNetworking, Plane>

    @Binds
    fun bindCarDomainToNetworkingMapper(mapper: CarDomainToNetworkingMapper): Mapper<Car, CarNetworking>

    @Binds
    fun bindCarNetworkingToDomainMapper(mapper: CarNetworkingToDomainMapper): Mapper<CarNetworking, Car>

    @Binds
    fun bindMotorcycleDomainToNetworkingMapper(mapper: MotorcycleDomainToNetworkingMapper): Mapper<Motorcycle, MotorcycleNetworking>

    @Binds
    fun bindMotorcycleNetworkingToDomainMapper(mapper: MotorcycleNetworkingToDomainMapper): Mapper<MotorcycleNetworking, Motorcycle>
}
