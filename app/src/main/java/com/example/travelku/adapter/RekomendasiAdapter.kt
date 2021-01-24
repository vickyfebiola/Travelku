package com.example.travelku.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.travelku.R
import com.example.travelku.model.Rekomendasi
import kotlinx.android.synthetic.main.item_rekomendasi.view.*

class RekomendasiAdapter(private val context: Context, private val data: ArrayList<Rekomendasi>)
    : RecyclerView.Adapter<RekomendasiAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view : View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_rekomendasi, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(data[position])
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val titleRekomendasi = view.titleRekomendasi
        private val rvSpot = view.rvSpot

        fun onBind(rekomendasi: Rekomendasi) {
            titleRekomendasi.text = rekomendasi.title
            rvSpot.layoutManager = LinearLayoutManager(context)
            rvSpot.adapter = SpotAdapter(context, rekomendasi.dataSpot){}
        }
    }
}