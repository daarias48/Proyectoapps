package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class RegistroUsuario extends AppCompatActivity {

    private EditText nom,correo,contra,confcon,nomusu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);

        nom = (EditText) findViewById(R.id.ENombre);
        nomusu = (EditText) findViewById(R.id.ENousu);
        correo = (EditText) findViewById(R.id.ECorreo);
        contra = (EditText) findViewById(R.id.ECon);
        confcon = (EditText) findViewById(R.id.EContra);

    }

    public void ejecutarServicio (String URL){
        StringRequest stringRequest = new StringRequest(Request.Method.POST,URL, new Response.Listener<String>(){

            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(),"Operación exitosa", Toast.LENGTH_SHORT).show();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> parametros = new HashMap<String,String>();
                parametros.put("correo",correo.getText().toString());
                parametros.put("nombre",nom.getText().toString());
                parametros.put("nombreusu",nomusu.getText().toString());
                parametros.put("contrasena",contra.getText().toString());
                return parametros;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);


        nom = (EditText) findViewById(R.id.ENombre);
        nomusu = (EditText) findViewById(R.id.ENousu);
        correo = (EditText) findViewById(R.id.ECorreo);
        contra = (EditText) findViewById(R.id.ECon);
        confcon = (EditText) findViewById(R.id.EContra);

    }

    public void Registrar (View view){

        ejecutarServicio("https://ariasdavid.000webhostapp.com/insertar_usuario.php");
        //ejecutarServicio("http://192.168.0.7:80/proyectoapps/insertar_usuario.php");
    }

    public void Atras (View view){
        Intent sig = new Intent(this, MainActivity.class);
        startActivity(sig);
    }


    public void ejecutarServicio (String URL){
        StringRequest stringRequest = new StringRequest(Request.Method.POST,URL, new Response.Listener<String>(){

            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(),"Operación exitosa", Toast.LENGTH_SHORT).show();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> parametros = new HashMap<String,String>();
                parametros.put("correo",correo.getText().toString());
                parametros.put("nombre",nom.getText().toString());
                parametros.put("nombreusu",nomusu.getText().toString());
                parametros.put("contrasena",contra.getText().toString());
                return parametros;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }

    public void Registrar (View view){

        ejecutarServicio("https://ariasdavid.000webhostapp.com/insertar_usuario.php");
        //ejecutarServicio("http://192.168.0.7:80/proyectoapps/insertar_usuario.php");
    }

}