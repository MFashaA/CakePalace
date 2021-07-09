package com.example.cakepalace2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public String nama_pembeli;
    public String alamat_pembeli;
    public String nomor_pembeli;

    EditText n_p;
    EditText a_p;
    EditText no_p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Tombol Submit
        Button SUBMIT = (Button) findViewById(R.id.masuk);
        n_p = findViewById(R.id.nama);
        a_p = findViewById(R.id.alamat);
        no_p = findViewById(R.id.telpon);
        SUBMIT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent UImenu = new Intent(MainActivity.this, menuutama.class);
                Intent UImenu1 = new Intent(MainActivity.this, menu1.class);
                Intent UImenu2 = new Intent(MainActivity.this,menu2.class);
                Intent UImenu3 = new Intent(MainActivity.this,menu3.class);
                Intent UIorder = new Intent(MainActivity.this,order.class);
                nama_pembeli = n_p.getText().toString();
                alamat_pembeli = a_p.getText().toString();
                nomor_pembeli = no_p.getText().toString();

                UImenu.putExtra("Nama", nama_pembeli);
                UImenu.putExtra("Alamat", alamat_pembeli);
                UImenu.putExtra("No.Telp", nomor_pembeli);
                UImenu1.putExtra("Nama", nama_pembeli);
                UImenu1.putExtra("Alamat", alamat_pembeli);
                UImenu1.putExtra("No.Telp", nomor_pembeli);
                UImenu2.putExtra("Nama",nama_pembeli);
                UImenu2.putExtra("Alamat",alamat_pembeli);
                UImenu2.putExtra("No.Telp",nomor_pembeli);
                UImenu3.putExtra("Nama",nama_pembeli);
                UImenu3.putExtra("Alamat",alamat_pembeli);
                UImenu3.putExtra("No.Telp",nomor_pembeli);

                startActivity(UImenu);
            }

        });

    }

}