/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nts.weddingmanager;

import java.util.Locale;

/**
 *
 * @author Thanh Sang
 */
public class ThucUong extends SanPham {

    private static int dem = 0;
    private String nhaSanXuat;

    {
        this.maSanPham = ++dem;
    }

    public ThucUong() {
    }

    @Override
    public void nhapSP() {
        super.nhapSP();
        System.out.println("- Nhap nha san xuat: ");
        this.nhaSanXuat = S.nextLine();
    }

    @Override
    public void xuatSP() {
        super.xuatSP();
        System.out.printf("-Nha san xuat: %s\n", this.nhaSanXuat);//To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the nhaSanXuat
     */
    public String getNhaSanXuat() {
        return nhaSanXuat;
    }

    /**
     * @param nhaSanXuat the nhaSanXuat to set
     */
    public void setNhaSanXuat(String nhaSanXuat) {
        this.nhaSanXuat = nhaSanXuat;
    }
}