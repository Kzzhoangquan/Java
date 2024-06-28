package quanlylaixe;

import java.io.Serializable;

class BangPhanCong implements Serializable {
    private LaiXe laixe;
    private Tuyen tuyen;
    private int soluot;

    public BangPhanCong(LaiXe laixe, Tuyen tuyen, int soluot) {
        this.laixe = laixe;
        this.tuyen = tuyen;
        this.soluot = soluot;
    }

    public LaiXe getLaixe() {
        return laixe;
    }

    public void setLaixe(LaiXe laixe) {
        this.laixe = laixe;
    }

    public int getSoluot() {
        return soluot;
    }

    public void setSoluot(int soluot) {
        this.soluot = soluot;
    }

    public Tuyen getTuyen() {
        return tuyen;
    }

    public void setTuyen(Tuyen tuyen) {
        this.tuyen = tuyen;
    }

    @Override
    public String toString(){
        return this.laixe + " " + this.tuyen + " " + this.soluot;
    }
}
