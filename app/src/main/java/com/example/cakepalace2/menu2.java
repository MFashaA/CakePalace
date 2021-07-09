package com.example.cakepalace2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class menu2 extends AppCompatActivity {

    private ImageView strawberry;
    private ImageView oreo;
    private ImageView mix;
    private ImageView keranjang;
    private CheckBox c1, c2, c3;


    String pembeli2;
    String alamat2;
    String nomorpembeli;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu2);

        pembeli2 = getIntent().getExtras().getString("Nama", pembeli2);
        alamat2 = getIntent().getExtras().getString("Alamat:", alamat2);
        nomorpembeli = getIntent().getExtras().getString("No.Telp:", nomorpembeli);
        c1 = findViewById(R.id.checkBox4);
        c2 = findViewById(R.id.checkBox5);
        c3 = findViewById(R.id.checkBox6);
        ArrayList<String> menupilihan = new ArrayList<>();
        c1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (c1.isChecked()) {
                    menupilihan.add("Macaron Strawberry");
                    Toast.makeText(getApplicationContext(), "Macaron Strawberry Segera Disiapkan", Toast.LENGTH_SHORT).show();
                } else {
                    menupilihan.remove("Macaron Strawberry");
                }
            }
        });
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (c2.isChecked()) {
                    menupilihan.add("Macaron Oreo");
                    Toast.makeText(getApplicationContext(), "Macaron Oreo Segera Disiapkan", Toast.LENGTH_SHORT).show();
                } else {
                    menupilihan.remove("Macaron Oreo");
                }

            }
        });
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (c3.isChecked()) {
                    menupilihan.add("Mix Macaron");
                    Toast.makeText(getApplicationContext(), "Mix Macaron Segera Disiapkan", Toast.LENGTH_SHORT).show();
                } else {
                    menupilihan.remove("Mix Macaron");
                }
            }
        });
        keranjang = (ImageView) findViewById(R.id.keranjangb);
        keranjang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent UIorder = new Intent(menu2.this, order.class);
                UIorder.putExtra("Nama", pembeli2);
                UIorder.putExtra("Alamat", alamat2);
                UIorder.putExtra("No.Telp", nomorpembeli);

                if (c1.isChecked() || c2.isChecked() || c3.isChecked()) {

                    UIorder.putExtra("MenuChecked", menupilihan);
                    startActivity(UIorder);
                } else {
                    Toast.makeText(getApplicationContext(), "Masukan Macaron Ke Dalam Keranjang", Toast.LENGTH_SHORT).show();
                }

            }
        });
        strawberry = (ImageView) findViewById(R.id.imageView6);
        strawberry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Macaron Strawberry! Pilihan yang tepat untuk menemani anda berbincang dengan kerabat.", Toast.LENGTH_LONG).show();
            }
        });
        oreo = (ImageView) findViewById(R.id.imageView7);
        oreo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Macaron Oreo! Anda pasti akan suka dengan rempah ciri khas rempah oreonya", Toast.LENGTH_LONG).show();
            }
        });
        mix = (ImageView) findViewById(R.id.imageView8);
        mix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Perpaduan setiap rasa macaron menjadikan rasa yang tepat di dalam mulut anda", Toast.LENGTH_LONG).show();
            }
        });

    }
}