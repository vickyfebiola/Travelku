package com.example.travelku.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.travelku.R
import kotlinx.android.synthetic.main.item_eksplor_img.view.*

class EksplorImgAdapter(private val context: Context, private val data: ArrayList<String>)
    : RecyclerView.Adapter<EksplorImgAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view : View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_eksplor_img, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(data[position])
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgView = view.img

        fun onBind(img: String) {
            Glide.with(context)
                .load(img)
                .centerCrop().into(imgView)
        }
    }

}