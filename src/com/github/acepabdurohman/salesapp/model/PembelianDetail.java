package com.github.acepabdurohman.salesapp.model;

import java.math.BigDecimal;
/*
    Ini merupakan kelas detail dari header pembelian tadi.
    Selain itu, kelas detail ini direlasikan dengan kelas barang
    relasinya N ke 1 (banyak pembelian untuk 1 barang).
*/
public class PembelianDetail {
    private Integer idPembelian;
    private Integer jumlah;
    private BigDecimal harga;
    private BigDecimal subtotal;
    private Barang barang;
    private Pembelian pembelian;

    public Integer getIdPembelian() {
        return idPembelian;
    }

    public void setIdPembelian(Integer idPembelian) {
        this.idPembelian = idPembelian;
    }

    public Integer getJumlah() {
        return jumlah;
    }

    public void setJumlah(Integer jumlah) {
        this.jumlah = jumlah;
    }

    public BigDecimal getHarga() {
        return harga;
    }

    public void setHarga(BigDecimal harga) {
        this.harga = harga;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public Barang getBarang() {
        return barang;
    }

    public void setBarang(Barang barang) {
        this.barang = barang;
    }

    public Pembelian getPembelian() {
        return pembelian;
    }

    public void setPembelian(Pembelian pembelian) {
        this.pembelian = pembelian;
    }    
    
}
