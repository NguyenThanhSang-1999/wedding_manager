/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nts.weddingmanager;

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
    private String trangThaiSanh;

    {
        maSanh = String.format("S%03d", ++dem);
    }

    public Sanh(String ts, String vts, int sc) {
        this.tenSanh = ts;
        this.viTriSanh = vts;
        this.sucChua = sc;

    }

    public void nhapSanh() {

        System.out.print("-Nhap ten sanh: ");
        this.tenSanh = S.nextLine();
        System.out.print("-Nhap vi tri sanh: ");
        this.viTriSanh = S.nextLine();
        do {
            System.out.print("-Nhap suc chua (ban): ");
            this.sucChua = S.nextInt();
            S.nextLine();

            if (this.sucChua <= 0) {
                System.out.print("<!> So ban khong the <= 0");
            }
        } while (this.sucChua <= 0);

        this.trangThaiSanh = "Ranh";

    }

    @Override
    public String toString() {
        return String.format("Ma sanh: %s\nTen sanh: %s\nVi tri sanh: %s\nSuc chua: %s\n",
                this.maSanh, this.tenSanh, this.viTriSanh, this.sucChua);
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
     * @return the trangThaiSanh
     */
    public String getTrangThaiSanh() {
        return trangThaiSanh;
    }

    /**
     * @param trangThaiSanh the trangThaiSanh to set
     */
    public void setTrangThaiSanh(String trangThaiSanh) {
        this.trangThaiSanh = trangThaiSanh;
    }
}
