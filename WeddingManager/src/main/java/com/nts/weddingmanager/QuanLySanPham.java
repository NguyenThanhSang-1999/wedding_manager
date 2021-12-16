/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nts.weddingmanager;

import java.lang.reflect.InvocationTargetException;
import java.rmi.AccessException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Thanh Sang
 */
public class QuanLySanPham {
    private List<SanPham> ds = new ArrayList<>();
    
    public void themSP(SanPham sp) {
        this.ds.add(sp);
    }

    public void themSP(String loaiSP) throws NoSuchMethodException{
        try {
            Class c = Class.forName(loaiSP);
            SanPham sp = (SanPham) c.getDeclaredConstructor(null).newInstance();
            sp.nhapSP();
            this.ds.add(sp);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException ex) {
            ex.printStackTrace();
        }
//        SanPham s = null;
//        if(loaiSP.equals("ThucAn"))
//            s = new ThucAn();
//        else if(loaiSP.equals("ThucUong"))
//            s = new ThucUong();
//        s.nhapSP();
//        this.ds.add(s);
    }
    public List<SanPham> timKiemSP(String kw){
        List<SanPham> sp = new ArrayList<>();
        
        for(SanPham s: this.ds)
            if(s.getTenSanPham().contains(kw) == true)
                sp.add(s);
        return sp;
    }
//    public List<SanPham> xoaSP(int id){
//        List<SanPham> sp = new ArrayList<>();
//        
//        for(int i = 0; i < )
//            
//        return sp;
//    }
    
    public  void xuatDS(){
        this.ds.forEach(s -> s.xuatSP());
    }
    /**
     * @return the ds
     */
    public List<SanPham> getDs() {
        return ds;
    }

    /**
     * @param ds the ds to set
     */
    public void setDs(List<SanPham> ds) {
        this.ds = ds;
    }
    
}
