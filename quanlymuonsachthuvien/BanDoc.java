package quanlymuonsachthuvien;

// Định nghĩa lớp Bạn đọc
public class BanDoc {
    // Các thuộc tính của lớp
    private static int idCounter = 10000;
    private int mabandoc;
    private String hoten;
    private String diachi;
    private String sdt;
    private String loaibandoc;

    public BanDoc(String hoten, String diachi, String sdt, String loaibandoc) {
        this.mabandoc = idCounter++;
        this.hoten = hoten;
        this.diachi = diachi;
        this.sdt = sdt;
        this.loaibandoc = loaibandoc;
    }

    // Phương thức để in thông tin bạn đọc


    public int getMabandoc() {
        return mabandoc;
    }

    public void setMabandoc(int mabandoc) {
        this.mabandoc = mabandoc;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
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

    public String getLoaibandoc() {
        return loaibandoc;
    }

    public void setLoaibandoc(String loaibandoc) {
        this.loaibandoc = loaibandoc;
    }

    @Override
    public String toString() {
        return "Bandoc{" +
                "mabandoc=" + mabandoc +
                ", hoten='" + hoten + '\'' +
                ", diachi='" + diachi + '\'' +
                ", sdt='" + sdt + '\'' +
                ", loaibandoc='" + loaibandoc + '\'' +
                '}';
    }

}

