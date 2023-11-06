package com.example.aridosmanolo.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aridosmanolo.Inventario;
import com.example.aridosmanolo.R;
import com.example.aridosmanolo.model.Material;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class MaterialAdapter extends FirestoreRecyclerAdapter<Material,MaterialAdapter.ViewHolder> {
    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     * @param inventario
     */
    public MaterialAdapter(@NonNull FirestoreRecyclerOptions<Material> options, Inventario inventario) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull MaterialAdapter.ViewHolder holder, int i, @NonNull Material Material) {

    }

    @NonNull
    @Override
    public MaterialAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_material_single,parent,false);
        return new ViewHolder(v);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView Nombre, Cantidad, Valor;

        ImageButton btn_Edit;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Nombre = itemView.findViewById(R.id.Nombre);
            Cantidad = itemView.findViewById(R.id.Cantidad);
            Valor = itemView.findViewById(R.id.Valor);
            btn_Edit = itemView.findViewById(R.id.btn_Edit);
        }
    }
}
