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

public class WisataEdukasi extends FragmentActivity implements OnMapReadyCallback,GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;

    private static final LatLng P1 = new LatLng (-6.125194, 106.832444);
    private static final LatLng P2 = new LatLng (-6.189989, 106.838902);
    private static final LatLng P3 = new LatLng (-6.307834, 106.820412);
    private static final LatLng P4 = new LatLng (-6.175419, 106.827066);
    private static final LatLng P5 = new LatLng (-6.170181, 106.831384);
    private static final LatLng P6 = new LatLng (-6.125971, 106.842911);

    private Marker nP1;
    private Marker nP2;
    private Marker nP3;
    private Marker nP4;
    private Marker nP5;
    private Marker nP6;
    private SliderLayout imageSlider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wisata_edukasi);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    private void setSliderView(String title){
        for (int i = 0; i <= 1; i++) {

            DefaultSliderView sliderView = new DefaultSliderView(this);

            switch (title){
                case "Dunia Fantasi": switch (i) {
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
                case "Planetarium": switch (i) {
                    case 0:
                        sliderView.setImageDrawable(R.drawable.planetdlm1);
                        break;
                    case 1:
                        sliderView.setImageDrawable(R.drawable.planet);
                        break;
                }
                    break;
                case "Kebun Binatang Ragunan": switch (i){
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
                case "Monumen Nasional": switch (i){
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
                case "Masjid Istiqlal": switch (i){
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
                case "Seaworld Ancol": switch (i){
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

        nP1 = mMap.addMarker(new MarkerOptions()
                .position(P1)
                .title("Dunia Fantasi")
                .snippet("☞ Address: RW.10, Ancol, Pademangan, North Jakarta City, Jakarta 14430 \n"+
                        "☞ Sebagai wahana fantasi kawasan edukasi fisika terbesar se-Indonesia" +
                        "\t menyediakan permainan outdoor dan indoor dengan teknologi canggih untuk berfantasi keliling Dunia\n"+
                        "☞ Telp: (021) 29222222\n"+
                        "☞ Opening Hours:\n"+
                        "-Senin-Jumat: 10.00-18.00 WIB \n" +
                        "-Sabtu/Minggu/Libur: 10.00-20.00 WIB"));
        nP1.setTag(R.drawable.monas);

        nP2 = mMap.addMarker(new MarkerOptions()
                .position(P2)
                .title("Planetarium")
                .snippet("☞ Address: Jl. Cikini Raya No.73, RT.8/RW.2, Cikini, Kec. Menteng, Kota Jakarta Pusat, DKI Jakarta, 10330 \n"+
                        "☞ Fasilitas: Pertunjukan teater bintang, Observatorium, Ruang pameran \n"+
                        "☞ Telp: (021) 2305146 \n"+
                        "☞ Opening hours: \n"+
                        "\t\t Selasa-Minggu : 08.00–15.00 WIB \n"+
                        "\t\t Senin dan libur Nasional: Tutup"));
        nP2.setTag(R.drawable.monas);

        nP3 = mMap.addMarker(new MarkerOptions()
                .position(P3)
                .title("Kebun Binatang Ragunan")
                .snippet("☞ Address: Jl. Harsono No.1, RT.10/RW.7 Ragunan, Kec. Ps. Minggu, Kota Jakarta Selatan, DKI Jakarta 12550 \n"+
                        "☞ Salah satu kebun binatang terbesar di Indonesia, sebagai taman konservasi berbagai satwa langka \n"+
                        "\t Terdapat area konservasi khusus bagi Orang Utan yaitu Pusat Primata Schmutzer\n"+
                        "☞ Telp: (021) 78847114 \n"+
                        "☞ Opening hours: \n"+
                        "\t\t Selasa-Minggu : 06.00–16.00 WIB \n"+
                        "\t\t Senin: Tutup"));
        nP3.setTag(R.drawable.monas);

        nP4 = mMap.addMarker(new MarkerOptions()
                .position(P4)
                .title("Monumen Nasional")
                .snippet("☞ Address: Gambir, Kecamatan Gambir, Kota Jakarta Pusat, Daerah Khusus Ibukota Jakarta\n"+
                        "☞ Monas adalah monumen peringatan setinggi 132 meter (433 kaki)\n"+
                        "\t Tugu Monas ini dimahkotai lidah api dilapisi lembaran emas yang melambangkan semangat perjuangan yang menyala-nyala\n"+
                        "☞ Telp: (021) 3822255\n"+
                        "☞ Opening Hours Tugu Monas:\n"+
                        "Selasa-Minggu: 07.30 – 19.00 WIB\n" +
                        "Senin: Libur.\n"+
                        "Note: Area Taman Monas: 07.00 – 24.00 WIB"));
        nP4.setTag(R.drawable.monas);

        nP5 = mMap.addMarker(new MarkerOptions()
                .position(P5)
                .title("Masjid Istiqlal")
                .snippet("☞ Address: Jl. Taman Wijaya Kusuma, Ps. Baru, Kecamatan Sawah Besar, Kota Jakarta Pusat, DKI Jakarta, 10710\n"+
                        "☞ Masjid Istiqlal adalah masjid Nasional Negara Indonesia\n"+
                        "\tsebagai masjid terbesar di asia tenggara dengan daya tampung 200.000 orang.\n"+
                        "\tTempat ibadah dan destinasi wisata yang dikemukakan oleh Presiden Soekarno\n"+
                        "☞ Opening hours: \n" +
                        "All day 04:00 – 21:00"));
        nP5.setTag(R.drawable.monas);

        nP6 = mMap.addMarker(new MarkerOptions()
                .position(P6)
                .title("Seaworld Ancol")
                .snippet("☞ Address: Jalan Lodan Timur No.7, RW.10, Ancol, Kec. Pademangan, Kota Jkt Utara, DKI Jakarta, 14430\n"+
                        "☞ Memberikan edukasi tentang biota laut,\n"+
                        "\t menyuguhkan 3 zona perairan yaitu zona perairan tawar, zona pesisir, dan zona perairan laut.\n"+
                        "☞ Telp: (021) 29222222\n"+
                        "☞ Opening Hours:\n" +
                        "Senin – Jumat  : 09.00 – 17.00 WIB\n" +
                        "Sabtu – Minggu : 09.00 – 18.00 WIB"));
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





