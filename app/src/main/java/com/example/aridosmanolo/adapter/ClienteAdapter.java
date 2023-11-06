package com.example.aridosmanolo.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aridosmanolo.R;
import com.example.aridosmanolo.model.Cliente;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class ClienteAdapter extends FirestoreRecyclerAdapter<Cliente,ClienteAdapter.ViewHolder> {

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    Activity activity;
    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public ClienteAdapter(@NonNull FirestoreRecyclerOptions<Cliente> options,Activity activity) {
        super(options);
        this.activity = activity;
    }

    @Override
    protected void onBindViewHolder(@NonNull ClienteAdapter.ViewHolder holder, int i, @NonNull Cliente Cliente) {

        DocumentSnapshot documentSnapshot = getSnapshots().getSnapshot(holder.getAdapterPosition());
        final String id = documentSnapshot.getId();

        holder.nombre.setText(Cliente.getNombre());
        holder.telefono.setText(Cliente.getTelefono());
        holder.email.setText(Cliente.getEmail());
        holder.direccion.setText(Cliente.getDireccion());


        holder.btn_Trash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteProveedor(id);
            }

            private void deleteProveedor(String id) {
                db.collection("Clientes").document(id).delete().addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(activity, "Eliminado Correctamente", Toast.LENGTH_SHORT).show();

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(activity, "Error al Eliminar", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }

    @NonNull
    @Override
    public ClienteAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_cliente_single,parent,false);
        return new ViewHolder(v);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nombre, telefono, email, direccion;

        ImageButton btn_Trash;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.nombre);
            telefono = itemView.findViewById(R.id.telefono);
            email = itemView.findViewById(R.id.email);
            direccion = itemView.findViewById(R.id.direccion);
            btn_Trash = itemView.findViewById(R.id.btn_Trash2);
        }
    }
}
