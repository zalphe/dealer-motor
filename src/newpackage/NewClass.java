/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

/**
 *
 * @author cups
 */
/**
 *
 * @author C800D
 */
class Data {

    String noFaktur;
    String waktu;
    int subtotal;
    int diskon;
}

class Method {

    static int jumlahData = 0;
    Data[] transaksi;

    public static void tampilSemua(Data[] transaksi) {
        for (int i = 0; i < transaksi.length; i++) {
            if (transaksi[i] != null) {
                tampil(transaksi[i]);
            }
        }
    }

    public static void tampil(Data transaksi) {
        System.out.println("No Faktur = " + transaksi.noFaktur);
        System.out.println("Waktu = " + transaksi.waktu);
        System.out.println("Subtotal = " + transaksi.subtotal);
        System.out.println("diskon = " + transaksi.diskon);
        System.out.println("Total Harga " + (transaksi.subtotal - (transaksi.subtotal / 100.0 * transaksi.diskon)));
        System.out.println("--------------------------------------");
    }

    //Read Data	
    public static Data[] readData() {
        Data[] transaksi = new Data[1000];
        int index = 0;
        File file = new File("E:\\goes to campuss\\TugasBesar\\data\\03_transaksi.txt");
        try {
            FileReader fr = new FileReader(file);
            BufferedReader dt = new BufferedReader(fr);
            String baca;
            dt.readLine();
            while ((baca = dt.readLine()) != null) {
                if (!baca.equalsIgnoreCase("")) {
                    String tmp[] = baca.split(";");
                    transaksi[index] = new Data();
                    transaksi[index].noFaktur = tmp[0];
                    transaksi[index].waktu = tmp[1];
                    transaksi[index].subtotal = Integer.parseInt(tmp[2]);
                    transaksi[index].diskon = Integer.parseInt(tmp[3]);
                    index++;
                }
            }
            fr.close();
        } catch (IOException e) {
        }
        NewClass.jumlahData = index;
        return transaksi;
    }

    public static void rewriteData(Data[] transaksi) {
        File file = new File("E:\\goes to campuss\\TugasBesar\\data\\03_transaksi.txt");
        try {
            FileWriter fw = new FileWriter(file, false);
            BufferedWriter bw = new BufferedWriter(fw);
            String teks = "NO_FAKTUR;WAKTU;SUBTOTAL;DISKON\n";
            for (int i = 0; i < transaksi.length; i++) {
                if (transaksi[i] != null) {
                    teks += transaksi[i].noFaktur + ";" + transaksi[i].waktu + ";" + transaksi[i].subtotal + ";" + transaksi[i].diskon + "\n";
                }
            }
            bw.write(teks);
            bw.close();
        } catch (IOException e) {
        }
    }

    static void ubahData(Data[] transaksi) {
        Scanner in = new Scanner(System.in);
        System.out.print("Masukkan No Faktur : ");
        String cari = in.nextLine();
        int index = -1;
        for (int i = 0; i < transaksi.length; i++) {
            if (transaksi[i] != null && cari.equalsIgnoreCase(transaksi[i].noFaktur)) {
                index = i;
            }
        }
        System.out.println("1.Ubah subtotal");
        System.out.println("2.Ubah diskon");
        System.out.print("Pilihan: ");
        String cari2 = in.nextLine();
        if (index != -1) {
            if (cari2.equalsIgnoreCase("1")) {
                System.out.print("Masukkan subtotal baru : ");
                transaksi[index].subtotal = in.nextInt();
                rewriteData(transaksi);
            } else if (cari2.equalsIgnoreCase("2")) {
                System.out.print("Masukkan diskon baru : ");
                transaksi[index].diskon = in.nextInt();
                rewriteData(transaksi);
            }

        } else {
            System.out.println("Data Tidak Ditemukan!!!");
        }
    }

    int cariIndex(String noFaktur) {
        return -1;
    }

    public static void tambahData(Data transaksi) {
        File file = new File("E:\\goes to campuss\\TugasBesar\\data\\03_transaksi.txt");
        try {
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(transaksi.noFaktur + ";" + transaksi.waktu + ";" + transaksi.subtotal + ";" + transaksi.diskon);
            bw.close();
        } catch (IOException e) {

        }
    }

    static void hapusData() {
        Data[] transaksi = readData();
        Scanner in = new Scanner(System.in);
        System.out.print("Masukkan No Faktur : ");
        String cari = in.nextLine();
        int index = -1;
        for (int i = 0; i < transaksi.length; i++) {
            if (transaksi[i] != null && cari.equalsIgnoreCase(transaksi[i].noFaktur)) {
                index = i;
            }
        }

        if (index != -1) {
            transaksi[index] = null;
            rewriteData(transaksi);
        } else {
            System.out.println("Data Tidak Ditemukan!!!");
        }
    }

    public static void cariBynoFaktur(Data[] transaksi, String key) {
        for (int i = 0; i < transaksi.length; i++) {
            if (transaksi[i] != null) {
                if (transaksi[i].noFaktur.equalsIgnoreCase(key)) {
                    tampil(transaksi[i]);
                }
            }
        }
    }

    public static void cariRangeWaktu(Data[] transaksi, String kunci) {
        for (int i = 0; i < transaksi.length; i++) {
            if (transaksi[i] != null && transaksi[i].waktu.equalsIgnoreCase(kunci)) {
                tampil(transaksi[i]);

            }
        }
    }
}

public class NewClass {

    static int jumlahData;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Data[] transaksis = Method.readData();

        int pilihan = 0;

        System.out.println("Menu");
        System.out.println("1. Read Data");
        System.out.println("2. Delete Data");
        System.out.println("3. Edit data");
        System.out.println("4. Tambah data");
        System.out.println("5. Search Data No Faktur");
        System.out.println("6. Search Data range waktu transaksi");
        System.out.print("Pilihan Anda : ");
        pilihan = Integer.valueOf(in.nextLine());

        switch (pilihan) {
            case 1:
                Method.tampilSemua(transaksis);
                break;
            case 2:
                Method.hapusData();
                break;
            case 3:
                Method.ubahData(transaksis);
                break;
            case 4:
                Data transaksi = new Data();
                System.out.println("Masukkan No Faktur: ");
                transaksi.noFaktur = in.nextLine();
                System.out.println("Masukkan tanggal dan waktu: ");
                transaksi.waktu = in.nextLine();
                System.out.println("Masukkan Subtotal: ");
                transaksi.subtotal = in.nextInt();
                System.out.println("Masukkan Diskon: ");
                transaksi.diskon = in.nextInt();
                Method.tambahData(transaksi);
                break;
            case 5:
                System.out.println("Masukkan No Faktur: ");
                String key = in.nextLine();
                Method.cariBynoFaktur(transaksis, key);
                break;
            case 6:
                System.out.println("Masukkan waktu dan tanggal: ");
                String kunci = in.nextLine();
                Method.cariRangeWaktu(transaksis, kunci);
                break;
            default:
                System.out.println("Menu tidak ada ^_^6");
        }
    }
}
