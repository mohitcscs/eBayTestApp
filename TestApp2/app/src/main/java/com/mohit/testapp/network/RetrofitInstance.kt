package com.mohit.testapp.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


// http://api.geonames.org/      earthquakesJSON?formatted=true&north=44.1&south=-9.9&east=-22.4&west=55.2&username=mkoppelman
class RetrofitInstance {
    companion object {
        private val retrofit by lazy {
            Retrofit.Builder()
                .baseUrl("http://api.geonames.org/")
                . addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        val earthquakeApi by lazy {
            retrofit.create(EarthquakeApi::class.java)
        }
    }
}