package com.example.aridosmanolo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.aridosmanolo.adapter.MaterialAdapter;
import com.example.aridosmanolo.model.Material;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class Inventario extends AppCompatActivity {

    private int Arena,Gravilla,Ripio,Maicillo,Bolones,Cemento,Bol9,Bol14,Bol19;
    private TextView text_Arena,text_Gravilla,text_Ripio,text_Maicillo,text_Bolones,text_Cemento,text_Bol9,text_Bol14,text_Bol19;
    private Button Editar,Volver,Pedido,Mapa,Calculadora,Menu;
    private RecyclerView mRecycler;
    private MaterialAdapter mAdapter;
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onStart() {
        super.onStart();
        mAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mAdapter.stopListening();
    }

    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventario);

        mRecycler = findViewById(R.id.Recy_Inventario);
        mRecycler.setLayoutManager(new LinearLayoutManager(this));
        Query query = db.collection("Inventario");
        FirestoreRecyclerOptions<Material> firestoreRecyclerOptions = new FirestoreRecyclerOptions.Builder<Material>().setQuery(query, Material.class).build();
        mAdapter = new MaterialAdapter(firestoreRecyclerOptions,this);
        mAdapter.notifyDataSetChanged();
        mRecycler.setAdapter(mAdapter);


        Volver = findViewById(R.id.btn_Volver);
        Pedido = findViewById(R.id.btn_Pedidos);
        Mapa = findViewById(R.id.btn_Mapa);
        Calculadora = findViewById(R.id.btn_Calculadora);
        Menu = findViewById(R.id.btn_Menu);
        //Editar = findViewById(R.id.btn_Edit);

        Pedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Inventario.this, Pedidos.class);
                startActivity(intent);
            }
        });
        Mapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Inventario.this, MapsActivity.class);
                startActivity(intent);
            }
        });
        Calculadora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Inventario.this, Calculadora.class);
                startActivity(intent);
            }
        });
        Menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Inventario.this, MainActivity.class);
                startActivity(intent);
            }
        });
        Volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Inventario.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}