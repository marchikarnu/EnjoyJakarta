package com.marchika.enjoyjakarte;

import android.content.DialogInterface;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.smarteist.autoimageslider.DefaultSliderView;
import com.smarteist.autoimageslider.SliderLayout;

public class WisataBelanja extends FragmentActivity implements OnMapReadyCallback,GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;

    private static final LatLng T1 = new LatLng(-6.2243966, 106.8424789); // kokas
    private static final LatLng T2 = new LatLng(-6.1947928, 106.8217716); // gi
    private static final LatLng T3 = new LatLng(-6.2803083, 106.8290779); // pv
    private static final LatLng T4 = new LatLng(-6.1945879, 106.8167811); // tamcit
    private static final LatLng T5 = new LatLng(-6.262825, 106.865406); // pgc
    private static final LatLng T6 = new LatLng(-6.1890096, 106.8119312); //tnh abang

    private Marker nT1;
    private Marker nT2;
    private Marker nT3;
    private Marker nT4;
    private Marker nT5;
    private Marker nT6;
    private SliderLayout imageSlider;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wisata_belanja);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    private void setSliderView(String title){
        for (int i = 0; i <= 1; i++) {

            DefaultSliderView sliderView = new DefaultSliderView(this);

            switch (title){
                case "Kota Kosablanka": switch (i) {
                    case 0:
                        sliderView.setImageDrawable(R.drawable.kokas);
                        break;
                    case 1:
                        sliderView.setImageDrawable(R.drawable.kokas);
                        break;
                }
                    break;
                case "Grand Indonesia": switch (i) {
                    case 0:
                        sliderView.setImageDrawable(R.drawable.gi2);
                        break;
                    case 1:
                        sliderView.setImageDrawable(R.drawable.gi4);
                        break;
                }
                    break;
                case "Pejaten Village": switch (i){
                    case 0:
                        sliderView.setImageDrawable(R.drawable.pv);
                        break;
                    case 1:
                        sliderView.setImageDrawable(R.drawable.pv);
                        break;
                }
                    break;
                case "Thamrin City": switch (i){
                    case 0:
                        sliderView.setImageDrawable(R.drawable.thamrincity1);
                        break;
                    case 1:
                        sliderView.setImageDrawable(R.drawable.thamrincity1);
                        break;
                }
                case "Pusat Grosir Cililitan": switch (i){
                    case 0:
                        sliderView.setImageDrawable(R.drawable.pgc);
                        break;
                    case 1:
                        sliderView.setImageDrawable(R.drawable.pgc);
                        break;
                }
                case "Pasar Tanah Abang": switch (i){
                    case 0:
                        sliderView.setImageDrawable(R.drawable.tnhabang2);
                        break;
                    case 1:
                        sliderView.setImageDrawable(R.drawable.tnhabang2);
                        break;
                }
            }

            sliderView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);
            imageSlider.addSliderView(sliderView);

        }
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        nT1 = mMap.addMarker(new MarkerOptions()
                .position(T1)
                .title("Kota Kosablanka")
                .snippet("Jl. Casablanka N0.88, RT.14/RW.5, Menteng Dalam, Kec. Tebet, kota Jakarta Selatan, DKI Jakarta, 12870"));
        nT1.setTag(R.drawable.kokas);


        nT2 = mMap.addMarker(new MarkerOptions()
                .position(T2)
                .title("Grand Indonesia")
                .snippet("Jl. M.H. Thamrin No.1, RT.1/RW.5, Kebon Melati, Menteng, Central Jakarta City, DKI Jakarta 10310\n"+
                        "☞ Mall menengah ke atas\n"+
                        "☞ Dibuka tahun 2007 oleh Presiden Susilo Bambang Yudhoyono.\n"+
                        "☞ Luas mall: 250.000 m2\n" +
                        "☞ Jumlah lantai: 7"));
        nT2.setTag(R.drawable.gi2);
        nT2.setTag(R.drawable.gi4);
        nT2.setTag(R.drawable.gidalam);

        nT3 = mMap.addMarker(new MarkerOptions()
                .position(T3)
                .title("Pejaten Village")
                .snippet("Jl. Pejaten Raya No.1, RT.1/RW.5, Pejaten Barat, Kec. Ps.Minggu, Kota Jakarta Selatan, DKI Jakarta, 12540"));
        nT3.setTag(R.drawable.pv);

        nT4 = mMap.addMarker(new MarkerOptions()
                .position(T4)
                .title("Thamrin City")
                .snippet("Jl. K.H. Mas Mansyur, Kebon Melati, Tanah Abang, Central Jakarta City, DKI Jakarta, 10230"));
        nT4.setTag(R.drawable.thamrincity1);

        nT5 = mMap.addMarker(new MarkerOptions()
                .position(T5)
                .title("Pusat Grosir Cililitan")
                .snippet("Jl. Dewi Sartika RT 001 RW 013 Kelurahan Cililitan, RW.11, Kecamatan, Kec. Kramat jati, Kota Jakarta Timur, DKI Jakarta, 13640"));
        nT5.setTag(R.drawable.pgc);

        nT6 = mMap.addMarker(new MarkerOptions()
                .position(T6)
                .title("Pasar Tanah Abang")
                .snippet("Jalan KH. Mas Mansyur, Kelurahan Kampung Bali, Kec. Tanah Abang, Kota Jakarta Pusat, 10250"));
        nT6.setTag(R.drawable.tnhabang2);


        mMap.addMarker(new MarkerOptions().position(T1).title("Wisata Belanja"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(T1, 14));
        mMap.setOnMarkerClickListener(this);

    }

    @Override
    public boolean onMarkerClick(Marker marker) {

        // Retrieve the data from the marker.
        Integer clickCount = (Integer) marker.getTag();

        // Check if a click count was set, then display the click count.
        if (clickCount != null) {
            clickCount = clickCount + 1;
            marker.setTag(clickCount);
            Toast.makeText(this,
                    marker.getTitle() +
                            " has been clicked " + clickCount + " times.",
                    Toast.LENGTH_SHORT).show();

            showCustomDialog(marker.getTitle(), marker.getSnippet(), (Integer) marker.getTag());
        }

        // Return false to indicate that we have not consumed the event and that we wish
        // for the default behavior to occur (which is for the camera to move such that the
        // marker is centered and for the marker's info window to open, if it has one).
        return false;
    }

    private void showCustomDialog(String title, String location, int drawable) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Details");

        View view = LayoutInflater.from(this).inflate(R.layout.mapwisatabelanja, null);
        imageSlider = view.findViewById(R.id.belanjaSlider);

        TextView txtTitle = view.findViewById(R.id.txtTitleMb);
        txtTitle.setText(title);

        TextView txtLoc = view.findViewById(R.id.txtLocMb);
        txtLoc.setText(location);

        setSliderView(title);

        builder.setView(view);

        // add a button
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }


}

