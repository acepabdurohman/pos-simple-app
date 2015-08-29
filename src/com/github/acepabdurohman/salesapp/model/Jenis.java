package com.github.acepabdurohman.salesapp.model;
/*
    Kelas ini juga merepresentasikan tabel jenis pada database menjadi suatu kelas
    yang akan di instance menjadi objek
*/
public class Jenis {
    
    private String kodeJenis;
    private String jenis;

    public String getKodeJenis() {
        return kodeJenis;
    }

    public void setKodeJenis(String kodeJenis) {
        this.kodeJenis = kodeJenis;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    
}
