/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SanPham;

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

    public void nhapSanPham() {
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

    public void xuatSanPham() {
        System.out.printf("  %-7d %-23s %,12.0f VND",
				this.maSanPham, this.tenSanPham.toUpperCase(),this.giaSanPham);
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
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


}
