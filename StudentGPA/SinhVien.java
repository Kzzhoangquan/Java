package StudentGPA;

import java.io.Serializable;

public class SinhVien implements Serializable {
     private static int idCounter = 10000;
     private int masv;
     private String hoten;
     private String diachi;
     private String sodt;
     private String lop;

     public SinhVien(String hoten, String diachi, String sodt, String lop) {
         this.masv = idCounter++;
         this.hoten = hoten;
         this.diachi = diachi;
         this.sodt = sodt;
         this.lop = lop;
     }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public String getSodt() {
        return sodt;
    }

    public void setSodt(String sodt) {
        this.sodt = sodt;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public int getMasv() {
        return masv;
    }

    public void setMasv(int masv) {
        this.masv = masv;
    }

    public static int getIdCounter() {
        return idCounter;
    }

    public static void setIdCounter(int idCounter) {
        SinhVien.idCounter = idCounter;
    }

    @Override
    public String toString(){
         return this.masv +" "+this.hoten + " " + this.diachi + " " + this.sodt + " " + this.lop;
    }
}