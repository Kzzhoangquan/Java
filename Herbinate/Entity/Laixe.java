package Herbinate.Entity;

import javax.persistence.*;

@Entity
@Table(name = "laixe")
public class Laixe {
    @Id
    @Column(name = "malx")
    private Integer malx;

    @Column(name = "hoten")
    private String hoten;

    @Column(name = "diachi")
    private String diachi;

    @Column(name = "sodt")
    private String sodt;

    @Column(name = "trinhdo")
    private String trinhdo;

    public Integer getMalx() {
        return this.malx;
    }

    public void setMalx(Integer malx) {
        this.malx = malx;
    }

    public String getHoten() {
        return this.hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getDiachi() {
        return this.diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getSodt() {
        return this.sodt;
    }

    public void setSodt(String sodt) {
        this.sodt = sodt;
    }

    public String getTrinhdo() {
        return this.trinhdo;
    }

    public void setTrinhdo(String trinhdo) {
        this.trinhdo = trinhdo;
    }
}
