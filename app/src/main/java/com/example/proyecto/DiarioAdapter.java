package com.example.proyecto;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DiarioAdapter extends RecyclerView.Adapter<DiarioAdapter.DiarioHolder> implements View.OnClickListener {

    List<InfoDiario> listaDiario;
    private View.OnClickListener listener;

    public DiarioAdapter(List<InfoDiario> listaDiario){
        this.listaDiario=listaDiario;
    }

    @NonNull
    @Override
    public DiarioAdapter.DiarioHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.vista_diarios,parent,false);
        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        vista.setLayoutParams(layoutParams);
        vista.setOnClickListener(this);
        return new DiarioHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull DiarioAdapter.DiarioHolder holder, int position) {
        holder.fecha.setText(listaDiario.get(position).getFecha().toString());
        holder.emocion.setText(listaDiario.get(position).getEmocion().toString());
    }

    @Override
    public int getItemCount() {
        return listaDiario.size();
    }

    public void SetOnClickListener (View.OnClickListener listener){
        this.listener = listener;
    }
    @Override
    public void onClick(View view) {
        if (listener!=null){
            listener.onClick(view);
        }

    }

    public class DiarioHolder extends RecyclerView.ViewHolder {

        TextView fecha, emocion;
        public DiarioHolder(@NonNull View itemView) {
            super(itemView);
            fecha = (TextView)itemView.findViewById(R.id.fec_Diario);
            emocion = (TextView) itemView.findViewById(R.id.emo_Diario);

        }
    }
}
