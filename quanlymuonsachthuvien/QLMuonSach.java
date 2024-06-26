package quanlymuonsachthuvien;

public class QLMuonSach {
    private BanDoc bandoc;
    private Sach sach;
    private int soluong;

    public QLMuonSach(BanDoc bandoc, Sach sach, int soluong) {
        this.bandoc = bandoc;
        this.sach = sach;
        this.soluong = soluong;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public BanDoc getBandoc() {
        return bandoc;
    }

    public void setBandoc(BanDoc bandoc) {
        this.bandoc = bandoc;
    }

    public Sach getSach() {
        return sach;
    }

    public void setSach(Sach sach) {
        this.sach = sach;
    }
    @Override
    public String toString() {
        return "QLMuonsach{" +
                "bandoc=" + bandoc +
                ", sach=" + sach +
                ", soluong=" + soluong +
                '}';
    }
}
