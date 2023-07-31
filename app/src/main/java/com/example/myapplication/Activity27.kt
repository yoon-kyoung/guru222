package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class Activity27 : AppCompatActivity() {
    private lateinit var mapFragment: SupportMapFragment
    private var googleMap: GoogleMap? = null
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.search2)
        // 맵 프래그먼트를 초기화합니다.
        mapFragment = supportFragmentManager.findFragmentById(R.id.map_fragment) as SupportMapFragment
        mapFragment.getMapAsync { mMap ->
            googleMap = mMap

            // 맵이 준비되었는지 확인합니다.
            googleMap?.let {
                // 라스베가스의 좌표를 설정합니다.
                val lasVegas = LatLng(36.1699, -115.1398)
                // 마커를 추가합니다.
                val markerOptions = MarkerOptions().position(lasVegas).title("라스베가스")
                it.addMarker(markerOptions)

                // 맵을 마커가 있는 위치로 이동합니다.
                it.moveCamera(com.google.android.gms.maps.CameraUpdateFactory.newLatLngZoom(lasVegas, 12f))
            }
        }



    }
}