package com.example.jstalin.aceptapolitica;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Verifica extends AppCompatActivity {
    Bundle bundle; // Obtendremos los datos de la actividad principal
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verifica);

        bundle = getIntent().getExtras(); //Obtenemos los extras del itent

        TextView tvInfo = (TextView) findViewById(R.id.tvInfo);// Obtenemos el TextView del xml Verifica mediante su id
        tvInfo.setText("Hola " + bundle.getString("NOMBRE") + " ¿Aceptas la politica de privacidad?");


        // Los dos botones siguientes llaman al mismo metodo

        //// Obtenemos el Button del xml Verifica mediante su id
        /*
        Este boton produce un evento cuando es pulsado, el evento se implementa de forma anonima
        por lo que no sera posible volver a utilizarlo ni sera visible para demas componentes
         */
        Button btAceptar = (Button) findViewById(R.id.btAceptar);
        btAceptar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) { // metodo que llama al metodo enviarResultado(View v)
                enviarResultado(v);
            }
        });
        //// Obtenemos el Button del xml Verifica mediante su id
        /*
        Este boton produce un evento cuando es pulsado, el evento se implementa de forma anonima
        por lo que no sera posible volver a utilizarlo ni sera visible para demas componentes
         */
        Button btRechazar = (Button) findViewById(R.id.btRechazar);
        btRechazar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {// metodo que llama al metodo enviarResultado(View v)

                enviarResultado(v);
            }
        });
    }
    /*
    Este metodo lo que hace es tratar los datos enviados de la actividad principal y en
    funcion de ella envia un dato u otro segun sea necesario
    @param View v - View que se le pasa por parametro para identificar que boton se ha pulsado
     */
    public void enviarResultado(View v) {
        Intent intent = new Intent(); // Creamos un nuevo itent


        switch (v.getId()) { //Comprobamos que boton ha sifo pulsado
            case R.id.btAceptar:

                if(bundle.getInt("EDAD")>=18){// Comprobamos que el dato EDAD del Activity principal es mayot o igual que 18 o no
                    intent.putExtra("AR", "Aceptado sin restricciones");
                }else {
                    intent.putExtra("AR", "Aceptado con restricciones");
                }


                break;
            case R.id.btRechazar:
                intent.putExtra("AR", "Rechazado");

                break;


        }
        setResult(RESULT_OK, intent); // Marcamos que todo ha sido correcto y volvemos a enviar informacion al Activity principal
        finish();//Finalizamos esta actividad


    }


}
