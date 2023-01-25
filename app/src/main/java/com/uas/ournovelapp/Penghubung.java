package com.uas.ournovelapp;

public class Penghubung {
    private String key;
    private String Judul;
    private String Cerita;

    public Penghubung (){

    }

    public Penghubung(String judul, String cerita) {
        Judul = judul;
        Cerita = cerita;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getJudul() {
        return Judul;
    }

    public void setJudul(String judul) {
        Judul = judul;
    }

    public String getCerita() {
        return Cerita;
    }

    public void setCerita(String cerita) {
        Cerita = cerita;
    }
}
