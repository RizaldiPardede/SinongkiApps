package com.example.sinongki;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.android.volley.AuthFailureError;





import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {
    TextView username;
    TextView password;
    TextView nama;
    Button btndaftar;
    ImageView ic_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ic_back = findViewById(R.id.ic_back);
        nama = findViewById(R.id.register_nama);
        username = findViewById(R.id.register_username);
        password = findViewById(R.id.register_password);
        btndaftar = findViewById(R.id.daftar);
        ic_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(back);
            }
        });

        btndaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register("http://192.168.0.100:8000/user");
            }
        });
    }
    private void register(String url) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonRootObject = new JSONObject(response);
                    JSONArray jsonArray = jsonRootObject.optJSONArray("result");
//                    JSONObject jsonObject = jsonArray.getJSONObject(0);
//
//                    String status = jsonObject.optString("status").trim();
//                    Toast.makeText(RegisterActivity.this, status, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(intent);

                } catch (JSONException e) {
                    Toast.makeText(RegisterActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(RegisterActivity.this, "Akun ini sudah ada", Toast.LENGTH_SHORT).show();
                    }
                })
        {

            @Override
            protected Map<String, String> getParams()  {
                Map<String , String>params = new HashMap<>();
                params.put("nama",nama.getText().toString());
                params.put("email",username.getText().toString());
                params.put("password",password.getText().toString());
                return params;
            }
        };
        Volley.newRequestQueue(RegisterActivity.this).add(stringRequest);

    }
}