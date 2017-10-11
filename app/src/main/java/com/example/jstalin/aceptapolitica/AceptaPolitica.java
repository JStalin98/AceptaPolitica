package com.example.jstalin.aceptapolitica;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AceptaPolitica extends AppCompatActivity {
    private final static int CODIGO = 0; // Codigo que sirve para identificarse entre actividades

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acepta_politica);

        // Boton que hace referencia al btVerificar del XML mediante el ID
        /*
        Este boton produce un evento cuando es pulsado, el evento se implementa de forma anonima
        por lo que no sera posible volver a utilizarlo ni sera visible para demas componentes
         */
        Button btVerifica = (Button) findViewById(R.id.btVerificar);
        btVerifica.setOnClickListener(new View.OnClickListener() {

            // El metodo del evento lo que hace es llamar a otro metodo llamado verifica()
            @Override
            public void onClick(View v) {
                verifica();
            }
        });

    }

    /*
    El metodo verifica, lo que va hacer es instanciar los campos de texto(EditText)
    del XML para poder tratarlos, mediante el ID de estos
    Enviar la informacion validandola que hay en estos un activy llamado Verifica
     */
    private void verifica() {
        TextView tvResultado = (TextView) findViewById(R.id.tvResultado);

        try {
            EditText etNombre = (EditText) findViewById(R.id.etNombre);
            String nombre = etNombre.getText().toString(); // El nombre no es necesario validarlo, ya que en este proyecto no es relevante si se pone o no
            EditText etEdad = (EditText) findViewById(R.id.etEdad);
            int edad = Integer.parseInt(etEdad.getText().toString());

            if(edad<0 || edad>150){ // Validamos la edad ya que puede no es posible tener vaores negativos o un numero muy grande
                tvResultado.setText("Edad no valida, introduce edad entre 0 y 150");
            }else {
                Intent intent = new Intent(this, Verifica.class);
                Bundle bundle = new Bundle();
                bundle.putString("NOMBRE", nombre);
                bundle.putInt("EDAD", edad);
                intent.putExtras(bundle);
                startActivityForResult(intent, CODIGO); // Iniciamos un actividad que espera respuesta
            }

        } catch (NumberFormatException nfe) { // Capturamos la excepcion que puede dar al convertir la edad a entero

            tvResultado.setText("Error, el campo edad debe contener solo caracteres numericos");
        }

    }

    /*
    Este metodo sobreescrito es el encargado de recoger y tratar la informacion que sera recivida
    @param int requesCode - Codigo con el que se comunicacn las dos actividades (0)
    @param int resultCode - Indica si el traspaso de informacion ha sido correcto(RESULT_OK) o no(RESULT_CANCELED)
    @param Intent data - Intent que devuelve la actividad de la cual se espera respuesta
     */
    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent data) {
        TextView tvResultado = (TextView) findViewById(R.id.tvResultado); // Campo de texto donde se escribira informacion
        if (requestCode == CODIGO && resultCode == RESULT_OK) {// Comprobamos que el codigo y la operacion sean correctas
            String st = data.getExtras().getString("AR"); // Obtenemos informacion del itent que ha sido devuelto y la almacenamos en un variable st
            tvResultado.setText(st); // Mostramos la informacion

        }

    }


}
