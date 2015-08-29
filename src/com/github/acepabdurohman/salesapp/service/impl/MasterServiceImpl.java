package com.github.acepabdurohman.salesapp.service.impl;

import com.github.acepabdurohman.salesapp.connection.KoneksiDatabase;
import com.github.acepabdurohman.salesapp.dao.BarangDao;
import com.github.acepabdurohman.salesapp.dao.DistributorDao;
import com.github.acepabdurohman.salesapp.dao.JenisDao;
import com.github.acepabdurohman.salesapp.model.Barang;
import com.github.acepabdurohman.salesapp.model.Distributor;
import com.github.acepabdurohman.salesapp.model.Jenis;
import com.github.acepabdurohman.salesapp.model.User;
import com.github.acepabdurohman.salesapp.service.MasterService;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/*
    Implementasi dari interface master service.
    Diatur juga koneksi dari aplikasi ke database.
    Selain itu juga kelas ini berisi method yang dapat menghandel setiap exception
    yang terjadi antara aplikasi dan sumber data (database)
*/
public class MasterServiceImpl implements MasterService {
    private final KoneksiDatabase koneksiDB;
    private final Connection koneksi;
    private final JenisDao jenisDao;
    private final BarangDao barangDao;
    private final DistributorDao distributorDao;
    
    public MasterServiceImpl(KoneksiDatabase kon){
        this.koneksiDB = kon;
        this.koneksi = koneksiDB.connect();
        this.jenisDao = new JenisDao(koneksiDB);
        this.barangDao = new BarangDao(koneksiDB);
        this.distributorDao = new DistributorDao(koneksiDB);
    }
    
    @Override
    public void simpan(Jenis jenis){
        try{
            koneksi.setAutoCommit(false);
            jenisDao.simpan(jenis);
            koneksi.commit();
            koneksi.setAutoCommit(true);            
        } catch(SQLException exe){
            try{
                koneksi.rollback();
                System.out.println("Rollback transaksi");
            } catch(SQLException ex){
                Logger.getLogger(MasterServiceImpl.class.getName()).log(Level.SEVERE, null, exe);
            }   
            exe.printStackTrace();
            System.out.println("Masalah saat penyimpanan");
        }
    }
    
    @Override
    public void ubah(Jenis jenis){
        try{
            koneksi.setAutoCommit(false);
            jenisDao.ubah(jenis);
            koneksi.commit();
            koneksi.setAutoCommit(true);            
        } catch(SQLException exe){
            try{
                koneksi.rollback();
                System.out.println("Rollback transaksi");
            } catch(SQLException ex){
                Logger.getLogger(MasterServiceImpl.class.getName()).log(Level.SEVERE, null, exe);
                System.out.println("Masalah saat ubah data");
            } 
            exe.printStackTrace();
            
        }
    }
    
    @Override
    public void hapus(Jenis jenis){
         try{
            koneksi.setAutoCommit(false);
            jenisDao.hapus(jenis);
            koneksi.commit();
            koneksi.setAutoCommit(true);            
        } catch(SQLException exe){
            try{
                koneksi.rollback();
                System.out.println("Rollback transaksi");
            } catch(SQLException ex){
                Logger.getLogger(MasterServiceImpl.class.getName()).log(Level.SEVERE, null, exe);
                System.out.println("Masalah saat hapus data");
            }
            exe.printStackTrace();
             JOptionPane.showMessageDialog(null, "Data tidak dapat dihapus, sedang digunakan digunakan di tabel barang", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    @Override
    public List<Jenis> getAllJenis(){
        try{
            return jenisDao.getAllJenis();
        } catch(SQLException ex){
            Logger.getLogger(MasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Masalah saat pengambilan data dari database");
        }
        return new ArrayList<>();
    }
    
    @Override
    public List<Jenis> getJenisByKode(String kodeJenis){
        try{
            return jenisDao.getJenisByKode(kodeJenis);
        } catch(SQLException ex){
            Logger.getLogger(MasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Masalah saat pengambilan data dari database");
        }
        return new ArrayList<>();
    }
    
    @Override
    public Jenis getJenisByKodeSelection(String kode){
        try{
            return jenisDao.getJenisByKodeSelection(kode);
        } catch(SQLException exe){
            exe.printStackTrace();
            System.out.println("Masalah saat pengambilan data dari database");
        }
        return null;
    }
    
    @Override
    public void simpan(Barang barang){
        try{
            koneksi.setAutoCommit(false);
            barangDao.simpan(barang);
            koneksi.commit();
            koneksi.setAutoCommit(true);
        } catch(SQLException ex){
            try{
                koneksi.rollback();
                System.out.println("Rollback transaksi");
            } catch(SQLException exe){
                Logger.getLogger(MasterServiceImpl.class.getName()).log(Level.SEVERE, null, exe);
                System.out.println("Masalah saat penyimpanan");
            }
            ex.printStackTrace();
            System.out.println("error");
        }
    }
    
    @Override
    public void ubah(Barang barang){
         try{
            koneksi.setAutoCommit(false);
            barangDao.ubah(barang);
            koneksi.commit();
            koneksi.setAutoCommit(true);
        } catch(SQLException ex){
            try{
                koneksi.rollback();
                System.out.println("Rollback transaksi");
            } catch(SQLException exe){
                Logger.getLogger(MasterServiceImpl.class.getName()).log(Level.SEVERE, null, exe);
                System.out.println("Masalah saat edit");
            }
            ex.printStackTrace();
            System.out.println("error");
        }
    }
    
    @Override
    public void hapus(Barang barang){
        try{
            koneksi.setAutoCommit(false);
            barangDao.hapus(barang);
            koneksi.commit();
            koneksi.setAutoCommit(true);
        } catch(SQLException ex){
            try{
                koneksi.rollback();
                System.out.println("Rollback transaksi");
            } catch(SQLException exe){
                Logger.getLogger(MasterServiceImpl.class.getName()).log(Level.SEVERE, null, exe);
                System.out.println("Masalah saat hapus");
            }
            ex.printStackTrace();
            System.out.println("error");
        }
    }
        
    @Override
    public List<Barang> getBarangPaging(int halaman, int banyakBaris){
        try{
            return barangDao.getBarangPaging(halaman, banyakBaris);
        } catch(SQLException exe){
            exe.printStackTrace();
        }
        return new ArrayList<>();
    }
    
    @Override
    public int countBarang(){
        int count = 0;
        try{
            koneksi.setAutoCommit(false);
            count = barangDao.countBarang();
            koneksi.commit();
            koneksi.setAutoCommit(true);
        } catch(SQLException exe){
            try{
                koneksi.rollback();
            } catch(SQLException ex){
                ex.printStackTrace();
            }
            exe.printStackTrace();
            System.out.println("Error");
        }
        return count;
    }
    
    @Override
    public List<Barang> getAllBarang(){
        try{
            return barangDao.getAllBarang();
        } catch(SQLException exe){
            exe.printStackTrace();
        }
        return new ArrayList<>();
    }
    
    @Override
    public List<Barang> getBarangByKode(String kode){
        try{
            return barangDao.getBarangByKode(kode);
        } catch(SQLException exe){
            exe.printStackTrace();
        }
        return null;
    }
    
    @Override
    public List<Barang> searchBarangByNama(String nama){
        try{
            return barangDao.searchBarangByNama(nama);
        } catch(SQLException exe){
            exe.printStackTrace();
            System.out.println("Masalah dalam pengambilan data");
        }
        return new ArrayList<>();
    }
    
    @Override
    public Barang getByKode(String kode){
        try{
            return barangDao.getByKode(kode);
        } catch(SQLException exe){
            exe.printStackTrace();
            System.out.println("Masalah dalam pengambilan data");
        }
        return null;
    }
    
    @Override
    public void simpan(Distributor distributor){
        try{
            koneksi.setAutoCommit(false);
            distributorDao.simpan(distributor);
            koneksi.commit();
            koneksi.setAutoCommit(true);
        } catch(SQLException exe){
            try{
                System.out.println("Rollback transaksi");
                koneksi.rollback();
            } catch(SQLException ex){
                ex.printStackTrace();
            }
            exe.printStackTrace();
        }
    }
    
    @Override
    public void ubah(Distributor distributor){
        try{
            koneksi.setAutoCommit(false);
            distributorDao.ubah(distributor);
            koneksi.commit();
            koneksi.setAutoCommit(true);
        } catch(SQLException exe){
            try{
                koneksi.rollback();
            } catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }
    
    @Override
    public void hapus(Distributor distributor){
        try{
            koneksi.setAutoCommit(false);
            distributorDao.hapus(distributor);
            koneksi.commit();
            koneksi.setAutoCommit(true);
        } catch(SQLException exe){
            try{
                koneksi.rollback();
            } catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }
    
    @Override
    public List<Distributor> getAllDistributor(){
        try{
            return distributorDao.getAllDistributor();
        } catch(SQLException exe){
            exe.printStackTrace();
        }
        return new ArrayList<>();
    }
    
    @Override
    public List<Distributor> searchByNama(String nama){
        try{
            return distributorDao.searchByNama(nama);
        } catch(SQLException exe){
            exe.printStackTrace();
        }
        return new ArrayList<>();
    }
    
}
