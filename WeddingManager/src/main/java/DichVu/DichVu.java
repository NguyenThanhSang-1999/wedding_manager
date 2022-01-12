/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DichVu;

import java.util.Scanner;

/**
 *
 * @author Thanh Sang
 */
public abstract class DichVu {
    public static final Scanner S = new Scanner(System.in);
    protected int maDichVu;
    protected String tenDichVu;
    protected double giaDichVu;

    public void nhapDichVu() {
        System.out.println("- Nhap ten dich vu: ");
        this.tenDichVu = S.nextLine();

        do {
            System.out.println("- Nhap gia dich vu: ");
            this.giaDichVu = Double.parseDouble(S.nextLine());

            if (this.giaDichVu < 0) {
                System.out.println("<!> Gia dich vu khong the am.");
            }
        } while (this.giaDichVu < 0);
    }

    public void xuatDichVu() {
        System.out.printf("  %-12d %-25s %,10.0f VND",
                this.maDichVu, this.tenDichVu.toUpperCase(), this.giaDichVu);
    }

    @Override
    public String toString() {
        return String.format("  %-12d %-25s %,10.0f VND\n",
                this.maDichVu, this.tenDichVu.toUpperCase(), this.giaDichVu);

    }

    /**
     * @return the maDichVu
     */
    public int getMaDichVu() {
        return maDichVu;
    }

    /**
     * @param maDichVu the maDichVu to set
     */
    public void setMaDichVu(int maDichVu) {
        this.maDichVu = maDichVu;
    }

    /**
     * @return the tenDichVu
     */
    public String getTenDichVu() {
        return tenDichVu.toUpperCase();
    }

    /**
     * @param tenDichVu the tenDichVu to set
     */
    public void setTenDichVu(String tenDichVu) {
        this.tenDichVu = tenDichVu;
    }

    /**
     * @return the giaDichVu
     */
    public double getGiaDichVu() {
        return giaDichVu;
    }

    /**
     * @param giaDichVu the giaDichVu to set
     */
    public void setGiaDichVu(double giaDichVu) {
        this.giaDichVu = giaDichVu;
    }
}
