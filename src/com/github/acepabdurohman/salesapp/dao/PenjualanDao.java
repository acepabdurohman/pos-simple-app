
package com.github.acepabdurohman.salesapp.dao;

import com.github.acepabdurohman.salesapp.connection.KoneksiDatabase;
import com.github.acepabdurohman.salesapp.model.Barang;
import com.github.acepabdurohman.salesapp.model.Jenis;
import com.github.acepabdurohman.salesapp.model.Penjualan;
import com.github.acepabdurohman.salesapp.model.PenjualanDetail;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
/*
    Kelas penjualandao digunakan untuk setiap query ke table penjualan
*/
public class PenjualanDao {
    private KoneksiDatabase koneksiDB;
    
    public PenjualanDao(KoneksiDatabase koneksiDB){
        this.koneksiDB = koneksiDB;
    }
    
    public void simpan(Penjualan p) throws SQLException{
        Connection koneksi = koneksiDB.connect();
        Integer row = null;
        String sql = "insert into t_penjualan values(null, now(), ?)";
        PreparedStatement ps = koneksi.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        // isi parameter
        ps.setBigDecimal(1, p.getTotal());
        row = ps.executeUpdate();
        if(row != 0){
            JOptionPane.showMessageDialog(null, "Data berhasil disimpan", "Informasi", JOptionPane.INFORMATION_MESSAGE);

        }
        else{
            JOptionPane.showMessageDialog(null, "Data gagal disimpan", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
        ResultSet rs = ps.getGeneratedKeys();
        rs.next();
        // ambil data pada baris yang baru saja diinsert
        Integer id = rs.getInt(row);
        p.setIdPenjualan(id);
        koneksiDB.disconnect();
    }
    
    public void simpan(PenjualanDetail detail) throws SQLException{
        Connection koneksi = koneksiDB.connect();
        
        String sql = "insert into t_penjualan_detail values(null, ?, ?, ?, ?, ?)";
        PreparedStatement ps = koneksi.prepareStatement(sql);
        ps.setInt(1, detail.getPenjualan().getIdPenjualan());
        ps.setString(2, detail.getBarang().getKodeBarang());
        ps.setInt(3, detail.getJumlah());
        ps.setBigDecimal(4, detail.getHarga());
        ps.setBigDecimal(5, detail.getSubtotal());
        ps.executeUpdate();
        
        String sqlUpdateStok = "update t_barang set stok = stok - ? where kode_barang = ?"; // update stok barang
        PreparedStatement psUpdate = koneksi.prepareStatement(sqlUpdateStok);
        psUpdate.setInt(1, detail.getJumlah());
        psUpdate.setString(2, detail.getBarang().getKodeBarang());
        psUpdate.executeUpdate();
        koneksiDB.disconnect();
    }
    
    public List<PenjualanDetail> getPenjualanDetailByIdPenjualan(Integer id) throws SQLException{
        List<PenjualanDetail> details = new ArrayList<>();
        Connection koneksi = koneksiDB.connect();
        String sql = "select b.kode_barang, b.nama_barang, d.jumlah, d.harga, d.subtotal"
                + " from t_barang b, t_penjualan_detail d, t_penjualan p"
                + " where b.kode_barang = d.kode_barang"
                + " and p.id_penjualan = d.id_penjualan"
                + " and p.id_penjualan = ?";
        PreparedStatement ps = koneksi.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            PenjualanDetail detail = new PenjualanDetail();
            Barang barang = new Barang();
            barang.setKodeBarang(rs.getString("kode_barang"));
            barang.setNamaBarang(rs.getString("nama_barang"));
            detail.setBarang(barang);
            detail.setJumlah(rs.getInt("jumlah"));
            detail.setHarga(rs.getBigDecimal("harga"));
            detail.setSubtotal(rs.getBigDecimal("subtotal"));
            details.add(detail);
        }
        koneksiDB.disconnect();
        return details;
    }
    
    public List<Penjualan> getPenjualanPaging(int halaman, int banyakBaris) throws SQLException{
        Connection koneksi = koneksiDB.connect();
        List<Penjualan> listPenjualan = new ArrayList<>();
        String sql = "select * from t_penjualan limit ?, ?";
        PreparedStatement ps = koneksi.prepareStatement(sql);
        ps.setInt(1, banyakBaris * (halaman - 1));
        ps.setInt(2, banyakBaris);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Penjualan penjualan = new Penjualan();
            penjualan.setIdPenjualan(rs.getInt("id_penjualan"));
            penjualan.setTanggal(rs.getDate("tanggal"));
            penjualan.setTotal(rs.getBigDecimal("total"));
            listPenjualan.add(penjualan);
        }
        koneksiDB.disconnect();
        return listPenjualan;
    }
    
    public List<Penjualan> getPenjualanById(Integer id) throws SQLException{
        Connection koneksi = koneksiDB.connect();
        List<Penjualan> listPenjualan = new ArrayList<>();
        String sql = "select * from t_penjualan where id_penjualan = ?";
        PreparedStatement ps = koneksi.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Penjualan penjualan = new Penjualan();
            penjualan.setIdPenjualan(rs.getInt("id_penjualan"));
            penjualan.setTanggal(rs.getDate("tanggal"));
            penjualan.setTotal(rs.getBigDecimal("total"));
            listPenjualan.add(penjualan);
        }
        koneksiDB.disconnect();
        return listPenjualan;
    }
    
    public Integer countPenjualan() throws SQLException{
        Integer rowPenjualan = null;
        Connection koneksi = koneksiDB.connect();
        String sql = "select count(*) from t_penjualan";
        PreparedStatement ps = koneksi.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            rowPenjualan = rs.getInt("count(*)");
        }
        koneksiDB.disconnect();
        return rowPenjualan;
    }
    
}
