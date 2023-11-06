package com.example.aridosmanolo;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.aridosmanolo.adapter.ClienteAdapter;
import com.example.aridosmanolo.model.Cliente;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class Clientes extends AppCompatActivity {

    private Button Volver,Pedido,Mapa,Calculadora,Menu;

    private RecyclerView mRecycler;
    private ClienteAdapter mAdapter;
    private ImageButton AgregarCliente;
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

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes);

        mRecycler = findViewById(R.id.Recy_Clientes);
        mRecycler.setLayoutManager(new LinearLayoutManager(this));
        Query query = db.collection("Clientes");
        FirestoreRecyclerOptions<Cliente> firestoreRecyclerOptions = new FirestoreRecyclerOptions.Builder<Cliente>().setQuery(query, Cliente.class).build();
        mAdapter = new ClienteAdapter(firestoreRecyclerOptions,this);
        mAdapter.notifyDataSetChanged();
        mRecycler.setAdapter(mAdapter);

        Volver = findViewById(R.id.btn_Volver2);
        Pedido = findViewById(R.id.btn_Pedidos);
        Mapa = findViewById(R.id.btn_Mapa);
        Calculadora = findViewById(R.id.btn_Calculadora);
        Menu = findViewById(R.id.btn_Menu);
        AgregarCliente = findViewById(R.id.imBtn_AgregarCliente);

        Pedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Clientes.this, Pedidos.class);
                startActivity(intent);
            }
        });
        Mapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Clientes.this, MapsActivity.class);
                startActivity(intent);
            }
        });
        Calculadora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Clientes.this, Calculadora.class);
                startActivity(intent);
            }
        });
        Menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Clientes.this, MainActivity.class);
                startActivity(intent);
            }
        });
        Volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Clientes.this, MainActivity.class);
                startActivity(intent);
            }
        });
        AgregarCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Clientes.this, New_Cliente.class);
                startActivity(intent);
            }
        });

        db.collection("Clientes")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d(TAG, document.getId() + " => " + document.getData());

                                String Nombre = document.getString("Nombre");

                            }
                        } else {
                            Log.w(TAG, "Error getting documents.", task.getException());
                        }
                    }
                });
    }
}