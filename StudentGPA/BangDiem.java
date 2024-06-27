package StudentGPA;

import java.io.Serializable;

public class BangDiem implements Serializable {
    private SinhVien sinhvien;
    private MonHoc monhoc;
    private float diem;

    public BangDiem(SinhVien sinhvien, MonHoc monhoc, float diem) {
        this.sinhvien = sinhvien;
        this.monhoc = monhoc;
        this.diem = diem;
    }

    public float getDiem() {
        return diem;
    }

    public void setDiem(float diem) {
        this.diem = diem;
    }

    public MonHoc getMonhoc() {
        return monhoc;
    }

    public void setMonhoc(MonHoc monhoc) {
        this.monhoc = monhoc;
    }

    public SinhVien getSinhvien() {
        return sinhvien;
    }

    public void setSinhvien(SinhVien sinhvien) {
        this.sinhvien = sinhvien;
    }

    public void hienThiThongTin() {
        System.out.println("Sinh Vien: " + sinhvien.getHoten() + ", Mon Hoc: " + monhoc.getTenmon() + ", Diem: " + diem);
    }
}
