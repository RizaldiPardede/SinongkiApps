package com.example.sinongki;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class PesananActivity extends AppCompatActivity {
    RecyclerView rv_Pesanan;
    private PesananAdapter pesananAdapter;
//    private ArrayList<PesananModel> pesananList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesanan);
//        pesananList.add(new PesananModel("Nasi Goreng", "15.000", 3));
//        pesananList.add(new PesananModel("Miew Goreng", "15000", 2));

//        rv_Pesanan = findViewById(R.id.rv_pemesanan);
//        pesananAdapter = new PesananAdapter(PesananActivity.this, pesananList);
//        RecyclerView.LayoutManager layoutManager2 = new LinearLayoutManager(PesananActivity.this);
//        rv_Pesanan.setLayoutManager(layoutManager2);
//        rv_Pesanan.setAdapter(pesananAdapter);



    }
}