package com.example.registrounivalle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.chip.ChipGroup;

public class MainActivity extends AppCompatActivity {

    private EditText ETnombre;
    private EditText ETapellido;
    private EditText ETcorreo;
    private EditText ETcelular;
    private EditText ETcodigo;
    private Button BTNregistrar;
    private Switch SWestudiantes;
    //DATO PRIMITIVO=DATO BÁSICO STRING BOLEEAN INT ETC
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializarVistas();
        ETcodigo.setVisibility(View.GONE);

        BTNregistrar.setOnClickListener(view -> {
            Validar();
            pasarPantalla();
        });
        SWestudiantes.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                gestionarVistaCodigo(b);
            }
        });

    }

    private void pasarPantalla()
    {
        /*Para pasar o navegar entre pantallas van a utilizar el componente llamado INTENT
        DEEN CREAR UNA INSTANCIA DE LA CLASE DENOMINADA INTENT COMO PARÁMETROS AL CONSTRUCTOR DE ESA CLASE VAN A PASAR A
        PRAMETROS
        OAR1: DE DONDE O DE QUE PANTALLA VAN A VENIR
        PAR2:  A DPNDE O A QUE PANTALLA VAN A IR
        ESTOS PAREAMETROS DEBEN REPRESENTAR EÑ CPNTEXTO O AMBITO
        DE LAS CLASES QUE REPRESENTAN A ESAS PANTALLAS
        EN REALIDAD EL METODO QUE LANZARA LA PANTALLA SE LLAMA START ACTIVITY PERO ESTE NECESITA QUE EL INTENT HAYA RESULTO
         EL DESEO DE PASO DE PANTALLAS, SIUESO HA PASADO IRAN A LA OTRA PANTALLA CASO CONTRARIO FALLARA
        * */
        Intent intencion= new Intent(this, HomeActivity.class);
        //CONFIGURAR PASO DE DATOS ENTRE PANTALLAS USANDO UN INTENT
        /*
        1EL INTENT TIENE DIGAMOS UN ARCHIVO TEMPORAL, PUEDEN ENTENDER EL ARCHIVO SE LLAMA "EXTRAS"
        2. ESE ARCHIVO TEMPORAL CONTIENE REGISTROS EN FORMATO CLAVE (KEY)- VALOR
        3.CADA REGISTRO SOLO PUEDE CONTENER UN DATO EN ESPECIFICO
        4. EL DATO SOLO PUEDE SER TIPO PRIMITIVO(INT,FLOAT,STRING )
        5. CADA REGITRO ENTIENDAN QUE SE LLAMA EXTRA
         */
        //Generar registroclave- valor
        //
        intencion.putExtra("nombre_persona",ETnombre.getText().toString());
        intencion.putExtra("apellido_persona",ETapellido.getText().toString());
        startActivity(intencion);
    }

    private void gestionarVistaCodigo(boolean marcado) {
        if(marcado)
        {
            ETcodigo.setVisibility(View.VISIBLE);
        }else
        {
            ETcodigo.setVisibility(View.GONE);
        }
    }

    private void mostrarMensaje(boolean b) {
        String mensaje="No estoy marcado";
        if(b)
        {
            mensaje="Estoy marcado";
        }
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }

    private void inicializarVistas() {
        ETnombre= findViewById(R.id.ETnombre);
        ETapellido= findViewById(R.id.ETapellido);
        ETcorreo= findViewById(R.id.ETcorreo);
        ETcelular= findViewById(R.id.ETcelular);
        ETcodigo= findViewById(R.id.ETcodigo);
        BTNregistrar= findViewById(R.id.BTNregistrar);
        SWestudiantes= findViewById(R.id.SWestudiante);
    }

    private void Validar()
    {
        String nombre= ETnombre.getText().toString();
        String apellido= ETapellido.getText().toString();
        if(nombre.length()==0 && apellido.length()==0)
        {
            String auxiliar="Debe ingresar su nombre y apellido";
            Toast.makeText(this, auxiliar, Toast.LENGTH_LONG).show();
        }
        else
        {
            MostrarDatos();
            pasarPantalla();
        }
    }

    private void MostrarDatos()
    {
        String nombre= ETnombre.getText().toString();
        String apellido= ETapellido.getText().toString();
        String correo= ETcorreo.getText().toString();
        String celular= ETcelular.getText().toString();
        String codigo= ETcodigo.getText().toString();
        String estado="Error";
        if(SWestudiantes.isChecked())
        {
            estado="Es estudiante";
        }
        else
        {
            estado="No es estudiante";
        }
        String mostrar="\nNombres: "+nombre+"\nApellidos: "+apellido+"\nCorreo: "+correo+"\nCelular: "+celular+"\nCodigo: "+codigo+"\nEstado: "+estado;
        Toast.makeText(this, mostrar, Toast.LENGTH_LONG).show();
    }
}
/*
iNTENTAR QUE LA LLAVE SEA UN REGISTRO UNICO, ACOMPAÑADO DE ESA LLAVE DESE ESTAR EL VALOR QUE SE DEBE GUARDAR
SE ASEGURA QUE LA LLAVE SEA UNICA
PRIMERO BUSCA QUE LA LLAVE EXISTE, EN CASO QUE NO HALLA CREA OTRO
EN CASO DE PILLAR EL MISMO LO REEMPLAZA
*/