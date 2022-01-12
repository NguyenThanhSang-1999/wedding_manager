/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Bill.BaoCaoThongKe;
import Bill.QuanLyBill;
import DichVu.DichVu;
import DichVu.Karaoke;
import DichVu.QuanLyDichVu;
import DichVu.ThueCaSi;
import DichVu.TrangTri;
import SanPham.QuanLySanPham;
import SanPham.SanPham;
import SanPham.ThucAn;
import SanPham.ThucUong;
import Sanh.QuanLySanh;
import Sanh.Sanh;
import java.text.ParseException;
import java.util.Scanner;

/**
 *
 * @author Thanh Sang
 */
public class View {

    public static final Scanner S = new Scanner(System.in);

    public static void main(String[] args) throws NoSuchMethodException, ParseException {
        BaoCaoThongKe b1 = new BaoCaoThongKe();

        Sanh s1 = new Sanh("a", "1", 60);
        Sanh s2 = new Sanh("B", "2", 30);
        Sanh s3 = new Sanh("C", "2", 30);

        QuanLySanh.QLSANH.themSanh(s1);
        QuanLySanh.QLSANH.themSanh(s2);
        QuanLySanh.QLSANH.themSanh(s3);

        SanPham ta1 = new ThucAn("ga kho xa", 250000, false);
        SanPham ta2 = new ThucAn("sup cua", 150000, false);
        SanPham ta3 = new ThucAn("lau thai", 250000, false);
        SanPham ta4 = new ThucAn("ga bo xoi", 250000, false);
        SanPham ta5 = new ThucAn("dau hu chien", 50000, true);
        SanPham ta6 = new ThucAn("lau nam", 250000, true);

        SanPham tu1 = new ThucUong("coca", 15000, "Coca cola");
        SanPham tu2 = new ThucUong("pepsi", 15000, "Pepsi");
        SanPham tu3 = new ThucUong("number 1", 15000, "Number 1");
        SanPham tu4 = new ThucUong("c2", 15000, "URC");
        SanPham tu5 = new ThucUong("bia Heineken", 25000, "Heineken");
        SanPham tu6 = new ThucUong("strongbow", 25000, "VBL");

        QuanLySanPham.QLSP.themSanPham(ta1);
        QuanLySanPham.QLSP.themSanPham(ta2);
        QuanLySanPham.QLSP.themSanPham(ta3);
        QuanLySanPham.QLSP.themSanPham(ta4);
        QuanLySanPham.QLSP.themSanPham(ta5);
        QuanLySanPham.QLSP.themSanPham(ta6);

        QuanLySanPham.QLSP.themSanPham(tu1);
        QuanLySanPham.QLSP.themSanPham(tu2);
        QuanLySanPham.QLSP.themSanPham(tu3);
        QuanLySanPham.QLSP.themSanPham(tu4);
        QuanLySanPham.QLSP.themSanPham(tu5);
        QuanLySanPham.QLSP.themSanPham(tu6);

        DichVu kr1 = new Karaoke("kara Basic", 600000, 3);
        DichVu kr2 = new Karaoke("kara Hot", 800000, 4);
        DichVu kr3 = new Karaoke("kara Vip", 1500000, 5);

        DichVu cs1 = new ThueCaSi("liveShow ", 25000000, "Son Tung - MTP", 5);
        DichVu cs2 = new ThueCaSi("dance", 20000000, "Bich Phuong", 6);
        DichVu cs3 = new ThueCaSi("fire dancing", 30000000, "Laydy Gaga", 4);

        DichVu tt1 = new TrangTri("co dien", 15000000);
        DichVu tt2 = new TrangTri("hien dai", 12000000);
        DichVu tt3 = new TrangTri("trung hoa", 20000000);

        QuanLyDichVu.QLDV.themDichVu(kr1);
        QuanLyDichVu.QLDV.themDichVu(kr2);
        QuanLyDichVu.QLDV.themDichVu(kr3);

        QuanLyDichVu.QLDV.themDichVu(cs1);
        QuanLyDichVu.QLDV.themDichVu(cs2);
        QuanLyDichVu.QLDV.themDichVu(cs3);

        QuanLyDichVu.QLDV.themDichVu(tt1);
        QuanLyDichVu.QLDV.themDichVu(tt2);
        QuanLyDichVu.QLDV.themDichVu(tt3);

        int choice;

        do {
            System.out.println("====== QUAN LY TIEC CUOI =====");
            System.out.println("1. Quan ly sanh");
            System.out.println("2. Quan ly thuc pham");
            System.out.println("3. Quan ly dich vu");
            System.out.println("4. Quan ly bill");
            System.out.println("5. Thong ke");
            System.out.println("0. Thoat");
            System.out.println("=============================");
            System.out.println("=> Nhap lua chon: ");
            choice = S.nextInt();
            S.nextLine();

            switch (choice) {
                case 1 ->
                    QuanLySanh.QLSANH.sanhController();
                case 2 ->
                    QuanLySanPham.QLSP.sanPhamController();
                case 3 ->
                    QuanLyDichVu.QLDV.dichVuController();
                case 4 ->
                    QuanLyBill.QLBILL.billController();
                case 5 ->
                    b1.statisticsController();
//				case 6 -> lpl.priceListController();
//				case 7 -> stt.statisticsController();
                default ->
                    System.out.println("Ban da chon thoat!!!");
            }
        } while (choice != 0);

    }
}
