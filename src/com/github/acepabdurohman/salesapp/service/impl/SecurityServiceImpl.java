package com.github.acepabdurohman.salesapp.service.impl;

import com.github.acepabdurohman.salesapp.connection.KoneksiDatabase;
import com.github.acepabdurohman.salesapp.dao.UserDao;
import com.github.acepabdurohman.salesapp.model.User;
import com.github.acepabdurohman.salesapp.service.SecurityService;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
    Sama dengan master service
    akan tetapi yang digunakan adalah objek user
*/
public class SecurityServiceImpl implements SecurityService{
    private KoneksiDatabase koneksiDB;
    private UserDao userDao;
    public SecurityServiceImpl(KoneksiDatabase koneksiDB){
        this.koneksiDB = koneksiDB;
        userDao = new UserDao(koneksiDB);
    }
    @Override
    public List<User> getAllUser(){
    
        try{
            return userDao.getAllUser();
        }
        catch(SQLException exe){
            exe.printStackTrace();
        }
        return new ArrayList<>();
    }
}
