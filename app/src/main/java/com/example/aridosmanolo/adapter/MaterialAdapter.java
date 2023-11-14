package com.example.aridosmanolo.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aridosmanolo.Edit_Inventario;
import com.example.aridosmanolo.R;
import com.example.aridosmanolo.model.Material;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class MaterialAdapter extends FirestoreRecyclerAdapter<Material,MaterialAdapter.ViewHolder> {

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    Activity activity;


    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public MaterialAdapter(@NonNull FirestoreRecyclerOptions<Material> options, Activity activity) {
        super(options);
        this.activity = activity;
    }

    @Override
    protected void onBindViewHolder(@NonNull MaterialAdapter.ViewHolder holder, int i, @NonNull Material Material) {

        DocumentSnapshot documentSnapshot = getSnapshots().getSnapshot(holder.getAdapterPosition());
        final String id = documentSnapshot.getId();

        holder.Material.setText(Material.getMaterial());
        holder.Cantidad.setText(Material.getCantidad());

        holder.btn_Edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(activity, Edit_Inventario.class);
                i.putExtra("id_Material",id);
                activity.startActivity(i);
            }
        });

    }

    @NonNull
    @Override
    public MaterialAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_material_single,parent,false);
        return new ViewHolder(v);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView Material, Cantidad;

        ImageButton btn_Edit;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Material = itemView.findViewById(R.id.Material);
            Cantidad = itemView.findViewById(R.id.Cantidad);
            btn_Edit = itemView.findViewById(R.id.btn_Edit);
        }
    }
}
