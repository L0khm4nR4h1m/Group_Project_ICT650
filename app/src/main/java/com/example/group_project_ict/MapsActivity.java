package com.example.group_project_ict;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.Context;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.widget.Toast;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.LocationSettingsStatusCodes;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.group_project_ict.databinding.ActivityMapsBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.maps.android.SphericalUtil;

import java.text.DecimalFormat;
import java.util.Vector;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    MarkerOptions marker;
    LatLng centerlocation;

    Vector<MarkerOptions> markerOptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        centerlocation = new LatLng(3.074313890208331, 101.49229391428368);

        markerOptions = new Vector<>();

        markerOptions.add( new MarkerOptions().title("Hospital Tengku Ampuan Rahimah")
                .position(new LatLng(3.021234470838002, 101.44002661580066))
                .snippet("Hospital")
        );
        markerOptions.add( new MarkerOptions().title("Shah Alam Hospital")
                .position(new LatLng(3.0786832206422865, 101.49015179582673))
                .snippet("Hospital")
        );
        markerOptions.add( new MarkerOptions().title("Pusat Kesihatan UITM")
                .position(new LatLng(3.0686848715422856, 101.49359382607732))
                .snippet("Health")
        );
        markerOptions.add( new MarkerOptions().title("Klinik Pakar Wanita Razif Norana")
                .position(new LatLng(3.0168426878107732, 101.44128029064898))
                .snippet("Clinic")
        );
        markerOptions.add( new MarkerOptions().title("Hania Clinic Medical & Surgery")
                .position(new LatLng(3.085470304562143, 101.55242546899609))
                .snippet("Clinic")
        );
        markerOptions.add( new MarkerOptions().title("U.n.i KLINIK Shah Alam")
                .position(new LatLng(3.07652670942602, 101.55126136617571))
                .snippet("Clinic")
        );
        markerOptions.add( new MarkerOptions().title("Sentosa Specialist Hospital Klang")
                .position(new LatLng(3.0060209363355064, 101.48297084646661))
                .snippet("Hospital")
        );
        markerOptions.add( new MarkerOptions().title("Klinik Munawarah")
                .position(new LatLng(3.075615549031854, 101.51002164589173))
                .snippet("Clinic")
        );
        markerOptions.add( new MarkerOptions().title("Klinik Nisa")
                .position(new LatLng(3.076818203931543, 101.496706640485))
                .snippet("Clinic")
        );
        markerOptions.add( new MarkerOptions().title("Klinik Pergigian UITM")
                .position(new LatLng(3.0685723099843165, 101.49344315492345))
                .snippet("Clinic")
        );
        markerOptions.add( new MarkerOptions().title("Shah Alam Health Clinic")
                .position(new LatLng(3.072312248476707, 101.49094494670842))
                .snippet("Clinic")
        );
        markerOptions.add( new MarkerOptions().title("Klinik Pergigian UITM")
                .position(new LatLng(3.0685723099843165, 101.49344315492345))
                .snippet("Clinic")
        );
        markerOptions.add( new MarkerOptions().title("Klinik Homeopathy Radziah")
                .position(new LatLng(3.075494091306734, 101.48596487956362))
                .snippet("Clinic")
        );
        markerOptions.add( new MarkerOptions().title("PrimeCare Dental Clinic Shah Alam")
                .position(new LatLng(3.071297238669664, 101.5081582510898))
                .snippet("Clinic")
        );
        markerOptions.add( new MarkerOptions().title("Klinik Pergigian Lissa Shah Alam")
                .position(new LatLng(3.068527120001389, 101.49046375108979))
                .snippet("Clinic")
        );

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        for (MarkerOptions mark : markerOptions) {
            mMap.addMarker(mark);

        }

        enableMyLocation();


        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(centerlocation,8));
        mMap.getUiSettings().setZoomControlsEnabled(true);



    }

    private void enableMyLocation() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            if (mMap != null) {
                mMap.setMyLocationEnabled(true);
            }
        } else {
            // Permission to access the location is missing. Show rationale and request permission
            String perms[] =  {"android.permission.ACCESS_FINE_LOCATION"};
            ActivityCompat.requestPermissions(this,perms, 200);
        }
    }
}