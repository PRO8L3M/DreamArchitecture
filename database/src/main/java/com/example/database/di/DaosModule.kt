package com.example.database.di

import com.example.database.daos.CarDao
import com.example.database.daos.MotorcycleDao
import com.example.database.daos.PlaneDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
interface DaosModule {

    companion object {

        @Provides
        fun providePlaneDao() = PlaneDao

        @Provides
        fun provideCarDao() = CarDao

        @Provides
        fun provideMotorcycleDao() = MotorcycleDao
    }
}