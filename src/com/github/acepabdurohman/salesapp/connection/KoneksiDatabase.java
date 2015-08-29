package com.github.acepabdurohman.salesapp.connection;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
    Kelas ini untuk koneksi ke database menggunakan DBMS MySQL
*/
public class KoneksiDatabase {

    private Connection koneksi;
    private final MysqlDataSource dataSource = new MysqlDataSource();
    public KoneksiDatabase(){
        this.dataSource.setServerName("localhost");
        this.dataSource.setDatabaseName("db_salesapp");
        this.dataSource.setPortNumber(3306);
        this.dataSource.setUser("root");
        this.dataSource.setPassword("admin1234");          
    }
    public Connection connect(){
        try{
            koneksi =  dataSource.getConnection();
        } catch(SQLException exe){
            JOptionPane.showMessageDialog(null, "Tidak terhubung dengan database", "Error", JOptionPane.ERROR_MESSAGE);            
            Logger.getLogger(KoneksiDatabase.class.getName()).log(Level.SEVERE, null, exe);
            System.exit(0);
        }  
        return koneksi;
    }
    public void disconnect(){
        try{
            if(koneksi != null){
                koneksi.close();
            }
        } catch(SQLException exe){
            Logger.getLogger(KoneksiDatabase.class.getName()).log(Level.SEVERE, null, exe);
        }
    }
}
