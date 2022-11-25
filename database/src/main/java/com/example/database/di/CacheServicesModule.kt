package com.example.database.di

import com.example.data.cacheservices.CarCacheService
import com.example.data.cacheservices.MotorcycleCacheService
import com.example.data.cacheservices.PlaneCacheService
import com.example.database.services.DefaultCarCacheService
import com.example.database.services.DefaultMotorcycleCacheService
import com.example.database.services.DefaultPlaneCacheService
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
interface CacheServicesModule {

    @Binds
    fun bindPlaneCacheService(service: DefaultPlaneCacheService): PlaneCacheService

    @Binds
    fun bindCarCacheService(service: DefaultCarCacheService): CarCacheService

    @Binds
    fun bindMotorcycleCacheService(service: DefaultMotorcycleCacheService): MotorcycleCacheService
}