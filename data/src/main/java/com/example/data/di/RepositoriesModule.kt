package com.example.data.di

import com.example.data.repositories.DefaultCarRepository
import com.example.data.repositories.DefaultMotorcycleRepository
import com.example.data.repositories.DefaultPlaneRepository
import com.example.domain.repositories.CarRepository
import com.example.domain.repositories.MotorcycleRepository
import com.example.domain.repositories.PlaneRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
interface RepositoriesModule {

    @Binds
    fun bindPlaneRepository(repository: DefaultPlaneRepository): PlaneRepository

    @Binds
    fun bindCarRepository(repository: DefaultCarRepository): CarRepository

    @Binds
    fun bindMotorcycleRepository(repository: DefaultMotorcycleRepository): MotorcycleRepository
}