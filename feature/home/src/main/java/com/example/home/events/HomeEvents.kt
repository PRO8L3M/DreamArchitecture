package com.example.home.events

import com.example.core.Event
import com.example.domain.error.ErrorEntity
import com.example.domain.models.Car
import com.example.home.state.HomeState

object Sync : Event
data class AddCar(val car: Car) : Event
