package StudentGPA;

import java.io.*;
import java.util.Scanner;

public class Main {
    private static SinhVien[] danhSachSinhVien = new SinhVien[100];
    private static int soLuongSinhVien = 0;
    private static MonHoc[] danhSachMonHoc = new MonHoc[100];
    private static int soLuongMonHoc = 0;
    private static BangDiem[] bangDiem = new BangDiem[1000];
    private static int soLuongBangDiem = 0;
    private static Scanner scanner = new Scanner(System.in);
    private static final String SINH_VIEN_FILE = "StudentGPA/sinhvien.txt";
    private static final String MON_HOC_FILE = "StudentGPA/monhoc.txt";
    private static final String BANG_DIEM_FILE = "StudentGPA/bangdiem.txt";

    public static void main(String[] args)  {
        docDuLieu();
        while (true) {
            System.out.println("1. Nhap danh sach sinh vien moi");
            System.out.println("2. In ra danh sách sinh viên");
            System.out.println("3. Nhap danh sach mon hoc moi");
            System.out.println("4. In ra danh sách môn học");
            System.out.println("5. Nhap diem cho moi sinh vien");
            System.out.println("6. Sap xep danh sach Bang diem");
            System.out.println("7. Tinh diem tong ket chung cho moi sinh vien");
            System.out.println("8. Thoat");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    nhapDanhSachSinhVien();
                    break;
                case 2:
                    inDanhSachSinhVien();
                    break;
                case 3:
                    nhapDanhSachMonHoc();

                    break;
                case 4:

                    inDanhSachMonHoc();
                    break;
                case 5:
                    nhapDiem();
                    inDanhSachBangDiem();
                    break;
                case 6:
                    sapXepBangDiem();
                    break;
                case 7:
                    tinhDiemTongKet();
                    break;
                case 8:
                    luuDuLieu();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        }
    }

    public static void nhapDanhSachSinhVien() {
        System.out.print("Nhap so luong sinh vien: ");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.print("Nhap ho ten: ");
            String hoten = scanner.nextLine();
            System.out.print("Nhap dia chi: ");
            String diachi = scanner.nextLine();
            System.out.print("Nhap so DT: ");
            String sodt = scanner.nextLine();
            System.out.print("Nhap lop: ");
            String lop = scanner.nextLine();
            danhSachSinhVien[soLuongSinhVien++] = new SinhVien(hoten, diachi, sodt, lop);
        }
    }

    public static void inDanhSachSinhVien() {
        for (int i = 0; i < soLuongSinhVien; i++) {
            System.out.println(danhSachSinhVien[i]);;
        }
    }

    public static void nhapDanhSachMonHoc() {
        System.out.print("Nhap so luong mon hoc: ");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.print("Nhap ten mon: ");
            String tenmon = scanner.nextLine();
            System.out.print("Nhap so don vi hoc trinh: ");
            int sodonvihoctrinh = Integer.parseInt(scanner.nextLine());
            System.out.print("Nhap loai mon (Dai cuong, Co so nganh, Chuyen nganh): ");
            String loaimon = scanner.nextLine();
            danhSachMonHoc[soLuongMonHoc++] = new MonHoc(tenmon, sodonvihoctrinh, loaimon);
        }
    }

    public static void inDanhSachMonHoc() {
        for (int i = 0; i < soLuongMonHoc; i++) {
            System.out.println(danhSachMonHoc[i]);;
        }
    }

    public static void nhapDiem() {
        for (int i = 0; i < soLuongSinhVien; i++) {
            SinhVien sv = danhSachSinhVien[i];
            for (int j = 0; j < soLuongMonHoc; j++) {
                MonHoc mh = danhSachMonHoc[j];
                System.out.print("Nhap diem cho sinh vien " + sv.getHoten() + " voi mon hoc " + mh.getTenmon() + ": ");
                float diem = Float.parseFloat(scanner.nextLine());
                bangDiem[soLuongBangDiem++] = new BangDiem(sv, mh, diem);
            }
        }
    }

    public static void inDanhSachBangDiem() {
        for (int i = 0; i < soLuongBangDiem; i++) {
            bangDiem[i].hienThiThongTin();
        }
    }

    public static void sapXepBangDiem() {
        System.out.println("1. Sap xep theo ho ten sinh vien");
        System.out.println("2. Sap xep theo ten mon hoc");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                sapXepBangDiemTheoHoTen();
                inDanhSachBangDiem();
                break;
            case 2:
                sapXepBangDiemTheoTenMonHoc();
                inDanhSachBangDiem();
                break;
            default:
                System.out.println("Lua chon khong hop le!");
        }
    }

    public static void sapXepBangDiemTheoHoTen() {
        for (int i = 0; i < soLuongBangDiem - 1; i++) {
            for (int j = i + 1; j < soLuongBangDiem; j++) {
                if (bangDiem[i].getSinhvien().getHoten().compareTo(bangDiem[j].getSinhvien().getHoten()) > 0) {
                    BangDiem temp = bangDiem[i];
                    bangDiem[i] = bangDiem[j];
                    bangDiem[j] = temp;
                }
            }
        }

    }

    public static void sapXepBangDiemTheoTenMonHoc() {
        for (int i = 0; i < soLuongBangDiem - 1; i++) {
            for (int j = i + 1; j < soLuongBangDiem; j++) {
                if (bangDiem[i].getMonhoc().getTenmon().compareTo(bangDiem[j].getMonhoc().getTenmon()) > 0) {
                    BangDiem temp = bangDiem[i];
                    bangDiem[i] = bangDiem[j];
                    bangDiem[j] = temp;
                }
            }
        }
    }

    public static void tinhDiemTongKet() {
        for (int i = 0; i < soLuongSinhVien; i++) {
            SinhVien sv = danhSachSinhVien[i];
            float tongDiem = 0;
            int tongSoDonViHocTrinh = 0;
            for (int j = 0; j < soLuongBangDiem; j++) {
                if (bangDiem[j].getSinhvien().equals(sv)) {
                    tongDiem += bangDiem[j].getDiem() * bangDiem[j].getMonhoc().getSodonvihoctrinh();
                    tongSoDonViHocTrinh += bangDiem[j].getMonhoc().getSodonvihoctrinh();
                }
            }
            float diemTongKet = tongDiem / tongSoDonViHocTrinh;
            System.out.println("Sinh vien: " + sv.getHoten() + ", Diem tong ket: " + diemTongKet);
        }
    }

    public static void luuDuLieu() {
        try (BufferedWriter svWriter = new BufferedWriter(new FileWriter(SINH_VIEN_FILE));
             BufferedWriter mhWriter = new BufferedWriter(new FileWriter(MON_HOC_FILE));
             BufferedWriter bdWriter = new BufferedWriter(new FileWriter(BANG_DIEM_FILE))) {

            for (int i = 0; i < soLuongSinhVien; i++) {
                SinhVien sv = danhSachSinhVien[i];
                svWriter.write(sv.getMasv() + "," + sv.getHoten() + "," + sv.getDiachi() + "," + sv.getSodt() + "," + sv.getLop());
                svWriter.newLine();
            }

            for (int i = 0; i < soLuongMonHoc; i++) {
                MonHoc mh = danhSachMonHoc[i];
                mhWriter.write(mh.getMamon() + "," + mh.getTenmon() + "," + mh.getSodonvihoctrinh() + "," + mh.getLoaimon());
                mhWriter.newLine();
            }

            for (int i = 0; i < soLuongBangDiem; i++) {
                BangDiem bd = bangDiem[i];
                bdWriter.write(bd.getSinhvien().getMasv() + "," + bd.getMonhoc().getMamon() + "," + bd.getDiem());
                bdWriter.newLine();
            }

        } catch (IOException e) {
            System.out.println("Loi khi luu du lieu: " + e.getMessage());
        }
    }

    public static void docDuLieu() {
        try (BufferedReader svReader = new BufferedReader(new FileReader(SINH_VIEN_FILE));
             BufferedReader mhReader = new BufferedReader(new FileReader(MON_HOC_FILE));
             BufferedReader bdReader = new BufferedReader(new FileReader(BANG_DIEM_FILE))) {

            String line;
            while ((line = svReader.readLine()) != null) {
                String[] parts = line.split(",");
                int masv = Integer.parseInt(parts[0]);
                String hoten = parts[1];
                String diachi = parts[2];
                String sodt = parts[3];
                String lop = parts[4];
                SinhVien sv = new SinhVien(hoten, diachi, sodt, lop);
                sv.setIdCounter(masv + 1); // Đảm bảo idCounter cập nhật đúng
                danhSachSinhVien[soLuongSinhVien++] = sv;
            }

            while ((line = mhReader.readLine()) != null) {
                String[] parts = line.split(",");
                int mamon = Integer.parseInt(parts[0]);
                String tenmon = parts[1];
                int sodonvihoctrinh = Integer.parseInt(parts[2]);
                String loaimon = parts[3];
                MonHoc mh = new MonHoc(tenmon, sodonvihoctrinh, loaimon);
                mh.setIdCounter(mamon + 1); // Đảm bảo idCounter cập nhật đúng
                danhSachMonHoc[soLuongMonHoc++] = mh;
            }

            while ((line = bdReader.readLine()) != null) {
                String[] parts = line.split(",");
                int masv = Integer.parseInt(parts[0]);
                int mamon = Integer.parseInt(parts[1]);
                float diem = Float.parseFloat(parts[2]);
                SinhVien sv = null;
                MonHoc mh = null;

                for (int i = 0; i < soLuongSinhVien; i++) {
                    if (danhSachSinhVien[i].getMasv() == masv) {
                        sv = danhSachSinhVien[i];
                        break;
                    }
                }

                for (int i = 0; i < soLuongMonHoc; i++) {
                    if (danhSachMonHoc[i].getMamon() == mamon) {
                        mh = danhSachMonHoc[i];
                        break;
                    }
                }

                if (sv != null && mh != null) {
                    bangDiem[soLuongBangDiem++] = new BangDiem(sv, mh, diem);
                }
            }

        }

        catch (FileNotFoundException e) {
            System.out.println("Không tìm thấy file: " + e.getMessage());
        }

        catch (IOException e) {
            System.out.println("Loi khi doc du lieu: " + e.getMessage());
        }
    }
}
