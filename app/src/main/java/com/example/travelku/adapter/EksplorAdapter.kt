package com.example.travelku.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.travelku.R
import com.example.travelku.model.Eksplor
import kotlinx.android.synthetic.main.item_eksplor.view.*

class EksplorAdapter(private val context: Context, private val data: ArrayList<Eksplor>)
    : RecyclerView.Adapter<EksplorAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view : View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_eksplor, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(data[position])
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleEksplor = view.titleEksplor
        val rvImg = view.rvImg

        fun onBind(eksplor: Eksplor) {
            titleEksplor.text = eksplor.title
            rvImg.layoutManager = LinearLayoutManager(context,
                LinearLayoutManager.HORIZONTAL, false)
            rvImg.adapter = EksplorImgAdapter(context, eksplor.img)
        }
    }
}