package com.example.cakepalace2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class menu3 extends AppCompatActivity {

    private ImageView blueberry;
    private ImageView unicorn;
    private ImageView stroberi;
    private ImageView keranjang;
    private CheckBox c1, c2, c3;


    String pembeli2;
    String alamat2;
    String nomorpembeli;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu3);


        pembeli2 = getIntent().getExtras().getString("Nama", pembeli2);
        alamat2 = getIntent().getExtras().getString("Alamat:", alamat2);
        nomorpembeli = getIntent().getExtras().getString("No.Telp:", nomorpembeli);


        c1 = findViewById(R.id.checkBox7);
        c2 = findViewById(R.id.checkBox8);
        c3 = findViewById(R.id.checkBox9);
        ArrayList<String> menupilihan = new ArrayList<>();
        c1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (c1.isChecked()) {
                    menupilihan.add("Bluberry Cupcake");
                    Toast.makeText(getApplicationContext(), "Blueberry Cupcake Segera Disiapkan", Toast.LENGTH_SHORT).show();
                } else {
                    menupilihan.remove("Blueberry Cupcake");
                }
            }
        });
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (c2.isChecked()) {
                    menupilihan.add("Unicorn Cupcake");
                    Toast.makeText(getApplicationContext(), "Unicorn Cupcake Segera Disiapkan", Toast.LENGTH_SHORT).show();
                } else {
                    menupilihan.remove("Unicorn Cupcake");
                }

            }
        });
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (c3.isChecked()) {
                    menupilihan.add("Strawberry Cupcake");
                    Toast.makeText(getApplicationContext(), "Strawberry Cupcake Segera Disiapkan", Toast.LENGTH_SHORT).show();
                } else {
                    menupilihan.remove("Strawberry Cupcake");
                }
            }
        });
        keranjang = (ImageView) findViewById(R.id.keranjangc);
        keranjang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent UIorder = new Intent(menu3.this, order.class);
                UIorder.putExtra("Nama", pembeli2);
                UIorder.putExtra("Alamat", alamat2);
                UIorder.putExtra("Nomortelpon", nomorpembeli);


                if (c1.isChecked() || c2.isChecked() || c3.isChecked()) {

                    UIorder.putExtra("MenuChecked", menupilihan);
                    startActivity(UIorder);
                } else {
                    Toast.makeText(getApplicationContext(), "Masukan Macaron Ke Dalam Keranjang", Toast.LENGTH_SHORT).show();
                }

            }
        });
        blueberry = (ImageView) findViewById(R.id.imageView9);
        blueberry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Cupcake Bluberry! Pilihan terbaik untuk menemani si kecil", Toast.LENGTH_LONG).show();
            }
        });
        unicorn = (ImageView) findViewById(R.id.imageView10);
        unicorn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Cupcake Unicorn! Anak anda pasti sangat menyukai bentuknya", Toast.LENGTH_LONG).show();
            }
        });
        stroberi = (ImageView) findViewById(R.id.imageView11);
        stroberi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Cupcake Strawberry! Rasa asam manis yang muncul bersama senyum anak anda wkwk", Toast.LENGTH_LONG).show();
            }
        });

    }
}