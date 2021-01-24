package com.example.travelku

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        switchView(HomeFragment())
        bottom_nav.setOnNavigationItemSelectedListener(this)
    }

    fun switchView(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame, fragment)
            .commit()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.home -> switchView(HomeFragment())
            R.id.rekomendasi -> switchView(RekomendasiFragment())
            R.id.eksplor -> switchView(EksplorFragment())
            R.id.profile -> switchView(ProfileFragment())
        }
        return true
    }
}