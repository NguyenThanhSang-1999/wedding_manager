/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nts.weddingmanager;


/**
 *
 * @author Thanh Sang
 */
public class Test {
    public static void main(String[] args) throws NoSuchMethodException {
        QuanLySanPham ql = new QuanLySanPham();
        SanPham s1 = new ThucAn();
        s1.nhapSP();
        SanPham.S.nextLine();

        ql.themSP(s1);
        ql.themSP("com.nts.weddingmanager.ThucUong");
        SanPham.S.nextLine();
        ql.xuatDS();
        
        System.err.println("Tim kiem");
        ql.timKiemSP("ga").forEach(s -> s.xuatSP());
        
    }
    
}
