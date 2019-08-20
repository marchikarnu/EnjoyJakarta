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
import com.smarteist.autoimageslider.SliderView;

public class WisataAir extends FragmentActivity implements OnMapReadyCallback,GoogleMap.OnMarkerClickListener  {

    private GoogleMap mMap;
    private static final LatLng C1 = new LatLng(-6.1138953, 106.7472149); //waterboom jkt
    private static final LatLng C2 = new LatLng(-6.1242956, 106.8391409); //atlantis
    private static final LatLng C3 = new LatLng(-6.2990434, 106.8917246); //snowbay
    private static final LatLng C4 = new LatLng(-6.267746, 106.784401); // the wave park

    private Marker nC1;
    private Marker nC2;
    private Marker nC3;
    private Marker nC4;
    private SliderLayout imageSlider;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wisata_air);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    private void setSliderView(String title){
        for (int i = 0; i <= 1; i++) {

            DefaultSliderView sliderView = new DefaultSliderView(this);

            switch (title){
                case "The Wave Park": switch (i) {
                    case 0:
                        sliderView.setImageDrawable(R.drawable.thewavepark);
                        break;
                    case 1:
                        sliderView.setImageDrawable(R.drawable.thewave);
                        break;
                }
                break;
                case "Waterboom Jakarta": switch (i) {
                    case 0:
                        sliderView.setImageDrawable(R.drawable.pik);
                        break;
                    case 1:
                        sliderView.setImageDrawable(R.drawable.pik1);
                        break;
                    case 2:
                        sliderView.setImageDrawable(R.drawable.pik2);
                        break;
                    case 3:
                        sliderView.setImageDrawable(R.drawable.pik3);
                        break;

                }
                    break;
                case "Atlantis Ancol": switch (i){
                    case 0:
                        sliderView.setImageDrawable(R.drawable.atlantis1);
                        break;
                    case 1:
                        sliderView.setImageDrawable(R.drawable.atlantis);
                        break;
                }
                break;
                case "Snowbay": switch (i){
                    case 0:
                        sliderView.setImageDrawable(R.drawable.snowbay1);
                        break;
                    case 1:
                        sliderView.setImageDrawable(R.drawable.snowbay);
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


        nC1 = mMap.addMarker(new MarkerOptions()
                .position(C1)
                .title("Waterboom Jakarta")
                .snippet("Jl. Pantai Indah Barat No.1 RT.7/RW.2, Kamal Muara, Penjaringan, North Jakarta City, Jakarta, 14470\n"+
                        "☞ Saat ini hanya ada dua Waterbom di Indonesia yaitu: Waterbom Bali dan Waterbom Jakarta \n"+
                        "☞ Telepon: (021) 55966666\n"+
                        "☞ Opening Hours:\n" +
                        "Monday\t\t\t9AM–7PM\n" +
                        "Tuesday\t\t9AM–7PM\n" +
                        "Wednesday\t9AM–7PM\n" +
                        "Thursday\t\t9AM–7PM\n" +
                        "Friday\t\t\t9AM–7PM\n" +
                        "Saturday\t\t9AM–7PM\n" +
                        "Sunday\t\t\t9AM–7PM"));
        nC1.setTag(R.drawable.pik);
        nC1.setTag(R.drawable.pik1);

        nC2 = mMap.addMarker(new MarkerOptions()
                .position(C2)
                .title("Atlantis Ancol")
                .snippet("Lokasi: Taman Impian Jaya Ancol, Jl. Lodan Timur No.7, RW.10, Ancol, Pademangan, North Jakarta City, Jakarta 14430"));
        nC2.setTag(R.drawable.atlantis);
        nC2.setTag(R.drawable.atlantis1);

        nC3 = mMap.addMarker(new MarkerOptions()
                .position(C3)
                .title("Snowbay")
                .snippet("Komplek Taman Mini Indonesia Indah. Kel. Pinang Ranti, Kec. Makasar, Kota Jakarta Timur, DKI Jakarta, 13820"));
        nC3.setTag(R.drawable.snowbay);
        nC3.setTag(R.drawable.snowbay1);

        nC4 = mMap.addMarker(new MarkerOptions()
                .position(C4)
                .title("The Wave Park")
                .snippet("PIM, Jl Metro PI RT.1/RW.16, Kel. Pondok Pinang, Kec. Kebayoran Lama, Kota Jakarta Selatan, DKI Jakarta, 12310"));
        nC4.setTag(R.drawable.thewave);
        nC4.setTag(R.drawable.thewavepark);


//        // Add a marker in Sydney and move the camera
//        LatLng sydney = new LatLng(-34, 151);
//        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        mMap.addMarker(new MarkerOptions().position(C1).title("cika"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(C1,14));
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

        View view = LayoutInflater.from(this).inflate(R.layout.mapwisataair, null);
        imageSlider = view.findViewById(R.id.airSlider);

        TextView txtTitle = view.findViewById(R.id.t);
        txtTitle.setText(title);
        TextView txtLoc = view.findViewById(R.id.tx);
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


