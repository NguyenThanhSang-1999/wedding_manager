/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weddingmanager;

/**
 *
 * @author Thanh Sang
 */
public class ThucUong extends SanPham {
    private static int dem = 0;
    private String nhaSanXuat;

    {
        this.maSanPham = ++dem;
        this.loaiSanPham = "Do uong";
    }

    public ThucUong() {
    }

    public ThucUong(String tenSanPham, double giaSanPham, String nhaSanXuat) {
        this.tenSanPham = tenSanPham;
        this.giaSanPham = giaSanPham;
        this.nhaSanXuat = nhaSanXuat;
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
        System.out.printf("- Nha san xuat: %s\n", this.nhaSanXuat);
        System.out.printf("- Loai san pham: %s\n", this.loaiSanPham);
        System.out.println("--------------------------------------");
    }

    @Override
    public String toString() {
        return super.toString()
                + String.format("%24s\n%s", this.nhaSanXuat.toUpperCase(),
                        "----------------------------------------------------"
                        + "---------------------------------------------");
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
