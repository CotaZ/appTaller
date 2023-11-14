package com.example.aridosmanolo;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class New_Cliente extends AppCompatActivity {

    private Button Volver,Guardar;
    private EditText nombre, telefono, email, direccion;
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_cliente);

        Volver = findViewById(R.id.btn_Volver);
        Guardar = findViewById(R.id.btn_Guardar);

        nombre = findViewById(R.id.nombre);
        email = findViewById(R.id.email);
        telefono = findViewById(R.id.telefono);
        direccion = findViewById(R.id.direccion);

        Volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(New_Cliente.this, Clientes.class);
                startActivity(intent);
            }
        });

        Guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Nombre = nombre.getText().toString();
                String Email = email.getText().toString();
                String Telefono = telefono.getText().toString();
                String Direccion = direccion.getText().toString();

                Map<String, Object> Cliente = new HashMap<>();
                Cliente.put("nombre",Nombre);
                Cliente.put("email",Email);
                Cliente.put("telefono",Telefono);
                Cliente.put("direccion",Direccion);

                db.collection("Clientes")
                        .add(Cliente)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                Log.d(TAG, "Cliente agregado con la ID: " + documentReference.getId());
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.w(TAG, "Error al agregar el Cliente",e);
                            }
                        });
                Intent intent = new Intent(New_Cliente.this, Clientes.class);
                startActivity(intent);
            }
        });

    }
}