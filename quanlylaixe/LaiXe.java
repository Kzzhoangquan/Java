package quanlylaixe;

import java.io.Serializable;

class LaiXe implements Serializable {
    private static int idCounter = 10000;
    private int malx;
    private String hoten;
    private String diachi;
    private String sodt;
    private String trinhdo;

    public LaiXe(String hoten, String diachi, String sodt, String trinhdo) {
        this.malx = idCounter++;
        this.hoten = hoten;
        this.diachi = diachi;
        this.sodt = sodt;
        this.trinhdo = trinhdo;
    }

    public String getTrinhdo() {
        return trinhdo;
    }

    public void setTrinhdo(String trinhdo) {
        this.trinhdo = trinhdo;
    }

    public String getSodt() {
        return sodt;
    }

    public void setSodt(String sodt) {
        this.sodt = sodt;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public int getMalx() {
        return malx;
    }

    public void setMalx(int malx) {
        this.malx = malx;
    }

    public static int getIdCounter() {
        return idCounter;
    }

    public static void setIdCounter(int idCounter) {
        LaiXe.idCounter = idCounter;
    }

    public static void caidatId(int a){
        idCounter = a;
    }
    @Override
    public String toString(){
        return this.malx + " " + this.hoten + " " + this.diachi + " " + this.sodt + " " + this.trinhdo;
     }
}