package com.example.sinongki;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PesananAdapter extends RecyclerView.Adapter<PesananAdapter.PesananViewHolder>{
    private Context context;
    private List<PesananModel> pesananList;
    //private int counts = 0;

    public PesananAdapter(Context context, ArrayList<PesananModel> pesananList){
        this.context = context;
        this.pesananList = pesananList;
    }

    @NonNull
    @Override
    public PesananViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_pesanan, parent, false);
        return new PesananViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PesananViewHolder holder, int position) {
        final PesananModel pesanan = pesananList.get(position);
        holder.namaPesanan.setText(pesanan.getNamaPesanan());
        holder.hargaPesanan.setText(pesanan.getHargaPesanan());
        holder.jumlahPesanan.setText(pesanan.getJumlahPesanan());
    }

    @Override
    public int getItemCount() {
        return pesananList.size();
    }

    public class PesananViewHolder extends RecyclerView.ViewHolder {
        ImageView ic_pesanan;
        TextView namaPesanan;
        TextView hargaPesanan;
        TextView jumlahPesanan;
        public PesananViewHolder(@NonNull View itemView) {
            super(itemView);
//            ic_pesanan = itemView.findViewById(R.id.pic_pesanan);
            namaPesanan = itemView.findViewById(R.id.txt_pesanan);
            hargaPesanan = itemView.findViewById(R.id.txt_price_pesanan);
            jumlahPesanan = itemView.findViewById(R.id.txt_count_pesanan);
        }
    }
}
