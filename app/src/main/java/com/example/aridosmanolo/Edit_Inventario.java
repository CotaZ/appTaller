package com.example.aridosmanolo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.firestore.FirebaseFirestore;

public class Edit_Inventario extends AppCompatActivity {

    private Button Volver, Actualizar;
    private EditText Cantidad, Valor;
    FirebaseFirestore db = FirebaseFirestore.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_inventario);

        Volver = findViewById(R.id.btn_Volver);
        Actualizar = findViewById(R.id.btn_Actualizar);

        Volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Edit_Inventario.this, Inventario.class);
                startActivity(intent);
            }
        });

    }
}