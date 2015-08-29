package com.github.acepabdurohman.salesapp.dao;

import com.github.acepabdurohman.salesapp.connection.KoneksiDatabase;
import com.github.acepabdurohman.salesapp.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/*
    Kelas userdao digunakan untuk setiap query ke table user
*/
public class UserDao {
    private final KoneksiDatabase koneksiDB;
    public UserDao(KoneksiDatabase koneksiDB){
        this.koneksiDB = koneksiDB;
    }
    public List<User> getAllUser() throws SQLException{
        List<User> users = new ArrayList<>();
        Connection koneksi = koneksiDB.connect();
        String sql = "select * from t_user";
        PreparedStatement ps = koneksi.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            User user = new User();
            user.setIdUser(rs.getInt("id_user"));
            user.setUsername(rs.getString("username"));
            user.setUserpass(rs.getString("userpass"));
            user.setNama(rs.getString("nama"));
            users.add(user);
        }
        koneksiDB.disconnect();
        return users;
    }
}
