package com.marchika.enjoyjakarte;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.smarteist.autoimageslider.DefaultSliderView;
import com.smarteist.autoimageslider.SliderLayout;
import com.smarteist.autoimageslider.SliderView;
import com.smarteist.autoimageslider.SliderAnimations;

public class Home extends AppCompatActivity {
    private CardView wk, wb, wh, wa;
    private SliderLayout imageSlider;
    private TextView btnKeluar;
    private ImageView btnInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        wk = findViewById(R.id.wk);
        wb = findViewById(R.id.wb);
        wa = findViewById(R.id.wa);
        wh = findViewById(R.id.wh);
        btnKeluar = findViewById(R.id.btnKeluar);
        btnInfo = findViewById(R.id.btnInfo);


        wk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent u = new Intent(Home.this, Wisatakuliner.class);
                startActivity(u);
            }
        });

        wb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent u = new Intent(Home.this, WisataBelanja.class);
                startActivity(u);
            }

        });

        wa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent u = new Intent(Home.this, WisataAir.class);
                startActivity(u);
            }
        });

        wh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent u = new Intent(Home.this, WisataEdukasi.class);
                startActivity(u);
            }
        });

        btnKeluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(Home.this)
                        .setTitle("Keluar")
                        .setMessage("Terima kasih telah menggunakan aplikasi ini. Semoga membantu ☺")
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        })
                        .show();
            }
        });

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(Home.this)
                        .setTitle("Tentang")
                        .setMessage("Aplikasi 'EnjoyJakarte' dibuat oleh Marchika Retno\n" +
                                "Universitas Gunadarma \n"+
                                "September, 2019\n" +
                                "Version 1.0.0")
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        })
                        .show();
            }
        });


        imageSlider = findViewById(R.id.imageSlider);
        setSliderView();
    }

    private void setSliderView() {

        for (int i = 0; i <= 3; i++) {

            DefaultSliderView sliderView = new DefaultSliderView(this);

            switch (i) {
                case 0:
                    sliderView.setImageDrawable(R.drawable.pik3);
                    sliderView.setDescription("Waterboom Jakarta");
                    break;
                case 1:
                    sliderView.setImageDrawable(R.drawable.gi4);
                    sliderView.setDescription("Grand Indonesia Mall \n Wisata Belanja");
                    break;
                case 2:
                    sliderView.setImageDrawable(R.drawable.taican);
                    sliderView.setDescription("Taichan Goreng Senayan \n Wisata Kuliner");
                    break;
                case 3:
                    sliderView.setImageDrawable(R.drawable.dufan);
                    sliderView.setDescription("Dunia Fantasi");
                    break;
            }

            sliderView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);
            final int finalI = i;
            sliderView.setOnSliderClickListener(new SliderView.OnSliderClickListener() {
                @Override
                public void onSliderClick(SliderView sliderView) {
                    Toast.makeText(Home.this, "This is slider " + (finalI + 1), Toast.LENGTH_SHORT).show();
                }
            });
            imageSlider.addSliderView(sliderView);
        }
    }
}