package com.example.jstalin.aceptapolitica;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AceptaPolitica extends AppCompatActivity {
    private Bundle bundle = getIntent().getExtras();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acepta_politica);

        Button btVerifica = (Button)findViewById(R.id.btVerificar);
        btVerifica.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                verifica();
            }
        });

        TextView tvResultado = (TextView)findViewById(R.id.tvResultado);

        if(bundle.getBoolean("AR")){
            tvResultado.setText("Aceptado");
        }else if (bundle.getBoolean("AR")==false) {
            tvResultado.setText("Rechazado");
        }
    }


    private void verifica() {

        EditText etNombre = (EditText)findViewById(R.id.etNombre);
        String nombre = etNombre.getText().toString();
        Intent intent = new Intent(this, Verifica.class);
        Bundle bundle = new Bundle();
        bundle.putString("NOMBRE", nombre);
        intent.putExtras(bundle);
        startActivity(intent);

    }

}
