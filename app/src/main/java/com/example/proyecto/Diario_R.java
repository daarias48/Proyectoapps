package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import android.widget.TextView;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;


public class Diario_R extends AppCompatActivity {
    TextView muestra;
    EditText efecha;
    Button bfeliz,btriste,bmeh,bfrutra,benojo;
    EditText diario;

    private  int dia,mes,anio;
    private String emocion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diario__r);
        efecha=(EditText)findViewById(R.id.ID_fecha);
        btriste=(Button)findViewById(R.id.ID_triste);
        bmeh=(Button)findViewById(R.id.ID_meh);
        bfrutra=(Button)findViewById(R.id.ID_frustracion);
        benojo=(Button)findViewById(R.id.ID_enojo);
        bfeliz=(Button)findViewById(R.id.ID_feliz);
        muestra=(TextView)findViewById((R.id.ID_emoción));
        diario = (EditText) findViewById(R.id.ID_Esc);
    }

    public void onClick(View view) {

        if (bfeliz.isPressed()){
            emocion="FELIZ";
        }else if (btriste.isPressed()){
            emocion="TRISTE";
        }else if (bmeh.isPressed()){
            emocion="INDIFERENTE";
        }else if (bfrutra.isPressed()){
            emocion="FRUSTRADO";
        }else if (benojo.isPressed()){
            emocion="ENOJADO";
        }

        muestra.setText(emocion);

    }

    public void  Calendario (View view){
        final Calendar c= Calendar.getInstance();
        dia=c.get(Calendar.DAY_OF_MONTH);
        mes=c.get(Calendar.MONTH);
        anio=c.get(Calendar.YEAR);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                efecha.setText(dayOfMonth+"/"+(monthOfYear+1)+"/"+year);
            }
        }
                ,dia,mes,anio);
        datePickerDialog.show();
    }


    public void ejecutarServicio (String URL){
        StringRequest stringRequest = new StringRequest(Request.Method.POST,URL, new Response.Listener<String>(){

            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(),"Diario registrado", Toast.LENGTH_SHORT).show();

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
                parametros.put("fecha",efecha.getText().toString());
                parametros.put("emocion",muestra.getText().toString());
                parametros.put("diario",diario.getText().toString());
                return parametros;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }

    public void RegisDiario (View view){
        ejecutarServicio("https://ariasdavid.000webhostapp.com/insertar_diario.php");
    }

    public void Atras (View view){
        Intent sig = new Intent(this, Pantalla_inicio.class);
        startActivity(sig);
    }
}