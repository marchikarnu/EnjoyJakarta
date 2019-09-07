package com.marchika.enjoyjakarte;

import android.content.DialogInterface;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
import com.smarteist.autoimageslider.SliderView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WisataEdukasi extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;

    private static final LatLng P1 = new LatLng(-6.125194, 106.832444);
    private static final LatLng P2 = new LatLng(-6.189989, 106.838902);
    private static final LatLng P3 = new LatLng(-6.307834, 106.820412);
    private static final LatLng P4 = new LatLng(-6.175419, 106.827066);
    private static final LatLng P5 = new LatLng(-6.170181, 106.831384);
    private static final LatLng P6 = new LatLng(-6.125971, 106.842911);

    private Marker nP1;
    private Marker nP2;
    private Marker nP3;
    private Marker nP4;
    private Marker nP5;
    private Marker nP6;
    private SliderLayout imageSlider;
    private String TAG = "Wisata Hiburan Edukasi";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wisata_edukasi);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    private void setSliderView(String title) {
        for (int i = 0; i <= 2; i++) {

            DefaultSliderView sliderView = new DefaultSliderView(this);

            switch (title) {
                case "Dunia Fantasi":
                    switch (i) {
                        case 0:
                            sliderView.setImageDrawable(R.drawable.dufan2);
                            break;
                        case 1:
                            sliderView.setImageDrawable(R.drawable.dufan3);
                            break;
                        case 2:
                            sliderView.setImageDrawable(R.drawable.dufankartun);
                            break;
                    }
                    break;
                case "Planetarium":
                    switch (i) {
                        case 0:
                            sliderView.setImageDrawable(R.drawable.planetdlm1);
                            break;
                        case 1:
                            sliderView.setImageDrawable(R.drawable.planet);
                            break;
                        case 2:
                            sliderView.setImageDrawable(R.drawable.planetdlm);
                    }
                    break;
                case "Kebun Binatang Ragunan":
                    switch (i) {
                        case 0:
                            sliderView.setImageDrawable(R.drawable.ragunan);
                            break;
                        case 1:
                            sliderView.setImageDrawable(R.drawable.primata);
                            break;
                        case 2:
                            sliderView.setImageDrawable(R.drawable.spesieskbr);
                            break;
                    }
                    break;
                case "Monumen Nasional":
                    switch (i) {
                        case 0:
                            sliderView.setImageDrawable(R.drawable.monas1);
                            break;
                        case 1:
                            sliderView.setImageDrawable(R.drawable.monas2);
                            break;
                        case 2:
                            sliderView.setImageDrawable(R.drawable.monas3);
                            break;
                    }
                    break;
                case "Masjid Istiqlal":
                    switch (i) {
                        case 0:
                            sliderView.setImageDrawable(R.drawable.istiqlal1);
                            break;
                        case 1:
                            sliderView.setImageDrawable(R.drawable.dlmiqtiqlal);
                            break;
                        case 2:
                            sliderView.setImageDrawable(R.drawable.luasistiqlal);
                            break;
                    }
                    break;
                case "Seaworld Ancol":
                    switch (i) {
                        case 0:
                            sliderView.setImageDrawable(R.drawable.seaworld1);
                            break;
                        case 1:
                            sliderView.setImageDrawable(R.drawable.seaworld2);
                            break;
                        case 2:
                            sliderView.setImageDrawable(R.drawable.seaworldshark);
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
        String url = "http://quiet-meadow-14635.herokuapp.com/WisataHiburanEdukasi";
        JsonArrayRequest stringRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
//                nC1.setSnippet(response.toString());
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject data = response.getJSONObject(i);
                        switch (data.getString("nama")) {
                            case "Dunia Fantasi":
                                nP1.setSnippet(data.getString("deskripsi"));
                                break;
                            case "Planetarium":
                                nP2.setSnippet(data.getString("deskripsi"));
                                break;
                            case "Kebun Binatang Ragunan":
                                nP3.setSnippet(data.getString("deskripsi"));
                                break;
                            case "Monumen Nasional":
                                nP4.setSnippet(data.getString("deskripsi"));
                                break;
                            case "Masjid Istiqlal":
                                nP5.setSnippet(data.getString("deskripsi"));
                                break;
                            case "Seaworld":
                                nP6.setSnippet(data.getString("deskripsi"));
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

        nP1 = mMap.addMarker(new MarkerOptions()
                .position(P1)
                .title("Dunia Fantasi"));
        nP1.setTag(R.drawable.monas);

        nP2 = mMap.addMarker(new MarkerOptions()
                .position(P2)
                .title("Planetarium"));
        nP2.setTag(R.drawable.monas);

        nP3 = mMap.addMarker(new MarkerOptions()
                .position(P3)
                .title("Kebun Binatang Ragunan"));
        nP3.setTag(R.drawable.monas);

        nP4 = mMap.addMarker(new MarkerOptions()
                .position(P4)
                .title("Monumen Nasional"));
        nP4.setTag(R.drawable.monas);

        nP5 = mMap.addMarker(new MarkerOptions()
                .position(P5)
                .title("Masjid Istiqlal"));
        nP5.setTag(R.drawable.monas);

        nP6 = mMap.addMarker(new MarkerOptions()
                .position(P6)
                .title("Seaworld Ancol"));
        nP6.setTag(R.drawable.monas);


        mMap.addMarker(new MarkerOptions().position(P1).title("Wisata Edukasi"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(P1, 14));
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

        View view = LayoutInflater.from(this).inflate(R.layout.mapwisataedukasi, null);
        imageSlider = view.findViewById(R.id.edukasiSlider);

        TextView txtTitle = view.findViewById(R.id.tu);
        txtTitle.setText(title);

        TextView txtLoc = view.findViewById(R.id.oc);
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





