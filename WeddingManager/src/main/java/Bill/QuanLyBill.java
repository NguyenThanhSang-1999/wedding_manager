/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bill;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Thanh Sang
 */
public class QuanLyBill {
    public static final Scanner S = new Scanner(System.in);
    private List<Bill> ds = new ArrayList<>();
    public static QuanLyBill QLBILL = new QuanLyBill();

    public List<Bill> DanhSachBill() {
        return ds;
    }
    
    public void taoBill(){
        try {
            Bill p = new Bill();
            p.nhapBill();
            ds.add(p);

        } catch (InputMismatchException ei) {
            System.out.println("Ban da nhap sai gia tri, xin vui long nhap lai!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Bill> xoaBill() {
        List<Bill> ds2 = new ArrayList<>();
        System.out.println("- Nhap ma bill can xoa: ");
        String kw = S.nextLine();

        for (Bill s : ds2) {
            if (s.getMaBill().contains(kw)) {
                ds.remove(s);
                System.out.println("Xoa thanh cong!");
                break;
            }
        }
        return ds;
    }

    public List<Bill> timBill() {
        List<Bill> ds2 = new ArrayList<>();
        System.out.println("- Nhap ma bill can tim: ");
        String kw = S.nextLine();

        for (Bill s : ds) {
            if (s.getMaBill().contains(kw)) {
                ds2.add(s);
                break;
            }
        }
        return ds2;
    }

    public List<Bill> capNhatBill() throws ParseException {
        System.out.println("- Nhap ma bill can cap nhat: ");
        String kw = S.nextLine();

        for (Bill s : this.ds) {
            if (s.getMaBill().contains(kw)) {
                s.nhapBill();
                System.out.println("Cap nhat thanh cong!");
                break;
            } else {
                System.out.println("Bill khong ton tai!");
                break;
            }
        }
        return ds;
    }

    public void billController() throws ParseException {

        int choice;
        do {
            System.out.println("============= BILL ==============");
            System.out.println("1. Hien thi danh sach bill");
            System.out.println("2. Tao bill");
            System.out.println("3. Tim kiem");
            System.out.println("4. Cap nhat bill");
            System.out.println("0. Thoát");
            System.out.println("=================================");
            System.out.println("=> Nhap lua chon: ");
            choice = S.nextInt();
            S.nextLine();

            switch (choice) {
                case 1 ->
                    QLBILL.DanhSachBill().forEach(s -> s.xuatBill());
                case 2 ->
                    QLBILL.taoBill();
                case 3 -> {
                    QLBILL.timBill().forEach(s -> s.xuatBill());
                }
                case 4 -> {
                    QLBILL.capNhatBill();
                }
                default ->
                    System.out.println("- Ban da chon thoat!");
            }
        } while (choice != 0);
    }

}
