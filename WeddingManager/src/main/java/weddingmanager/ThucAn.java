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
public class ThucAn extends SanPham {
    private static int dem = 0;
    private boolean monChay;

    {
        this.maSanPham = ++dem;
        this.loaiSanPham = "Do an";
    }

    public ThucAn() {
    }

    public ThucAn(String tenSanPham, double giaSanPham, boolean monChay) {
        this.tenSanPham = tenSanPham;
        this.giaSanPham = giaSanPham;
        this.monChay = monChay;
    }

    @Override
    public void nhapSP() {
        super.nhapSP();
        this.monChay = laMonChay(S);

    }

    @Override
    public void xuatSP() {
        super.xuatSP();
        System.out.printf("- Loai san pham: %s\n", this.loaiSanPham);
        if (this.monChay == true) {
            System.out.print("<!> Ghi chu: co the an chay\n");
        }
        System.out.println("--------------------------------------");
    }

    public boolean laMonChay(Scanner scanner) {
        boolean kindFood = false;
        boolean check = false;

        do {
            System.out.println("- La mon chay? (Y/N): ");
            String inp = S.nextLine();
            if (inp.equalsIgnoreCase("Y")) {
                kindFood = true;
                check = true;
            } else {
                check = inp.equalsIgnoreCase("N");
            }
        } while (!check);
        return kindFood;
    }

    @Override
    public String toString() {
        return super.toString()
                + String.format("%s",
                        "----------------------------------------------------"
                        + "---------------------------------------------");
    }

    /**
     * @return the laDoAnChay
     */
    public boolean isLaDoAnChay() {
        return monChay;
    }

    /**
     * @param laDoAnChay the laDoAnChay to set
     */
    public void setLaDoAnChay(boolean laDoAnChay) {
        this.monChay = laDoAnChay;
    }

}
