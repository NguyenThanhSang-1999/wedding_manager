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
public class ThucAn extends SanPham {
    private static int dem = 0;
    private boolean monChay;

    {
        this.maSanPham = ++dem;
    }

    public ThucAn() {
    }

    public ThucAn(String tenSanPham, double giaSanPham, boolean monChay) {
        this.tenSanPham = tenSanPham;
        this.giaSanPham = giaSanPham;
        this.monChay = monChay;
    }

    @Override
    public void nhapSanPham() {
        super.nhapSanPham();
        this.monChay = laMonChay(S);

    }

    @Override
    public void xuatSanPham() {
        String kw = "Co the an chay!";
        if (this.monChay == true) {
            super.xuatSanPham();
            System.out.printf("%25s\n", kw);
        }
        else{
            super.xuatSanPham();
            System.out.print("\n");
        }
        
        System.out.println("--------------------------------------------" +
						"-------------------------------------------------------");
    }

    public boolean laMonChay(Scanner s) {
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
