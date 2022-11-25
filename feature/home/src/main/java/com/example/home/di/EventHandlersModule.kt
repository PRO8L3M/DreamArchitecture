package com.example.home.di

import com.example.core.EventHandler
import com.example.core.di.EventHandlerKey
import com.example.home.events.AddCar
import com.example.home.events.handlers.AddCarEventHandler
import com.example.home.events.Sync
import com.example.home.events.handlers.SyncHomeDataEventHandler
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.multibindings.IntoMap

@InstallIn(ViewModelComponent::class)
@Module
interface EventHandlersModule {

    @Binds
    @IntoMap
    @EventHandlerKey(AddCar::class)
    @ViewModelScoped
    fun bindAddCarEventHandler(handler: AddCarEventHandler): EventHandler

    @Binds
    @IntoMap
    @EventHandlerKey(Sync::class)
    @ViewModelScoped
    fun bindSyncEventHandler(handler: SyncHomeDataEventHandler): EventHandler
}
