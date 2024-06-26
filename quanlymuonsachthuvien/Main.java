package quanlymuonsachthuvien;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Nhap danh sach dau sach moi");
            System.out.println("2. In ra danh sach cac dau sach da co");
            System.out.println("3. Nhap danh sach ban doc moi");
            System.out.println("4. In ra danh sach ban doc da co");
            System.out.println("5. Lap bang QL muon sach");
            System.out.println("6. In danh sach QL muon sach");
            System.out.println("7. Sap xep danh sach QL muon sach theo ten ban doc");
            System.out.println("8. Sap xep danh sach QL muon sach theo so luong cuon sach duoc muon (giam dan)");
            System.out.println("9. Tim kiem va hien thi danh sach muon sach theo ten ban doc");
            System.out.println("0. Thoat");
            System.out.print("Chon chuc nang: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    Quanlythuvien.nhapsachmoi(scanner);
                    break;
                case 2:
                    Quanlythuvien.indanhsachsach();
                    break;
                case 3:
                    Quanlythuvien.nhapbandocmoi(scanner);
                    break;
                case 4:
                    Quanlythuvien.indanhsachbandoc();
                    break;
                case 5:
                    Quanlythuvien.lapbangmuonsach(scanner);
                    break;
                case 6:
                    Quanlythuvien.indanhsachmuonsach();
                    break;
                case 7:
                    Quanlythuvien.sapxepmuonsachtheotenbandoc();
                    Quanlythuvien.indanhsachmuonsach();
                    break;
                case 8:
                    Quanlythuvien.sapxepmuonsachtheosoluonggiamdan();
                    Quanlythuvien.indanhsachmuonsach();
                    break;
                case 9:
                    System.out.print("Nhap ten ban doc can tim: ");
                    String tenbandoc = scanner.nextLine();
                    Quanlythuvien.timkiemvaindsmuonsachtheotenbandoc(tenbandoc);
                    break;
                case 0:
                    System.out.println("Thoat chuong trinh.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        }
    }
}

class Quanlythuvien {
    private static Sach[] danhsachsach = new Sach[100];
    private static int sachCount = 0;
    private static BanDoc[] danhsachbandoc = new BanDoc[100];
    private static int bandocCount = 0;
    private static QLMuonSach[] danhsachmuonsach = new QLMuonSach[100];
    private static int muonsachCount = 0;

    public static void nhapsachmoi(Scanner scanner) {
        System.out.print("Nhap so luong sach muon them: ");
        int soluong = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < soluong; i++) {
            System.out.print("Nhap ten sach: ");
            String tensach = scanner.nextLine();
            System.out.print("Nhap tac gia: ");
            String tacgia = scanner.nextLine();
            System.out.print("Nhap chuyen nganh: ");
            String chuyennganh = scanner.nextLine();
            System.out.print("Nhap nam xuat ban: ");
            int namxuatban = scanner.nextInt();
            scanner.nextLine();
            danhsachsach[sachCount++] = new Sach(tensach, tacgia, chuyennganh, namxuatban);
        }
    }

    public static void indanhsachsach() {
        for (int i = 0; i < sachCount; i++) {
            System.out.println(danhsachsach[i]);
        }
    }

    public static void nhapbandocmoi(Scanner scanner) {
        System.out.print("Nhap so luong ban doc muon them: ");
        int soluong = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < soluong; i++) {
            System.out.print("Nhap ho ten: ");
            String hoten = scanner.nextLine();
            System.out.print("Nhap dia chi: ");
            String diachi = scanner.nextLine();
            System.out.print("Nhap sdt: ");
            String sdt = scanner.nextLine();
            System.out.print("Nhap loai ban doc: ");
            String loaibandoc = scanner.nextLine();
            danhsachbandoc[bandocCount++] = new BanDoc(hoten, diachi, sdt, loaibandoc);
        }
    }

    public static void indanhsachbandoc() {
        for (int i = 0; i < bandocCount; i++) {
            System.out.println(danhsachbandoc[i]);
        }
    }

    public static void lapbangmuonsach(Scanner scanner) {
        System.out.print("Nhap ma ban doc: ");
        int mabandoc = scanner.nextInt();
        scanner.nextLine();
        BanDoc bandoc = null;
        for (int i = 0; i < bandocCount; i++) {
            if (danhsachbandoc[i].getMabandoc() == mabandoc) {
                bandoc = danhsachbandoc[i];
                break;
            }
        }
        if (bandoc == null) {
            System.out.println("Ban doc khong ton tai!");
            return;
        }

        System.out.print("Nhap so luong dau sach muon muon: ");
        int soluongdausach = scanner.nextInt();
        scanner.nextLine();
        if (soluongdausach > 5) {
            System.out.println("Khong the muon qua 5 dau sach!");
            return;
        }

        for (int i = 0; i < soluongdausach; i++) {
            System.out.print("Nhap ma sach: ");
            int masach = scanner.nextInt();
            scanner.nextLine();
            Sach sach = null;
            for (int j = 0; j < sachCount; j++) {
                if (danhsachsach[j].getMasach() == masach) {
                    sach = danhsachsach[j];
                    break;
                }
            }
            if (sach == null) {
                System.out.println("Sach khong ton tai!");
                continue;
            }

            System.out.print("Nhap so luong muon: ");
            int soluongmuon = scanner.nextInt();
            scanner.nextLine();
            if (soluongmuon > 3) {
                System.out.println("Khong the muon qua 3 cuon!");
                continue;
            }

            boolean kiemtratrungmabandoc = false;
            for (int j = 0; j < muonsachCount; j++) {
                if (danhsachmuonsach[j].getBandoc().getMabandoc() == mabandoc && danhsachmuonsach[j].getSach().getMasach() == masach) {
                    kiemtratrungmabandoc = true;
                    break;
                }
            }
            if (!kiemtratrungmabandoc) {
                boolean kiemtratrungloaibandoc = false;
                for (int j = 0; j < muonsachCount; j++) {
                    if (danhsachmuonsach[j].getBandoc().getLoaibandoc().equals(bandoc.getLoaibandoc()) && danhsachmuonsach[j].getSach().getMasach() == masach) {
                        kiemtratrungloaibandoc = true;
                        break;
                    }
                }
                if (!kiemtratrungloaibandoc) {
                    danhsachmuonsach[muonsachCount++] = new QLMuonSach(bandoc, sach, soluongmuon);
                } else {
                    System.out.println("Cung mot loai ban doc voi mot dau sach da ton tai!");
                }
            }
        }
    }

    public static void indanhsachmuonsach() {
        for (int i = 0; i < muonsachCount; i++) {
            System.out.println(danhsachmuonsach[i]);
        }
    }

    public static void sapxepmuonsachtheotenbandoc() {
        for (int i = 0; i < muonsachCount - 1; i++) {
            for (int j = i + 1; j < muonsachCount; j++) {
                if (danhsachmuonsach[i].getBandoc().getHoten().compareTo(danhsachmuonsach[j].getBandoc().getHoten()) > 0) {
                    QLMuonSach temp = danhsachmuonsach[i];
                    danhsachmuonsach[i] = danhsachmuonsach[j];
                    danhsachmuonsach[j] = temp;
                }
            }
        }
    }

    public static void sapxepmuonsachtheosoluonggiamdan() {
        for (int i = 0; i < muonsachCount - 1; i++) {
            for (int j = i + 1; j < muonsachCount; j++) {
                if (danhsachmuonsach[i].getSoluong() < danhsachmuonsach[j].getSoluong()) {
                    QLMuonSach temp = danhsachmuonsach[i];
                    danhsachmuonsach[i] = danhsachmuonsach[j];
                    danhsachmuonsach[j] = temp;
                }
            }
        }
    }

    public static void timkiemvaindsmuonsachtheotenbandoc(String ten){
        for(int i = 0; i < muonsachCount ; i++){
            if(danhsachmuonsach[i].getBandoc().getHoten().equals(ten)){
                System.out.println(danhsachmuonsach[i].getSach());
            }
        }

    }
}