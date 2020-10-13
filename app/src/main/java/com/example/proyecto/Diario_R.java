package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import android.widget.DatePicker;

import java.util.Calendar;


public class Diario_R extends AppCompatActivity {
    EditText efecha;
    private  int dia,mes,anio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diario__r);
        efecha=(EditText)findViewById(R.id.ID_fecha);
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