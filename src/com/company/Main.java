package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Vector;

import static java.lang.System.exit;

public class Main {

    static Vector<DataIPS> data_ips = new Vector<>();
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
	// write your code here
        menu();
    }

    public static void menu() {
        int pilihan;
        System.out.println("Pendataan dan Perhitungan IPS (Indeks Prestasi Semester)");
        System.out.println("1. Pendataan Matakuliah");
        System.out.println("2. Perhitungan IPS");
        System.out.println("3. Update Grade");
        System.out.println("4. Keluar");
        System.out.print("Masukan Pilihan Anda : ");
        try {
            pilihan = scan.nextInt();
            switch (pilihan) {
                case 1:
                    pendataan_matakuliah();
                    break;
                case 2:
                    perhitungan_ips();
                    break;
                case 3:
                    update_grade();
                    break;
                case 4:
                    exit(0);
                    break;
                default:
                    System.out.println("Maaf, pilihan Anda tidak ada.");
                    break;
            }
        } catch (InputMismatchException ime) {
            System.out.println("Inputan Anda harus angka.");
            throw_catch();
        }
    }

    public static void pendataan_matakuliah() {
        int jumlah_matakuliah;
        String kode_matakuliah, nama_matakuliah, grade_matakuliah;
        int jumlah_sks;
        System.out.print("Masukan Jumlah Matakuliah : ");
        try {
            jumlah_matakuliah = scan.nextInt();
            for (int i = 1; i <= jumlah_matakuliah; i++) {
                System.out.print("Masukan Kode Mata Kuliah : ");
                kode_matakuliah = scan.next();
                System.out.print("Masukan Nama Mata Kuliah : ");
                nama_matakuliah = scan.next();
                do {
                    System.out.print("Masukan Grade Mata Kuliah : ");
                    grade_matakuliah = scan.next();
                    if (grade_matakuliah.equals("A") || grade_matakuliah.equals("B") ||
                            grade_matakuliah.equals("C") || grade_matakuliah.equals("D") ||
                            grade_matakuliah.equals("E")) {
                        break;
                    }
                } while (true);
                System.out.print("Masukan Jumlah SKS : ");
                jumlah_sks = scan.nextInt();
                System.out.println();

                DataIPS dataIPS = new DataIPS(kode_matakuliah,
                        nama_matakuliah,grade_matakuliah,jumlah_sks);
                data_ips.add(dataIPS);
            }
        } catch (InputMismatchException ime) {
            System.out.println("Inputan Anda harus angka.");
            throw_catch();
        }
        menu();
    }

    public static void perhitungan_ips() {
        float ips, total_sks_grade = 0, total_sks = 0, grade;
        System.out.println("Matakuliah yang Anda ambil adalah : ");
        for (int i = 0; i < data_ips.size(); i++) {
            System.out.println(data_ips.get(i).getKode_matakuliah()
                    + "\t" + data_ips.get(i).getNama_matakuliah()
                    + "\t\t" + data_ips.get(i).getGrade_matakuliah()
                    + "\t\t" + data_ips.get(i).getSks());
            if (data_ips.get(i).getGrade_matakuliah().equals("A")) grade = 4;
            else if (data_ips.get(i).getGrade_matakuliah().equals("B")) grade = 3;
            else if (data_ips.get(i).getGrade_matakuliah().equals("C")) grade = 2;
            else if (data_ips.get(i).getGrade_matakuliah().equals("D")) grade = 1;
            else grade = 0;

            total_sks_grade += (data_ips.get(i).getSks() * grade);
            total_sks += data_ips.get(i).getSks();
        }
        ips = total_sks_grade / total_sks;
        System.out.println("Nilai IPS Anda adalah " + ips);
        System.out.println();
        menu();
    }

    public static void update_grade() {
        String kode_matakuliah, grade_baru;
        int cek = 0;
        System.out.print("Masukan Kode Mata Kuliah : ");
        kode_matakuliah = scan.next();
        do {
            System.out.print("Masukan Grade Baru : ");
            grade_baru = scan.next();
            if (grade_baru.equals("A") || grade_baru.equals("B") ||
                    grade_baru.equals("C") || grade_baru.equals("D") ||
                    grade_baru.equals("E")) {
                break;
            }
        } while (true);
        // update data
        for (int i = 0; i < data_ips.size(); i++) {
            if (data_ips.get(i).getKode_matakuliah().equals(kode_matakuliah)) {
                data_ips.get(i).setGrade_matakuliah(grade_baru);
                cek++;
                break;
            }
        }
        if (cek == 0) {
            System.out.println("Maaf, kode matakuliah tidak ditemukan.");
        }
        // show data
        for (int i = 0; i < data_ips.size(); i++) {
            System.out.println(data_ips.get(i).getKode_matakuliah()
                    + "\t" + data_ips.get(i).getNama_matakuliah()
                    + "\t\t" + data_ips.get(i).getGrade_matakuliah()
                    + "\t\t" + data_ips.get(i).getSks());
        }
        System.out.println();
        menu();
    }

    public static void throw_catch() {
        System.out.print("Kembali ke menu [y/t]? ");
        scan.nextLine();
        String ulang = scan.next();
        if (ulang.equals("y")) menu();
        else exit(0);
        System.out.println();
    }
}
