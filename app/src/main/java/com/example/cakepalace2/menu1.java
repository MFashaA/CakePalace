package com.example.cakepalace2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class menu1 extends AppCompatActivity {

    private ImageView korean;
    private ImageView fruit;
    private ImageView blackberry;
    private ImageView keranjang;
    private CheckBox c1, c2, c3;


    String pembeli2;
    String alamat2;
    String nomorpembeli;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu1);


        pembeli2 = getIntent().getExtras().getString("pembeli", pembeli2);
        alamat2 = getIntent().getExtras().getString("alamat", alamat2);
        nomorpembeli = getIntent().getExtras().getString("nomorbeli", nomorpembeli);

        c1 = findViewById(R.id.checkBox1);
        c2 = findViewById(R.id.checkBox2);
        c3 = findViewById(R.id.checkBox3);
        ArrayList<String> menupilihan = new ArrayList<>();
        c1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (c1.isChecked()) {
                    menupilihan.add("Korean Cake");
                    Toast.makeText(getApplicationContext(), "Korean Cake Segera Disiapkan", Toast.LENGTH_SHORT).show();
                } else {
                    menupilihan.remove("Korean Cake");
                }
            }
        });
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (c2.isChecked()) {
                    menupilihan.add("Fruit Cake");
                    Toast.makeText(getApplicationContext(), "Fruit Cake Segera Disiapkan", Toast.LENGTH_SHORT).show();
                } else {
                    menupilihan.remove("Fruit Cake");
                }

            }
        });
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (c3.isChecked()) {
                    menupilihan.add("Blackberry Cake");
                    Toast.makeText(getApplicationContext(), "Blackberry Cake Segera Disiapkan", Toast.LENGTH_SHORT).show();
                } else {
                    menupilihan.remove("Blackberry Cake");
                }
            }
        });
        keranjang = (ImageView) findViewById(R.id.keranjanga);
        keranjang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent UIorder = new Intent(menu1.this, order.class);
                UIorder.putExtra("Nama", pembeli2);
                UIorder.putExtra("Alamat", alamat2);
                UIorder.putExtra("No.Telp", nomorpembeli);

                if (c1.isChecked() || c2.isChecked() || c3.isChecked()) {

                    UIorder.putExtra("MenuChecked", menupilihan);
                    startActivity(UIorder);
                } else {
                    Toast.makeText(getApplicationContext(), "Masukan Kue Ke Dalam Keranjang", Toast.LENGTH_SHORT).show();
                }

            }
        });
        korean = (ImageView) findViewById(R.id.imageView3);
        korean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Kue Dengan Cita Rasa Korea dan Dibuat Dengan Bahan Terbaik", Toast.LENGTH_LONG).show();
            }
        });
        fruit = (ImageView) findViewById(R.id.imageView4);
        fruit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Buah Segar Yang Dijadikan Bahan Pilihan Terasa Sangat Segar Ketika Dimulut", Toast.LENGTH_LONG).show();
            }
        });
        blackberry = (ImageView) findViewById(R.id.imageView5);
        blackberry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Blackberry For Your Life!", Toast.LENGTH_LONG).show();
            }
        });

    }
}