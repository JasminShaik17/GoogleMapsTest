package cubex.mahesh.googlemapstest

import android.content.Context
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.MapStyleOptions

class MainActivity : AppCompatActivity() {
    var tv1:TextView? = null
    var tv2:TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv1 = findViewById(R.id.latitude)
        tv2 = findViewById(R.id.longitude)

        var frag:SupportMapFragment =
                            (SupportMapFragment())
                            supportFragmentManager.
                            findFragmentById(R.id.frag1)
        frag.getMapAsync(object : OnMapReadyCallback {
            override fun onMapReady(gMap: GoogleMap?) {

       //  gMap?.mapType=GoogleMap.MAP_TYPE_SATELLITE

  var lservice :LocationManager =
          getSystemService(Context.LOCATION_SERVICE)
                  as LocationManager

        lservice.getLastKnownLocation(
                LocationManager.NETWORK_PROVIDER)

        lservice.requestLocationUpdates(
                LocationManager.NETWORK_PROVIDER,
              1000.toLong(),1.toFloat(), object : LocationListener {
            override fun onLocationChanged(location: Location?) {
                tv1?.setText(location?.latitude.toString())
                tv2?.setText( location?.longitude.toString())
            }

            override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onProviderEnabled(provider: String?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onProviderDisabled(provider: String?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        }
        )
            }
        })
    }
}
