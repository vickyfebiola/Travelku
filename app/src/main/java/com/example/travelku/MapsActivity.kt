package com.example.travelku

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.travelku.model.Spot

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {
    companion object {
        const val EXTRA_MYDATA = "mydata"
    }

    private lateinit var mMap: GoogleMap

    lateinit var latLng: LatLng

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
        latLng = intent.getParcelableExtra<Spot>(EXTRA_MYDATA)?.latlng!!
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // data lokasi
        val location = latLng

        //marker
        mMap.addMarker(MarkerOptions().position(location).title(location!!.toString()))
        //cameraoptions
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 16.0f))


    }
}