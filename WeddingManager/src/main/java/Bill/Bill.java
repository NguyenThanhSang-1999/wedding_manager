/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bill;

import DichVu.DichVu;
import DichVu.QuanLyDichVu;
import SanPham.QuanLySanPham;
import SanPham.SanPham;
import Sanh.QuanLySanh;
import Sanh.Sanh;
import static View.View.S;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thanh Sang
 */
public class Bill {
    
    private static int dem = 0;
    private String maBill;
    private String tenTiecCuoi;
    private double giaMenu = 0;
    private double giaDichVu = 0;
    private double tongBill = 0;
    private String timeOfDay;
    private String date;
    private Sanh sanh;
    private List<SanPham> sp = new ArrayList<>();
    private List<DichVu> dv = new ArrayList<>();


    {
        this.maBill = String.format("BILL%03d", ++dem);
    }
    
    public Bill() {
        
    }

    public double tinhTienBill() {
        return tongBill = this.sanh.getGiaSanh() + this.sanh.getSucChua() * this.giaMenu + this.giaDichVu;
    }

    public void nhapBill() throws ParseException {   
        System.out.println("- Nhap ten buoi tiec: ");
        this.tenTiecCuoi = S.nextLine().toUpperCase();
        themSanh();
        themMenu();
        themDichVu();
        tinhTienBill();
    }

    public void themSanh() throws ParseException {
        List<Sanh> ds = new ArrayList<>();
        ds = QuanLySanh.QLSANH.xuatDanhSach();
        ds.forEach(s -> s.xuatSanh());
        System.out.println("=== CHON SANH CUOI === ");
        System.out.println("- Nhap ma sanh: ");
        String kw = S.nextLine();

        for (Sanh s : ds) {
            if (s.getMaSanh().contains(kw)) {
                this.sanh = s;
                s.setSoLanThue(s.getSoLanThue() + 1);
                System.out.println("- Nhap ngay thue: ");
                this.date = S.nextLine();
                System.out.println("- Nhap thoi diem thue: ");
                this.timeOfDay = S.nextLine();
                this.sanh.setGiaSanh(s.tinhGiaSanh(this.date, this.timeOfDay));
                break;
            }
        }
    }

    public void themMenu() {

        int choice;
        do {
            System.out.println("===== CHON MENU =====");
            System.out.println("1. Chon thuc an");
            System.out.println("2. Chon thuc uong");
            System.out.println("0. Xong");
            System.out.println("=====================");
            System.out.println("=> Nhap lua chon: ");
            choice = S.nextInt();
            S.nextLine();

            switch (choice) {
                case 1 -> {
                    int choiceSP;

                    List<SanPham> ds = new ArrayList<>();
                    System.out.println("=== DANH SACH THUC AN === ");
                    ds = QuanLySanPham.QLSP.xuatTheoLoaiSP("SanPham.ThucAn");
                    ds.forEach(s -> s.xuatSanPham());
                    do {
                        System.out.println("Nhap ma thuc an: ");
                        choiceSP = Integer.parseInt(S.nextLine());

                        for (SanPham s : ds) {
                            if (s.getMaSanPham() == choiceSP) {
                                sp.add(s);
                                this.giaMenu += s.getGiaSanPham();
                                break;
                            }
                        }
                    } while (choiceSP != 0);

                }
                case 2 -> {
                    int choiceSP;

                    List<SanPham> ds = new ArrayList<>();
                    ds = QuanLySanPham.QLSP.xuatTheoLoaiSP("SanPham.ThucUong");
                    System.out.println("=== DANH SACH THUC UONG === ");
                    ds.forEach(s -> s.xuatSanPham());
                    do {
                        System.out.println("Nhap ma thuc uong: ");
                        choiceSP = Integer.parseInt(S.nextLine());

                        for (SanPham s : ds) {
                            if (s.getMaSanPham() == choiceSP) {
                                sp.add(s);
                                giaMenu += s.getGiaSanPham();
                                break;
                            }
                        }
                    } while (choiceSP != 0);
                }

                default ->
                    System.out.println("=> Ban da chon thoat!");
            }
        } while (choice != 0);

    }

    public void themDichVu() {
        int choice;
        do {
            System.out.println("======= CHON DICH VU =======");
            System.out.println("1. Dich vu karaoke");
            System.out.println("2. Dich vu trang tri");
            System.out.println("3. Dich vu thue ca si");
            System.out.println("0. Xong");
            System.out.println("============================");
            System.out.println("=> Nhap lua chon: ");
            choice = S.nextInt();
            S.nextLine();

            switch (choice) {
                case 1 -> {
                    List<DichVu> ds = new ArrayList<>();
                    ds = QuanLyDichVu.QLDV.xuatTheoLoaiDV("DichVu.Karaoke");
                    ds.forEach(s -> s.xuatDichVu());
                    System.out.println("Nhap ma dich vu: ");
                    int i = Integer.parseInt(S.nextLine());

                    for (DichVu s : ds) {
                        if (s.getMaDichVu() == i) {
                            dv.add(s);
                            giaDichVu += s.getGiaDichVu();
                            break;
                        }
                    }
                }
                case 2 -> {
                    List<DichVu> ds = new ArrayList<>();
                    ds = QuanLyDichVu.QLDV.xuatTheoLoaiDV("DichVu.TrangTri");
                    ds.forEach(s -> s.xuatDichVu());
                    System.out.println("Nhap ma dich vu: ");
                    int i = Integer.parseInt(S.nextLine());

                    for (DichVu s : ds) {
                        if (s.getMaDichVu() == i) {
                            dv.add(s);
                            giaDichVu += s.getGiaDichVu();
                            break;
                        }
                    }
                }
                case 3 -> {
                    List<DichVu> ds = new ArrayList<>();
                    ds = QuanLyDichVu.QLDV.xuatTheoLoaiDV("DichVu.ThueCaSi");
                    ds.forEach(s -> s.xuatDichVu());
                    System.out.println("Nhap ma dich vu: ");
                    int i = Integer.parseInt(S.nextLine());

                    for (DichVu s : ds) {
                        if (s.getMaDichVu() == i) {
                            dv.add(s);
                            giaDichVu += s.getGiaDichVu();
                            break;
                        }
                    }
                }

                default ->
                    System.out.println("=> Ban da chon thoat!");
            }
        } while (choice != 0);
    }

    public void xuatBill() {
        System.out.println("===================================================");
        System.out.println("- Ma tiec cuoi: " + this.maBill);
        System.out.println("- Ten tiec cuoi: " + this.tenTiecCuoi);
        System.out.println("- Ma sanh: " + this.sanh.getMaSanh());
        System.out.println("- Ten sanh: " + this.sanh.getTenSanh().toUpperCase());
        System.out.println("- Vi tri sanh thue: " + this.sanh.getViTriSanh());
        System.out.println("- So luong ban: " + this.sanh.getSucChua());
        System.out.printf("- Gia sanh thue: %,.0f VND\n", this.sanh.getGiaSanh());
        System.out.println("- Ngay thue: " + this.date);
        System.out.println("- Thoi diem thue: " + this.timeOfDay);
        System.out.println("");
        System.out.println("- Danh sach thuc don tung ban: ");
        System.out.println("---------------------------");
        for (SanPham s : sp) {
            System.out.printf(" + Ten san pham: %s\n", s.getTenSanPham());
            System.out.printf(" + Gia san pham: %,.0f VND\n", s.getGiaSanPham());
            System.out.println("---------------------------");
        }
        System.out.printf("- Gia moi menu: %,.0f VND\n", this.giaMenu);
        System.out.printf("- Tong gia thuc don: %,.0f VND\n", this.giaMenu * this.sanh.getSucChua());
        System.out.println("");
        System.out.println("- Danh sach dich vu: ");
        System.out.println("---------------------------");
        for (DichVu s : dv) {
            System.out.printf(" + Ten dich vu: %s\n", s.getTenDichVu());
            System.out.printf(" + Gia dich vu: %,.0f VND\n ", s.getGiaDichVu());
            System.out.println("---------------------------");
        }
        System.out.printf("- Tong gia dich vu: %,.0f VND\n", this.giaDichVu);
        System.out.printf("=> Tong tien thanh toan: %,.0f VND\n", tinhTienBill());
        System.out.println("===================================================");
    }

    /**
     * @return the maBill
     */
    public String getMaBill() {
        return maBill;
    }

    /**
     * @param maBill the maBill to set
     */
    public void setMaBill(String maBill) {
        this.maBill = maBill;
    }

    /**
     * @return the tenTiecCuoi
     */
    public String getTenTiecCuoi() {
        return tenTiecCuoi;
    }

    /**
     * @param tenTiecCuoi the tenTiecCuoi to set
     */
    public void setTenTiecCuoi(String tenTiecCuoi) {
        this.tenTiecCuoi = tenTiecCuoi;
    }

    /**
     * @return the giaMenu
     */
    public double getGiaMenu() {
        return giaMenu;
    }

    /**
     * @param giaMenu the giaMenu to set
     */
    public void setGiaMenu(double giaMenu) {
        this.giaMenu = giaMenu;
    }

    /**
     * @return the giaDichVu
     */
    public double getGiaDichVu() {
        return giaDichVu;
    }

    /**
     * @param giaDichVu the giaDichVu to set
     */
    public void setGiaDichVu(double giaDichVu) {
        this.giaDichVu = giaDichVu;
    }

    /**
     * @return the tongBill
     */
    public double getTongBill() {
        return tongBill;
    }

    /**
     * @param tongBill the tongBill to set
     */
    public void setTongBill(double tongBill) {
        this.tongBill = tongBill;
    }

    /**
     * @return the timeOfDay
     */
    public String getTimeOfDay() {
        return timeOfDay;
    }

    /**
     * @param timeOfDay the timeOfDay to set
     */
    public void setTimeOfDay(String timeOfDay) {
        this.timeOfDay = timeOfDay;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    public Sanh getSanh() {
        return sanh;
    }

    /**
     * @param sanh the sanh to set
     */
    public void setSanh(Sanh sanh) {
        this.sanh = sanh;
    }

}
