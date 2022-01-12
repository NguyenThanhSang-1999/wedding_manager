/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DichVu;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author Thanh Sang
 */
public class QuanLyDichVu {
    public static final Scanner S = new Scanner(System.in);
    private List<DichVu> DICHVU = new ArrayList<>();
    public static QuanLyDichVu QLDV = new QuanLyDichVu();

    public void themDichVu(DichVu sp) {
        this.DICHVU.add(sp);
    }

    public void themDichVu(String loaiSP) throws NoSuchMethodException {
        try {
            Class c = Class.forName(loaiSP);
            DichVu sp = (DichVu) c.getDeclaredConstructor(null).newInstance();
            sp.nhapDichVu();
            this.DICHVU.add(sp);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException ex) {
            ex.printStackTrace();
        }
    }

    public List<DichVu> xuatTheoLoaiDV(String loaiDV) {
        return this.DICHVU.stream().filter(s -> {
            try {
                Class c = Class.forName(loaiDV);

                return c.isInstance(s);

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            return false;
        }).collect(Collectors.toList());
    }

    public List<DichVu> xoaDichVu(String loaiDV, int i) {

        for (DichVu s : QLDV.xuatTheoLoaiDV(loaiDV)) {
            if (s.getMaDichVu() == i) {
                DICHVU.remove(s);
                System.out.println("Xoa thanh cong!");
                break;
            } else {
                System.out.println("Dich vu khong ton tai!");
                break;
            }
        }
        return DICHVU;
    }

    public List<DichVu> capNhatDichVu(String loaiDV, int i) {

        for (DichVu s : QLDV.xuatTheoLoaiDV(loaiDV)) {
            if (s.getMaDichVu() == i) {
                s.nhapDichVu();
                System.out.println("Cap nhat thanh cong!");
                break;
            } else {
                System.out.println("Dich vu khong ton tai!");
                break;
            }
        }
        return DICHVU;
    }

    public List<DichVu> timDichVu(String loaiDV, String kw) {
        List<DichVu> ds2 = new ArrayList<>();

        for (DichVu s : QLDV.xuatTheoLoaiDV(loaiDV)) {
            if (s.getTenDichVu().contains(kw)) {
                ds2.add(s);
            }
        }
        return ds2;
    }

    private void titleKaraoke() {
        System.out.printf("  %-12s %-20s %18s %22s\n", "ID", "TEN DICH VU",
                "GIA DICH VU", "THOI GIAN THUE");
        System.out.println("--------------------------------------------------------"
                + "-------------------------------------------------");
    }

    private void titleTrangTri() {
        System.out.printf("  %-12s %-20s %18s\n", "ID", "TEN DICH VU",
                "GIA DICH VU");
        System.out.println("--------------------------------------------------------"
                + "-------------------------------------------------");
    }

    private void titleCaSi() {
        System.out.printf("  %-12s %-20s %18s %20s %25s\n", "ID", "TEN DICH VU",
                "GIA DICH VU", "TEN CA SI", "SO LUONG BAI HAT");
        System.out.println("--------------------------------------------------------"
                + "-------------------------------------------------");
    }

    public void dichVuController() throws NoSuchMethodException {

        int choice;

        do {
            System.out.println("======= QUAN LY DICH VU =======");
            System.out.println("1. Dich vu karaoke");
            System.out.println("2. Dich vu trang tri");
            System.out.println("3. Dich vu thue ca si");
            System.out.println("0. Thoat");
            System.out.println("===============================");
            System.out.println("=> Nhap lua chon: ");
            choice = S.nextInt();
            S.nextLine();

            switch (choice) {
                case 1 -> {
                    int choiceProduct;
                    do {

                        System.out.println("=========== KARAOKE ==========");
                        System.out.println("1. Hien thi dich vu");
                        System.out.println("2. Them dich vu");
                        System.out.println("3. Xoa dich vu");
                        System.out.println("4. Cap nhat dich vu");
                        System.out.println("5. Tim kiem dich vu");
                        System.out.println("0. Thoat");
                        System.out.println("==============================");
                        System.out.println("=> Nhap lua chon: ");
                        choiceProduct = S.nextInt();
                        S.nextLine();

                        switch (choiceProduct) {
                            case 1 -> {
                                System.out.println("==== DICH VU KARAOKE  ====");
                                titleKaraoke();
                                QLDV.xuatTheoLoaiDV("DichVu.Karaoke").forEach(s -> s.xuatDichVu());
                            }
                            case 2 -> {
                                QLDV.themDichVu("DichVu.Karaoke");
                            }
                            case 3 -> {
                                System.out.println("- Nhap ma san pham can xoa: ");
                                int i = Integer.parseInt(S.nextLine());
                                QLDV.xoaDichVu("DichVu.Karaoke", i);
                            }
                            case 4 -> {
                                System.out.println("- Nhap ma dich vu can cap nhat: ");
                                int i = Integer.parseInt(S.nextLine());
                                QLDV.capNhatDichVu("DichVu.Karaoke", i);
                            }
                            case 5 -> {
                                System.out.println("- Nhap tu khoa: ");
                                String kw = S.nextLine().toUpperCase();
                                titleKaraoke();
                                QLDV.timDichVu("DichVu.Karaoke",kw).forEach(s -> s.xuatDichVu());
                            }
                            default ->
                                System.out.println("=> Ban da chon thoat!");
                        }
                    } while (choiceProduct != 0);
                }
                case 2 -> {
                    int choiceProduct;
                    do {
                        System.out.println("=========== TRANG TRI ==========");
                        System.out.println("1. Hien thi dich vu");
                        System.out.println("2. Them dich vu");
                        System.out.println("3. Xoa dich vu");
                        System.out.println("4. Cap nhat dich vu");
                        System.out.println("5. Tim kiem dich vu");
                        System.out.println("0. Thoat");
                        System.out.println("================================");
                        System.out.println("=> Nhap lua chon: ");
                        choiceProduct = S.nextInt();
                        S.nextLine();

                        switch (choiceProduct) {
                            case 1 -> {
                                System.out.println("==== DICH VU TRANG TRI ====");
                                titleTrangTri();
                                QLDV.xuatTheoLoaiDV("DichVu.TrangTri").forEach(s -> s.xuatDichVu());
                            }
                            case 2 -> {
                                QLDV.themDichVu("DichVu.TrangTri");
                            }
                            case 3 -> {
                                System.out.println("- Nhap ma san pham can xoa: ");
                                int i = Integer.parseInt(S.nextLine());
                                QLDV.xoaDichVu("DichVu.TrangTri", i);
                            }
                            case 4 -> {
                                System.out.println("- Nhap ma dich vu can cap nhat: ");
                                int i = Integer.parseInt(S.nextLine());
                                QLDV.capNhatDichVu("DichVu.TrangTri", i);
                            }
                            case 5 -> {
                                System.out.println("- Nhap tu khoa: ");
                                String kw = S.nextLine().toUpperCase();
                                titleTrangTri();
                                QLDV.timDichVu("DichVu.TrangTri",kw).forEach(s -> s.xuatDichVu());
                            }
                            default ->
                                System.out.println("=> Ban da chon thoat!");
                        }
                    } while (choiceProduct != 0);
                }
                case 3 -> {
                    int choiceProduct;
                    do {
                        System.out.println("========== THUE CA SI =========");
                        System.out.println("1. Hien thi dich vu");
                        System.out.println("2. Them dich vu");
                        System.out.println("3. Xoa dich vu");
                        System.out.println("4. Cap nhat dich vu");
                        System.out.println("5. Tim kiem dich vu");
                        System.out.println("0. Thoat");
                        System.out.println("===============================");
                        System.out.println("=> Nhap lua chon: ");
                        choiceProduct = S.nextInt();
                        S.nextLine();

                        switch (choiceProduct) {
                            case 1 -> {
                                System.out.println("==== DICH VU THUE CA SI ====");
                                titleCaSi();
                                QLDV.xuatTheoLoaiDV("DichVu.ThueCaSi").forEach(s -> s.xuatDichVu());
                            }
                            case 2 -> {
                                QLDV.themDichVu("DichVu.ThueCaSi");
                            }
                            case 3 -> {
                                System.out.println("- Nhap ma san pham can xoa: ");
                                int i = Integer.parseInt(S.nextLine());
                                QLDV.xoaDichVu("DichVu.ThueCaSi", i);
                            }
                            case 4 -> {
                                System.out.println("- Nhap ma dich vu can cap nhat: ");
                                int i = Integer.parseInt(S.nextLine());
                                QLDV.capNhatDichVu("DichVu.ThueCaSi", i);
                            }
                            case 5 -> {
                                System.out.println("- Nhap tu khoa: ");
                                String kw = S.nextLine().toUpperCase();
                                titleCaSi();
                                QLDV.timDichVu("DichVu.ThueCaSi",kw).forEach(s -> s.xuatDichVu());
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
}
