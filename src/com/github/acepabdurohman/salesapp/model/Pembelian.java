package com.github.acepabdurohman.salesapp.model;

import java.math.BigDecimal;
import java.sql.Date;
/*
    Kelas ini juga merepresentasikan tabel pembelian pada database menjadi suatu kelas
    yang akan di instance menjadi objek.
    Pada database, pembelian merupakan header yang mana mempunyai detail.
    Artinya pembelian ini direlasikan ke pembelian detail dengan relasi 1 ke N.
    Dimana 1 header (pembelian) tentunya mempunyai banyak detail (pembelian detail).
    Selain itu relasi antara pembelian dengan distributor adalah N ke 1
    Sehingga 1 distributor bisa mengirim banyak barang.
    Di kelas ini dideklarasikan kelas distributor
*/
public class Pembelian {
    private Integer idPembelian;
    private Distributor distributor;
    private Date tanggal;
    private BigDecimal total;

    public Integer getIdPembelian() {
        return idPembelian;
    }

    public void setIdPembelian(Integer idPembelian) {
        this.idPembelian = idPembelian;
    }

    public Distributor getDistributor() {
        return distributor;
    }

    public void setDistributor(Distributor distributor) {
        this.distributor = distributor;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    
    
}
