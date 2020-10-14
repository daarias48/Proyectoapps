package com.example.proyecto;

import android.content.Context;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class CRUD_usuario {

    int x;
    MainActivity m = new MainActivity();

    public void Registrar (String URL, final String correo, final String nombre, final String nombreusu, final String contrasena, final Context context){
        StringRequest stringRequest = new StringRequest(Request.Method.POST,URL, new Response.Listener<String>(){

            @Override
            public void onResponse(String response) {
                Toast.makeText(context,"Registrado correctamente", Toast.LENGTH_SHORT).show();

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
                parametros.put("correo",correo);
                parametros.put("nombre",nombre);
                parametros.put("nombreusu",nombreusu);
                parametros.put("contrasena",contrasena);
                return parametros;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }

    public int InicioSesion (String URL, final TextView aux, final TextView contra, final Context context){

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                JSONObject jsonObject = null;
                for (int i = 0; i < response.length(); i++) {
                    try {
                        jsonObject = response.getJSONObject(i);
                        aux.setText(jsonObject.getString("contrasena"));

                            if (aux.getText().toString().equals(contra.getText().toString())) {
                                Toast.makeText(context, "Cargando...", Toast.LENGTH_SHORT).show();
                                x = 1;
                            }
                    } catch (JSONException e) {
                        Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();

                    }

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "No está registrado", Toast.LENGTH_SHORT).show();
            }
        }
        );
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(jsonArrayRequest);
        return x;
    }

}
