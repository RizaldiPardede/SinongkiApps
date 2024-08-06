package com.example.sinongki;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MinumanAdapter extends RecyclerView.Adapter<MinumanAdapter.MinumanViewHolder>{
    private Context context;
    private List<MinumanModel> minumanList;
    //private int counts = 0;

    public MinumanAdapter(Context context, ArrayList<MinumanModel> minumanList){
        this.context = context;
        this.minumanList = minumanList;
    }

    @NonNull
    @Override

    public MinumanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_minuman, parent, false);
        return new MinumanViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MinumanViewHolder holder, int position) {
        final MinumanModel minuman = minumanList.get(position);
        holder.namaMinuman.setText(minuman.getNamaMinuman());
        holder.hargaMinuman.setText(String.valueOf(minuman.getHargaMinuman()));
        holder.jenis.setText(minuman.getJenis());
        //counts = Integer.parseInt(holder.count. getText().toString());
        holder.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //counts = counts + 1;
                int counts = 0;
                counts = Integer.parseInt(holder.count.getText().toString()) + 1;
                holder.count.setText(String.valueOf(counts));
            }
        });

        holder.substract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int counts = Integer.parseInt(holder.count.getText().toString()) - 1;
                holder.count.setText(String.valueOf(counts));
            }
        });
        holder.pesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, holder.count.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return minumanList.size();
    }

    public class MinumanViewHolder extends RecyclerView.ViewHolder {
        TextView namaMinuman;
        TextView hargaMinuman;
        TextView jenis;
        ImageView add;
        ImageView substract;
        Button pesan;
        TextView count;
        public MinumanViewHolder(@NonNull View itemView) {
            super(itemView);
            namaMinuman = itemView.findViewById(R.id.txt_minuman);
            hargaMinuman = itemView.findViewById(R.id.txt_price);
            jenis = itemView.findViewById(R.id.txt_jenis);
            add = itemView.findViewById(R.id.ic_add);
            substract = itemView.findViewById(R.id.ic_substract);
            pesan = itemView.findViewById(R.id.btn_pesan);
            count = itemView.findViewById(R.id.count);
        }
    }

}
