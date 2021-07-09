package com.example.cakepalace2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class order extends MainActivity {
    TextView infonama, infoaalamat, nomortelepon, infomakanan, resi_, lihatresi;
    String in, in2, in3, ia, ia2, ia3, nop, nop2, nop3, po="pesanan";
    RadioButton k1, k2, k3;
    ImageView K;
    database db;
    public void onCreate(Bundle savedInstanceStates){
        super.onCreate(savedInstanceStates);
        setContentView(R.layout.activity_order);

        infonama = findViewById(R.id.pembeliii);
        in = getIntent().getExtras().getString("Nama",nama_pembeli);
        infonama.setText(in);
        infoaalamat = findViewById(R.id.nomorrumah);
        ia = getIntent().getExtras().getString("Alamat",alamat_pembeli);
        infoaalamat.setText(ia);
        nomortelepon = findViewById(R.id.hengpon);
        nop = getIntent().getExtras().getString("No. Telp", nomor_pembeli);

        infonama = findViewById(R.id.pembeliii);
        in = getIntent().getExtras().getString("Nama",nama_pembeli);
        infonama.setText(in);
        infoaalamat = findViewById(R.id.nomorrumah);
        ia = getIntent().getExtras().getString("Alamat",alamat_pembeli);
        infoaalamat.setText(ia);
        nomortelepon = findViewById(R.id.hengpon);
        nop = getIntent().getExtras().getString("No. Telp", nomor_pembeli);

        infonama = findViewById(R.id.pembeliii);
        in = getIntent().getExtras().getString("Nama",nama_pembeli);
        infonama.setText(in);
        infoaalamat = findViewById(R.id.nomorrumah);
        ia = getIntent().getExtras().getString("Alamat",alamat_pembeli);
        infoaalamat.setText(ia);
        nomortelepon = findViewById(R.id.hengpon);
        nop = getIntent().getExtras().getString("No. Telp", nomor_pembeli);

        infomakanan = findViewById(R.id.menupilihan);
        Bundle bundle = getIntent().getExtras();
        ArrayList<String> array_list = (ArrayList<String>) getIntent().getSerializableExtra("menuchecked");
        infomakanan.setText(String.valueOf(array_list));
        ArrayList <String> ik = new ArrayList<>();

        k1 = findViewById(R.id.gofut);
        k2 = findViewById(R.id.grabfut);
        k3 = findViewById(R.id.syopi);
        k1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (k1.isChecked()){
                    Toast.makeText(getApplicationContext(), "Pengiriman Melalui Go-Food Telah Dipilih", Toast.LENGTH_SHORT).show();
                    k1.setEnabled(false);
                    k2.setEnabled(false);
                    k3.setEnabled(false);
                    ik.add("Go-Food akan segera mengantar pesanan");
                    ik.remove("Grab-Food akan segera mengantar pesanan");
                    ik.remove("Shopee-Food akan segera mengantar pesanan");
                }

            }
        });
        k2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (k2.isChecked()){
                    Toast.makeText(getApplicationContext(), "Pengiriman Melalui Grab-Food Telah Dipilih", Toast.LENGTH_SHORT).show();
                    k1.setEnabled(false);
                    k2.setEnabled(false);
                    k3.setEnabled(false);
                    ik.add("Grab-Food akan segera mengantar pesanan");
                    ik.remove("Go-Food akan segera mengantar pesanan");
                    ik.remove("Shopee-Food akan segera mengantar pesanan");
                }

            }
        });
        k3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (k3.isChecked()){
                    Toast.makeText(getApplicationContext(), "Pengiriman Melalui Shopee-Food Telah Dipilih", Toast.LENGTH_SHORT).show();
                    k1.setEnabled(false);
                    k2.setEnabled(false);
                    k3.setEnabled(false);
                    ik.add("Shopee-Food akan segera mengantar pesanan");
                    ik.remove("Go-Food akan segera mengantar pesanan");
                    ik.remove("Grab-Food akan segera mengantar pesanan");
                }

            }
        });

        K = findViewById(R.id.kiriman);
        resi_ = findViewById(R.id.resi);
        String namaresi = infonama.getText().toString();
        String makananresi = infomakanan.getText().toString();
        K.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (k1.isChecked()||k2.isChecked()||k3.isChecked()){
                    resi_.setText("Terima kasih Sudah Membeli, "+namaresi+", anda telah memesan\n"+makananresi+"\n Dengan Pengiriman :\n"+ik);
                    k1.setEnabled(false);
                    k2.setEnabled(false);
                    k3.setEnabled(false);

                    String namaorang = in;
                    String alamatorang = ia;
                    String nomororang = nop;
                    String pesananorang = po;

                    Boolean cekdata = db.insertdatatransaksi(namaorang, alamatorang, nomororang, pesananorang);
                    if (cekdata==true){
                        Toast.makeText(order.this, "Data Tersimpan", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(order.this, "Data Error", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(getApplicationContext(), "Sebelum pesan, mohon pilih metode pengiriman", Toast.LENGTH_SHORT).show();
                }


            }
        });
        lihatresi = findViewById(R.id.resiii);
        lihatresi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor kwitansi = db.getdatatransaksi();
                if (kwitansi.getCount()==0){
                    Toast.makeText(order.this, "Tidak Ada Data", Toast.LENGTH_SHORT). show();
                }
                StringBuffer buffer = new StringBuffer();
                while (kwitansi.moveToNext()){
                    buffer.append("Nama Pemesanan :"+ kwitansi.getString(0)+"\n");
                    buffer.append("Alamat :"+kwitansi.getString(1)+"\n");
                    buffer.append("No. Telp :"+kwitansi.getString(2)+"\n");
                    buffer.append("Pesanan :"+kwitansi.getString(3)+"\n\n");
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(order.this);
                builder.setCancelable(true);
                builder.setTitle("Daftar Pesanan");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });

    }
}