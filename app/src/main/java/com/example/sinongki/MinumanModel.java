package com.example.sinongki;

public class MinumanModel {
    private String namaMinuman;
    private int hargaMinuman;
    private String jenis;

    public MinumanModel(String namaMinuman, int hargaMinuman, String jenis) {
        this.namaMinuman = namaMinuman;
        this.hargaMinuman = hargaMinuman;
        this.jenis = jenis;
    }

    public MinumanModel() {

    }

    public String getNamaMinuman() {
        return namaMinuman;
    }

    public void setNamaMinuman(String namaMinuman) {
        this.namaMinuman = namaMinuman;
    }

    public int getHargaMinuman() {
        return hargaMinuman;
    }

    public void setHargaMinuman(int hargaMinuman) {
        this.hargaMinuman = hargaMinuman;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }
}
