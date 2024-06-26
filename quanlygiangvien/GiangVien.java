package quanlygiangvien;

public class GiangVien {
        private static int idCounter = 100;
        private int magv;
        private String hoten;
        private String diachi;
        private String sdt;
        private String trinhdo;

        public GiangVien(String hoten, String diachi, String sdt, String trinhdo) {
            this.magv = idCounter++;
            this.hoten = hoten;
            this.diachi = diachi;
            this.sdt = sdt;
            this.trinhdo = trinhdo;
        }

    public static int getIdCounter() {
        return idCounter;
    }

    public static void setIdCounter(int idCounter) {
        GiangVien.idCounter = idCounter;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public int getMagv() {
        return magv;
    }

    public void setMagv(int magv) {
        this.magv = magv;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getTrinhdo() {
        return trinhdo;
    }

    public void setTrinhdo(String trinhdo) {
        this.trinhdo = trinhdo;
    }

    @Override
    public String toString() {
        return "Giangvien{" +
                "magv=" + magv +
                ", hoten='" + hoten + '\'' +
                ", diachi='" + diachi + '\'' +
                ", sdt='" + sdt + '\'' +
                ", trinhdo='" + trinhdo + '\'' +
                '}';
    }
}
