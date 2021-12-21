/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weddingmanager;

import java.util.Scanner;

/**
 *
 * @author Thanh Sang
 */
public class Test {

    public static void main(String[] args) throws NoSuchMethodException {

        Scanner scanner = new Scanner(System.in);

        QuanLySanh s = new QuanLySanh();
        QuanLySanPham sp = new QuanLySanPham();


        int choice;

        do {
            System.out.println("====== QUAN LY TIEC CUOI =====");
            System.out.println("1. Quan ly sanh");
            System.out.println("2. Quan ly thuc pham");
            System.out.println("3. Quan ly dich vu");
            System.out.println("4. Quan ly bill");
            System.out.println("5. Quan ly danh sach cac menu");
            System.out.println("6. Quan ly bang gia sanh");
            System.out.println("7. Thong ke");
            System.out.println("0. Thoat");
            System.out.println("=============================");
            System.out.println("=> Nhap lua chon: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
//				case 1 -> s1.lobbyController();
                case 2 ->
                    sp.sanPhamController();
//				case 3 -> ms.serviceController();
//				case 4 -> mb.billController();
//				case 5 -> mm.menuController();
//				case 6 -> lpl.priceListController();
//				case 7 -> stt.statisticsController();
                default ->
                    System.out.println("Ban da chon thoat!!!");
            }
        } while (choice != 0);

    }
}
