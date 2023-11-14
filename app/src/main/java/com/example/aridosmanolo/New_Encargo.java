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

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class New_Encargo extends AppCompatActivity {

    private Button Volver,Guardar;
    private TextView patata;
    private EditText Proveedor, Material, Cantidad, Gasto;
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_encargo);

        String id = getIntent().getStringExtra("id_Encargo");
        Volver = findViewById(R.id.btn_Volver);
        Guardar = findViewById(R.id.btn_Guardar);

        Proveedor = findViewById(R.id.Proveedor);
        Material = findViewById(R.id.Material);
        Cantidad = findViewById(R.id.Cantidad);
        Gasto = findViewById(R.id.Gasto);
        patata = findViewById(R.id.patata);

        if (id == null || id == ""){
            Guardar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String proveedor = Proveedor.getText().toString();
                    String material = Material.getText().toString();
                    String cantidad = Cantidad.getText().toString();
                    String gasto = Gasto.getText().toString();

                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM HH:mm");
                    String horaActual = sdf.format(date);


                    Map<String, Object> Encargo = new HashMap<>();
                    Encargo.put("Proveedor",proveedor);
                    Encargo.put("Material",material);
                    Encargo.put("Cantidad",cantidad);
                    Encargo.put("Gasto",gasto);
                    Encargo.put("Fecha",horaActual);

                    db.collection("Encargos")
                            .add(Encargo)
                            .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                @Override
                                public void onSuccess(DocumentReference documentReference) {
                                    Log.d(TAG, "Encargo añadido con la ID: " + documentReference.getId());
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.w(TAG, "Error al añadir el Engargo",e);
                                }
                            });
                    Intent intent = new Intent(New_Encargo.this, Encargos.class);
                    startActivity(intent);
                }
            });
        }else{
            patata.setText("Actualizar Encargo");
            Guardar.setText("Actualizar");
            getEncargo(id);
            Guardar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String proveedor = Proveedor.getText().toString();
                    String material = Material.getText().toString();
                    String cantidad = Cantidad.getText().toString();
                    String gasto = Gasto.getText().toString();

                    UpdateEncargo(proveedor,material,cantidad,gasto, id);
                }
            });
        }

        Volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(New_Encargo.this, Encargos.class);
                startActivity(i);
            }
        });
    }

    private void UpdateEncargo(String proveedor, String material, String cantidad, String gasto, String id) {
        Map<String, Object> Encargo = new HashMap<>();
        Encargo.put("Proveedor",proveedor);
        Encargo.put("Material",material);
        Encargo.put("Cantidad",cantidad);
        Encargo.put("Gasto",gasto);
        db.collection("Encargos").document(id).update(Encargo).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                finish();
            }
        });
    }

    private void getEncargo(String id){
        db.collection("Encargos").document(id).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                String aMaterial = documentSnapshot.getString("Material");
                String aCantidad = documentSnapshot.getString("Cantidad");
                String aGasto = documentSnapshot.getString("Gasto");
                String aProveedor = documentSnapshot.getString("Proveedor");
                Material.setText(aMaterial);
                Cantidad.setText(aCantidad);
                Gasto.setText(aGasto);
                Proveedor.setText(aProveedor);
            }
        });
    }


}