package com.example.registrounivalle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    //Atributos que representen a sus views o vistas

    private TextView txtResultado;
    //Atributos o variables
    String nombre,apellido;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        inicializarVistas();
        ObtenerDatosPrimeraPantalla();
        mostrarDatos();
    }

    private void mostrarDatos() {
        txtResultado.setText(nombre+","+apellido);
    }

    private void ObtenerDatosPrimeraPantalla() {
        nombre=this.getIntent().getExtras().getString("nombre_persona","");
        apellido=this.getIntent().getExtras().getString("apellido_persona","");

    }

    private void inicializarVistas() {
        txtResultado=findViewById(R.id.BTNregistrar);
    }

}