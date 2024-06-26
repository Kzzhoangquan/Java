package quanlygiangvien;

import java.util.Scanner;

public class Main {
    private static  MonHoc[] danhsachmonhoc = new MonHoc[100];
    private static int monhocCount = 0;
    private static  GiangVien[] danhsachgiangvien = new GiangVien[100];
    private static int giangvienCount = 0;
    private static  QLGiangDay[] danhsachgiangday = new QLGiangDay[100];
    private static int giangdayCount = 0;


    static class TienCong {
        private String hoten;
        private double sotien;

        public TienCong(String hoten , double sotien){
            this.hoten = hoten;
            this.sotien = sotien;
        }
        public String getHoten() {
            return hoten;
        }

        public void setHoten(String hoten) {
            this.hoten = hoten;
        }

        public double getSotien() {
            return sotien;
        }

        public void setSotien(double sotien) {
            this.sotien = sotien;
        }

        public void themtien(double sotien){
            this.sotien += sotien;
        }
    }

    public static void nhapmonhocmoi(Scanner scanner) {
        System.out.print("Nhap so luong mon hoc muon them: ");
        int soLuong = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < soLuong; i++) {
            System.out.print("Nhap ten mon: ");
            String tenmon = scanner.nextLine();
            System.out.print("Nhap tong so tiet: ");
            int tongsotiet = scanner.nextInt();
            System.out.print("Nhap so tiet ly thuyet: ");
            int sotietlythuyet = scanner.nextInt();
            System.out.print("Nhap muc kinh phi: ");
            double muckinhphi = scanner.nextDouble();
            scanner.nextLine();
            danhsachmonhoc[monhocCount++] = new MonHoc(tenmon, tongsotiet, sotietlythuyet, muckinhphi);
        }
    }

    public static void indanhsachmonhoc() {
        for (int i = 0; i < monhocCount; i++) {
            System.out.println(danhsachmonhoc[i]);
        }
    }

    public static void nhapgiangvienmoi(Scanner scanner) {
        System.out.print("Nhap so luong giang vien muon them: ");
        int soLuong = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < soLuong; i++) {
            System.out.print("Nhap ho ten: ");
            String hoten = scanner.nextLine();
            System.out.print("Nhap dia chi: ");
            String diachi = scanner.nextLine();
            System.out.print("Nhap so dien thoai: ");
            String sdt = scanner.nextLine();
            System.out.print("Nhap trinh do: ");
            String trinhdo = scanner.nextLine();
            danhsachgiangvien[giangvienCount++] = new GiangVien(hoten, diachi, sdt, trinhdo);
        }
    }

    public static void indanhsachgiangvien() {
        for (int i = 0; i < giangvienCount; i++) {
            System.out.println(danhsachgiangvien[i]);
        }
    }

    public static void lapbangkekhaigiangday(Scanner scanner) {
        System.out.print("Nhap ma giang vien: ");
        int magv = scanner.nextInt();
        scanner.nextLine();
        GiangVien giangvien = null;
        for (int i = 0; i < giangvienCount; i++) {
            if (danhsachgiangvien[i].getMagv() == magv) {
                giangvien = danhsachgiangvien[i];
                break;
            }
        }
        if (giangvien == null) {
            System.out.println("Giang vien khong ton tai!");
            return;
        }

        System.out.print("Nhap so luong mon hoc muon giang day: ");
        int soLuongMonHoc = scanner.nextInt();
        scanner.nextLine();
        if (soLuongMonHoc > 3) {
            System.out.println("Khong the giang day qua 3 mon!");
            return;
        }

        int tongSoTiet = 0;
        for (int i = 0; i < soLuongMonHoc; i++) {
            System.out.print("Nhap ma mon hoc: ");
            int mamh = scanner.nextInt();
            scanner.nextLine();
            MonHoc monhoc = null;
            for (int j = 0; j < monhocCount; j++) {
                if (danhsachmonhoc[j].getMamh() == mamh) {
                    monhoc = danhsachmonhoc[j];
                    break;
                }
            }
            if (monhoc == null) {
                System.out.println("Mon hoc khong ton tai!");
                continue;
            }

            System.out.print("Nhap so lop giang day: ");
            int solop = scanner.nextInt();
            scanner.nextLine();
            if (solop > 3) {
                System.out.println("Khong the giang day qua 3 lop!");
                continue;
            }

            tongSoTiet += monhoc.getTongsotiet() * solop;
            if (tongSoTiet > 200) {
                System.out.println("Tong so tiet giang day vuot qua 200!");
                return;
            }

            danhsachgiangday[giangdayCount++] = new QLGiangDay(giangvien, monhoc, solop);
        }
    }

    public static void indanhsachkekhaigiangday() {
        for (int i = 0; i < giangdayCount; i++) {
            System.out.println(danhsachgiangday[i]);
        }
    }

    public static void sapxeptheohoten() {
        for (int i = 0; i < giangdayCount - 1; i++) {
            for (int j = i + 1; j < giangdayCount; j++) {
                if (danhsachgiangday[i].getGiangvien().getHoten().compareToIgnoreCase(danhsachgiangday[j].getGiangvien().getHoten()) > 0) {
                    QLGiangDay temp = danhsachgiangday[i];
                    danhsachgiangday[i] = danhsachgiangday[j];
                    danhsachgiangday[j] = temp;
                }
            }
        }
    }

    public static void sapxeptheosotietgiangday() {
        for (int i = 0; i < giangdayCount - 1; i++) {
            for (int j = i + 1; j < giangdayCount; j++) {
                if (danhsachgiangday[i].getTongsotiet() < danhsachgiangday[j].getTongsotiet()) {
                    QLGiangDay temp = danhsachgiangday[i];
                    danhsachgiangday[i] = danhsachgiangday[j];
                    danhsachgiangday[j] = temp;
                }
            }
        }
    }

    public static void tinhvantiencong() {
        TienCong[] danhsachtiencong = new TienCong[100];

        for (int i = 0; i < giangvienCount ; i++){
            TienCong res = new TienCong(danhsachgiangvien[i].getHoten(),0);
            danhsachtiencong[i] = res;
        }


        for (int i = 0; i < giangdayCount; i++) {
            double tien = danhsachgiangday[i].getTiencong();
            for(int j = 0; j < giangvienCount ; j++ )
                if(danhsachgiangday[i].getGiangvien().getHoten().equals(danhsachtiencong[j].getHoten())) {
                    danhsachtiencong[j].themtien(tien);
                    break;
                }
        }

        for(int i = 0; i < giangvienCount ; i++)
            System.out.println("Giang vien: "+danhsachtiencong[i].getHoten() +" Tien cong: "+danhsachtiencong[i].getSotien());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Nhap danh sach mon hoc moi");
            System.out.println("2. Nhap danh sach giang vien moi");
            System.out.println("3. Lap bang ke khai giang day");
            System.out.println("4. Sap xep danh sach ke khai giang day theo ho ten giang vien");
            System.out.println("5. Sap xep danh sach ke khai giang day theo so tiet giang day (giam dan)");
            System.out.println("6. Tinh va in bang ke tien cong cho moi giang vien");
            System.out.println("0. Thoat");
            System.out.print("Nhap lua chon cua ban: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (choice) {
                case 1 -> {
                    nhapmonhocmoi(scanner);
                    System.out.println("\nDanh sach mon hoc sau khi nhap:");
                    indanhsachmonhoc();
                }
                case 2 -> {
                    nhapgiangvienmoi(scanner);
                    System.out.println("\nDanh sach giang vien sau khi nhap:");
                    indanhsachgiangvien();
                }
                case 3 -> {
                    lapbangkekhaigiangday(scanner);
                    System.out.println("\nDanh sach ke khai giang day sau khi nhap:");
                    indanhsachkekhaigiangday();
                }
                case 4 -> {
                    sapxeptheohoten();
                    System.out.println("\nDanh sach ke khai giang day sau khi sap xep theo ho ten giang vien:");
                    indanhsachkekhaigiangday();
                }
                case 5 -> {
                    sapxeptheosotietgiangday();
                    System.out.println("\nDanh sach ke khai giang day sau khi sap xep theo so tiet giang day (giam dan):");
                    indanhsachkekhaigiangday();
                }
                case 6 -> tinhvantiencong();
                case 0 -> System.out.println("Thoat chuong trinh.");
                default -> System.out.println("Lua chon khong hop le.");
            }
        } while (choice != 0);
        scanner.close();
        System.exit(0);
    }
}
