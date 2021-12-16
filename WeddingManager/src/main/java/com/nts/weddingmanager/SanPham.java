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
public abstract class SanPham {

    public static final Scanner S = new Scanner(System.in);
    protected int maSanPham;
    private String tenSanPham;
    private double giaSanPham;
    private String loaiSanPham;

    public void nhapSP() {
        System.out.println("-Nhap ten san pham: ");
        this.tenSanPham = S.nextLine();
        System.out.println("-Nhap loai san pham: ");
        this.setLoaiSanPham(S.nextLine());

        do {
            System.out.println("-Nhap gia san pham: ");
            this.giaSanPham = S.nextDouble();

            if (this.giaSanPham < 0) {
                System.out.println("<!> Gia san pham khong the am.");
            }
        } while (this.giaSanPham < 0);
        S.nextLine();
    }

    public void xuatSP() {
        System.out.printf("-Ma san pham: %d\n", this.maSanPham);
        System.out.printf("-Ten san pham: %s\n", this.tenSanPham);
        System.out.printf("-Gia: %.1f\n", this.giaSanPham);
    }

    ;

    /**
     * @return the maSanPham
     */
    public int getMaSanPham() {
        return maSanPham;
    }

    /**
     * @param maSanPham the maSanPham to set
     */
    public void setMaSanPham(int maSanPham) {
        this.maSanPham = maSanPham;
    }

    /**
     * @return the tenSanPham
     */
    public String getTenSanPham() {
        return tenSanPham;
    }

    /**
     * @param tenSanPham the tenSanPham to set
     */
    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    /**
     * @return the giaSanPham
     */
    public double getGiaSanPham() {
        return giaSanPham;
    }

    /**
     * @param giaSanPham the giaSanPham to set
     */
    public void setGiaSanPham(double giaSanPham) {
        this.giaSanPham = giaSanPham;
    }

    /**
     * @return the loaiSanPham
     */
    public String getLoaiSanPham() {
        return loaiSanPham;
    }

    /**
     * @param loaiSanPham the loaiSanPham to set
     */
    public void setLoaiSanPham(String loaiSanPham) {
        this.loaiSanPham = loaiSanPham;
    }

}
