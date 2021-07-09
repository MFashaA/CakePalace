package com.example.cakepalace2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


    public class menuutama extends MainActivity {

        private ImageView ultah;
        private ImageView macaron;
        private ImageView cupcake;


        String pembeli2;
        String alamat2;
        String nomorpembeli;
        ImageView kue, macaroon, cupcakess;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_menuutama);

            pembeli2 = getIntent().getExtras().getString("Nama", nama_pembeli);
            alamat2 = getIntent().getExtras().getString("Alamat:", alamat_pembeli);
            nomorpembeli = getIntent().getExtras().getString("No.Telp", nomor_pembeli);

            kue = findViewById(R.id.kueultah);
            macaroon = findViewById(R.id.macaron);
            cupcakess = findViewById(R.id.cupcakesss);

            kue.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent UImenu1_ = new Intent(menuutama.this, menu1.class);

                    UImenu1_.putExtra("pembeli", nama_pembeli);
                    UImenu1_.putExtra("alamat", alamat_pembeli);
                    UImenu1_.putExtra("nomorbeli", nomor_pembeli);


                    startActivity(UImenu1_);

                }
            });

            macaroon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent UImenu2_ = new Intent(menuutama.this, menu2.class);

                    UImenu2_.putExtra("pembeli", nama_pembeli);
                    UImenu2_.putExtra("alamat", alamat_pembeli);
                    UImenu2_.putExtra("nomorbeli", nomor_pembeli);


                    startActivity(UImenu2_);

                }
            });

            cupcakess.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent UImenu3_ = new Intent(menuutama.this, menu3.class);
                    UImenu3_.putExtra("pembeli", nama_pembeli);
                    UImenu3_.putExtra("alamat", alamat_pembeli);
                    UImenu3_.putExtra("nomorbeli", nomor_pembeli);


                    startActivity(UImenu3_);

                }
            });

        }
    }

