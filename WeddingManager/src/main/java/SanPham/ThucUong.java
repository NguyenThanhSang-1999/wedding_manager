/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SanPham;

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

    public ThucUong(String tenSanPham, double giaSanPham, String nhaSanXuat) {
        this.tenSanPham = tenSanPham;
        this.giaSanPham = giaSanPham;
        this.nhaSanXuat = nhaSanXuat;
    }

    @Override
    public void nhapSanPham() {
        super.nhapSanPham();
        System.out.println("- Nhap nha san xuat: ");
        this.nhaSanXuat = S.nextLine();
    }

    @Override
    public void xuatSanPham() {
        super.xuatSanPham();
	System.out.printf("%24s\n", this.nhaSanXuat.toUpperCase());
        System.out.println("--------------------------------------------" +
						"-------------------------------------------------------");
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
