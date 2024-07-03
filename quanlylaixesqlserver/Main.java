package quanlylaixesqlserver;

import java.io.*;
import java.util.*;

public class Main {
    private static List<LaiXe> danhSachLaiXe = new ArrayList<>();

    private static List<Tuyen> danhSachTuyen = new ArrayList<>();
    private static List<BangPhanCong> danhSachPhanCong = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        docDuLieu();
        while (true) {
            System.out.println("===== MENU =====");
            System.out.println("1. Nhap danh sach lai xe");
            System.out.println("2. In danh sach lai xe");
            System.out.println("3. Nhap danh sach tuyen");
            System.out.println("4. In danh sach tuyen");
            System.out.println("5. Nhap danh sach phan cong");
            System.out.println("6. In danh sach phan cong");
            System.out.println("7. Sap xep phan cong theo ho ten");
            System.out.println("8. Sap xep phan cong theo so luot");
            System.out.println("9. Tinh tong quang duong lai xe di trong ngay");
            System.out.println("10. Thoat");
            System.out.print("Chon chuc nang: ");
            int luaChon = scanner.nextInt();
            scanner.nextLine(); // Đọc ký tự newline sau khi nhập số

            switch (luaChon) {
                case 1:
                    nhapDanhSachLaiXe();
                    break;
                case 2:
                    inDanhSachLaiXe();
                    break;
                case 3:
                    nhapDanhSachTuyen();
                    break;
                case 4:
                    inDanhSachTuyen();
                    break;
                case 5:
                    nhapDanhSachPhanCong();
                    break;
                case 6:
                    inDanhSachPhanCong();
                    break;
                case 7:
                    sapxeptheohoten();
                    inDanhSachPhanCong();
                    break;
                case 8:
                    sapxeptheosotuyen();
                    inDanhSachPhanCong();
                    break;
                case 9:
                    tongquangduongditrongngay();
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        }
    }

    public static void nhapDanhSachLaiXe() {
        System.out.print("Nhap so luong lai xe: ");
        int soLuong = scanner.nextInt();
        scanner.nextLine(); // Đọc ký tự newline sau khi nhập số

        for (int i = 0; i < soLuong; i++) {
            System.out.print("Nhap ho ten: ");
            String hoTen = scanner.nextLine();
            System.out.print("Nhap dia chi: ");
            String diaChi = scanner.nextLine();
            System.out.print("Nhap so dien thoai: ");
            String soDienThoai = scanner.nextLine();
            System.out.print("Nhap trinh do: ");
            String trinhDo = scanner.nextLine();

            LaiXe laiXe = new LaiXe(hoTen, diaChi, soDienThoai, trinhDo);
            danhSachLaiXe.add(laiXe);
            MainDao.luulaixe(laiXe);
        }

        ;
    }

    public static void inDanhSachLaiXe() {
        System.out.println("===== DANH SACH LAI XE =====");
        for (LaiXe laiXe : danhSachLaiXe) {
            System.out.println(laiXe);
        }
    }

    public static void nhapDanhSachTuyen() {
        System.out.print("Nhap so luong tuyen: ");
        int soLuong = scanner.nextInt();
        scanner.nextLine(); // Đọc ký tự newline sau khi nhập số

        for (int i = 0; i < soLuong; i++) {
            System.out.print("Nhap khoang cach: ");
            float khoangCach = scanner.nextFloat();
            System.out.print("Nhap so diem dung: ");
            int soDiemDung = scanner.nextInt();
            scanner.nextLine(); // Đọc ký tự newline sau khi nhập số

            Tuyen tuyen = new Tuyen(khoangCach, soDiemDung);
            danhSachTuyen.add(tuyen);
            MainDao.luutuyen(tuyen);
        }


    }

    public static void inDanhSachTuyen() {
        System.out.println("===== DANH SACH TUYEN =====");
        for (Tuyen tuyen : danhSachTuyen) {
            System.out.println(tuyen);
        }
    }

    public static void nhapDanhSachPhanCong() {
        System.out.print("Nhap so luong phan cong: ");
        int soLuong = scanner.nextInt();
        scanner.nextLine(); // Đọc ký tự newline sau khi nhập số

        for (int i = 0; i < soLuong; i++) {
            System.out.println("Nhap thong tin phan cong thu " + (i + 1) + ":");
            System.out.print("Nhap ma lai xe: ");
            int maLaiXe = scanner.nextInt();
            System.out.print("Nhap ma tuyen: ");
            int maTuyen = scanner.nextInt();
            System.out.print("Nhap so luot: ");
            int soLuot = scanner.nextInt();
            scanner.nextLine(); // Đọc ký tự newline sau khi nhập số

            LaiXe laiXe = timLaiXeTheoMa(maLaiXe);
            Tuyen tuyen = timTuyenTheoMa(maTuyen);


            if (laiXe != null && tuyen != null) {
                boolean daDuocPhanCong = false;
                for (BangPhanCong bpc : danhSachPhanCong) {
                    if (bpc.getMalx() == maLaiXe && bpc.getMatuyen() == maTuyen) {
                        System.out.println("Lai xe da duoc phan cong tuyen nay roi");
                        daDuocPhanCong = true;
                        break;
                    }
                }

                if (!daDuocPhanCong) {
                    BangPhanCong phanCong = new BangPhanCong(maLaiXe,maTuyen, soLuot);
                    phanCong.setHoten(timtenlaixe(maLaiXe));
                    danhSachPhanCong.add(phanCong);
                    MainDao.luuBangPhanCong(phanCong);
                }
            } else {
                System.out.println("Khong tim thay lai xe hoac tuyen tuong ung.");
            }
        }
    }

    public static void inDanhSachPhanCong() {
        System.out.println("===== DANH SACH PHAN CONG =====");
        for (BangPhanCong phanCong : danhSachPhanCong) {
            System.out.println(phanCong);
        }
    }

    public static void docDuLieu() {
        danhSachLaiXe = MainDao.laydanhsachlaixe();
        if (!danhSachLaiXe.isEmpty()) {
            int lastMalx = danhSachLaiXe.get(danhSachLaiXe.size() - 1).getMalx();
            LaiXe.caidatId(lastMalx+1);
        }

        danhSachTuyen = MainDao.laydanhsachtuyen();
        if (!danhSachTuyen.isEmpty()) {
            int lastMatuyen = danhSachTuyen.get(danhSachTuyen.size() - 1).getMatuyen();
            Tuyen.caidatId(lastMatuyen+1);
        }

        danhSachPhanCong = MainDao.laydanhsachphancong();
        for(BangPhanCong bpc : danhSachPhanCong){
            bpc.setHoten(timtenlaixe(bpc.getMalx()));
        }
    }


    public static LaiXe timLaiXeTheoMa(int maLaiXe) {
        for (LaiXe laiXe : danhSachLaiXe) {
            if (laiXe.getMalx() == maLaiXe) {
                return laiXe;
            }
        }
        return null;
    }
    public static String timtenlaixe(int maLaiXe) {
        for (LaiXe laiXe : danhSachLaiXe) {
            if (laiXe.getMalx() == maLaiXe) {
                return laiXe.getHoten();
            }
        }
        return null;
    }

    public static Tuyen timTuyenTheoMa(int maTuyen) {
        for (Tuyen tuyen : danhSachTuyen) {
            if (tuyen.getMatuyen() == maTuyen) {
                return tuyen;
            }
        }
        return null;
    }
    public static float timkhoangcachtuyen(int maTuyen) {
        for (Tuyen tuyen : danhSachTuyen) {
            if (tuyen.getMatuyen() == maTuyen) {
                return tuyen.getKhoangcach();
            }
        }
        return 0;
    }

    public static  void sapxeptheohoten(){
        Comparator<BangPhanCong> compareByHoTen = Comparator.comparing(bpc -> bpc.getHoten());
        danhSachPhanCong.sort(compareByHoTen);
    }
    public static  void sapxeptheosotuyen(){
        Comparator<BangPhanCong> compareBySoLuotGiamDan = (bpc1, bpc2) -> Integer.compare(bpc2.getSoluot(), bpc1.getSoluot());
        danhSachPhanCong.sort(compareBySoLuotGiamDan);

    }
    public static void tongquangduongditrongngay(){
        Map<Integer, Float> bangKeKhoangCach = new HashMap<>();
        for (BangPhanCong phanCong : danhSachPhanCong) {
            int maLaiXe = phanCong.getMalx();
            float khoangCach = (float) timkhoangcachtuyen(phanCong.getMatuyen());
            int soluot = phanCong.getSoluot();
            // Kiểm tra xem lái xe đã có trong Map chưa, nếu chưa thì thêm vào với khoảng cách ban đầu là 0
            bangKeKhoangCach.putIfAbsent(maLaiXe, 0f);

            // Cộng dồn khoảng cách chạy của lái xe
            float tongKhoangCach = bangKeKhoangCach.get(maLaiXe) + khoangCach * soluot;

            // Cập nhật tổng khoảng cách vào Map
            bangKeKhoangCach.put(maLaiXe, tongKhoangCach);
        }
        System.out.println("===== Bảng kê tổng quãng đường đi của từng lái xe =====");
        for (Map.Entry<Integer, Float> entry : bangKeKhoangCach.entrySet()) {
            int maLaiXe = entry.getKey();
            float tongQuangDuong = entry.getValue();

            // Tìm tên lái xe từ danh sách
            LaiXe lx = timLaiXeTheoMa(maLaiXe);

            // In ra thông tin
            System.out.println("Mã lái xe: " + maLaiXe + ", Tên lái xe: " + lx.getHoten() + ", Tổng quãng đường đi: " + tongQuangDuong);
        }

    }

}