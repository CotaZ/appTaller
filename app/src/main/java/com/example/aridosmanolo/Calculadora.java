package com.example.aridosmanolo;



import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Calculadora extends AppCompatActivity {

    private Button btn_Calcular, Volver,Pedido,Mapa,Calculadora,Menu, btn_MenArena,btn_MasArena,btn_MenGravilla,btn_MasGravilla,btn_MenRipio,btn_MasRipio,btn_MenMaicillo,btn_MasMaicillo,btn_MenBolones,btn_MasBolones,btn_MenCemento,btn_MasCemento;
    private TextView text_Arena,text_Gravilla,text_Ripio,text_Maicillo,text_Bolones,text_Cemento,text_Resultado;
    private EditText text_Bol9,text_Bol14,text_Bol19;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        Volver = findViewById(R.id.btn_Volver);
        Pedido = findViewById(R.id.btn_Pedidos);
        Mapa = findViewById(R.id.btn_Mapa);
        Calculadora = findViewById(R.id.btn_Calculadora);
        Menu = findViewById(R.id.btn_Menu);
        btn_Calcular = findViewById(R.id.btn_Calcular);

        btn_MenArena = findViewById(R.id.btn_MenArena);
        btn_MasArena = findViewById(R.id.btn_MasArena);
        btn_MenGravilla = findViewById(R.id.btn_MenGravilla);
        btn_MasGravilla = findViewById(R.id.btn_MasGravilla);
        btn_MenMaicillo = findViewById(R.id.btn_MenMaicillo);
        btn_MasMaicillo = findViewById(R.id.btn_MasMaicillo);
        btn_MenRipio = findViewById(R.id.btn_MenRipio);
        btn_MasRipio = findViewById(R.id.btn_MasRipio);
        btn_MenBolones = findViewById(R.id.btn_MenBolones);
        btn_MasBolones = findViewById(R.id.btn_MasBolones);
        btn_MenCemento = findViewById(R.id.btn_MenCemento);
        btn_MasCemento = findViewById(R.id.btn_MasCemento);

        text_Arena =findViewById(R.id.text_Arena);
        text_Gravilla =findViewById(R.id.text_Gravilla);
        text_Maicillo =findViewById(R.id.text_Maicillo);
        text_Ripio =findViewById(R.id.text_Ripio);
        text_Cemento =findViewById(R.id.text_Cemento);
        text_Bolones =findViewById(R.id.text_Bolones);
        text_Bol9 =findViewById(R.id.text_Bol9);
        text_Bol14 =findViewById(R.id.text_Bol14);
        text_Bol19 =findViewById(R.id.text_Bol19);
        text_Resultado = findViewById(R.id.text_Resultado);

        Pedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Calculadora.this, Pedidos.class);
                startActivity(intent);
            }
        });
        Mapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Calculadora.this, MapsActivity.class);
                startActivity(intent);
            }
        });
        Calculadora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Calculadora.this, Calculadora.class);
                startActivity(intent);
            }
        });
        Menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Calculadora.this, MainActivity.class);
                startActivity(intent);
            }
        });
        Volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Calculadora.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btn_MasArena.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String x = text_Arena.getText().toString();
                int suma = Integer.parseInt(x);
                suma = suma+ 1;
                x = String.valueOf(suma);
                text_Arena.setText(x);
            }
        });
        btn_MenArena.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String x = text_Arena.getText().toString();
                int resta = Integer.parseInt(x);
                if (resta < 1){

                }else {
                    resta = resta -1;
                    x = String.valueOf(resta);
                    text_Arena.setText(x);
                }
            }
        });
        btn_MasGravilla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String x = text_Gravilla.getText().toString();
                int suma = Integer.parseInt(x);
                suma = suma+ 1;
                x = String.valueOf(suma);
                text_Gravilla.setText(x);
            }
        });
        btn_MenGravilla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String x = text_Gravilla.getText().toString();
                int resta = Integer.parseInt(x);
                if (resta < 1){

                }else {
                    resta = resta -1;
                    x = String.valueOf(resta);
                    text_Gravilla.setText(x);
                }
            }
        });
        btn_MasRipio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String x = text_Ripio.getText().toString();
                int suma = Integer.parseInt(x);
                suma = suma+ 1;
                x = String.valueOf(suma);
                text_Ripio.setText(x);
            }
        });
        btn_MenRipio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String x = text_Ripio.getText().toString();
                int resta = Integer.parseInt(x);
                if (resta < 1){

                }else {
                    resta = resta -1;
                    x = String.valueOf(resta);
                    text_Ripio.setText(x);
                }
            }
        });
        btn_MasMaicillo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String x = text_Maicillo.getText().toString();
                int suma = Integer.parseInt(x);
                suma = suma+ 1;
                x = String.valueOf(suma);
                text_Maicillo.setText(x);
            }
        });
        btn_MenMaicillo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String x = text_Maicillo.getText().toString();
                int resta = Integer.parseInt(x);
                if (resta < 1){

                }else {
                    resta = resta -1;
                    x = String.valueOf(resta);
                    text_Maicillo.setText(x);
                }
            }
        });
        btn_MasBolones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String x = text_Bolones.getText().toString();
                int suma = Integer.parseInt(x);
                suma = suma+ 1;
                x = String.valueOf(suma);
                text_Bolones.setText(x);
            }
        });
        btn_MenBolones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String x = text_Bolones.getText().toString();
                int resta = Integer.parseInt(x);
                if (resta < 1){

                }else {
                    resta = resta -1;
                    x = String.valueOf(resta);
                    text_Bolones.setText(x);
                }
            }
        });
        btn_MasCemento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String x = text_Cemento.getText().toString();
                int suma = Integer.parseInt(x);
                suma = suma+ 1;
                x = String.valueOf(suma);
                text_Cemento.setText(x);
            }
        });
        btn_MenCemento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String x = text_Cemento.getText().toString();
                int resta = Integer.parseInt(x);
                if (resta < 1){

                }else {
                    resta = resta -1;
                    x = String.valueOf(resta);
                    text_Cemento.setText(x);
                }
            }
        });
        btn_Calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String x1 = text_Arena.getText().toString();
                int arena = Integer.parseInt(x1);
                arena = arena *26000;
                String x2 = text_Gravilla.getText().toString();
                int grava = Integer.parseInt(x2);
                grava = grava *29000;
                String x3 = text_Ripio.getText().toString();
                int ripio = Integer.parseInt(x3);
                ripio = ripio *26000;
                String x4 = text_Maicillo.getText().toString();
                int maicillo = Integer.parseInt(x4);
                maicillo = maicillo *14000;
                String x5 = text_Bolones.getText().toString();
                int bolones = Integer.parseInt(x5);
                bolones = bolones *35000;
                String x6 = text_Cemento.getText().toString();
                int cemento = Integer.parseInt(x6);
                cemento = cemento *4200;
                String x7 = text_Bol9.getText().toString();
                if (x7 == ""|| x7 == null){x7 =String.valueOf(0);}
                int bol9 = Integer.parseInt(x7);
                bol9 = bol9 *1100;
                String x8 = text_Bol14.getText().toString();
                if (x8 == ""|| x8 == null){x8 = String.valueOf(0);}
                int bol14 = Integer.parseInt(x8);
                bol14 = bol14 *1350;
                String x9 = text_Bol19.getText().toString();
                if (x9 == ""|| x9 == null){x9 =String.valueOf(0);}
                int bol19 = Integer.parseInt(x9);
                bol19 = bol19 *1550;
                int resultado = arena+grava+ripio+maicillo+bolones+cemento+bol9+bol14+bol19;
                String x = String.valueOf(resultado);
                text_Resultado.setText(x);

            }
        });

    }
}