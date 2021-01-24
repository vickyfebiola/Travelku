package com.example.travelku

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.travelku.adapter.BannerAdapter
import com.example.travelku.adapter.SpotAdapter
import com.example.travelku.model.Spot
import com.google.android.gms.maps.model.LatLng
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvSpotBaru.layoutManager = LinearLayoutManager(context)
        rvSpotBaru.adapter = SpotAdapter(context!!, getData()) {
            val intent = Intent(requireContext(), ScrollingDetailActivity::class.java)
                .putExtra(ScrollingDetailActivity.EXTRA_LOCATION, it)

            startActivity(intent)
        }
    }

    private fun getData(): ArrayList<Spot> {
        val data = ArrayList<Spot>()
        for (i in 1..5) {
            val item = Spot(
                "Owabong Waterpark",
                "https://travelspromo.com/wp-content/uploads/2018/11/Fun-Park-Water-Boom.jpg",
                "Wahana Air, Keluarga",
                "Lorem ipsum sit amet, los dol dang",
                4.5,
                "09.00 - 17.00",
                "Rp15.000,- / Orang",
                LatLng(-7.348492356670486, 109.34972487122866)
            )
            data.add(item)
        }
        return data
    }

}