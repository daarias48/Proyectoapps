package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    public EditText correo, contra;
    public TextView aux;
    Intent in;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        correo = (EditText) findViewById(R.id.correo);
        contra = (EditText) findViewById(R.id.contra);
        aux = (TextView) findViewById(R.id.Aux);
    }

    public void Atras (View view){
        Intent sig = new Intent(this, PantallaPrincipal.class);
        startActivity(sig);
    }

    public void Buscar (String URL){
        Toast.makeText(getApplicationContext(), "Cargando...", Toast.LENGTH_SHORT).show();
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                JSONObject jsonObject = null;
                for (int i = 0; i < response.length(); i++) {
                    try {
                        jsonObject = response.getJSONObject(i);
                        aux.setText(jsonObject.getString("contrasena"));

                        if (aux.getText().toString().equals(contra.getText().toString())){
                            in= new Intent(getApplicationContext(), Resp.class);
                            startActivity(in);
                        }


                    } catch (JSONException e) {
                        Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "No está registrado", Toast.LENGTH_SHORT).show();
            }
        }
        );
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);
    }

    public void Ingresar (View view) {
        Buscar("https://ariasdavid.000webhostapp.com/buscar_usuario.php?correo=" + correo.getText() + "&contrasena=" + contra.getText());

    }


}