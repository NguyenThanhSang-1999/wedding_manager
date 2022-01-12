/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bill;

import static Bill.QuanLyBill.QLBILL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Thanh Sang
 */
public class BaoCaoThongKe {

    public BaoCaoThongKe() {
    }

    public void thongKeTheoThang(String y) throws ParseException {
        double priceJan = 0, priceFeb = 0, priceMar = 0, priceApr = 0, priceMay = 0,
                priceJun = 0, priceJul = 0, priceAug = 0, priceSep = 0, priceOct = 0,
                priceNov = 0, priceDec = 0;

        for (Bill b : QLBILL.DanhSachBill()) {
            SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
            Date date = format1.parse(b.getDate());

            DateFormat month = new SimpleDateFormat("MMMM");
            String finalMonth = month.format(date);

            DateFormat year = new SimpleDateFormat("YYYY");
            String finalYear = year.format(date);

            if (finalMonth.contains("January") && finalYear.contains(y)) {
                priceJan += b.getTongBill();
            } else if (finalMonth.contains("February") && finalYear.contains(y)) {
                priceFeb += b.getTongBill();
            } else if (finalMonth.contains("March") && finalYear.contains(y)) {
                priceMar += b.getTongBill();
            } else if (finalMonth.contains("April") && finalYear.contains(y)) {
                priceApr += b.getTongBill();
            } else if (finalMonth.contains("May") && finalYear.contains(y)) {
                priceMay += b.getTongBill();
            } else if (finalMonth.contains("June") && finalYear.contains(y)) {
                priceJun += b.getTongBill();
            } else if (finalMonth.contains("July") && finalYear.contains(y)) {
                priceJul += b.getTongBill();
            } else if (finalMonth.contains("August") && finalYear.contains(y)) {
                priceAug += b.getTongBill();
            } else if (finalMonth.contains("September") && finalYear.contains(y)) {
                priceSep += b.getTongBill();
            } else if (finalMonth.contains("October") && finalYear.contains(y)) {
                priceOct += b.getTongBill();
            } else if (finalMonth.contains("November") && finalYear.contains(y)) {
                priceNov += b.getTongBill();
            } else if (finalMonth.contains("December") && finalYear.contains(y)) {
                priceDec += b.getTongBill();
            }
        }
        System.out.printf("Doanh so thang 1: %,.0f VND\n", priceJan);
        System.out.printf("Doanh so thang 2: %,.0f VND\n", priceFeb);
        System.out.printf("Doanh so thang 3: %,.0f VND\n", priceMar);
        System.out.printf("Doanh so thang 4: %,.0f VND\n", priceApr);
        System.out.printf("Doanh so thang 5: %,.0f VND\n", priceMay);
        System.out.printf("Doanh so thang 6: %,.0f VND\n", priceJun);
        System.out.printf("Doanh so thang 7: %,.0f VND\n", priceJul);
        System.out.printf("Doanh so thang 8: %,.0f VND\n", priceAug);
        System.out.printf("Doanh so thang 9: %,.0f VND\n", priceSep);
        System.out.printf("Doanh so thang 10: %,.0f VND\n", priceOct);
        System.out.printf("Doanh so thang 11: %,.0f VND\n", priceNov);
        System.out.printf("Doanh so thang 12: %,.0f VND\n", priceDec);

    }

    public void thongKeTheoQuy(String y) throws ParseException {
        double price1StQuarter = 0, price2NdQuarter = 0, price3RdQuarter = 0, price4ThQuarter = 0;

        for (Bill b : QLBILL.DanhSachBill()) {
            SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
            Date date = format1.parse(b.getDate());

            DateFormat month = new SimpleDateFormat("MMMM");
            String finalMonth = month.format(date);

            DateFormat year = new SimpleDateFormat("YYYY");
            String finalYear = year.format(date);

            if (finalMonth.contains("January") && finalYear.contains(y)) {
                price1StQuarter += b.getTongBill();
            } else if (finalMonth.contains("February") && finalYear.contains(y)) {
                price1StQuarter += b.getTongBill();
            } else if (finalMonth.contains("March") && finalYear.contains(y)) {
                price1StQuarter += b.getTongBill();
            } else if (finalMonth.contains("April") && finalYear.contains(y)) {
                price1StQuarter += b.getTongBill();
            } else if (finalMonth.contains("May") && finalYear.contains(y)) {
                price2NdQuarter += b.getTongBill();
            } else if (finalMonth.contains("June") && finalYear.contains(y)) {
                price2NdQuarter += b.getTongBill();
            } else if (finalMonth.contains("July") && finalYear.contains(y)) {
                price2NdQuarter += b.getTongBill();
            } else if (finalMonth.contains("August") && finalYear.contains(y)) {
                price2NdQuarter += b.getTongBill();
            } else if (finalMonth.contains("September") && finalYear.contains(y)) {
                price4ThQuarter += b.getTongBill();
            } else if (finalMonth.contains("October") && finalYear.contains(y)) {
                price4ThQuarter += b.getTongBill();
            } else if (finalMonth.contains("November") && finalYear.contains(y)) {
                price4ThQuarter += b.getTongBill();
            } else if (finalMonth.contains("December") && finalYear.contains(y)) {
                price4ThQuarter += b.getTongBill();
            }
        }
        System.out.printf("Doanh so quy 1: %,.0f VND\n", price1StQuarter);
        System.out.printf("Doanh so quy 2: %,.0f VND\n", price2NdQuarter);
        System.out.printf("Doanh so quy 3: %,.0f VND\n", price3RdQuarter);
        System.out.printf("Doanh so quy 4: %,.0f VND\n", price4ThQuarter);

    }

    public void statisticsController() throws ParseException {
        Scanner scanner = new Scanner(System.in);
        int choice;
        String year;

        do {
            System.out.println("=============== BAO CAO THONG KE ===============");
            System.out.println("1. Thong ke theo thang");
            System.out.println("2. Thong ke theo quy");
            System.out.println("0. Thoat");
            System.out.println("================================================");
            System.out.println("=> Nhap lua chon: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.println("- Nhap nam can thong ke: ");
                    year = scanner.nextLine();

                    thongKeTheoThang(year);
                }
                case 2 -> {
                    System.out.println("- Nhập năm cần thống kê: ");
                    year = scanner.nextLine();

                    thongKeTheoQuy(year);
                }

                default ->
                    System.out.println("- Bạn đa chon thoat!");
            }
        } while (choice != 0);
    }
}
