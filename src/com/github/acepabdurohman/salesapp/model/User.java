package com.github.acepabdurohman.salesapp.model;

/*
    Kelas ini merupakan kelas representasi dari tabel user yang mana asumsinya tabel user
    tersebut menampung data user yang mempunyai akses login ke aplikasi
*/
public class User {
    private Integer idUser;
    private String username;
    private String userpass;
    private String nama;

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpass() {
        return userpass;
    }

    public void setUserpass(String userpass) {
        this.userpass = userpass;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
    
}
