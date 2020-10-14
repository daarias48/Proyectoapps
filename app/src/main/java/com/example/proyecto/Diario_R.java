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

import java.util.Calendar;


public class Diario_R extends AppCompatActivity {
    TextView muestra;
    EditText efecha;
    Button bfeliz,btriste,bmeh,bfrutra,benojo;
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
}