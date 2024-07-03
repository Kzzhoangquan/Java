package Herbinate.Entity;

import javax.persistence.*;

@Entity
@Table(name = "bangphancong")
public class Bangphancong {
    @Id
    @Column(name = "idbangphancong")
    private Integer idbangphancong;

    @Column(name = "malx")
    private Integer malx;

    @Column(name = "matuyen")
    private Integer matuyen;

    @Column(name = "soluot")
    private Integer soluot;

    public Integer getIdbangphancong() {
        return this.idbangphancong;
    }

    public void setIdbangphancong(Integer idbangphancong) {
        this.idbangphancong = idbangphancong;
    }

    public Integer getMalx() {
        return this.malx;
    }

    public void setMalx(Integer malx) {
        this.malx = malx;
    }

    public Integer getMatuyen() {
        return this.matuyen;
    }

    public void setMatuyen(Integer matuyen) {
        this.matuyen = matuyen;
    }

    public Integer getSoluot() {
        return this.soluot;
    }

    public void setSoluot(Integer soluot) {
        this.soluot = soluot;
    }
}
