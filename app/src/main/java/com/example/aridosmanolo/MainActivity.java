package com.example.aridosmanolo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private ImageButton imBtn_Pedidos,imBtn_Encargos,imBtn_Clientes,imBtn_Calculadora,imBtn_Inventario,imBtn_Estadisticas,imBtn_Mapa,imBtn_Proveedores,imBtn_Alertas;
    private Button Salir,Pedido,Mapa,Calculadora,Menu;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Salir = findViewById(R.id.btn_Salir);
        Pedido = findViewById(R.id.btn_Pedidos);
        Mapa = findViewById(R.id.btn_Mapa);
        Calculadora = findViewById(R.id.btn_Calculadora);
        Menu = findViewById(R.id.btn_Menu);

        imBtn_Pedidos = findViewById(R.id.imBtn_Pedidos);
        imBtn_Encargos = findViewById(R.id.imBtn_Encargos);
        imBtn_Clientes = findViewById(R.id.imBtn_Clientes);
        imBtn_Calculadora = findViewById(R.id.imBtn_Calculadora);
        imBtn_Inventario = findViewById(R.id.imBtn_Inventario);
        imBtn_Estadisticas = findViewById(R.id.imBtn_Estadisticas);
        imBtn_Mapa = findViewById(R.id.imBtn_Mapa);
        imBtn_Proveedores = findViewById(R.id.imBtn_Proveedores);
        imBtn_Alertas = findViewById(R.id.imBtn_Alertas);

        Pedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Pedidos.class);
                startActivity(intent);
            }
        });
        Mapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                startActivity(intent);
            }
        });
        Calculadora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Calculadora.class);
                startActivity(intent);
            }
        });
        Menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        Salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(MainActivity.this, LogIn.class);
                startActivity(intent);
            }
        });

        imBtn_Pedidos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Pedidos.class);
                startActivity(intent);
            }
        });
        imBtn_Encargos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Encargos.class);
                startActivity(intent);
            }
        });
        imBtn_Clientes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Clientes.class);
                startActivity(intent);
            }
        });
        imBtn_Calculadora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Calculadora.class);
                startActivity(intent);
            }
        });
        imBtn_Inventario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Inventario.class);
                startActivity(intent);
            }
        });
        imBtn_Estadisticas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Estadisticas.class);
                startActivity(intent);
            }
        });
        imBtn_Mapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                startActivity(intent);
            }
        });
        imBtn_Proveedores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Proveedores.class);
                startActivity(intent);
            }
        });
        imBtn_Alertas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Alertas.class);
                startActivity(intent);
            }
        });

    }
}