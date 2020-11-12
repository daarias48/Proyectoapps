package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Context;
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
    EditText diario_esp;

    public int dia,mes,anio;
    public String emocion;

    Diario crud_diario;
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
        diario_esp = (EditText) findViewById(R.id.ID_Esc);
        crud_diario = new Diario();
        String value="";
        Bundle extras = getIntent().getExtras();
        if(extras !=null){
            value = extras.getString("hola");
        }
        diario_esp.setText(value);
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
        Context context = this;
        crud_diario.Calendario(dia,mes,anio,efecha,context);
    }

    public void RegisDiario (View view){
        String fecha = efecha.getText().toString();
        String emocion = muestra.getText().toString();
        String diario = diario_esp.getText().toString();
        Context context = this;
        crud_diario.RegistrarDiario("https://ariasdavid.000webhostapp.com/insertar_diario.php",fecha,emocion,diario,context);
        efecha.setText("");
        muestra.setText("");
        diario_esp.setText("");

    }

    public void Atras (View view){
        Intent sig = new Intent(this, Pantalla_inicio.class);
        startActivity(sig);
    }
}