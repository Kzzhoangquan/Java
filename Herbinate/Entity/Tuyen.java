package Herbinate.Entity;

import javax.persistence.*;

@Entity
@Table(name = "tuyen")
public class Tuyen {
    @Id
    @Column(name = "matuyen")
    private Integer matuyen;

    @Column(name = "khoangcach")
    private Double khoangcach;

    @Column(name = "sodiemdung")
    private Integer sodiemdung;

    public Integer getMatuyen() {
        return this.matuyen;
    }

    public void setMatuyen(Integer matuyen) {
        this.matuyen = matuyen;
    }

    public Double getKhoangcach() {
        return this.khoangcach;
    }

    public void setKhoangcach(Double khoangcach) {
        this.khoangcach = khoangcach;
    }

    public Integer getSodiemdung() {
        return this.sodiemdung;
    }

    public void setSodiemdung(Integer sodiemdung) {
        this.sodiemdung = sodiemdung;
    }
}
