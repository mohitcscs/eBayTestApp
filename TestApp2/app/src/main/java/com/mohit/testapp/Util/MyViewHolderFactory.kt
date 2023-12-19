package com.mohit.testapp.Util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mohit.testapp.repository.EarthquakeRepository
import com.mohit.testapp.viewmodel.EarthquakeViewModel

class MyViewHolderFactory (private val repository: EarthquakeRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return EarthquakeViewModel(repository) as T
    }
}