/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weddingmanager;

import java.util.Scanner;

/**
 *
 * @author Thanh Sang
 */
public abstract class SanPham {

    public static final Scanner S = new Scanner(System.in);
    protected int maSanPham;
    protected String tenSanPham;
    protected double giaSanPham;
    protected String loaiSanPham;

    public void nhapSP() {
        System.out.println("- Nhap ten san pham: ");
        this.tenSanPham = S.nextLine();

        do {
            System.out.println("- Nhap gia san pham: ");
            this.giaSanPham = Double.parseDouble(S.nextLine());

            if (this.giaSanPham < 0) {
                System.out.println("<!> Gia san pham khong the am.");
            }
        } while (this.giaSanPham < 0);
    }

    public void xuatSP() {
        System.out.printf("- Ma san pham: %d\n", this.maSanPham);
        System.out.printf("- Ten san pham: %s\n", this.tenSanPham);
        System.out.printf("- Gia: %.3f vnd\n", this.giaSanPham);
    }

    @Override
    public String toString() {
        return String.format("  %-7d %-30s %,8.0f vnđ %15s\n",
                this.maSanPham, this.tenSanPham.toUpperCase(),
                this.giaSanPham, this.loaiSanPham.toUpperCase());

    }

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
