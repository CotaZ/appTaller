package com.example.aridosmanolo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Edit_Inventario extends AppCompatActivity {

    private Button Volver, Actualizar;
    private EditText Cantidad, Valor;
    private TextView Material;
    FirebaseFirestore db = FirebaseFirestore.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_inventario);

        String id = getIntent().getStringExtra("id_Material");

        Volver = findViewById(R.id.btn_Volver);
        Actualizar = findViewById(R.id.btn_Actualizar);

        Material = findViewById(R.id.Material);
        Valor = findViewById(R.id.Valor);
        Cantidad = findViewById(R.id.Cantidad);

        getMaterial(id);
        Actualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String material = Material.getText().toString();
                String valor = Valor.getText().toString();
                String cantidad = Cantidad.getText().toString();

                updateMaterial(material,valor,cantidad,id);
            }
        });

        Volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Edit_Inventario.this, Inventario.class);
                startActivity(intent);
            }
        });

    }

    private void updateMaterial(String material, String valor, String cantidad, String id) {
        Map<String, Object> Material = new HashMap<>();
        Material.put("Material",material);
        Material.put("Valor",valor);
        Material.put("Cantidad",cantidad);
        db.collection("Inventario").document(id).update(Material).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                finish();
            }
        });
    }

    private void getMaterial(String id){
        db.collection("Inventario").document(id).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                String nameMaterial = documentSnapshot.getString("Material");
                String valorMaterial = documentSnapshot.getString("Valor");
                String cantidadMaterial = documentSnapshot.getString("Cantidad");
                Material.setText(nameMaterial);
                Valor.setText(valorMaterial);
                Cantidad.setText(cantidadMaterial);
            }
        });
    }
}