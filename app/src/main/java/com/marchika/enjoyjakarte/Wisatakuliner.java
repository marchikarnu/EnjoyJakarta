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

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.marchika.enjoyjakarte.DBHelper.DBHelper;
import com.marchika.enjoyjakarte.DBHelper.Kuliner;
import com.smarteist.autoimageslider.DefaultSliderView;
import com.smarteist.autoimageslider.SliderLayout;

import java.util.ArrayList;
import java.util.List;

public class Wisatakuliner extends FragmentActivity implements OnMapReadyCallback,GoogleMap.OnMarkerClickListener  {


    private GoogleMap mMap;
    private static final LatLng L1 = new LatLng (-6.122493, 106.843411); // bandar djakarta
    private static final LatLng L2 = new LatLng (-6.246475, 106.793048); // bubur ayam barito
    private static final LatLng L3 = new LatLng (-6.183210, 106.825690); // nasi goreng kambing
    private static final LatLng L4 = new LatLng (-6.243616, 106.796550); // gultik
    private static final LatLng L5 = new LatLng (-6.170950, 106.799229); // indomie abang adek
    private static final LatLng L6 = new LatLng (-6.228264, 106.795939); // taichan senayan

    private Marker nL1;
    private Marker nL2;
    private Marker nL3;
    private Marker nL4;
    private Marker nL5;
    private Marker nL6;
    private SliderLayout imageSlider;
    private List<Kuliner> listKuliner;
    private DBHelper db;
    private TextView harga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wisatamakuliner);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        db = new DBHelper(this);
        listKuliner = new ArrayList<Kuliner>();
        listKuliner = db.getKuliner();

        harga = findViewById(R.id.harga);
    }

    private void setSliderView(String title){
        for (int i = 0; i <= 1; i++) {

            DefaultSliderView sliderView = new DefaultSliderView(this);

            switch (title){
                case "Bandar Djakarta Ancol": switch (i) {
                    case 0:
                        sliderView.setImageDrawable(R.drawable.bandarjktfood);
                        break;
                    case 1:
                        sliderView.setImageDrawable(R.drawable.bandarjkt);
                        break;
                    case 2:
                        sliderView.setImageDrawable(R.drawable.bandarjkt1);
                        break;
                    case 3:
                        sliderView.setImageDrawable(R.drawable.bandarjktprice);
                        break;
                }
                    break;
                case "Bubur Ayam Barito": switch (i) {
                    case 0:
                        sliderView.setImageDrawable(R.drawable.buburab);
                        break;
                    case 1:
                        sliderView.setImageDrawable(R.drawable.buburab1);
                        break;
                    case 2:
                        sliderView.setImageDrawable(R.drawable.buburabplace);
                        break;
                    case 3:
                        sliderView.setImageDrawable(R.drawable.buburabprice);
                        break;
                }
                    break;
                case "Nasi Goreng Kambing Kebon Sirih": switch (i){
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
                case "Gulai Tikungan": switch (i){
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
                case "Indomie Goreng Abang Adek": switch (i){
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
                case "Sate Taichan Senayan": switch (i){
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

        nL1 = mMap.addMarker(new MarkerOptions()
                .position(L1)
                .title("Bandar Djakarta Ancol")
                .snippet("☞ Pintu Timur, Taman Impian Jaya Ancol, Jl Lodan Timur No.7, RW 10, Ancol, Kec.Pademangan, Kota Jkt Utara, DKI Jakarta, 14430 \n" +
                        "☞ Live seafood to choose \n" +
                        "☞ Average cost: Rp250.000 for two people (approx.) \n" +
                        "☞ Telp: (021) 6455472 \n" +
                        "☞ Opening hours: \n" +
                            "\tSaturday\t\t\t 10AM–12AM\n" +
                            "\tSunday\t\t\t\t 10AM–11:30PM\n" +
                            "\tMonday\t\t\t\t 11AM–11PM\n" +
                            "\tTuesday \t\t\t 11AM–11PM\n" +
                            "\tWednesday\t 11AM–11PM\n" +
                            "\tThursday\t\t\t 11AM–11PM\n" +
                            "\tFriday\t\t\t\t\t 11AM–11PM"));
        nL1.setTag(R.drawable.bandarjktfood);
        nL1.setTag(R.drawable.bandarjkt);

        nL2 = mMap.addMarker(new MarkerOptions()
                .position(L2)
                .title("Bubur Ayam Barito")
                .snippet("☞ Jl. Gandaria Tengah III No.3, RW.4, Kramat Pela, Kec. Kby. Baru, Kota Jakarta Selatan, Daerah Khusus Ibukota Jakarta, 12130 \n" +
                        "☞ The one and only chicken porridge topped with crunchy cheese sticks \n" +
                        "☞ Telp: 0813 81488989\n"+
                        "☞ Average cost: Rp60.000 for two people (approx.) \n" +
                        "☞ Opening hours: \n" +
                                "\tTue\t17h – 23h\n" +
                                "\tWed\t17h – 23h\n" +
                                "\tThu\t17h – 23h\n" +
                                "\tFri\t17h – 23h\n" +
                                "\tSat\t17h – 23h\n" +
                                "\tSun\t17h – 23h"));
        nL2.setTag(R.drawable.buburab);
        nL2.setTag(R.drawable.buburab1);


        nL3 = mMap.addMarker(new MarkerOptions()
                .position(L3)
                .title("Nasi Goreng Kambing Kebon Sirih")
                .snippet("☞ Jl. Kebon Sirih Barat I Dalam I No.9, RT.1/RW.1, Kb. Sirih, Kec. Menteng, Kota Jakarta Pusat, DKI Jakarta 10340 \n"+
                        "☞ Tempat makan santai dan sederhana menyajikan menu nasi goreng kambing dan ayam, sop, es buah, sate \n" +
                        "☞ Average cost: Rp120.000 for two people (approx.) \n"+
                        "☞ Telp: 0811 190775\n" +
                        "\t\t\t 0811 865011 \n" +
                        "☞ Opening hours: \n" +
                            "\tMon\t17h – 2h\n" +
                            "\tTue\t17h – 2h\n" +
                            "\tWed\t17h – 2h\n" +
                            "\tThu\t17h – 2h\n" +
                            "\tFri\t17h – 2h\n" +
                            "\tSat\t17h – 2h\n" +
                            "\tSun\t17h – 2h\n"));
        nL3.setTag(R.drawable.ngkks1);
        nL3.setTag(R.drawable.ngkks);
        nL3.setTag(R.drawable.ngkksplace);


        nL4 = mMap.addMarker(new MarkerOptions()
                .position(L4)
                .title("Gulai Tikungan ")
                .snippet("☞ Jl. Mahakam No.28, RT.1/RW.6, Kramat Pela, Kec. Kby. Baru, Kota Jakarta Selatan, Daerah Khusus Ibukota Jakarta, 12130 \n" +
                        "☞ Indonesian version of lamb curry. \n"+
                        "☞ Average cost: Rp50.000 for two people (approx.)\n"+
                        "☞ Telp: 0852 87676143 \n" +
                        "☞ Opening hours: \n" +
                        "Mon\t17h – 24h\n" +
                        "Tue\t17h – 24h\n" +
                        "Wed\t17h – 24h\n" +
                        "Thu\t17h – 24h\n" +
                        "Fri\t17h – 24h\n" +
                        "Sat\t17h – 24h\n" +
                        "Sun\t17h – 24h\n"));
        nL4.setTag(R.drawable.gultik);
        nL4.setTag(R.drawable.gultik1);
        nL4.setTag(R.drawable.gultikplace);


        nL5 = mMap.addMarker(new MarkerOptions()
                .position(L5)
                .title("Indomie Goreng Abang Adek")
                .snippet("☞ Jl. Mandala Utara No.8, RT.16/RW.4, Tomang, Kec. Grogol petamburan, Kota Jakarta Barat, Daerah Khusus Ibukota Jakarta, 11440 \n" +
                        "☞ Instant noodle with generous chopped chilli toppings \n"+
                        "☞ Average cost: Rp90.000 for two people (approx.)\n"+
                        "☞ Telp: 021 5657988\n" +
                        "\t\t 0815 10199224 \n" +
                        "☞ Opening hours: \n" +
                        "Mon\t9h – 2h\n" +
                        "Tue\t9h – 2h\n" +
                        "Wed\t9h – 2h\n" +
                        "Thu\t9h – 2h\n" +
                        "Fri\t9h – 2h\n" +
                        "Sat\t9h – 2h\n" +
                        "Sun\t9h – 2h"));
        nL5.setTag(R.drawable.miead);
        nL5.setTag(R.drawable.miead1);


        nL6 = mMap.addMarker(new MarkerOptions()
                .position(L6)
                .title("Sate Taichan Senayan")
                .snippet("☞ Jl. Simprug Golf 2 No.1, RW.3, Gelora, Kecamatan Tanah Abang, Kota Jakarta Selatan, Daerah Khusus Ibukota Jakarta, 10270 \n"+
                        "☞ Sate Taichan 87 Bang Ocit \n"+
                        "☞ Average cost: Rp60.000 for two people (approx.)\n"+
                        "☞ Telp: 0878 86893623\n" +
                        "\t\t 0878 844445288\n" +
                        "☞ Opening hours: \n" +
                        "Mon\t21h – 2h\n" +
                        "Tue\t21h – 2h\n" +
                        "Wed\t21h – 2h\n" +
                        "Thu\t21h – 2h\n" +
                        "Fri\t21h – 2h\n" +
                        "Sat\t21h – 2h\n" +
                        "Sun\t21h – 2h"));
        nL6.setTag(R.drawable.taican);
        nL6.setTag(R.drawable.taican1);


        mMap.addMarker(new MarkerOptions().position(L1).title("Wisata Kuliner"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(L1,14));
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

        View view = LayoutInflater.from(this).inflate(R.layout.mapwisatakuliner, null);
        imageSlider = view.findViewById(R.id.kulinerSlider);

        TextView txtTitle = view.findViewById(R.id.txtTitle);
        txtTitle.setText(title);

        TextView txtLoc = view.findViewById(R.id.txtLoc);
        txtLoc.setText(location);
        setSliderView(title);


        TextView txtHarga = view.findViewById(R.id.harga);


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

    public void tunjukkanHarga(int urutanHarga){
        try{
            Kuliner kuliner = new Kuliner();
            kuliner = listKuliner.get(urutanHarga);
            String harga2 = kuliner.getAverage();
            harga.setText(harga2.toCharArray(),0,harga2.length());

        }catch (Exception e){
            Log.e(this.getClass().toString(), e.getMessage(), e.getCause());
        }
    }
}

