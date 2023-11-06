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

public class New_Prov extends AppCompatActivity {

    private Button Volver,Guardar;
    private EditText text_Nombre, text_Correo, text_Celular, text_Empresa;
    FirebaseFirestore db = FirebaseFirestore.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_prov);

        Volver = findViewById(R.id.btn_Volver);
        Guardar = findViewById(R.id.btn_Guardar);

        text_Nombre = findViewById(R.id.text_Nombre);
        text_Correo = findViewById(R.id.text_Correo);
        text_Celular = findViewById(R.id.text_Celular);
        text_Empresa = findViewById(R.id.text_Empresa);

        Volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(New_Prov.this, Proveedores.class);
                startActivity(intent);
            }
        });

        Guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Nombre = text_Nombre.getText().toString();
                String Correo = text_Correo.getText().toString();
                String Empresa = text_Empresa.getText().toString();
                String Celular = text_Celular.getText().toString();

                Map<String, Object> Proveedor = new HashMap<>();
                Proveedor.put("Nombre",Nombre);
                Proveedor.put("Email",Correo);
                Proveedor.put("Celular",Celular);
                Proveedor.put("Empresa",Empresa);

                db.collection("Proveedores")
                        .add(Proveedor)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                Log.d(TAG, "Proveedor agregado con la ID: " + documentReference.getId());
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.w(TAG, "Error al agregar el Proveedor",e);
                            }
                        });
                Intent intent = new Intent(New_Prov.this, Proveedores.class);
                startActivity(intent);
            }
        });
    }
}