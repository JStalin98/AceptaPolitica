package com.example.jstalin.aceptapolitica;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Verifica extends AppCompatActivity {
    // private
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verifica);

        Bundle bundle = getIntent().getExtras();

        TextView tvInfo = (TextView) findViewById(R.id.tvInfo);
        tvInfo.setText("Hola " + bundle.getString("NOMBRE") + " ¿Aceptas la politica de privacidad?");

        Button btAceptar = (Button) findViewById(R.id.btAceptar);
        btAceptar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                enviarResultado(v);
            }
        });

        Button btRechazar = (Button) findViewById(R.id.btRechazar);
        btRechazar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                enviarResultado(v);
            }
        });
    }

    public void enviarResultado(View v) {
        Intent intent = new Intent();


        switch (v.getId()) {
            case R.id.btAceptar:
                intent.putExtra("AR", true);

                break;
            case R.id.btRechazar:
                intent.putExtra("AR", false);

                break;


        }
        setResult(RESULT_OK, intent);
        finish();


    }


}
