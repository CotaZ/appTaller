package com.example.aridosmanolo;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class New_Pedido extends AppCompatActivity {

    private Button btn_Crear, btn_Volver;
    private TextView patata;
    private EditText Cliente, Direccion, Fecha, Descripcion;

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_pedido);

        String id = getIntent().getStringExtra("id_Pedido");
        btn_Volver = findViewById(R.id.btn_Volver);
        btn_Crear = findViewById(R.id.btn_Crear);

        Cliente = findViewById(R.id.Cliente);
        Direccion = findViewById(R.id.Direccion);
        Fecha = findViewById(R.id.Fecha);
        Descripcion = findViewById(R.id.Descripcion);
        patata = findViewById(R.id.patata);

        if (id== null || id == ""){
            btn_Crear.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String cliente = Cliente.getText().toString();
                    String direccion = Direccion.getText().toString();
                    String fecha = Fecha.getText().toString();
                    String descripcion = Descripcion.getText().toString();

                    Map<String, Object> Pedido = new HashMap<>();
                    Pedido.put("Cliente",cliente);
                    Pedido.put("Direccion",direccion);
                    Pedido.put("Fecha",fecha);
                    Pedido.put("Descripcion",descripcion);

                    db.collection("Pedidos")
                            .add(Pedido)
                            .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                @Override
                                public void onSuccess(DocumentReference documentReference) {
                                    Log.d(TAG, "Pedido añadido con la ID: " + documentReference.getId());
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.w(TAG, "Error al añadir el Pedido",e);
                                }
                            });
                    Intent i = new Intent(New_Pedido.this, Pedidos.class);
                    startActivity(i);
                }
            });
        }else{
            patata.setText("Actualizar Pedido");
            btn_Crear.setText("Actualizar");
            getPedido(id);
            btn_Crear.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String cliente = Cliente.getText().toString();
                    String direccion = Direccion.getText().toString();
                    String fecha = Fecha.getText().toString();
                    String descripcion = Descripcion.getText().toString();

                    UpdatePedido(cliente,descripcion,direccion,fecha,id);
                }
            });
        }

        btn_Volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(New_Pedido.this, Pedidos.class);
                startActivity(i);
            }
        });
    }

    private void UpdatePedido(String cliente, String descripcion, String direccion, String fecha, String id) {
        Map<String, Object> Pedido = new HashMap<>();
        Pedido.put("Cliente",cliente);
        Pedido.put("Direccion",direccion);
        Pedido.put("Fecha",fecha);
        Pedido.put("Descripcion",descripcion);
        db.collection("Pedidos").document(id).update(Pedido).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                finish();
            }
        });
    }

    private void getPedido(String id){
        db.collection("Pedidos").document(id).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                String aCliente = documentSnapshot.getString("Cliente");
                String aDireccion = documentSnapshot.getString("Direccion");
                String aFecha = documentSnapshot.getString("Fecha");
                String aDescripcion = documentSnapshot.getString("Descripcion");
                Cliente.setText(aCliente);
                Direccion.setText(aDireccion);
                Fecha.setText(aFecha);
                Descripcion.setText(aDescripcion);
            }
        });
    }
}