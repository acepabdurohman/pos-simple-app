package com.github.acepabdurohman.salesapp.dao;

import com.github.acepabdurohman.salesapp.connection.KoneksiDatabase;
import com.github.acepabdurohman.salesapp.model.Barang;
import com.github.acepabdurohman.salesapp.model.Jenis;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/*
    Kelas dao barang untuk setiap query ke tabel barang
*/
public class BarangDao {
    
    private final KoneksiDatabase koneksiDB;
    
    public BarangDao(KoneksiDatabase kon){
        this.koneksiDB = kon;
    }
    
    public void simpan(Barang barang) throws SQLException{
        Connection con = koneksiDB.connect();
        String sql = "insert into t_barang values(?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, barang.getKodeBarang());
        ps.setString(2, barang.getNamaBarang());
        ps.setString(3, barang.getJenis().getKodeJenis());
        ps.setInt(4, barang.getStok());
        ps.setBigDecimal(5, barang.getHargaBeli());
        ps.setBigDecimal(6, barang.getHargaJual());
        int hasil = ps.executeUpdate();
        if(hasil != 0){
            JOptionPane.showMessageDialog(null, "Data berhasil disimpan", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null, "Data gagal disimpan", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
        koneksiDB.disconnect();
    }
    
    public void ubah(Barang barang) throws SQLException{
        Connection con = koneksiDB.connect();
        String sql = "update t_barang set nama_barang = ?, kode_jenis = ?, stok = ?, harga_beli = ?, harga_jual = ? where kode_barang = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, barang.getNamaBarang());
        ps.setString(2, barang.getJenis().getKodeJenis());
        ps.setInt(3, barang.getStok());
        ps.setBigDecimal(4, barang.getHargaBeli());
        ps.setBigDecimal(5, barang.getHargaJual());
        ps.setString(6, barang.getKodeBarang());
        int hasil = ps.executeUpdate();
        if(hasil != 0){
            JOptionPane.showMessageDialog(null, "Data berhasil diubah", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null, "Data gagal diubah", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
        koneksiDB.disconnect(); 
    }
    
    public void hapus(Barang barang) throws SQLException{
        Connection koneksi = koneksiDB.connect();
        String sql = "delete from t_barang where kode_barang = ?";
        PreparedStatement ps = koneksi.prepareStatement(sql);
        ps.setString(1, barang.getKodeBarang());
        ps.executeUpdate();
        koneksiDB.disconnect();
    }
        
    // method mengambil data pada database berdasarkan pada limit tertentu
    public List<Barang> getBarangPaging(int halaman, int banyakBaris) throws SQLException{
        Connection koneksi = koneksiDB.connect();
        List<Barang> listBarang = new ArrayList<>();
        String sql = "select * from t_barang limit ?, ?";
        PreparedStatement ps = koneksi.prepareStatement(sql);
        ps.setInt(1, banyakBaris * (halaman - 1));
        ps.setInt(2, banyakBaris);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Barang barang = new Barang();
            Jenis jenis = new Jenis();
            barang.setKodeBarang(rs.getString("kode_barang"));            
            barang.setNamaBarang(rs.getString("nama_barang"));
            jenis.setKodeJenis(rs.getString("kode_jenis"));
            barang.setJenis(jenis);
            barang.setStok(rs.getInt("stok"));
            barang.setHargaBeli(rs.getBigDecimal("harga_beli"));
            barang.setHargaJual(rs.getBigDecimal("harga_jual"));
            listBarang.add(barang);
        }
        koneksiDB.disconnect();
        return listBarang;
    }
    
    // untuk menghitung jumlah data barang
    public int countBarang() throws SQLException{
        int jumlahBaris = 0;
        Connection koneksi = koneksiDB.connect();
        String sql = "select count(*) from t_barang";
        PreparedStatement ps = koneksi.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            jumlahBaris = rs.getInt("count(*)");
        }
        koneksiDB.disconnect();
        return jumlahBaris;
    }
    
    public List<Barang> getAllBarang() throws SQLException{
        Connection koneksi = koneksiDB.connect();
        List<Barang> listBarang = new ArrayList<>();
        String sql = "select * from t_barang";
        PreparedStatement ps = koneksi.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Barang barang = new Barang();
            Jenis jenis = new Jenis();
            barang.setKodeBarang(rs.getString("kode_barang"));            
            barang.setNamaBarang(rs.getString("nama_barang"));
            jenis.setKodeJenis(rs.getString("kode_jenis"));
            barang.setJenis(jenis);
            barang.setStok(rs.getInt("stok"));
            barang.setHargaBeli(rs.getBigDecimal("harga_beli"));
            barang.setHargaJual(rs.getBigDecimal("harga_jual"));
            listBarang.add(barang);
        }
        koneksiDB.disconnect();
        return listBarang;
    }
    
    public List<Barang> getBarangByKode(String kode) throws SQLException{
        List<Barang> barangs = new ArrayList<>();
        Connection koneksi = koneksiDB.connect();
        String sql = "select * from t_barang where kode_barang = ?";
        PreparedStatement ps = koneksi.prepareStatement(sql);
        ps.setString(1, kode);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Barang barang = new Barang();
            Jenis jenis = new Jenis();
            barang.setKodeBarang(rs.getString("kode_barang"));            
            barang.setNamaBarang(rs.getString("nama_barang"));
            jenis.setKodeJenis(rs.getString("kode_jenis"));
            barang.setJenis(jenis);
            barang.setStok(rs.getInt("stok"));
            barang.setHargaBeli(rs.getBigDecimal("harga_beli"));
            barang.setHargaJual(rs.getBigDecimal("harga_jual"));
            barangs.add(barang);
        }
        koneksiDB.disconnect();
        return barangs;
    }
        
    public List<Barang> searchBarangByNama(String nama) throws SQLException{
        Connection koneksi = koneksiDB.connect();
        List<Barang> listBarang = new ArrayList<>();
        String sql = "select * from t_barang where nama_barang like ?";
        PreparedStatement ps = koneksi.prepareStatement(sql);
        ps.setString(1, "%" + nama + "%");
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Barang barang = new Barang();
            Jenis jenis = new Jenis();
            barang.setKodeBarang(rs.getString("kode_barang"));            
            barang.setNamaBarang(rs.getString("nama_barang"));
            jenis.setKodeJenis(rs.getString("kode_jenis"));
            barang.setJenis(jenis);
            barang.setStok(rs.getInt("stok"));
            barang.setHargaBeli(rs.getBigDecimal("harga_beli"));
            barang.setHargaJual(rs.getBigDecimal("harga_jual"));
            listBarang.add(barang);
        }
        koneksiDB.disconnect();
        return listBarang;
    }
    
    public Barang getByKode(String kode) throws SQLException{
        Barang barang = new Barang();
        Connection koneksi = koneksiDB.connect();
        String sql = "select * from t_barang where kode_barang = ?";
        PreparedStatement ps = koneksi.prepareStatement(sql);
        ps.setString(1, kode);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Jenis jenis = new Jenis();
            barang.setKodeBarang(rs.getString("kode_barang"));            
            barang.setNamaBarang(rs.getString("nama_barang"));
            jenis.setKodeJenis(rs.getString("kode_jenis"));
            barang.setJenis(jenis);
            barang.setStok(rs.getInt("stok"));
            barang.setHargaBeli(rs.getBigDecimal("harga_beli"));
            barang.setHargaJual(rs.getBigDecimal("harga_jual"));
        }
        koneksiDB.disconnect();
        return barang;
    }
}
