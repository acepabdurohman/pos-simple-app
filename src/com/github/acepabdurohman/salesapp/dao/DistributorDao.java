package com.github.acepabdurohman.salesapp.dao;

import com.github.acepabdurohman.salesapp.connection.KoneksiDatabase;
import com.github.acepabdurohman.salesapp.model.Distributor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/*
    Kelas DistributorDao untuk query ke tabel distributor
*/
public class DistributorDao {
    
    private final KoneksiDatabase koneksiDB;
    
    public DistributorDao(KoneksiDatabase kon){
          
        this.koneksiDB = kon;
    }
    
    public void simpan(Distributor distributor) throws SQLException{
        Connection koneksi = koneksiDB.connect();
        String sql = "insert into t_distributor values(null, ?, ?, ?, ?, ?)";
        PreparedStatement ps = koneksi.prepareStatement(sql);
        ps.setString(1, distributor.getNamaDistributor());
        ps.setString(2, distributor.getAlamat());
        ps.setString(3, distributor.getKotaAsal());
        ps.setString(4, distributor.getEmail());
        ps.setString(5, distributor.getNoTelepon());
        int hasil = ps.executeUpdate();
        if(hasil != 0){
            JOptionPane.showMessageDialog(null, "Data berhasil disimpan", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null, "Data gagal disimpan", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
        koneksiDB.disconnect();  
    }
    
    public void ubah(Distributor distributor) throws SQLException{
        Connection koneksi = koneksiDB.connect();
        String sql = "update t_distributor set nama_distributor = ?, alamat = ?, kota_asal = ?, email = ?, no_telpon = ? where id_distributor = ?";
        PreparedStatement ps = koneksi.prepareStatement(sql);
        ps.setString(1, distributor.getNamaDistributor());
        ps.setString(2, distributor.getAlamat());
        ps.setString(3, distributor.getKotaAsal());
        ps.setString(4, distributor.getEmail());
        ps.setString(5, distributor.getNoTelepon());
        ps.setInt(6, distributor.getIdDistributor());
        int hasil = ps.executeUpdate();
        if(hasil != 0){
            JOptionPane.showMessageDialog(null, "Data berhasil diubah", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null, "Data gagal diubah", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
        koneksiDB.disconnect();
    }
    
    public void hapus(Distributor distributor) throws SQLException{
        Connection con = koneksiDB.connect();
        String sql = "delete from t_distributor where id_distributor = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, distributor.getIdDistributor());
        ps.executeUpdate();
        koneksiDB.disconnect();
    }
    
    public List<Distributor> getAllDistributor() throws SQLException{
        List<Distributor> listDistributor = new ArrayList<>();
        Connection con = koneksiDB.connect();
        String sql = "select * from t_distributor";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Distributor dist = new Distributor();
            dist.setIdDistributor(rs.getInt(1));
            dist.setNamaDistributor(rs.getString(2));
            dist.setAlamat(rs.getString(3));
            dist.setKotaAsal(rs.getString(4));
            dist.setEmail(rs.getString(5));
            dist.setNoTelepon(rs.getString(6));
            listDistributor.add(dist);
        }
        koneksiDB.disconnect();
        return listDistributor;
    }
    
    public List<Distributor> searchByNama(String nama) throws SQLException{
    
        List<Distributor> listDistributor = new ArrayList<>();
        Connection con = koneksiDB.connect();
        String sql = "select * from t_distributor where nama_distributor = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, nama);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Distributor dist = new Distributor();
            dist.setIdDistributor(rs.getInt(1));
            dist.setNamaDistributor(rs.getString(2));
            dist.setNoTelepon(rs.getString(6));
            listDistributor.add(dist);
        }
        koneksiDB.disconnect();
        return listDistributor;
    }
}
