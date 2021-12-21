/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weddingmanager;

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
    private List<SanPham> ds = new ArrayList<>();


    public void themSP(SanPham sp) {
        this.ds.add(sp);
    }

    public void themSP(String loaiSP) throws NoSuchMethodException {
        try {
            Class c = Class.forName(loaiSP);
            SanPham sp = (SanPham) c.getDeclaredConstructor(null).newInstance();
            sp.nhapSP();
            this.ds.add(sp);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException ex) {
            ex.printStackTrace();
        }
    }

    public void xuatDanhSach() {
        this.ds.forEach(s -> s.xuatSP());
    }

    public List<SanPham> xuatTheoLoaiSP(String loaiSP) {
        return this.ds.stream().filter(s -> {
            try {
                Class c = Class.forName(loaiSP);

                return c.isInstance(s);

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
//            if (loaiSP.equals("ThucAn")) {
//                return s instanceof ThucAn;
//            } else if (loaiSP.equals("ThucUong")) {
//                return s instanceof ThucUong;
//            }
//
            return false;
        }).collect(Collectors.toList());
    }

    public List<SanPham> xoaSP() {
        System.out.println("-Nhap ma san pham can xoa: ");
        int i = Integer.parseInt(S.nextLine());

        for (SanPham s : this.ds) {
            if (s.getMaSanPham() == i) {
                this.ds.remove(s);
                System.out.println("Xoa thanh cong!");
                break;
            } else {
                System.out.println("San pham khong ton tai!");
                break;
            }
        }
        return this.ds;
    }

    public List<SanPham> capNhatSP() {
        System.out.println("-Nhap ma san pham can cap nhat: ");
        int i = Integer.parseInt(S.nextLine());

        for (SanPham s : this.ds) {
            if (s.getMaSanPham() == i) {
                s.nhapSP();
                System.out.println("Cap nhat thanh cong!");
                break;
            } else {
                System.out.println("San pham khong ton tai!");
                break;
            }
        }
        return ds;
    }

    public List<SanPham> timSP() {
        List<SanPham> sp = new ArrayList<>();
        System.out.println("-Nhap tu khoa: ");
        String kw = S.nextLine();

        for (SanPham s : this.ds) {
            if (s.getTenSanPham().contains(kw) == true) {
                System.out.println("Tim thanh cong!");
                sp.add(s);
                break;
            } else {
                System.out.println("San pham khong ton tai!");
                break;
            }
        }
        return ds;
    }

        public void sanPhamController() throws NoSuchMethodException {
        QuanLySanPham sp = new QuanLySanPham();
        int choice;
        SanPham ta1 = new ThucAn("Ga kho xa",150,false);
        SanPham ta2 = new ThucAn("Canh chua",50,true);
        SanPham ta3 = new ThucAn("Lau thai",250,false);
        
        SanPham tu1 = new ThucUong("Coca",15,"Coca cola");
        SanPham tu2 = new ThucUong("Pepsi",15,"Pepsi");
        SanPham tu3 = new ThucUong("Number 1",15,"Number 1");

        sp.themSP(ta1);
        sp.themSP(ta2);
        sp.themSP(ta3);
        
        sp.themSP(tu1);
        sp.themSP(tu2);
        sp.themSP(tu3);

        do {
            System.out.println("===========================MENU==========================");
            System.out.println("1. Quan ly thuc an");
            System.out.println("2. Quan ly thuc uong");
            System.out.println("0. Thoat");
            System.out.println("=========================================================");
            System.out.println("=> Nhap lua chon: ");
            choice = S.nextInt();
            S.nextLine();

            switch (choice) {
                case 1 -> {
                    int choiceProduct;

                    System.out.println("======== MENU =======");
                    System.out.println("1. Hien thi san pham");
                    System.out.println("2. Them san pham");
                    System.out.println("3. Xoa san pham");
                    System.out.println("4. Sua thong tin san pham");
                    System.out.println("5. Tim kiem san pham");
                    System.out.println("6. Thoat");
                    System.out.println("=====================");
                    System.out.println("=> Nhap lua chon: ");
                    choiceProduct = S.nextInt();
                    S.nextLine();

                    switch (choiceProduct) {
                        case 1 -> {
                            System.out.println("==== DANH SACH THUC AN ====");
                            sp.xuatTheoLoaiSP("weddingmanager.ThucAn").forEach(s->s.xuatSP());
                        }
                        case 2 -> {
                            sp.themSP("weddingmanager.ThucAn");
                        }
                        case 3 -> {
                            sp.xoaSP();
                        }
                        case 4 -> {
                            sp.capNhatSP();
                        }
                        case 5 -> {
                            sp.timSP();
                        }
                        default ->
                            System.out.println("=> Ban da chon thoat!");
                    }
                }
                case 2 -> {
                    int choiceProduct;

                    System.out.println("======== MENU =======");
                    System.out.println("1. Hien thi san pham");
                    System.out.println("2. Them san pham");
                    System.out.println("3. Xoa san pham");
                    System.out.println("4. Sua thong tin san pham");
                    System.out.println("5. Tim kiem san pham");
                    System.out.println("4. Thoat");
                    System.out.println("=====================");
                    System.out.println("=> Nhap lua chon: ");
                    choiceProduct = S.nextInt();
                    S.nextLine();

                    switch (choiceProduct) {
                        case 1 -> {
                            System.out.println("==== DANH SACH THUC UONG ====");
                            sp.xuatTheoLoaiSP("weddingmanager.ThucUong").forEach(s->s.xuatSP());
                        }
                        case 2 -> {
                            sp.themSP("weddingmanager.ThucUong");
                        }
                        case 3 -> {
                            sp.xoaSP();
                        }
                        case 4 -> {
                            sp.capNhatSP();
                        }
                        case 5 -> {
                            sp.timSP().forEach(s -> s.xuatSP());
                        }
                        default ->
                                System.out.println("=> Ban da chon thoat!");
                    }
                }

                default ->
                    System.out.println("=> Ban da chon thoat!");
            }
        } while (choice != 0);
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
