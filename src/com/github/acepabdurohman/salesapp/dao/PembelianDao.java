package com.github.acepabdurohman.salesapp.dao;

import com.github.acepabdurohman.salesapp.connection.KoneksiDatabase;
import com.github.acepabdurohman.salesapp.model.Barang;
import com.github.acepabdurohman.salesapp.model.Pembelian;
import com.github.acepabdurohman.salesapp.model.PembelianDetail;
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
    Kelas PembelianDao merupakan kelas untuk query ke tabel pembelian
*/
public class PembelianDao {
    private KoneksiDatabase koneksiDB;
    public PembelianDao(KoneksiDatabase koneksiDB){
        this.koneksiDB = koneksiDB;
    }
    
    public void simpan(Pembelian pembelian) throws SQLException{
    
        Connection koneksi = koneksiDB.connect();
        String sql = "insert into t_pembelian values(null, ?, now(), ?)";
        // ambil key yang di generate mysql
        PreparedStatement ps = koneksi.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, pembelian.getDistributor().getIdDistributor());
        ps.setBigDecimal(2, pembelian.getTotal());
        Integer row = ps.executeUpdate(); // return nya berupa id yang baru saja di generate oleh mysql
        if(row != 0){
            JOptionPane.showMessageDialog(null, "Data berhasil disimpan", "Informasi", JOptionPane.INFORMATION_MESSAGE);

        }
        else{
            JOptionPane.showMessageDialog(null, "Data gagal disimpan", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
        
        ResultSet rs = ps.getGeneratedKeys(); // return 1 baris dan 1 kolom. tipe kembalian berupa resultset
        // posisi pointer 1 baris sebelum baris pada index ke 0
        rs.next(); // maju ke baris pertama (index 0)
        Integer id = rs.getInt(row); // ambil id yang baru saja di generate
        pembelian.setIdPembelian(id);
        koneksiDB.disconnect();
    }
    
    // method overload, nama sama tapi tipe parameter berbeda
    public void simpan(PembelianDetail detail) throws SQLException{
        Connection koneksi = koneksiDB.connect();
        String sql = "insert into t_pembelian_detail values(null, ?, ?, ?, ?, ?)";
        PreparedStatement ps = koneksi.prepareStatement(sql);
        ps.setInt(1, detail.getPembelian().getIdPembelian());
        ps.setString(2, detail.getBarang().getKodeBarang());
        ps.setInt(3, detail.getJumlah());
        ps.setBigDecimal(4, detail.getHarga());
        ps.setBigDecimal(5, detail.getSubtotal());
        ps.executeUpdate();
        koneksiDB.disconnect();
    }
}
