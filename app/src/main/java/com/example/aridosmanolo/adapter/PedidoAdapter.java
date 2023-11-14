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

import com.example.aridosmanolo.New_Pedido;
import com.example.aridosmanolo.R;
import com.example.aridosmanolo.model.Pedido;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class PedidoAdapter extends FirestoreRecyclerAdapter<Pedido,PedidoAdapter.ViewHolder> {

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    Activity activity;

    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public PedidoAdapter(@NonNull FirestoreRecyclerOptions<Pedido> options,Activity activity) {
        super(options);
        this.activity = activity;
    }

    @Override
    protected void onBindViewHolder(@NonNull PedidoAdapter.ViewHolder holder, int i, @NonNull Pedido Pedido) {

        DocumentSnapshot documentSnapshot = getSnapshots().getSnapshot(holder.getAdapterPosition());
        final String id = documentSnapshot.getId();

        holder.Direccion.setText(Pedido.getDireccion());
        holder.Fecha.setText(Pedido.getFecha());
        holder.Descripcion.setText(Pedido.getDescripcion());
        holder.Cliente.setText(Pedido.getCliente());

        holder.btn_Trash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deletePedido(id);
            }

            private void deletePedido(String id){
                db.collection("Pedidos").document(id).delete().addOnSuccessListener(new OnSuccessListener<Void>() {
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
                Intent i = new Intent(activity, New_Pedido.class);
                i.putExtra("id_Pedido",id);
                activity.startActivity(i);
            }
        });
    }

    @NonNull
    @Override
    public PedidoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_pedido_single,parent,false);
        return new ViewHolder(v);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView Cliente,Descripcion,Direccion,Fecha;
        ImageButton btn_Edit,btn_Trash;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Cliente = itemView.findViewById(R.id.Cliente);
            Descripcion = itemView.findViewById(R.id.Descripcion);
            Direccion = itemView.findViewById(R.id.Direccion);
            Fecha = itemView.findViewById(R.id.Fecha);
            btn_Edit = itemView.findViewById(R.id.btn_Edit);
            btn_Trash = itemView.findViewById(R.id.btn_Trash);
        }
    }
}
