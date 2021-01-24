package com.example.travelku.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.travelku.R
import com.example.travelku.model.Spot
import kotlinx.android.synthetic.main.item_spot.view.*

class SpotAdapter(private val context: Context, private val data : ArrayList<Spot>)
    : RecyclerView.Adapter<SpotAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view : View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_spot, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val titleSpot = view.titleSpot
        private val tagSpot = view.tagSpot
        private val deskripsiSpot = view.deskripsiSpot
        private val ratingSpot = view.ratingSpot
        private val jadwalSpot = view.jadwalSpot
        private val hargaSpot = view.hargaSpot
        private val imgSpot = view.imgSpot

        fun bind(spot: Spot) {
            titleSpot.text = spot.title
            tagSpot.text = spot.tag
            deskripsiSpot.text = spot.deskripsi
            ratingSpot.text = spot.rating.toString()
            jadwalSpot.text = spot.jadwal
            hargaSpot.text = spot.harga
            Glide.with(context)
                .load(spot.img)
                .centerCrop().into(imgSpot)
        }
    }

}