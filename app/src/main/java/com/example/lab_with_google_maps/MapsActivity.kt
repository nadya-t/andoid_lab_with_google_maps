package com.example.lab_with_google_maps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.lab_with_google_maps.databinding.ActivityMapsBinding
import com.google.android.gms.maps.model.BitmapDescriptorFactory.defaultMarker

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var hseMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        hseMap = googleMap

        hseMap.setMinZoomPreference(11.0f)
        hseMap.setMaxZoomPreference(18.0f)

        val lvovskaya = LatLng(56.268068, 43.877230)
        val sormovskoye = LatLng(56.334979, 43.888268)
        val kostina = LatLng(56.312404, 43.991207)
        val pecherskaya = LatLng(56.324870, 44.022365)
        val rodionova = LatLng(56.317428, 44.067356)

        hseMap.addMarker(MarkerOptions()
            .position(lvovskaya)
            .title("ул. Львовская")
            .snippet("Корпус на улице Львовской, 1В")
            .icon(defaultMarker(312f)))
        hseMap.addMarker(MarkerOptions()
            .position(sormovskoye)
            .title("Сормовское ш.")
            .snippet("Корпус на Сормовском шоссе, 30")
            .icon(defaultMarker(312f)))
        hseMap.addMarker(MarkerOptions()
            .position(kostina)
            .title("ул. Костина")
            .snippet("Корпус на улице Костина, 2")
            .icon(defaultMarker(312f)))
        hseMap.addMarker(MarkerOptions()
            .position(pecherskaya)
            .title("ул. Большая Печерская")
            .snippet("Корпус на улице Большой Печерской, 25/12")
            .icon(defaultMarker(312f)))
        hseMap.addMarker(MarkerOptions()
            .position(rodionova)
            .title("ул. Родионова")
            .snippet("Корпус на улице Родионова, 136")
            .icon(defaultMarker(312f)))

        hseMap.moveCamera(CameraUpdateFactory.newLatLng(kostina))

    }
}