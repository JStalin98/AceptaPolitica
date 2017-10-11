package com.example.jstalin.aceptapolitica;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Verifica extends AppCompatActivity {
    private Bundle bundle = getIntent().getExtras();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verifica);

        TextView tvInfo = (TextView)findViewById(R.id.tvInfo);
        tvInfo.setText("Hola " + bundle.getString("NOMBRE") +" ¿Aceptas la politica de privacidad?");

        Button btAceptar = (Button)findViewById(R.id.btAceptar);
        btAceptar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                enviarResultado(v);
            }
        });

        Button btRechazar = (Button)findViewById(R.id.btRechazar);
        btRechazar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                enviarResultado(v);
            }
        });
    }

    public void enviarResultado(View v){
        Boolean b = null;
        Intent intent = new Intent(this, AceptaPolitica.class);
        Bundle bundle = new Bundle();

        if(v.getId()==R.id.btAceptar){
            b = true;
            bundle.putBoolean("AR", b);
        }else if(v.getId()==R.id.btRechazar){
            b = true;
            bundle.putBoolean("AR", b);
        }else{
            bundle.putBoolean("AR", b);
        }
        intent.putExtras(bundle);
        startActivity(intent);
    }



}
