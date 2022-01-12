/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SanPham;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author Thanh Sang
 */
public class QuanLySanPham {
    public static final Scanner S = new Scanner(System.in);
    private List<SanPham> SANPHAM = new ArrayList<>();
    public static QuanLySanPham QLSP = new QuanLySanPham();

    public void themSanPham(SanPham sp) {
        this.SANPHAM.add(sp);
    }

    public void themSanPham(String loaiSP) throws NoSuchMethodException {

        try {
            Class c = Class.forName(loaiSP);
            SanPham sp = (SanPham) c.getDeclaredConstructor(null).newInstance();
            sp.nhapSanPham();
            this.SANPHAM.add(sp);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException ex) {
            ex.printStackTrace();
        }
    }

    public List<SanPham> xuatTheoLoaiSP(String loaiSP) {

        return this.SANPHAM.stream().filter(s -> {
            try {
                Class c = Class.forName(loaiSP);

                return c.isInstance(s);

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            return false;
        }).collect(Collectors.toList());
    }

    public List<SanPham> xoaSanPham(String loaiSP, int i) {

        for (SanPham s : QLSP.xuatTheoLoaiSP(loaiSP)) {
            if (s.getMaSanPham() == i) {
                SANPHAM.remove(s);
                System.out.println("Xoa thanh cong!");
                break;
                
            } else {
                System.out.println("San pham khong ton tai!");
                break;
            }
        }
        return SANPHAM;
    }

    public List<SanPham> capNhatSanPham(String loaiSP, int i) {

        for (SanPham s : QLSP.xuatTheoLoaiSP(loaiSP)) {
            if (s.getMaSanPham() == i) {
                s.nhapSanPham();
                System.out.println("Cap nhat thanh cong!");
                break;
            } else {
                System.out.println("San pham khong ton tai!");
                break;
            }
        }
        return SANPHAM;
    }

    public List<SanPham> timSanPham(String loaiSP, String kw) {
        List<SanPham> ds2 = new ArrayList<>();

        for (SanPham s : QLSP.xuatTheoLoaiSP(loaiSP)) {
            if (s.getTenSanPham().contains(kw) == true) {
                ds2.add(s);
            }

        }
        return ds2;
    }

    private void titleThucAn() {
        System.out.printf("  %-6s %-27s %14s %20s\n", "ID", "TEN SAN PHAM",
                "GIA SAN PHAM", "GHI CHU");
        System.out.println("----------------------------------------------------"
                + "-----------------------------------------------");
    }

    private void titleThucUong() {
        System.out.printf("  %-6s %-27s %14s %23s\n", "ID", "TEN SAN PHAM",
                "GIA SAN PHAM", "HANG SAN XUAT");
        System.out.println("----------------------------------------------------"
                + "-----------------------------------------------");
    }

    public void sanPhamController() throws NoSuchMethodException {
        int choice;

        do {
            System.out.println("======== MENU ========");
            System.out.println("1. Quan ly thuc an");
            System.out.println("2. Quan ly thuc uong");
            System.out.println("0. Thoat");
            System.out.println("======================");
            System.out.println("=> Nhap lua chon: ");
            choice = S.nextInt();
            S.nextLine();

            switch (choice) {
                case 1 -> {
                    int choiceProduct;
                    do {
                        System.out.println("====== THUC AN =====");
                        System.out.println("1. Hien thi san pham");
                        System.out.println("2. Them san pham");
                        System.out.println("3. Xoa san pham");
                        System.out.println("4. Sua thong tin san pham");
                        System.out.println("5. Tim kiem san pham");
                        System.out.println("0. Thoat");
                        System.out.println("=====================");
                        System.out.println("=> Nhap lua chon: ");
                        choiceProduct = S.nextInt();
                        S.nextLine();

                        switch (choiceProduct) {
                            case 1 -> {
                                titleThucAn();
                                QLSP.xuatTheoLoaiSP("SanPham.ThucAn").forEach(s -> s.xuatSanPham());
                            }
                            case 2 -> {
                                QLSP.themSanPham("SanPham.ThucAn");
                            }
                            case 3 -> {
                                System.out.println("- Nhap ma san pham can xoa: ");
                                int i = Integer.parseInt(S.nextLine());
                                QLSP.xoaSanPham("SanPham.ThucAn", i);
                            }
                            case 4 -> {
                                System.out.println("- Nhap ma san pham can cap nhat: ");
                                int i = Integer.parseInt(S.nextLine());
                                QLSP.capNhatSanPham("SanPham.ThucAn", i);
                            }
                            case 5 -> {
                                System.out.println("- Nhap tu khoa: ");
                                String kw = S.nextLine();
                                titleThucAn();
                                QLSP.timSanPham("SanPham.ThucAn", kw).forEach(s -> s.xuatSanPham());
                            }
                            default ->
                                System.out.println("=> Ban da chon thoat!");
                        }
                    } while (choiceProduct != 0);

                }
                case 2 -> {
                    int choiceProduct;
                    do {
                        System.out.println("====== THUC UONG =====");
                        System.out.println("1. Hien thi san pham");
                        System.out.println("2. Them san pham");
                        System.out.println("3. Xoa san pham");
                        System.out.println("4. Sua thong tin san pham");
                        System.out.println("5. Tim kiem san pham");
                        System.out.println("0. Thoat");
                        System.out.println("======================");
                        System.out.println("=> Nhap lua chon: ");
                        choiceProduct = S.nextInt();
                        S.nextLine();

                        switch (choiceProduct) {
                            case 1 -> {
                                titleThucUong();
                                QLSP.xuatTheoLoaiSP("SanPham.ThucUong").forEach(s -> s.xuatSanPham());
                            }
                            case 2 -> {
                                QLSP.themSanPham("SanPham.ThucUong");
                            }
                            case 3 -> {
                                System.out.println("- Nhap ma san pham can xoa: ");
                                int i = Integer.parseInt(S.nextLine());
                                QLSP.xoaSanPham("SanPham.ThucUong", i);
                            }
                            case 4 -> {
                                System.out.println("- Nhap ma san pham can cap nhat: ");
                                int i = Integer.parseInt(S.nextLine());
                                QLSP.capNhatSanPham("SanPham.ThucUong", i);
                            }
                            case 5 -> {
                                System.out.println("- Nhap tu khoa: ");
                                String kw = S.nextLine();
                                titleThucUong();
                                QLSP.timSanPham("SanPham.ThucUong", kw).forEach(s -> s.xuatSanPham());
                            }
                            default ->
                                System.out.println("=> Ban da chon thoat!");
                        }
                    } while (choiceProduct != 0);

                }

                default ->
                    System.out.println("=> Ban da chon thoat!");
            }
        } while (choice != 0);
    }

    /**
     * @return the SANPHAM
     */
    public List<SanPham> getDs() {
        return SANPHAM;
    }

    /**
     * @param ds the SANPHAM to set
     */
    public void setDs(List<SanPham> ds) {
        this.SANPHAM = ds;
    }

}
