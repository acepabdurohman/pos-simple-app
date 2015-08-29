package com.github.acepabdurohman.salesapp.service;

import com.github.acepabdurohman.salesapp.model.Pembelian;
import com.github.acepabdurohman.salesapp.model.PembelianDetail;
import com.github.acepabdurohman.salesapp.model.Penjualan;
import com.github.acepabdurohman.salesapp.model.PenjualanDetail;
import java.util.List;

/*
    Sama dengan masterservice akan tetapi interface ini menampung setiap method
    pada objek yang digunakan untuk melakukan transaksi
    Misalnya penjualan dan pembelian
*/
public interface TransactionService {
    public void simpan(Penjualan p);
    public void simpan(PenjualanDetail detail);
    public List<PenjualanDetail> getPenjualanDetailByIdPenjualan(Integer id);
    public List<Penjualan> getPenjualanPaging(int halaman, int banyakBaris);
    public List<Penjualan> getPenjualanById(Integer id);
    public Integer countPenjualan();
    
    public void simpan(Pembelian pembelian);
    public void simpan(PembelianDetail detail);
}
