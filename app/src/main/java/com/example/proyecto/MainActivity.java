package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
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
    CRUD_usuario crud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        correo = (EditText) findViewById(R.id.correo);
        contra = (EditText) findViewById(R.id.contra);
        aux = (TextView) findViewById(R.id.Aux);
        crud = new CRUD_usuario();
    }

    public void Atras (View view){
        Intent sig = new Intent(this, PantallaPrincipal.class);
        startActivity(sig);
    }


    public void Ingresar (View view) {
        Context context = this;
        crud.InicioSesion("https://ariasdavid.000webhostapp.com/buscar_usuario.php?correo=" + correo.getText() + "&contrasena=" + contra.getText(),aux,contra,context);
        int a= crud.x;
        if (a==1 & !aux.getText().toString().isEmpty()) {
            in = new Intent(this, Resp.class);
            startActivity(in);

        }
    }


}