package com.example.travelku

import android.content.Intent
import android.location.Geocoder
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.example.travelku.model.Spot
import org.w3c.dom.Text

class ScrollingDetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_LOCATION = "location"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scrolling_detail)
        setSupportActionBar(findViewById(R.id.toolbar))
        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            val moveToMaps = Intent(this, MapsActivity::class.java)
            startActivity(moveToMaps)
        }
        val spot = intent.getParcelableExtra<Spot>(EXTRA_LOCATION)
        findViewById<CollapsingToolbarLayout>(R.id.toolbar_layout).title = spot?.title.toString()

        val tvDetail = findViewById<TextView>(R.id.item_deskripsi_wisata)
        tvDetail.text = spot?.deskripsi


        var buttonFloat = findViewById<FloatingActionButton>(R.id.fab)
        buttonFloat.setOnClickListener { view ->
            val moveWithObjectIntent = Intent(this, MapsActivity::class.java)
            moveWithObjectIntent.putExtra(MapsActivity.EXTRA_MYDATA, spot)
            startActivity(moveWithObjectIntent)
        }

    }
}