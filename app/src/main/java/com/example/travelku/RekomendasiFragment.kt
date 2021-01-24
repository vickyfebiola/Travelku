package com.example.travelku

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.travelku.adapter.RekomendasiAdapter
import com.example.travelku.model.Rekomendasi
import com.example.travelku.model.Spot
import kotlinx.android.synthetic.main.fragment_rekomendasi.*

class RekomendasiFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_rekomendasi, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        toolbar.title = "Rekomendasi"

        rvRekomendasi.layoutManager = LinearLayoutManager(context)
        rvRekomendasi.adapter = RekomendasiAdapter(context!!, getData())
    }

    private fun getData(): ArrayList<Rekomendasi> {
        val data = ArrayList<Rekomendasi>()
            data.add(Rekomendasi(
                "Paling Ramai",
                getSpot(2)
            ))
            data.add(Rekomendasi(
                "Wisata Paling Dekat",
                getSpot(3)
            ))
        return data
    }

    private fun getSpot(i: Int): ArrayList<Spot> {
        val data = ArrayList<Spot>()
        for (number in 1..i) {
            val item = Spot(
                "Waterboom Duar",
                "https://travelspromo.com/wp-content/uploads/2018/11/Fun-Park-Water-Boom.jpg",
                "Wahana Air, Keluarga",
                "Lorem ipsum sit amet, los dol dang",
                4.5,
                "09.00 - 17.00",
                "Rp15.000,- / Orang"
            )
            data.add(item)
        }
        return data
    }

}