package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Modif_Elim_Diario extends AppCompatActivity {
    Button bfeliz, btriste, bmeh,bfrustra, benojo, btnMod, btnElim;
    TextView muestra;
    EditText diario_esp,efecha;
    String emocion;
    Diario crud_diario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modif__elim__diario);
        btriste=(Button)findViewById(R.id.ID_triste);
        bmeh=(Button)findViewById(R.id.ID_meh);
        bfrustra=(Button)findViewById(R.id.ID_frustracion);
        benojo=(Button)findViewById(R.id.ID_enojo);
        bfeliz=(Button)findViewById(R.id.ID_feliz);
        muestra=(TextView)findViewById((R.id.ID_emoción));
        diario_esp = (EditText) findViewById(R.id.ID_Esc);
        btnMod = (Button) findViewById(R.id.btnModif);
        btnElim = (Button) findViewById(R.id.btnElim);
        efecha = (EditText) findViewById(R.id.ID_fecha);
        crud_diario = new Diario();

        String diario1="";
        String fecha1="";
        String emocion1 ="";
        Bundle extras = getIntent().getExtras();
        if(extras !=null){
            diario1 = extras.getString("hola");
            fecha1 = extras.getString("fecha");
            emocion1 = extras.getString("emocion");
        }
        diario_esp.setText(diario1);
        efecha.setText(fecha1);
        muestra.setText(emocion1);
    }

    public void onClick(View view) {

        if (bfeliz.isPressed()){
            emocion="FELIZ";
        }else if (btriste.isPressed()){
            emocion="TRISTE";
        }else if (bmeh.isPressed()){
            emocion="INDIFERENTE";
        }else if (bfrustra.isPressed()){
            emocion="FRUSTRADO";
        }else if (benojo.isPressed()){
            emocion="ENOJADO";
        }

        muestra.setText(emocion);
    }

    public void Modificar(View view){

        String fecha = efecha.getText().toString();
        String emocion = muestra.getText().toString();
        String diario = diario_esp.getText().toString();
        Context context = this;
        crud_diario.RegistrarDiario("https://ariasdavid.000webhostapp.com/editar_diario.php",fecha,emocion,diario,context);
        efecha.setText("");
        muestra.setText("");
        diario_esp.setText("");
    }

    public void Eliminar (View view){

        String fecha = efecha.getText().toString();
        crud_diario.EliminarDiario("https://ariasdavid.000webhostapp.com/eliminar_diario.php",fecha,this);
        efecha.setText("");
        muestra.setText("");
        diario_esp.setText("");
    }

    public void Atras (View view){
        Intent sig = new Intent(this, MostrarDiarios.class);
        startActivity(sig);
    }


}