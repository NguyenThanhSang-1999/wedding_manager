/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DichVu;

/**
 *
 * @author Thanh Sang
 */
public class TrangTri extends DichVu{
    private static int dem = 0;
    {
        this.maDichVu = ++dem;
    }

    public TrangTri() {
    }

    public TrangTri(String tenDichVu, double giaDichVu) {
        this.tenDichVu = tenDichVu;
        this.giaDichVu = giaDichVu;
    }
    
    
    @Override
    public void nhapDichVu() {
        super.nhapDichVu(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void xuatDichVu() {
        System.out.printf("%s",super.toString());
        System.out.println("-----------------------------------------"
                + "--------------------------------------------"
                + "--------------------");
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
       
    
}
