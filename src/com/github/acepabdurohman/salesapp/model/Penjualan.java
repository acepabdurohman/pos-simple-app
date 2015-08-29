package com.github.acepabdurohman.salesapp.model;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
/*
    Kelas ini sama dengan tabel pembelian tadi, tapi tidak mempunyai relasi lain
    selain dari relasi ke tabel detailnya
*/
public class Penjualan {
    private Integer idPenjualan;
    private Date tanggal;
    private BigDecimal total;

    public Integer getIdPenjualan() {
        return idPenjualan;
    }

    public void setIdPenjualan(Integer idPenjualan) {
        this.idPenjualan = idPenjualan;
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
