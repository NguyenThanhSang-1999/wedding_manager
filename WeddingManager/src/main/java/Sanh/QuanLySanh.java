/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sanh;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author Thanh Sang
 */
public class QuanLySanh {
    public static final Scanner S = new Scanner(System.in);
    private List<Sanh> SANH = new ArrayList<>();
    public static QuanLySanh QLSANH = new QuanLySanh();
 
    public void themSanh(Sanh s) {
        this.SANH.add(s);
    }

    public void themSanh() {
        try {
            Sanh p = new Sanh();
            p.nhapSanh();
            SANH.add(p);

        } catch (InputMismatchException ei) {
            System.out.println("Ban da nhap sai gia tri, xin vui long nhap lai!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public List<Sanh> xuatDanhSach() {
        titleSanh();
        return this.SANH;
    }

    public List<Sanh> xoaSanh() {
        System.out.println("-Nhap ma sanh can xoa: ");
        String kw = S.nextLine();

//        for (Sanh s : this.SANH) {
//            if (s.getMaSanh().contains(kw)) {
//                this.SANH.remove(s);
//                System.out.println("Xoa thanh cong!");
//                break;
//            } else {
//                System.out.println("San pham khong ton tai!");
//                break;
//            }
//        }
        SANH.removeIf(s -> (s.getMaSanh().contains(kw) == true));
        return this.SANH;
    }

    public List<Sanh> capNhatSanh() {
        System.out.println("- Nhap ma sanh can cap nhat: ");
        String kw = S.nextLine().toUpperCase();

        for (Sanh s : this.SANH) {
            if (s.getMaSanh().contains(kw)) {
                s.nhapSanh();
                System.out.println("Cap nhat thanh cong!");
                break;
            } else {
                System.out.println("San pham khong ton tai!");
                break;
            }
        }
        return SANH;
    }
  
    public List<Sanh> timKiemTheoViTri() {
        System.out.println("- Nhap vi tri sanh: ");
        String kw = S.nextLine();
        return this.SANH.stream().filter(s -> s.getViTriSanh().contains(kw) == true)
                .collect(Collectors.toList());
    
    }
    
    public List<Sanh> timKiemTheoTen() {
        List<Sanh> dsSanh = new ArrayList<>();
        
        System.out.println("- Nhap tu khoa: ");
        String kw = S.nextLine();
        
        for (Sanh s : this.SANH) {
            if (s.getTenSanh().contains(kw) == true) {
                dsSanh.add(s);
                titleSanh();
            } 
        }       
        return dsSanh;
    }
    
    public List<Sanh> sapXepTheoSoLanThue() {
        List<Sanh> ds = new ArrayList<>();
        ds = SANH;
        ds.sort((s1, s2) -> -(s1.getSoLanThue()- s2.getSoLanThue()));
        return ds;
    }
    
    public List<Sanh> timKiemTheoSoLuong() {
        List<Sanh> dsSanh = new ArrayList<>();
        
        System.out.println("- Nhap so luong: ");       
        int kw = Integer.parseInt(S.nextLine());
        
        for (Sanh s : this.SANH) {
            if (s.getSucChua() == kw) {
                dsSanh.add(s);
                titleSanh();
            } 
        }
        
        return dsSanh;
    }

    public void titleSanh() {
        System.out.printf("  %-15s %-15s %-15s %10s %15s \n%s\n",
                "ID", "TEN SANH", "VI TRI SANH", "SUC CHUA", "SO LAN THUE",
                "----------------------------------------------"
                + "------------------------------------------");
    }

    public void sanhController() {
        
        int choice; 
        
        do {
            System.out.println("============== SANH ===============");
            System.out.println("1. Hien thi danh sach sanh");
            System.out.println("2. Them sanh");
            System.out.println("3. Xoa sanh");
            System.out.println("4. Sua thong tin");
            System.out.println("5. Tim kiem sanh theo ten");
            System.out.println("6. Tim kiem sanh theo so luong");
            System.out.println("7. Tim kiem sanh theo vi tri");
            System.out.println("8. Sap xep theo so lan thue");
            System.out.println("0. Thoat");
            System.out.println("=================================");
            System.out.println("=> Nhap lua chon: ");
            choice = S.nextInt();
            S.nextLine();

            switch (choice) {
                case 1 ->
                    QLSANH.xuatDanhSach().forEach(s -> s.xuatSanh());
                case 2 ->
                    QLSANH.themSanh();
                case 3 -> {
                    QLSANH.xoaSanh();
                }
                case 4 -> {
                    QLSANH.capNhatSanh();
                }
                case 5 -> {
                    QLSANH.timKiemTheoTen().forEach(s -> s.xuatSanh());
                }
                case 6 -> {
                    QLSANH.timKiemTheoSoLuong().forEach(s -> s.xuatSanh());
                }
                case 7 -> {
                    QLSANH.timKiemTheoViTri().forEach(s -> s.xuatSanh());
                }
                case 8 -> {
                    System.out.println("=== SAP XEP THEO SO LAN DUOC THUE ===");
                    QLSANH.sapXepTheoSoLanThue().forEach(s -> s.xuatSanh());
                }
                default ->
                    System.out.println("=> Ban da chon thoat!");
            }
        } while (choice != 0);
    }
}
