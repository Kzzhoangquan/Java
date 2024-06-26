package quanlygiangvien;

public class QLGiangDay {
    private GiangVien giangvien;
    private MonHoc monhoc;
    private int solop;

    public QLGiangDay(GiangVien giangvien, MonHoc monhoc, int solop) {
        this.giangvien = giangvien;
        this.monhoc = monhoc;
        this.solop = solop;
    }

    public GiangVien getGiangvien() {
        return giangvien;
    }

    public void setGiangvien(GiangVien giangvien) {
        this.giangvien = giangvien;
    }

    public MonHoc getMonhoc() {
        return monhoc;
    }

    public void setMonhoc(MonHoc monhoc) {
        this.monhoc = monhoc;
    }

    public int getSolop() {
        return solop;
    }

    public void setSolop(int solop) {
        this.solop = solop;
    }
    public int getTongsotiet() {
        return this.monhoc.getTongsotiet() * solop;
    }

    public double getTiencong() {
        double tienlythuyet = this.monhoc.getSotietlythuyet() * this.monhoc.getMuckinhphi();
        double tienthuchanh = (this.monhoc.getTongsotiet() - this.monhoc.getSotietlythuyet()) * this.monhoc.getMuckinhphi() * 0.7;
        return (tienlythuyet + tienthuchanh) * this.solop;
    }

    public String toString() {
        return "Qlgiangday{" +
                "giangvien=" + giangvien +
                ", monhoc=" + monhoc +
                ", solop=" + solop +
                '}';
    }
}
