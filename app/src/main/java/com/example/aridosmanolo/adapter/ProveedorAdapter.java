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
import com.example.aridosmanolo.model.Proveedor;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class ProveedorAdapter extends FirestoreRecyclerAdapter<Proveedor,ProveedorAdapter.ViewHolder> {

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    Activity activity;
    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public ProveedorAdapter(@NonNull FirestoreRecyclerOptions<Proveedor> options,Activity activity) {
        super(options);
        this.activity = activity;
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, int i, @NonNull Proveedor Proveedor) {

        DocumentSnapshot documentSnapshot = getSnapshots().getSnapshot(holder.getAdapterPosition());
        final String id = documentSnapshot.getId();

        holder.Nombre.setText(Proveedor.getNombre());
        holder.Celular.setText(Proveedor.getCelular());
        holder.Email.setText(Proveedor.getEmail());
        holder.Empresa.setText(Proveedor.getEmpresa());

        holder.btn_Trash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            deleteProveedor(id);
            }

            private void deleteProveedor(String id) {
                db.collection("Proveedores").document(id).delete().addOnSuccessListener(new OnSuccessListener<Void>() {
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
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_proveedor_single,parent,false);
        return new ViewHolder(v);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView Nombre, Celular, Email, Empresa;

        ImageButton btn_Trash;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Nombre = itemView.findViewById(R.id.Nombre);
            Celular= itemView.findViewById(R.id.Celular);
            Email = itemView.findViewById(R.id.Email);
            Empresa = itemView.findViewById(R.id.Empresa);
            btn_Trash = itemView.findViewById(R.id.btn_Trash);
        }
    }
}
