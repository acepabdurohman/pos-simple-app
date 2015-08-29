package com.github.acepabdurohman.salesapp.service;

import com.github.acepabdurohman.salesapp.model.User;
import java.util.List;
/*
    Interface ini berisi deklarasi method untuk setiap kelas yang merepresentasikan
    tabel yang berhubungan dengan hak akses. Misal tabel user, customer, member customer
    , person dll
*/
public interface SecurityService {
    public List<User> getAllUser();
}
