package com.example.travelku.model

import android.os.Parcelable
import com.google.android.gms.maps.model.LatLng
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Spot(
    val title: String,
    val img: String,
    val tag: String,
    val deskripsi: String,
    val rating: Double,
    val jadwal: String,
    val harga: String,
    val latlng: LatLng
) : Parcelable