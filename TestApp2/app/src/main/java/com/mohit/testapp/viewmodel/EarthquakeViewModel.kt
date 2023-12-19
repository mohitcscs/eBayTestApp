package com.mohit.testapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mohit.testapp.model.EarthquakeX
import com.mohit.testapp.repository.EarthquakeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class EarthquakeViewModel (private val repository: EarthquakeRepository) : ViewModel() {

    val earthQuakeLiveData  = MutableLiveData<State>()

    fun getEarthquakes() {
        viewModelScope.launch {
            val response = repository.getEarthquakes()

            if (response.isSuccessful) {
                withContext(Dispatchers.Main) {
                    val result = response.body()
                    result?.let {
                        earthQuakeLiveData.postValue(State(result.earthquakes, ""))
                    }
                }
            } else {
                earthQuakeLiveData.postValue(State(listOf(), "Failure"))
            }
        }
    }

    data class State (
        val data: List<EarthquakeX>,
        val errorMessage: String ) {
        companion object {
            val DEFAULT_STATE : State = State(listOf(), "")
        }
    }
}