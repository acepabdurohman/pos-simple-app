package com.github.acepabdurohman.salesapp.model;
/*
    Kelas ini juga merepresentasikan tabel distributor pada database menjadi suatu kelas
    yang akan di instance menjadi objek
*/
public class Distributor {
    private Integer idDistributor;
    private String namaDistributor;
    private String alamat;
    private String kotaAsal;
    private String email;
    private String noTelepon;

    public Integer getIdDistributor() {
        return idDistributor;
    }

    public void setIdDistributor(Integer idDistributor) {
        this.idDistributor = idDistributor;
    }

    public String getNamaDistributor() {
        return namaDistributor;
    }

    public void setNamaDistributor(String namaDistributor) {
        this.namaDistributor = namaDistributor;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getKotaAsal() {
        return kotaAsal;
    }

    public void setKotaAsal(String kotaAsal) {
        this.kotaAsal = kotaAsal;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNoTelepon() {
        return noTelepon;
    }

    public void setNoTelepon(String noTelepon) {
        this.noTelepon = noTelepon;
    }
}
