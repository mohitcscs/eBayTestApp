package com.mohit.testapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mohit.testapp.R
import com.mohit.testapp.Util.MyViewHolderFactory
import com.mohit.testapp.repository.EarthquakeRepository
import com.mohit.testapp.view.adapters.RecyclerViewAdapter
import com.mohit.testapp.viewmodel.EarthquakeViewModel

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: EarthquakeViewModel
    lateinit var recycler : RecyclerView
    lateinit var earthQuakeAdapter : RecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler = findViewById(R.id.recycler_view)

        earthQuakeAdapter = RecyclerViewAdapter()

        recycler.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            hasFixedSize()
            adapter = earthQuakeAdapter
        }

        val repository = EarthquakeRepository()
        viewModel = ViewModelProvider(this, MyViewHolderFactory(repository)).get(EarthquakeViewModel::class.java)

        viewModel.earthQuakeLiveData.observe(this, Observer {
            val state = it
            //if ()
            earthQuakeAdapter.submitList(state.data)
        })

        viewModel.getEarthquakes()
    }
}