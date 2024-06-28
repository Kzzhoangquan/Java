package quanlylaixe;

import java.io.Serializable;

class Tuyen implements Serializable {
    private static int idCounter = 100;
    private int matuyen;
    private double khoangcach;
    private int sodiemdung;

    public int getSodiemdung() {
        return sodiemdung;
    }

    public void setSodiemdung(int sodiemdung) {
        this.sodiemdung = sodiemdung;
    }

    public double getKhoangcach() {
        return khoangcach;
    }

    public void setKhoangcach(double khoangcach) {
        this.khoangcach = khoangcach;
    }

    public int getMatuyen() {
        return matuyen;
    }

    public void setMatuyen(int matuyen) {
        this.matuyen = matuyen;
    }

    public static int getIdCounter() {
        return idCounter;
    }

    public static void setIdCounter(int idCounter) {
        Tuyen.idCounter = idCounter;
    }

    public static void caidatId(int a){
        idCounter = a;
    }
    public Tuyen(double khoangcach, int sodiemdung) {
        this.matuyen = idCounter++;
        this.khoangcach = khoangcach;
        this.sodiemdung = sodiemdung;
    }

    @Override
    public String toString(){
        return this.matuyen + " " + this.khoangcach + " " + this.sodiemdung;
     }

}
