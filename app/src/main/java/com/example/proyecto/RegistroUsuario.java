package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Context;
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
    CRUD_usuario crud;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);

        nom = (EditText) findViewById(R.id.ENombre);
        nomusu = (EditText) findViewById(R.id.ENousu);
        correo = (EditText) findViewById(R.id.ECorreo);
        contra = (EditText) findViewById(R.id.ECon);
        confcon = (EditText) findViewById(R.id.EContra);
        crud = new CRUD_usuario();

    }

    public void Registrar (View view){
        String corr = correo.getText().toString();
        String nomb = nom.getText().toString();
        String nombusu = nomusu.getText().toString();
        String cont = contra.getText().toString();
        Context context = this;
        if (contra.getText().toString().equals(confcon.getText().toString())) {
            crud.Registrar("https://ariasdavid.000webhostapp.com/insertar_usuario.php", corr, nomb, nombusu, cont, context);
            //ejecutarServicio("http://192.168.0.7:80/proyectoapps/insertar_usuario.php");
            correo.setText("");
            nom.setText("");
            nomusu.setText("");
            contra.setText("");
            confcon.setText("");
        }else {
            Toast.makeText(this,"La contraseña es incorrecta. Verifíquela",Toast.LENGTH_SHORT).show();
        }
    }

    public void Atras (View view){
            Intent next= new Intent(this,PantallaPrincipal.class);
            startActivity(next);

    }

}