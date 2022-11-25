package com.example.database.models

data class CarEntity(
    val id: Int, // Primary key
    val make: String,
    val model: String,
    val pictureUrl: String,
)
