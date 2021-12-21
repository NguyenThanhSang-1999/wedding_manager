/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weddingmanager;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thanh Sang
 */
public class QuanLySanh {
    
private List<Sanh> ds = new ArrayList<>();
    
    public void themSanh(Sanh s) {
        this.ds.add(s);
    }

    public void themSanh(String loaiSP) throws NoSuchMethodException{
        try {
            Class c = Class.forName(loaiSP);
            Sanh s = (Sanh) c.getDeclaredConstructor(null).newInstance();
            s.nhapSanh();
            this.ds.add(s);
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
    public List<Sanh> timKiemSanh(String kw){
        List<Sanh> sp = new ArrayList<>();    
        for(Sanh s: this.ds)
            if(s.getTenSanh().contains(kw) == true)
                sp.add(s);
            else if(s.getViTriSanh().contains(kw) == true)
                sp.add(s);
        return sp;
    }
}
