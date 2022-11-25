package com.example.networking.di

import com.example.networking.endpoints.Endpoints
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface NetworkingModule {

    companion object {

        @Provides
        fun provideFakeEndpoint() = Endpoints
    }
}
