package com.example.aridosmanolo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Alertas extends AppCompatActivity {

    private Button Volver,Pedido,Mapa,Calculadora,Menu;

    @SuppressLint("MissingInflatedId")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alertas);

        Volver = findViewById(R.id.btn_Volver2);
        Pedido = findViewById(R.id.btn_Pedidos);
        Mapa = findViewById(R.id.btn_Mapa);
        Calculadora = findViewById(R.id.btn_Calculadora);
        Menu = findViewById(R.id.btn_Menu);

        Pedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Alertas.this, Pedidos.class);
                startActivity(intent);
            }
        });
        Mapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Alertas.this, MapsActivity.class);
                startActivity(intent);
            }
        });
        Calculadora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Alertas.this, Calculadora.class);
                startActivity(intent);
            }
        });
        Menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Alertas.this, MainActivity.class);
                startActivity(intent);
            }
        });
        Volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Alertas.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}