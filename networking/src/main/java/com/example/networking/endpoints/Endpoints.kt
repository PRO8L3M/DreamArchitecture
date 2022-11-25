package com.example.networking.endpoints

import com.example.networking.models.CarNetworking
import com.example.networking.models.MotorcycleNetworking
import com.example.networking.models.PlaneNetworking
import kotlinx.coroutines.delay

object Endpoints {

    private val listOfPlane = mutableListOf(
        PlaneNetworking(
            id = 1,
            company = "AirBus",
            model = "A380",
            imageUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/0/09/A6-EDY_A380_Emirates_31_jan_2013_jfk_%288442269364%29_%28cropped%29.jpg/1200px-A6-EDY_A380_Emirates_31_jan_2013_jfk_%288442269364%29_%28cropped%29.jpg"
        ),
        PlaneNetworking(
            id = 2,
            company = "AirBus",
            model = "A320",
            imageUrl = "https://upload.wikimedia.org/wikipedia/commons/2/24/Lufthansa_Airbus_A320-211_D-AIQT_01.jpg"
        ),
        PlaneNetworking(
            id = 3,
            company = "AirBus",
            model = "A330",
            imageUrl = "https://upload.wikimedia.org/wikipedia/commons/c/c8/Turkish_Airlines%2C_Airbus_A330-300_TC-JNL_NRT_%2823708073592%29.jpg"
        ),
        PlaneNetworking(
            id = 4,
            company = "AirBus",
            model = "A340",
            imageUrl = "https://static1.simpleflyingimages.com/wordpress/wp-content/uploads/2021/03/Lufthansa-Airbus-A340-313-D-AIFF-2-1-scaled.jpg"
        ),
    )

    private val listOfCar = mutableListOf(
        CarNetworking(
            id = 1,
            make = "BMW",
            model = "Series 5",
            pictureUrl = "https://upload.wikimedia.org/wikipedia/commons/5/52/BMW_G30_FL_IMG_5351.jpg"
        ),
        CarNetworking(
            id = 2,
            make = "BMW",
            model = "Series 3",
            pictureUrl = "https://cdn.car-recalls.eu/wp-content/uploads/2021/07/BMW-3-Series-2021-seatbelt.jpg"
        ),
        CarNetworking(
            id = 3,
            make = "BMW",
            model = "Series 7",
            pictureUrl = "https://www.autocentrum.pl/ac-file/car-version/5cde7f37c74b3549196a1e99.jpg"
        ),
        CarNetworking(
            id = 4,
            make = "BMW",
            model = "Series 8",
            pictureUrl = "https://www.autocentrum.pl/ac-file/car-version/5cda900c57502abedf710e66.jpg"
        ),
    )

    private val listOfMotorcycle = mutableListOf(
        MotorcycleNetworking(
            id = 1,
            make = "Ducati",
            model = "Panigale V2",
            imageUrl = "https://ducatipolska.pl/photo/cf4b11fbc05db284cdeb8323b574abc6.780x460.png"
        ),
        MotorcycleNetworking(
            id = 2,
            make = "Ducati",
            model = "Monster",
            imageUrl = "https://ducatipolska.pl/photo/5cae176791a956fd49f48326aec28b4d.780x460.png"
        ),
        MotorcycleNetworking(
            id = 3,
            make = "Ducati",
            model = "Diavel 1260 S",
            imageUrl = "https://ducatipolska.pl/photo/da16bb679125b44521230285ebec1dd3.780x460.png"
        ),
        MotorcycleNetworking(
            id = 4,
            make = "Ducati",
            model = "Multistrada V4 Rally",
            imageUrl = "https://ducatipolska.pl/photo/8753af9b9466bd367351c309259fe1ed.780x460.png"
        ),
    )


    suspend fun getListOfPlane(): List<PlaneNetworking> {
        delay(1000L)
        return listOfPlane
    }

    suspend fun addPlane(model: PlaneNetworking): List<PlaneNetworking> {
        delay(1000)
        listOfPlane.add(model)
        return listOfPlane
    }

    suspend fun getListOfCar(): List<CarNetworking> {
        delay(1000L)
        return listOfCar
    }

    suspend fun addCar(model: CarNetworking): List<CarNetworking> {
        delay(1000)
        listOfCar.add(model)
        return listOfCar
    }

    suspend fun getListOfMotorcycle(): List<MotorcycleNetworking> {
        delay(1000L)
        return listOfMotorcycle
    }

    suspend fun addMotorcycle(model: MotorcycleNetworking): List<MotorcycleNetworking> {
        delay(1000)
        listOfMotorcycle.add(model)
        return listOfMotorcycle
    }
}
