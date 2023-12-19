package com.mohit.testapp.repository

import com.mohit.testapp.model.Earthquake
import com.mohit.testapp.model.EarthquakeX
import com.mohit.testapp.network.RetrofitInstance
import retrofit2.Response

class EarthquakeRepository  {

    suspend fun getEarthquakes() : Response<Earthquake> = RetrofitInstance.earthquakeApi.getEarthquakes()
}