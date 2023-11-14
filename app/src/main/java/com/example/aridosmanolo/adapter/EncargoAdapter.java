package com.example.aridosmanolo.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aridosmanolo.New_Encargo;
import com.example.aridosmanolo.R;
import com.example.aridosmanolo.model.Encargo;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class EncargoAdapter extends FirestoreRecyclerAdapter<Encargo,EncargoAdapter.ViewHolder> {

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    Activity activity;

    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public EncargoAdapter(@NonNull FirestoreRecyclerOptions<Encargo> options, Activity activity) {
        super(options);
        this.activity = activity;
    }

    @Override
    protected void onBindViewHolder(@NonNull EncargoAdapter.ViewHolder holder, int i, @NonNull Encargo Encargo) {

        DocumentSnapshot documentSnapshot = getSnapshots().getSnapshot(holder.getAdapterPosition());
        final String id = documentSnapshot.getId();

        holder.Gasto.setText(Encargo.getGasto());
        holder.Cantidad.setText(Encargo.getCantidad());
        holder.Proveedor.setText(Encargo.getProveedor());
        holder.Fecha.setText(Encargo.getFecha());
        holder.Material.setText(Encargo.getMaterial());

        holder.btn_Trash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteEncargado(id);
            }

            private void deleteEncargado(String id) {
                db.collection("Encargos").document(id).delete().addOnSuccessListener(new OnSuccessListener<Void>() {
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

        holder.btn_Edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(activity, New_Encargo.class);
                i.putExtra("id_Encargo",id);
                activity.startActivity(i);
            }
        });

    }

    @NonNull
    @Override
    public EncargoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_encargo_single,parent,false);
        return new ViewHolder(v);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView Cantidad,Material,Proveedor,Gasto,Fecha;

        ImageButton btn_Edit,btn_Trash;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Cantidad = itemView.findViewById(R.id.Cantidad);
            Material = itemView.findViewById(R.id.Material);
            Proveedor = itemView.findViewById(R.id.Proveedor);
            Gasto = itemView.findViewById(R.id.Gasto);
            Fecha = itemView.findViewById(R.id.Fecha);
            btn_Edit = itemView.findViewById(R.id.btn_Edit);
            btn_Trash = itemView.findViewById(R.id.btn_Trash);
        }
    }
}
