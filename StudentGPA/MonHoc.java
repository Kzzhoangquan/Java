package StudentGPA;

import java.io.Serializable;

class MonHoc implements Serializable {
    private static int idCounter = 100;
    private int mamon;
    private String tenmon;
    private int sodonvihoctrinh;
    private String loaimon;

    public MonHoc(String tenmon, int sodonvihoctrinh, String loaimon) {
        this.mamon = idCounter++;
        this.tenmon = tenmon;
        this.sodonvihoctrinh = sodonvihoctrinh;
        this.loaimon = loaimon;
    }

    public String getTenmon() {
        return tenmon;
    }

    public void setTenmon(String tenmon) {
        this.tenmon = tenmon;
    }

    public static int getIdCounter() {
        return idCounter;
    }

    public static void setIdCounter(int idCounter) {
        MonHoc.idCounter = idCounter;
    }

    public String getLoaimon() {
        return loaimon;
    }

    public void setLoaimon(String loaimon) {
        this.loaimon = loaimon;
    }

    public int getSodonvihoctrinh() {
        return sodonvihoctrinh;
    }

    public void setSodonvihoctrinh(int sodonvihoctrinh) {
        this.sodonvihoctrinh = sodonvihoctrinh;
    }

    public int getMamon() {
        return mamon;
    }

    public void setMamon(int mamon) {
        this.mamon = mamon;
    }

    @Override
    public String toString(){
        return this.mamon + " " + this.tenmon + " " + this.sodonvihoctrinh + " " + this.loaimon;
    }
}
