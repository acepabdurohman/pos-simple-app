package com.github.acepabdurohman.salesapp.dao;

import com.github.acepabdurohman.salesapp.connection.KoneksiDatabase;
import com.github.acepabdurohman.salesapp.model.Jenis;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/*
    JenisDao merupakan kelas untuk query ke tabel jenis

*/
public class JenisDao {
    private final KoneksiDatabase koneksiDB;

    public JenisDao(KoneksiDatabase kon){
        this.koneksiDB = kon;
    }
    
    public void simpan(Jenis jenis) throws SQLException{
        
        String sql = "insert into t_jenis values(?, ?)";

        Connection con = koneksiDB.connect();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, jenis.getKodeJenis());
        ps.setString(2, jenis.getJenis());
        int hasil = ps.executeUpdate();
        if(hasil != 0){
            JOptionPane.showMessageDialog(null, "Data berhasil disimpan", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null, "Data gagal disimpan", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
        koneksiDB.disconnect();       
    }
    
    public void ubah(Jenis jenis) throws SQLException{
        String sql = "update t_jenis set jenis = ? where kode_jenis = ?";
        Connection con = koneksiDB.connect();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, jenis.getJenis());
        ps.setString(2, jenis.getKodeJenis());
        int hasil = ps.executeUpdate();
        if(hasil != 0){
            JOptionPane.showMessageDialog(null, "Data berhasil diubah", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null, "Data gagal diubah", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
        koneksiDB.disconnect();  
    }
    
    public void hapus(Jenis jenis) throws SQLException{
        String sql = "delete from t_jenis where kode_jenis = ?";
        Connection con = koneksiDB.connect();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, jenis.getKodeJenis());
        ps.executeUpdate();
        koneksiDB.disconnect();  
    }
    
    public List<Jenis> getAllJenis() throws SQLException{
        List<Jenis> listJenis = new ArrayList<Jenis>();
        String sql = "select * from t_jenis";
        Connection con = koneksiDB.connect();
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Jenis jenis = new Jenis();
            jenis.setKodeJenis(rs.getString("kode_jenis"));
            jenis.setJenis(rs.getString("jenis"));
            listJenis.add(jenis);
        }
        koneksiDB.disconnect();
        return listJenis;
    }
    
    public List<Jenis> getJenisByKode(String kodeJenis) throws SQLException{
        List<Jenis> listJenis = new ArrayList<>();
        String sql = "select * from t_jenis where kode_jenis = ?";
        Connection con = koneksiDB.connect();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, kodeJenis);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Jenis jenis = new Jenis();
            jenis.setKodeJenis(rs.getString("kode_jenis"));
            jenis.setJenis(rs.getString("jenis"));
            listJenis.add(jenis);
        }
        koneksiDB.disconnect();
        return listJenis;
    }
    
    public Jenis getJenisByKodeSelection(String kode) throws SQLException{
        Jenis jenis = new Jenis();
        String sql = "select * from t_jenis where kode_jenis = ?";
        Connection con = koneksiDB.connect();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, kode);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            
            jenis.setKodeJenis(rs.getString("kode_jenis"));
            jenis.setJenis(rs.getString("jenis"));
            
        }
        koneksiDB.disconnect();
        return jenis;
    }
}
