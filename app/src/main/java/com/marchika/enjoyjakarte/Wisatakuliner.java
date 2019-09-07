package com.marchika.enjoyjakarte;

import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.smarteist.autoimageslider.DefaultSliderView;
import com.smarteist.autoimageslider.SliderLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Wisatakuliner extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {


    private GoogleMap mMap;
    private static final LatLng L1 = new LatLng(-6.122493, 106.843411); // bandar djakarta
    private static final LatLng L2 = new LatLng(-6.246475, 106.793048); // bubur ayam barito
    private static final LatLng L3 = new LatLng(-6.183210, 106.825690); // nasi goreng kambing
    private static final LatLng L4 = new LatLng(-6.243616, 106.796550); // gultik
    private static final LatLng L5 = new LatLng(-6.170950, 106.799229); // indomie abang adek
    private static final LatLng L6 = new LatLng(-6.228264, 106.795939); // taichan senayan

    private Marker nL1;
    private Marker nL2;
    private Marker nL3;
    private Marker nL4;
    private Marker nL5;
    private Marker nL6;
    private SliderLayout imageSlider;
    private String TAG = "Wisata Kuliner";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wisata_kuliner);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    private void setSliderView(String title) {
        for (int i = 0; i <= 2; i++) {

            DefaultSliderView sliderView = new DefaultSliderView(this);

            switch (title) {
                case "Bandar Djakarta Ancol":
                    switch (i) {
                        case 0:
                            sliderView.setImageDrawable(R.drawable.bandarjktfood);
                            break;
                        case 1:
                            sliderView.setImageDrawable(R.drawable.bandarjkt);
                            break;
                        case 2:
                            sliderView.setImageDrawable(R.drawable.bandarjkt1);
                            break;
                    }
                    break;
                case "Bubur Ayam Barito":
                    switch (i) {
                        case 0:
                            sliderView.setImageDrawable(R.drawable.buburab);
                            break;
                        case 1:
                            sliderView.setImageDrawable(R.drawable.buburab1);
                            break;
                        case 2:
                            sliderView.setImageDrawable(R.drawable.buburabplace);
                            break;
                    }
                    break;
                case "Nasi Goreng Kambing Kebon Sirih":
                    switch (i) {
                        case 0:
                            sliderView.setImageDrawable(R.drawable.ngkks);
                            break;
                        case 1:
                            sliderView.setImageDrawable(R.drawable.ngkks1);
                            break;
                        case 2:
                            sliderView.setImageDrawable(R.drawable.ngkksplace);
                            break;
                    }
                    break;
                case "Gulai Tikungan":
                    switch (i) {
                        case 0:
                            sliderView.setImageDrawable(R.drawable.gultik);
                            break;
                        case 1:
                            sliderView.setImageDrawable(R.drawable.gultik1);
                            break;
                        case 2:
                            sliderView.setImageDrawable(R.drawable.gultikplace);
                            break;
                    }
                    break;
                case "Indomie Goreng Abang Adek":
                    switch (i) {
                        case 0:
                            sliderView.setImageDrawable(R.drawable.miead);
                            break;
                        case 1:
                            sliderView.setImageDrawable(R.drawable.miead1);
                            break;
                        case 2:
                            sliderView.setImageDrawable(R.drawable.mieadplace);
                            break;
                    }
                    break;
                case "Sate Taichan Senayan":
                    switch (i) {
                        case 0:
                            sliderView.setImageDrawable(R.drawable.taican);
                            break;
                        case 1:
                            sliderView.setImageDrawable(R.drawable.taican1);
                            break;
                        case 2:
                            sliderView.setImageDrawable(R.drawable.taicanplace1);
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
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://enjoyjakarte.now.sh/WisataKuliner";
        JsonArrayRequest stringRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
//                nC1.setSnippet(response.toString());
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject data = response.getJSONObject(i);
                        switch (data.getString("nama")) {
                            case "Bandar Djakarta":
                                nL1.setSnippet(data.getString("deskripsi"));
                                break;
                            case "Bubur Ayam Barito":
                                nL2.setSnippet(data.getString("deskripsi"));
                                break;
                            case "Nasi Goreng Kambing Kebon Sirih":
                                nL3.setSnippet(data.getString("deskripsi"));
                                break;
                            case "Gulai Tikungan":
                                nL4.setSnippet(data.getString("deskripsi"));
                                break;
                            case "Indomie Goreng Abang Adek":
                                nL5.setSnippet(data.getString("deskripsi"));
                                break;
                            case "Sate Taichan Senayan":
                                nL6.setSnippet(data.getString("deskripsi"));
                                break;
                        }

                    } catch (JSONException e) {
                        //TODO : JSON ERROR
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO: Handle error
                Log.e("err", error.toString());
            }
        });

        stringRequest.setTag(TAG);
        queue.add(stringRequest);

        nL1 = mMap.addMarker(new MarkerOptions()
                .position(L1)
                .title("Bandar Djakarta Ancol"));
        nL1.setTag(R.drawable.bandarjktfood);
        nL1.setTag(R.drawable.bandarjkt);

        nL2 = mMap.addMarker(new MarkerOptions()
                .position(L2)
                .title("Bubur Ayam Barito")
        );
        nL2.setTag(R.drawable.buburab);
        nL2.setTag(R.drawable.buburab1);


        nL3 = mMap.addMarker(new MarkerOptions()
                .position(L3)
                .title("Nasi Goreng Kambing Kebon Sirih")
        );
        nL3.setTag(R.drawable.ngkks1);
        nL3.setTag(R.drawable.ngkks);
        nL3.setTag(R.drawable.ngkksplace);


        nL4 = mMap.addMarker(new MarkerOptions()
                .position(L4)
                .title("Gulai Tikungan")
        );
        nL4.setTag(R.drawable.gultik);
        nL4.setTag(R.drawable.gultik1);
        nL4.setTag(R.drawable.gultikplace);


        nL5 = mMap.addMarker(new MarkerOptions()
                .position(L5)
                .title("Indomie Goreng Abang Adek")
        );
        nL5.setTag(R.drawable.miead);
        nL5.setTag(R.drawable.miead1);


        nL6 = mMap.addMarker(new MarkerOptions()
                .position(L6)
                .title("Sate Taichan Senayan")
        );
        nL6.setTag(R.drawable.taican);
        nL6.setTag(R.drawable.taican1);


        mMap.addMarker(new MarkerOptions().position(L1).title("Wisata Kuliner"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(L1, 14));
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

        View view = LayoutInflater.from(this).inflate(R.layout.mapwisatakuliner, null);
        imageSlider = view.findViewById(R.id.kulinerSlider);

        TextView txtTitle = view.findViewById(R.id.txtTitle);
        txtTitle.setText(title);
        txtTitle.setTextColor(Color.BLACK);

        TextView txtLoc = view.findViewById(R.id.txtLoc);
        txtLoc.setText(location);
        txtLoc.setTextColor(Color.BLACK);

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

