package com.example.domain.usecases

import com.example.domain.models.Car
import com.example.domain.repositories.CarRepository
import javax.inject.Inject

class AddCarUseCase @Inject constructor(
    private val repository: CarRepository,
) {

    suspend operator fun invoke(model: Car) = repository.addCar(model)
}
