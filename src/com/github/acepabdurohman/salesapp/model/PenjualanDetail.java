package com.github.acepabdurohman.salesapp.model;

import java.math.BigDecimal;
/*
    Kelas detail dari header penjualan.
    Berelasi juga dengan barang
*/
public class PenjualanDetail {
    private Integer id;
    private Integer jumlah;
    private BigDecimal harga;
    private BigDecimal subtotal;
    private Barang barang;
    private Penjualan penjualan;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Penjualan getPenjualan() {
        return penjualan;
    }

    public void setPenjualan(Penjualan penjualan) {
        this.penjualan = penjualan;
    }
    
}
