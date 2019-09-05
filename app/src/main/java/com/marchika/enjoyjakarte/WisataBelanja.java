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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
    private String TAG = "Wisata Belanja";

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
        for (int i = 0; i <= 2; i++) {

            DefaultSliderView sliderView = new DefaultSliderView(this);

            switch (title){
                case "Kota Kosablanka": switch (i) {
                    case 0:
                        sliderView.setImageDrawable(R.drawable.kokas);
                        break;
                    case 1:
                        sliderView.setImageDrawable(R.drawable.kokas1);
                        break;
                    case 2:
                        sliderView.setImageDrawable(R.drawable.kokas2);
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
                    case 2:
                        sliderView.setImageDrawable(R.drawable.gidalam);
                        break;
                }
                break;
                case "Pejaten Village": switch (i){
                    case 0:
                        sliderView.setImageDrawable(R.drawable.pv2);
                        break;
                    case 1:
                        sliderView.setImageDrawable(R.drawable.pv);
                        break;
                    case 2:
                        sliderView.setImageDrawable(R.drawable.pv1);
                }
                break;
                case "Thamrin City": switch (i){
                    case 0:
                        sliderView.setImageDrawable(R.drawable.thamrincity1);
                        break;
                    case 1:
                        sliderView.setImageDrawable(R.drawable.thamcity);
                        break;
                }
                break;
                case "Pusat Grosir Cililitan": switch (i){
                    case 0:
                        sliderView.setImageDrawable(R.drawable.pgc);
                        break;
                    case 1:
                        sliderView.setImageDrawable(R.drawable.pgc1);
                        break;
                }
                break;
                case "Pasar Tanah Abang": switch (i){
                    case 0:
                        sliderView.setImageDrawable(R.drawable.tnhabang2);
                        break;
                    case 1:
                        sliderView.setImageDrawable(R.drawable.tnhabang);
                        break;
                    case 2:
                        sliderView.setImageDrawable(R.drawable.tnhabangdlm);
                        break;
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
        String url = "http://quiet-meadow-14635.herokuapp.com/WisataBelanja";
        JsonArrayRequest stringRequest = new JsonArrayRequest(Request.Method.GET, url, null ,new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
//                nC1.setSnippet(response.toString());
                for(int i = 0;i<response.length();i++){
                    try {
                        JSONObject data = response.getJSONObject(i);
                        switch (data.getString("nama")){
                            case "Kota Kasablanka":
                                nT1.setSnippet(data.getString("deskripsi"));
                                break;
                            case "Grand Indonesia":
                                nT2.setSnippet(data.getString("deskripsi"));
                                break;
                            case "Pejaten Village":
                                nT3.setSnippet(data.getString("deskripsi"));
                                break;
                            case "Thamrin City":
                                nT4.setSnippet(data.getString("deskripsi"));
                                break;
                            case "Pusat Grosir Cililitan":
                                nT5.setSnippet(data.getString("deskripsi"));
                                break;
                            case "Tanah Abang":
                                nT6.setSnippet(data.getString("deskripsi"));
                                break;
                        }

                    }catch (JSONException e){
                        //TODO : JSON ERROR
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO: Handle error
                Log.e("err",error.toString());
            }
        });

        stringRequest.setTag(TAG);
        queue.add(stringRequest);

        nT1 = mMap.addMarker(new MarkerOptions()
                .position(T1)
                .title("Kota Kosablanka"));
        nT1.setTag(R.drawable.kokas);


        nT2 = mMap.addMarker(new MarkerOptions()
                .position(T2)
                .title("Grand Indonesia"));
        nT2.setTag(R.drawable.gi2);
        nT2.setTag(R.drawable.gi4);
        nT2.setTag(R.drawable.gidalam);

        nT3 = mMap.addMarker(new MarkerOptions()
                .position(T3)
                .title("Pejaten Village"));
        nT3.setTag(R.drawable.pv);

        nT4 = mMap.addMarker(new MarkerOptions()
                .position(T4)
                .title("Thamrin City"));
        nT4.setTag(R.drawable.thamrincity1);

        nT5 = mMap.addMarker(new MarkerOptions()
                .position(T5)
                .title("Pusat Grosir Cililitan"));
        nT5.setTag(R.drawable.pgc);

        nT6 = mMap.addMarker(new MarkerOptions()
                .position(T6)
                .title("Pasar Tanah Abang"));
        nT6.setTag(R.drawable.tnhabang2);


        mMap.addMarker(new MarkerOptions().position(T1).title("Wisata Belanja"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(T1, 14));
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

