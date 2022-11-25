package com.example.data.di

import com.example.data.errorhandler.DefaultErrorHandler
import com.example.domain.error.ErrorHandler
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
interface DataModule {

    @Binds
    fun bindErrorHandler(errorHandler: DefaultErrorHandler): ErrorHandler
}