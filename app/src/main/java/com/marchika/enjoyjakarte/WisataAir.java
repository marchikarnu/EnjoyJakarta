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

import com.android.volley.*;


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


public class WisataAir extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;
    private static final LatLng C1 = new LatLng(-6.1138953, 106.7472149); //waterboom jkt
    private static final LatLng C2 = new LatLng(-6.1242956, 106.8391409); //atlantis
    private static final LatLng C3 = new LatLng(-6.2990434, 106.8917246); //snowbay
    private static final LatLng C4 = new LatLng(-6.267746, 106.784401); // the wave park

    //    private List<Marker> nC = new ArrayList<Marker>();
    private Marker nC1;
    private Marker nC2;
    private Marker nC3;
    private Marker nC4;
    private SliderLayout imageSlider;
    public static final String TAG = "Wisata Air";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wisata_air);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    private void setSliderView(String title) {
        for (int i = 0; i <= 2; i++) {

            DefaultSliderView sliderView = new DefaultSliderView(this);

            switch (title) {
                case "The Wave Park":
                    switch (i) {
                        case 0:
                            sliderView.setImageDrawable(R.drawable.thewave);
                            break;
                        case 1:
                            sliderView.setImageDrawable(R.drawable.thewave1);
                            break;
                        case 2:
                            sliderView.setImageDrawable(R.drawable.thewave3);
                            break;
                    }
                    break;
                case "Waterboom Jakarta":
                    switch (i) {
                        case 0:
                            sliderView.setImageDrawable(R.drawable.pik);
                            break;
                        case 1:
                            sliderView.setImageDrawable(R.drawable.pik1);
                            break;
                        case 2:
                            sliderView.setImageDrawable(R.drawable.pik3);
                            break;

                    }
                    break;
                case "Atlantis Ancol":
                    switch (i) {
                        case 0:
                            sliderView.setImageDrawable(R.drawable.atlantis1);
                            break;
                        case 1:
                            sliderView.setImageDrawable(R.drawable.atlantis);
                            break;
                        case 2:
                            sliderView.setImageDrawable(R.drawable.atlantis2);
                            break;
                    }
                    break;
                case "Snowbay":
                    switch (i) {
                        case 0:
                            sliderView.setImageDrawable(R.drawable.snowbay1);
                            break;
                        case 1:
                            sliderView.setImageDrawable(R.drawable.snowbay);
                            break;
                        case 2:
                            sliderView.setImageDrawable(R.drawable.snowbay22);
                    }
            }

            sliderView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);
            imageSlider.addSliderView(sliderView);

        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://enjoyjakarte.now.sh/WisataAir";
        JsonArrayRequest stringRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
//                nC1.setSnippet(response.toString());
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject data = response.getJSONObject(i);
                        switch (data.getString("nama")) {
                            case "Waterboom Jakarta":
                                nC1.setSnippet(data.getString("deskripsi"));
                                break;
                            case "Atlantis":
                                nC2.setSnippet(data.getString("deskripsi"));
                                break;
                            case "Snowbay":
                                nC3.setSnippet(data.getString("deskripsi"));
                                break;
                            case "The Wave Park":
                                nC4.setSnippet(data.getString("deskripsi"));
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

//        Iterator iterator = nC.iterator();
//        while (iterator.hasNext()){
//        }
        nC1 = mMap.addMarker(new MarkerOptions()
                .position(C1)
                .title("Waterboom Jakarta"));
        nC1.setTag(R.drawable.pik);
        nC1.setTag(R.drawable.pik1);
        nC1.setTag(R.drawable.pik3);

        nC2 = mMap.addMarker(new MarkerOptions()
                .position(C2)
                .title("Atlantis Ancol"));
        nC2.setTag(R.drawable.atlantis);
        nC2.setTag(R.drawable.atlantis1);
        nC2.setTag(R.drawable.atlantis2);

        nC3 = mMap.addMarker(new MarkerOptions()
                .position(C3)
                .title("Snowbay"));
        nC3.setTag(R.drawable.snowbay);
        nC3.setTag(R.drawable.snowbay1);

        nC4 = mMap.addMarker(new MarkerOptions()
                .position(C4)
                .title("The Wave Park"));
        nC4.setTag(R.drawable.thewave);
        nC4.setTag(R.drawable.thewavepark);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(C1, 14));
        mMap.setOnMarkerClickListener(this);
    }

    @Override
    public boolean onMarkerClick(Marker marker) {

        Integer clickCount = (Integer) marker.getTag();
        if (clickCount != null) {
            clickCount = clickCount + 1;
            marker.setTag(clickCount);
            showCustomDialog(marker.getTitle(), marker.getSnippet(), (Integer) marker.getTag());
        }
        return false;
    }

    private void showCustomDialog(String title, String location, int drawable) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Details");

        View view = LayoutInflater.from(this).inflate(R.layout.mapwisataair, null);
        imageSlider = view.findViewById(R.id.airSlider);

        TextView txtTitle = view.findViewById(R.id.t);
        txtTitle.setText(title);
        txtTitle.setTextColor(Color.BLACK);
        TextView txtLoc = view.findViewById(R.id.tx);
        txtLoc.setText(location);
        txtLoc.setTextColor(Color.BLACK);

        setSliderView(title);

        builder.setView(view);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}


