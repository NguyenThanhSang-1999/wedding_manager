/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sanh;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Thanh Sang
 */
public class Sanh {

    public static final Scanner S = new Scanner(System.in);
    private static int dem = 0;
    private String maSanh;
    private String tenSanh;
    private String viTriSanh;
    private int sucChua;
    private double giaSanh;
    private int soLanThue = 0;

    {
        this.setMaSanh(String.format("S%03d", ++dem));
    }

    public Sanh() {
    }

    public Sanh(String tenSanh, String viTriSanh, int sucChua) {
        this.tenSanh = tenSanh;
        this.viTriSanh = String.format("Tang %s", viTriSanh);
        this.sucChua = sucChua;

    }

    public void nhapSanh() {
        System.out.println("=== NHAP THONG TIN SANH === ");

        System.out.println("- Ten sanh: ");
        this.setTenSanh(S.nextLine());

        System.out.println("- Vi tri sanh: ");
        this.setViTriSanh(String.format("Tang %s", S.nextLine()));

        do {
            System.out.println("- Suc chua (ban): ");
            this.setSucChua(S.nextInt());
            S.nextLine();

            if (this.getSucChua() <= 0) {
                System.out.println("So ban khong the <= 0 !");
            }
        } while (this.getSucChua() <= 0);

    }

    public double tinhGiaSanh(String date, String timeOfDay) throws ParseException {
        SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
        Date dt1 = format1.parse(date);
        
        DateFormat format2 = new SimpleDateFormat("EEEE");
        String finalDay = format2.format(dt1);
        
        DateFormat format3 = new SimpleDateFormat("MMMM");
        String finalMonth = format3.format(dt1);
        
        DateFormat format4 = new SimpleDateFormat("YYYY");
        String finalYear = format4.format(dt1);
        
        System.out.printf("Day: %s, Month: %s, Year: %s\n", finalDay, finalMonth, finalYear);

        if (timeOfDay.contains("sang") && !finalDay.contains("Sunday") && !finalDay.contains("Saturday")) {
            this.setGiaSanh(4000000);
        } else if (timeOfDay.contains("chieu") && !finalDay.contains("Sunday") && !finalDay.contains("Saturday")) {
            this.setGiaSanh(4500000);
        } else if (timeOfDay.contains("toi") && !finalDay.contains("Sunday") && !finalDay.contains("Saturday")) {
            this.setGiaSanh(5000000);
        } else if (finalDay.contains("Saturday") && timeOfDay.contains("sang")
                || finalDay.contains("Sunday") && timeOfDay.contains("sang")) {
            this.setGiaSanh(5000000);
        } else if (finalDay.contains("Saturday") && timeOfDay.contains("chieu")
                || finalDay.contains("Sunday") && timeOfDay.contains("chieu")) {
            this.setGiaSanh(5500000);
        } else if (finalDay.contains("Saturday") && timeOfDay.contains("toi")
                || finalDay.contains("Sunday") && timeOfDay.contains("toi")) {
            this.setGiaSanh(6000000);
        }

        return this.getGiaSanh();
    }

    public void xuatSanh() {
        System.out.printf("  %-16s %-16s %-10s %10d %13s \n%s\n", this.getMaSanh(),
                this.getTenSanh().toUpperCase(), this.getViTriSanh().toUpperCase(), this.getSucChua(), this.getSoLanThue(), "----------------"
                + "----------------------------------------------"
                + "--------------------------");

    }

    @Override
    public String toString() {
        return String.format("Ma sanh: %s\nTen sanh: %s\nVi tri sanh: %s\nSuc chua: %s\n-So lan thue: %s\n", this.getMaSanh(), this.getTenSanh(), this.getViTriSanh(), this.getSucChua(), this.getSoLanThue());
    }

    /**
     * @return the maSanh
     */
    public String getMaSanh() {
        return maSanh;
    }

    /**
     * @param maSanh the maSanh to set
     */
    public void setMaSanh(String maSanh) {
        this.maSanh = maSanh;
    }

    /**
     * @return the tenSanh
     */
    public String getTenSanh() {
        return tenSanh;
    }

    /**
     * @param tenSanh the tenSanh to set
     */
    public void setTenSanh(String tenSanh) {
        this.tenSanh = tenSanh;
    }

    /**
     * @return the viTriSanh
     */
    public String getViTriSanh() {
        return viTriSanh;
    }

    /**
     * @param viTriSanh the viTriSanh to set
     */
    public void setViTriSanh(String viTriSanh) {
        this.viTriSanh = viTriSanh;
    }

    /**
     * @return the sucChua
     */
    public int getSucChua() {
        return sucChua;
    }

    /**
     * @param sucChua the sucChua to set
     */
    public void setSucChua(int sucChua) {
        this.sucChua = sucChua;
    }

    /**
     * @return the giaSanh
     */
    public double getGiaSanh() {
        return giaSanh;
    }

    /**
     * @param giaSanh the giaSanh to set
     */
    public void setGiaSanh(double giaSanh) {
        this.giaSanh = giaSanh;
    }

    /**
     * @return the soLanThue
     */
    public int getSoLanThue() {
        return soLanThue;
    }

    /**
     * @param soLanThue the soLanThue to set
     */
    public void setSoLanThue(int soLanThue) {
        this.soLanThue = soLanThue;
    }

}
