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
public class Karaoke extends DichVu {
    private static int dem = 0;
    private int thoiGianThue;

    {
        this.maDichVu = ++dem;
    }

    public Karaoke() {
    }

    public Karaoke(String tenDichVu, double giaDichVu, int thoiGianThue) {
        this.tenDichVu = tenDichVu;
        this.giaDichVu = giaDichVu;
        this.thoiGianThue = thoiGianThue;
    }

    @Override
    public void nhapDichVu() {
        super.nhapDichVu();
        System.out.println("- Nhap thoi gian thue:");
        this.thoiGianThue = Integer.parseInt(S.nextLine());
    }

    @Override
    public void xuatDichVu() {
        super.xuatDichVu();
        System.out.printf("%14s\n", this.thoiGianThue);
        System.out.println("-----------------------------------------"
                + "--------------------------------------------"
                + "--------------------");
    }

    @Override
    public String toString() {
        return super.toString()
                + String.format("%s %15s",
                        "-----------------------------------------------"
                        + "--------------------------------------"
                        + "--------------------", this.thoiGianThue);
    }

    /**
     * @return the thoiGianThue
     */
    public int getThoiGianThue() {
        return thoiGianThue;
    }

    /**
     * @param thoiGianThue the thoiGianThue to set
     */
    public void setThoiGianThue(int thoiGianThue) {
        this.thoiGianThue = thoiGianThue;
    }

}
