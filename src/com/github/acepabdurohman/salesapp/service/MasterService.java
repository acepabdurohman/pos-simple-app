package com.github.acepabdurohman.salesapp.service;

import com.github.acepabdurohman.salesapp.model.Barang;
import com.github.acepabdurohman.salesapp.model.Distributor;
import com.github.acepabdurohman.salesapp.model.Jenis;
import com.github.acepabdurohman.salesapp.model.User;
import java.sql.SQLException;
import java.util.List;
/*
    Interface untuk kelas yang merepresentasikan tabel tabel master pada database
    Interface ini untuk nantinya di implementasikan oleh kelas yang memiliki "kontrak" untuk mengimplementasikannya
    Service layer berupa Kelas - kelas yang mengatur setiap koneksi ke database
    juga sebagai layer yang berfungsi menghandle setiap exception yang terjadi
*/
public interface MasterService {
    
    public void simpan(Jenis jenis);
    public void ubah(Jenis jenis);
    public void hapus(Jenis jenis);
    public List<Jenis> getAllJenis();
    public List<Jenis> getJenisByKode(String kodeJenis);
    public Jenis getJenisByKodeSelection(String kode);
    
    public void simpan(Barang barang);
    public void ubah(Barang barang);
    public void hapus(Barang barang);
    public List<Barang> getBarangPaging(int halaman, int banyakBaris);
    public int countBarang();
    public List<Barang> getAllBarang();
    public List<Barang> getBarangByKode(String kode);
    public List<Barang> searchBarangByNama(String nama);
    public Barang getByKode(String kode);
    
    public void simpan(Distributor distributor);
    public void ubah(Distributor distributor);
    public void hapus(Distributor distributor);
    public List<Distributor> getAllDistributor();
    public List<Distributor> searchByNama(String nama);
    
    
}
