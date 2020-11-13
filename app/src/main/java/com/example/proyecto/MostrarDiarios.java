package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MostrarDiarios extends AppCompatActivity implements Response.ErrorListener, Response.Listener<JSONObject> {

    RecyclerView recyclerDiario;
    ArrayList<InfoDiario> listaDiario;
    MainActivity main = new MainActivity();

    ProgressDialog progress;
    RequestQueue request;
    JsonObjectRequest json;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_diarios);
        listaDiario = new ArrayList<>();
        recyclerDiario = (RecyclerView) findViewById(R.id.recyclerDiario);
        recyclerDiario.setLayoutManager(new LinearLayoutManager(this.getApplicationContext()));
        recyclerDiario.setHasFixedSize(true);
        request = Volley.newRequestQueue(getApplicationContext());

        cargarWebService();
    }

    public void cargarWebService(){
        progress = new ProgressDialog(getApplicationContext());
        progress.setMessage("Cargando...");
        String parametro = main.usuario;
        String url = "https://ariasdavid.000webhostapp.com/consulta_diario.php?correo_usu="+parametro;

        json = new JsonObjectRequest(Request.Method.GET,url,null,this,this);
        request.add(json);

    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(this,"No se encontraron diarios registrados",Toast.LENGTH_SHORT).show();
        System.out.println();
        Log.d("Error: ", error.toString());
        progress.hide();

    }

    @Override
    public void onResponse(JSONObject response) {
        InfoDiario infoDiario = null;

        try {
            JSONArray jsonArray = response.optJSONArray("diario");

            for (int i = 0; i<jsonArray.length();i++){
                infoDiario = new InfoDiario();
                JSONObject jsonObject = null;
                jsonObject = jsonArray.getJSONObject(i);
                infoDiario.setId(jsonObject.optInt("id"));
                infoDiario.setFecha(jsonObject.optString("fecha"));
                infoDiario.setEmocion(jsonObject.optString("emocion"));
                infoDiario.setTexto(jsonObject.optString("diario"));
                listaDiario.add(infoDiario);
            }
        progress.hide();
        final DiarioAdapter adapter = new DiarioAdapter(listaDiario);
        adapter.SetOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = String.valueOf(listaDiario.get(recyclerDiario.getChildAdapterPosition(v)).getId());
                String diario = listaDiario.get(recyclerDiario.getChildAdapterPosition(v)).getTexto();
                String fecha = listaDiario.get(recyclerDiario.getChildAdapterPosition(v)).getFecha();
                String emocion = listaDiario.get(recyclerDiario.getChildAdapterPosition(v)).getEmocion();
                Intent intent = new Intent(getApplicationContext(), Modif_Elim_Diario.class);
                intent.putExtra("id",id);
                intent.putExtra("hola",diario);
                intent.putExtra("fecha",fecha);
                intent.putExtra("emocion",emocion);
                getApplicationContext().startActivity(intent);
            }
        });
        recyclerDiario.setAdapter(adapter);

        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(this,"No se pudo",Toast.LENGTH_SHORT).show();
            progress.hide();
        }
    }

    public void Agregar (View view){
            Intent sig = new Intent(this, Diario_R.class);
            startActivity(sig);
    }

    public void Atras (View view){
        Intent sig = new Intent(this, Pantalla_inicio.class);
        startActivity(sig);
    }
}