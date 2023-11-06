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

import com.example.aridosmanolo.adapter.ProveedorAdapter;
import com.example.aridosmanolo.model.Proveedor;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.Set;

public class Proveedores extends AppCompatActivity {

    private Button Volver,Pedido,Mapa,Calculadora,Menu;
    private RecyclerView mRecycler;
    private ProveedorAdapter mAdapter;
    private ImageButton AgregarProveedor;
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
        setContentView(R.layout.activity_proveedores);

        mRecycler = findViewById(R.id.Recy_Proveedores);
        mRecycler.setLayoutManager(new LinearLayoutManager(this));
        Query query = db.collection("Proveedores");
        FirestoreRecyclerOptions<Proveedor> firestoreRecyclerOptions = new FirestoreRecyclerOptions.Builder<Proveedor>().setQuery(query,Proveedor.class).build();
        mAdapter = new ProveedorAdapter(firestoreRecyclerOptions,this);
        mAdapter.notifyDataSetChanged();
        mRecycler.setAdapter(mAdapter);

        Volver = findViewById(R.id.btn_Volver2);
        Pedido = findViewById(R.id.btn_Pedidos);
        Mapa = findViewById(R.id.btn_Mapa);
        Calculadora = findViewById(R.id.btn_Calculadora);
        Menu = findViewById(R.id.btn_Menu);
        AgregarProveedor = findViewById(R.id.imBtn_AgregarProveedor);

        Pedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Proveedores.this, Pedidos.class);
                startActivity(intent);
            }
        });
        Mapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Proveedores.this, MapsActivity.class);
                startActivity(intent);
            }
        });
        Calculadora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Proveedores.this, Calculadora.class);
                startActivity(intent);
            }
        });
        Menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Proveedores.this, MainActivity.class);
                startActivity(intent);
            }
        });
        Volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Proveedores.this, MainActivity.class);
                startActivity(intent);
            }
        });

        AgregarProveedor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Proveedores.this, New_Prov.class);
                startActivity(intent);
            }
        });

        db.collection("Proveedores")
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