package com.company;

public class DataIPS {
    String kode_matakuliah;
    String nama_matakuliah;
    String grade_matakuliah;
    int sks;

    public DataIPS(String kode_matakuliah, String nama_matakuliah,
                   String grade_matakuliah, int sks) {
        this.kode_matakuliah = kode_matakuliah;
        this.nama_matakuliah = nama_matakuliah;
        this.grade_matakuliah = grade_matakuliah;
        this.sks = sks;
    }

    public String getKode_matakuliah() {
        return kode_matakuliah;
    }

    public void setKode_matakuliah(String kode_matakuliah) {
        this.kode_matakuliah = kode_matakuliah;
    }

    public String getNama_matakuliah() {
        return nama_matakuliah;
    }

    public void setNama_matakuliah(String nama_matakuliah) {
        this.nama_matakuliah = nama_matakuliah;
    }

    public String getGrade_matakuliah() {
        return grade_matakuliah;
    }

    public void setGrade_matakuliah(String grade_matakuliah) {
        this.grade_matakuliah = grade_matakuliah;
    }

    public int getSks() {
        return sks;
    }

    public void setSks(int sks) {
        this.sks = sks;
    }
}
