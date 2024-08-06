package com.example.sinongki;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
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

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {
    TextView register;
    ImageButton btn_login;
    TextView email;
    TextView password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        register = findViewById(R.id.register);
        btn_login = findViewById(R.id.btn_login);
        email = findViewById(R.id.login_username);
        password = findViewById(R.id.login_password);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_register = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent_register);
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login("http://192.168.0.100:8000/user/login");
            }
        });
    }
    private void login(String url) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonRootObject = new JSONObject(response);
//                    JSONArray jsonArray = jsonRootObject.optJSONArray("result");
//                    JSONObject jsonObject = jsonArray.getJSONObject(0);

                    String status = jsonRootObject.optString("message").trim();
                    int id_status = jsonRootObject.optInt("id_user");
                        if(status.equals("Successfully logged in")){
                            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                            intent.putExtra("email", email.getText().toString());
                            startActivity(intent);
                        }
                        else{
                            Toast.makeText(LoginActivity.this, "Gagal login", Toast.LENGTH_SHORT).show();
                        }
//                    Toast.makeText(RegisterActivity.this, status, Toast.LENGTH_SHORT).show();
//                    Intent intent = new Intent(LoginActivity.this, LoginActivity.class);
//                    startActivity(intent);

                } catch (JSONException e) {
                    Toast.makeText(LoginActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(LoginActivity.this, "email atau password yang kamu masukkan salah", Toast.LENGTH_SHORT).show();
                    }
                })
        {

            @Override
            protected Map<String, String> getParams()  {
                Map<String , String>params = new HashMap<>();
                params.put("email",email.getText().toString());
                params.put("password",password.getText().toString());
                return params;
            }
        };
        Volley.newRequestQueue(LoginActivity.this).add(stringRequest);

    }
}