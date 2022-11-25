package com.example.domain.models

import com.example.domain.models.wrappers.Result

data class Home(
    val listOfPlane: Result<List<Plane>>,
    val listOfCar: Result<List<Car>>,
    val listOfMotorcycle: Result<List<Motorcycle>>,
)
