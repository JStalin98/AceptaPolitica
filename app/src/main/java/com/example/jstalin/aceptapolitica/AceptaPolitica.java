package com.example.jstalin.aceptapolitica;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AceptaPolitica extends AppCompatActivity {
    private final static int CODIGO = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acepta_politica);

        Button btVerifica = (Button) findViewById(R.id.btVerificar);
        btVerifica.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                verifica();
            }
        });


        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

    }


    private void verifica() {

        EditText etNombre = (EditText) findViewById(R.id.etNombre);
        String nombre = etNombre.getText().toString();
        Intent intent = new Intent(this, Verifica.class);
        Bundle bundle = new Bundle();
        bundle.putString("NOMBRE", nombre);
        intent.putExtras(bundle);
        startActivityForResult(intent, CODIGO);

    }

    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent data) {
        TextView tvResultado = (TextView) findViewById(R.id.tvResultado);
        if (requestCode == CODIGO && resultCode == RESULT_OK) {
            if (data.getExtras().getBoolean("AR")) {
                tvResultado.setText("Aceptado");
            } else {
                tvResultado.setText("Rechazado");
            }
        }

    }


}
