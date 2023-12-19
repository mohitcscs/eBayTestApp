package com.mohit.testapp.model

data class EarthquakeX(
    val datetime: String,
    val depth: Double,
    val eqid: String,
    val lat: Double,
    val lng: Double,
    val magnitude: Double,
    val src: String
)