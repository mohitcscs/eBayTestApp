package com.mohit.testapp.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.mohit.testapp.R
import com.mohit.testapp.model.Earthquake
import com.mohit.testapp.model.EarthquakeX

class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> () {

    private var earthquakeList : List<EarthquakeX> = listOf()

    class MyViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {

        val idtextView = itemView.findViewById<TextView>(R.id.eq_id_textview)
        val magnitudeTextView = itemView.findViewById<TextView>(R.id.magnitude_textview)

        fun bind(earthquake: EarthquakeX) {
            idtextView.text = earthquake.eqid
            magnitudeTextView.text = earthquake.magnitude.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_earthquake, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return earthquakeList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(earthquakeList[position])
        holder.itemView.setOnClickListener(View.OnClickListener {
            Toast.makeText(holder.itemView.context, earthquakeList[position].eqid, Toast.LENGTH_SHORT).show()
        })
    }

    fun submitList(earthquake : List<EarthquakeX>) {
        earthquakeList = earthquake
        notifyDataSetChanged()
    }
}