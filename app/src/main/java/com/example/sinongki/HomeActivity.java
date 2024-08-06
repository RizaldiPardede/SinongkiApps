package com.example.sinongki;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HomeActivity extends AppCompatActivity {
    RecyclerView rvMinuman;
    Button pesan;
    Button konfirmasiPesanan;
//    RecyclerView rvMakanan;
    LinearLayoutManager linearLayoutManager;
    private MinumanAdapter minumanAdapter;
//    private MakananAdapter makananAdapter;
    private ArrayList<MinumanModel> minumanList = new ArrayList<>();
    private ArrayList<MakananModel> makananList = new ArrayList<>();

    TextView user;
    Bundle extras;
    String text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        user = findViewById(R.id.homeNama);
        extras = getIntent().getExtras();
        text = extras.getString("email");
        user.setText(String.valueOf(text));
        konfirmasiPesanan = findViewById(R.id.konfirmasi);
        showmenu("http://192.168.0.100:8000/menu");
//        minumanList.add(new MinumanModel("ES Jeruk", "10.000"));
//        minumanList.add(new MinumanModel("Es Teh", "5.000"));
//        minumanList.add(new MinumanModel("Nasi Goreng", "15.000"));
//        minumanList.add(new MinumanModel("Pecel", "15.000"));

//        makananList.add(new MakananModel("Nasi Goreng", "15.000"));
//        makananList.add(new MakananModel("Mie Goreng", "15.000"));

        rvMinuman = findViewById(R.id.rv_minuman);
//        rvMakanan = findViewById(R.id.rv_makanan);
//        makananAdapter = new MakananAdapter(this, makananList);
        minumanAdapter = new MinumanAdapter(this, minumanList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(HomeActivity.this);
        RecyclerView.LayoutManager layoutManagerMakanan = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true);
        rvMinuman.setLayoutManager(layoutManager);
//        rvMakanan.setLayoutManager(layoutManagerMakanan);
        rvMinuman.setAdapter(minumanAdapter);
//        rvMakanan.setAdapter(makananAdapter);
        konfirmasiPesanan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, PesananActivity.class);
                startActivity(intent);
            }
        });
    }

    private void showmenu(String JSON_URL) {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, JSON_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonRootObject = new JSONObject(response);
                    JSONArray jsonArray = jsonRootObject.optJSONArray("menu");
//                    System.out.println(jsonArray);
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject object = jsonArray.getJSONObject(i);
                        System.out.println(object);
                        String nama = object.getString("nama_menu").trim();
                        int Harga = object.getInt("harga");
                        String jenis = object.getString("jenis").trim();

                        minumanList.add(new MinumanModel(nama, Harga,jenis));
                    }
//                    for(int i=0;i<jsonArray.length();i++){
//                        JSONObject jsonObject = jsonArray.getJSONObject(i);
//                        MinumanModel menu = new MinumanModel();
//                        menu.setNamaMinuman(jsonObject.optString("nama_menu").trim());
//                        menu.setHargaMinuman(jsonObject.optInt("harga"));
//                        menu.setJenis(jsonObject.optString("jenis").trim());
//                        minumanList.add(menu);
//                    }



                } catch (JSONException e) {
                    Toast.makeText(HomeActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(HomeActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                })
        {

            @Override
            protected Map<String, String> getParams()  {
                Map<String , String>params = new HashMap<>();
                return params;
            }
        };
        Volley.newRequestQueue(HomeActivity.this).add(stringRequest);

    }


}