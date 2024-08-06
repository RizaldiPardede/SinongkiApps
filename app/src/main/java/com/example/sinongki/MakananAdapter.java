package com.example.sinongki;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MakananAdapter extends RecyclerView.Adapter<MakananAdapter.MakananViewHolder>{
    private Context context;
    private List<MakananModel> makananList;

    public MakananAdapter(Context context, List<MakananModel> makananList) {
        this.context = context;
        this.makananList = makananList;
    }

    @NonNull
    @Override
    public MakananViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_makanan, parent, false);
        return new MakananViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MakananViewHolder holder, int position) {
        final MakananModel makanan = makananList.get(position);
        holder.namaMakanan.setText(makanan.getNamaMakanan());
        holder.hargaMakanan.setText(makanan.getHargaMakanan());
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
    }

    @Override
    public int getItemCount() {
        return makananList.size();
    }

    public class MakananViewHolder extends RecyclerView.ViewHolder {
        TextView namaMakanan;
        TextView hargaMakanan;
        ImageView add;
        ImageView substract;
        Button pesan;
        TextView count;
        public MakananViewHolder(@NonNull View itemView) {
            super(itemView);
            namaMakanan = itemView.findViewById(R.id.txt_menu_makanan);
            hargaMakanan = itemView.findViewById(R.id.harga_makanan);
            add = itemView.findViewById(R.id.ic_add_makanan);
            substract = itemView.findViewById(R.id.ic_substract_makanan);
            pesan = itemView.findViewById(R.id.btn_pesan_makanan);
            count = itemView.findViewById(R.id.count_makanan);
        }
    }
}
