package com.example.networking.di

import com.example.data.networkingservices.CarNetworkingService
import com.example.data.networkingservices.MotorcycleNetworkingService
import com.example.data.networkingservices.PlaneNetworkingService
import com.example.networking.services.DefaultCarNetworkingService
import com.example.networking.services.DefaultMotorcycleNetworkingService
import com.example.networking.services.DefaultPlaneNetworkingService
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
interface NetworkingServicesModule {

    @Binds
    fun bindPlaneNetworkingService(service: DefaultPlaneNetworkingService): PlaneNetworkingService

    @Binds
    fun bindCarNetworkingService(service: DefaultCarNetworkingService): CarNetworkingService

    @Binds
    fun bindMotorcycleNetworkingService(service: DefaultMotorcycleNetworkingService): MotorcycleNetworkingService
}
