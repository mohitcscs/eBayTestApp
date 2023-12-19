package com.mohit.testapp.network

import com.mohit.testapp.model.Earthquake
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface EarthquakeApi {

    @GET("earthquakesJSON?formatted=true&north=44.1&south=-9.9&east=-22.4&west=55.2&username=mkoppelman")
    suspend fun getEarthquakes() : Response<Earthquake>
}