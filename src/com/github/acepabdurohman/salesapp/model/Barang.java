package com.github.acepabdurohman.salesapp.model;

import java.math.BigDecimal;
/*
    Kelas POJO barang. Kelas ini merepresentasikan tabel barang di database menjadi suatu kelas
    yang kemudian di instance (wujudkan) menjadi objek
    Karena relasi antara barang dengan jenis adalah N ke 1 maka kelas jenis di deklarasikan
    di kelas barang ini
*/
public class Barang {
    
    private String kodeBarang;
    private String namaBarang;
    private Integer stok;
    private BigDecimal hargaBeli;
    private BigDecimal hargaJual;
    private Jenis jenis;

    public String getKodeBarang() {
        return kodeBarang;
    }

    public void setKodeBarang(String kodeBarang) {
        this.kodeBarang = kodeBarang;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public Integer getStok() {
        return stok;
    }

    public void setStok(Integer stok) {
        this.stok = stok;
    }

    public BigDecimal getHargaBeli() {
        return hargaBeli;
    }

    public void setHargaBeli(BigDecimal hargaBeli) {
        this.hargaBeli = hargaBeli;
    }

    public BigDecimal getHargaJual() {
        return hargaJual;
    }

    public void setHargaJual(BigDecimal hargaJual) {
        this.hargaJual = hargaJual;
    }

    public Jenis getJenis() {
        return jenis;
    }

    public void setJenis(Jenis jenis) {
        this.jenis = jenis;
    }

}
