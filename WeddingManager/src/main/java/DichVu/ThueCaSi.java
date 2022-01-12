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
public class ThueCaSi extends DichVu{
    private static int dem = 0;
    private String thongTinCaSi;
    private int soLuongBaiHat;

    {
        this.maDichVu = ++dem;
    }

    public ThueCaSi() {
    }
    
    public ThueCaSi(String tenDichVu, double giaDichVu, String thongTinCaSi, int soLuongBaiHat) {
        this.tenDichVu = tenDichVu;
        this.giaDichVu = giaDichVu;
        this.thongTinCaSi = thongTinCaSi;
        this.soLuongBaiHat = soLuongBaiHat;
    }
    
    @Override
    public void nhapDichVu() {
        super.nhapDichVu();
        System.out.println("- Nhap ten ca si:");
        this.thongTinCaSi = S.nextLine();
        System.out.println("- Nhap so luong bai hat:");
        this.soLuongBaiHat = Integer.parseInt(S.nextLine());
        
    }

    @Override
    public void xuatDichVu() {
        super.xuatDichVu();
        System.out.printf("%22s %15d\n", this.thongTinCaSi.toUpperCase(), this.soLuongBaiHat);
        System.out.println("-----------------------------------------"
                + "--------------------------------------------"
                + "--------------------");
    }

    @Override
    public String toString() {
        return super.toString()
                + String.format("%s %20s %10d",
                        "-----------------------------------------------"
                        + "--------------------------------------"
                        + "--------------------", this.thongTinCaSi, this.soLuongBaiHat);
    }
    
    /**
     * @return the thongTinCaSi
     */
    public String getThongTinCaSi() {
        return thongTinCaSi;
    }

    /**
     * @param thongTinCaSi the thongTinCaSi to set
     */
    public void setThongTinCaSi(String thongTinCaSi) {
        this.thongTinCaSi = thongTinCaSi;
    }

    /**
     * @return the soLuongBaiHat
     */
    public int getSoLuongBaiHat() {
        return soLuongBaiHat;
    }

    /**
     * @param soLuongBaiHat the soLuongBaiHat to set
     */
    public void setSoLuongBaiHat(int soLuongBaiHat) {
        this.soLuongBaiHat = soLuongBaiHat;
    }
    
}
