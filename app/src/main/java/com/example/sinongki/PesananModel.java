package com.example.sinongki;

public class PesananModel {
    private String namaPesanan;
    private String hargaPesanan;
    private int jumlahPesanan;

    public PesananModel(String namaPesanan, String hargaPesanan, int jumlahPesanan) {
        this.namaPesanan = namaPesanan;
        this.hargaPesanan = hargaPesanan;
        this.jumlahPesanan = jumlahPesanan;
    }

    public String getNamaPesanan() {
        return namaPesanan;
    }

    public void setNamaPesanan(String namaPesanan) {
        this.namaPesanan = namaPesanan;
    }

    public String getHargaPesanan() {
        return hargaPesanan;
    }

    public void setHargaPesanan(String hargaPesanan) {
        this.hargaPesanan = hargaPesanan;
    }

    public int getJumlahPesanan() {
        return jumlahPesanan;
    }

    public void setJumlahPesanan(int jumlahPesanan) {
        this.jumlahPesanan = jumlahPesanan;
    }
}