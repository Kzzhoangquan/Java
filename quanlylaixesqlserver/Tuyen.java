package quanlylaixesqlserver;

public class Tuyen {
    private static int idCounter = 100;
    private int matuyen;
    private float khoangcach;
    private int sodiemdung;

    public int getSodiemdung() {
        return sodiemdung;
    }

    public void setSodiemdung(int sodiemdung) {
        this.sodiemdung = sodiemdung;
    }

    public float getKhoangcach() {
        return khoangcach;
    }

    public void setKhoangcach(float khoangcach) {
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

    public static void caidatId(int a){
        idCounter = a;
    }
    public Tuyen(float khoangcach, int sodiemdung) {
        this.matuyen = idCounter++;
        this.khoangcach = khoangcach;
        this.sodiemdung = sodiemdung;
    }
    public Tuyen(int matuyen , float khoangcach, int sodiemdung) {
        this.matuyen = matuyen;
        this.khoangcach = khoangcach;
        this.sodiemdung = sodiemdung;
    }

    @Override
    public String toString(){
        return this.matuyen + " " + this.khoangcach + " " + this.sodiemdung;
    }

}

