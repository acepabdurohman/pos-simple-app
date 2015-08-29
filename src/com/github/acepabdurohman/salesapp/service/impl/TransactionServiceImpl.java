package com.github.acepabdurohman.salesapp.service.impl;

import com.github.acepabdurohman.salesapp.connection.KoneksiDatabase;
import com.github.acepabdurohman.salesapp.dao.PembelianDao;
import com.github.acepabdurohman.salesapp.dao.PenjualanDao;
import com.github.acepabdurohman.salesapp.model.Pembelian;
import com.github.acepabdurohman.salesapp.model.PembelianDetail;
import com.github.acepabdurohman.salesapp.model.Penjualan;
import com.github.acepabdurohman.salesapp.model.PenjualanDetail;
import com.github.acepabdurohman.salesapp.service.TransactionService;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.openide.util.Exceptions;

/*
    Kelas yang mengimplementasikan interface transaksi service
    Tugasnya sama seperti master service dan security service tapi beda objek
    dan tentunya data yang diolah
*/
public class TransactionServiceImpl implements TransactionService{
    private final KoneksiDatabase koneksiDB;
    private final Connection koneksi;
    private final PenjualanDao penjualanDao;
    private final PembelianDao pembelianDao;
    public TransactionServiceImpl(KoneksiDatabase koneksiDB){
        this.koneksiDB = koneksiDB;
        this.koneksi = this.koneksiDB.connect();
        penjualanDao = new PenjualanDao(this.koneksiDB);
        pembelianDao = new PembelianDao(this.koneksiDB);
    }
    @Override
    public void simpan(Penjualan p){
        try{
            // dalam mode transaksi, koneksi di disable dulu
            koneksi.setAutoCommit(false);
            // panggil dao penjualan
            penjualanDao.simpan(p);
            // eksekusi
            koneksi.commit();
            // enable mode transaksi
            koneksi.setAutoCommit(true);
        } catch(SQLException exe){
            try{
                koneksi.rollback();
                System.out.println("Rollback transaksi");
            } catch(SQLException ex){
                ex.printStackTrace();
            }
            exe.printStackTrace();
            System.out.println("Masalah saat penyimpanan");
        }
        
    }
    @Override
    public void simpan(PenjualanDetail detail){
        try{
            // dalam mode transaksi, koneksi di disable dulu
            koneksi.setAutoCommit(false);
            // panggil dao penjualan
            penjualanDao.simpan(detail);
            // eksekusi
            koneksi.commit();
            // enable mode transaksi
            koneksi.setAutoCommit(true);
        } catch(SQLException exe){
            try{
                koneksi.rollback();
                System.out.println("Rollback transaksi");
            } catch(SQLException ex){
                ex.printStackTrace();
            }
            exe.printStackTrace();
            System.out.println("Masalah saat penyimpanan");
        }
    }
    
    @Override
    public List<PenjualanDetail> getPenjualanDetailByIdPenjualan(Integer id){
        try{
            return penjualanDao.getPenjualanDetailByIdPenjualan(id);
        } catch(SQLException exe){
            exe.printStackTrace();
            System.out.println("Masalah dalam pengambilan data");
        }
        return new ArrayList<>();
    }
    @Override
    public List<Penjualan> getPenjualanPaging(int halaman, int banyakBaris){
        try{
            return penjualanDao.getPenjualanPaging(halaman, banyakBaris);
        } catch(SQLException exe){
            exe.printStackTrace();
            System.out.println("Masalah dalam pengambilan data");
        }
        return new ArrayList<>();
    }
    @Override
    public List<Penjualan> getPenjualanById(Integer id){
        try{
            return penjualanDao.getPenjualanById(id);
        } catch(SQLException exe){
            exe.printStackTrace();
            System.out.println("Masalah dalam pengambilan data");
        }
        return new ArrayList<>();
    }
    @Override
    public Integer countPenjualan(){
        try{
            return penjualanDao.countPenjualan();
        } catch(SQLException exe){
            exe.printStackTrace();
        }
        return null;      
    }
    
    @Override
    public void simpan(Pembelian pembelian){
        try{
            koneksi.setAutoCommit(false);
            pembelianDao.simpan(pembelian);
            koneksi.commit();
            koneksi.setAutoCommit(true);
        }
        catch(SQLException exe){
            exe.printStackTrace();
            try{
                koneksi.rollback();
                System.out.println("Rollback");
            }
            catch(SQLException exec){
                exec.printStackTrace();
            }            
        }
    }
    
    @Override
    public void simpan(PembelianDetail detail){
        try{
            koneksi.setAutoCommit(false);
            pembelianDao.simpan(detail);
            koneksi.commit();
            koneksi.setAutoCommit(true);
        }
        catch(SQLException ex){
            ex.printStackTrace();
            try {
                koneksi.rollback();
                System.out.println("Rollback");
            } catch (SQLException exe) {
                exe.printStackTrace();
            }
        }
    }
}
