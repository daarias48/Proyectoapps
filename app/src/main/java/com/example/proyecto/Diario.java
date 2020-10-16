package com.example.proyecto;

import android.app.DatePickerDialog;
import android.content.Context;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class Diario {

    public void RegistrarDiario (String URL, final String fecha, final String emocion, final String diario, final Context context){
        StringRequest stringRequest = new StringRequest(Request.Method.POST,URL, new Response.Listener<String>(){

            @Override
            public void onResponse(String response) {
                Toast.makeText(context,"Diario registrado", Toast.LENGTH_SHORT).show();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context,error.toString(),Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override

            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> parametros = new HashMap<String,String>();
                parametros.put("fecha",fecha);
                parametros.put("emocion",emocion);
                parametros.put("diario",diario);
                return parametros;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }

    public void Calendario (int dia, int mes, int anio, final EditText efecha, Context context){
        final Calendar c = Calendar.getInstance();
        dia=c.get(Calendar.DAY_OF_MONTH);
        mes=c.get(Calendar.MONTH);
        anio=c.get(Calendar.YEAR);

        DatePickerDialog datePickerDialog = new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                efecha.setText(dayOfMonth+"/"+(monthOfYear+1)+"/"+year);
            }
        }
                ,dia,mes,anio);
        datePickerDialog.show();
    }
}
