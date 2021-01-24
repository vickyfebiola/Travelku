package com.example.travelku

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.travelku.adapter.EksplorAdapter
import com.example.travelku.model.Eksplor
import kotlinx.android.synthetic.main.fragment_eksplor.*

class EksplorFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_eksplor, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        toolbar.title = "Eksplor"
        rvEksplor.layoutManager = LinearLayoutManager(context)
        rvEksplor.adapter = EksplorAdapter(context!!, getData())
    }

    private fun getData() : ArrayList<Eksplor> {
        val data = ArrayList<Eksplor>()
        data.add(Eksplor(
            "Pegunungan",
                getImg()
        ))
        data.add(Eksplor(
            "Kemah",
            getImg()
        ))
        data.add(Eksplor(
            "Pantai",
            getImg()
        ))
        data.add(Eksplor(
            "Wahana Air",
            getImg()
        ))
        return data
    }

    private fun getImg() : ArrayList<String> {
        val data = ArrayList<String>()
        for (i in 1..5) {
            data.add("https://travelspromo.com/wp-content/uploads/2018/11/Fun-Park-Water-Boom.jpg")
        }
        return data
    }

}