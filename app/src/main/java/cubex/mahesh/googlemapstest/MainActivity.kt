package cubex.mahesh.googlemapstest

import android.content.Context
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapFragment
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MapStyleOptions
import com.google.android.gms.maps.model.MarkerOptions

class MainActivity : AppCompatActivity() {
    var tv1:TextView? = null
    var tv2:TextView? = null

    var lManager: LocationManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lManager = getSystemService(Context.LOCATION_SERVICE)
                as LocationManager
        lManager?.requestLocationUpdates(
                LocationManager.NETWORK_PROVIDER,
                0L,0f,location_listener)


        tv1 = findViewById(R.id.latitude)
        tv2 = findViewById(R.id.longitude)

        var frag:MapFragment =
                (MapFragment())
                        fragmentManager.
                findFragmentById(R.id.frag1)

        frag.getMapAsync(mcallback)

    }
    
    var location_listener = object:LocationListener
    {
        override fun onLocationChanged(location: Location?) {
            tv1?.setText(location?.latitude.toString())
            tv2?.setText(location?.longitude.toString())

            Toast.makeText(this@MainActivity,
                    "Location Ready ...", Toast.LENGTH_LONG).show()

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

    var mcallback:OnMapReadyCallback = object : OnMapReadyCallback {
        override fun onMapReady(p0: GoogleMap?) {

            Toast.makeText(this@MainActivity,
                    "Map Ready ...", Toast.LENGTH_LONG).show()

        }

    }
}
