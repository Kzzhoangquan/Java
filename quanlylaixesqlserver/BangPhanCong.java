package quanlylaixesqlserver;

public class BangPhanCong{
    private int malx;
    private int matuyen;
    private int soluot;

    private String hoten;

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public BangPhanCong(int malx, int matuyen, int soluot) {
        this.malx = malx;
        this.matuyen = matuyen;
        this.soluot = soluot;
    }

    public int getSoluot() {
        return soluot;
    }

    public void setSoluot(int soluot) {
        this.soluot = soluot;
    }

    public int getMalx() {
        return malx;
    }

    public void setMalx(int malx) {
        this.malx = malx;
    }

    public int getMatuyen() {
        return matuyen;
    }

    public void setMatuyen(int matuyen) {
        this.matuyen = matuyen;
    }

    @Override
    public String toString(){
        return this.malx + " "+this.hoten + " " + this.matuyen + " " + this.soluot;
     }
}