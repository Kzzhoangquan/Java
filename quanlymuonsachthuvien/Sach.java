package quanlymuonsachthuvien;

public class Sach {
    private static int idCounter = 10000;
    private int masach;
    private String tensach;
    private String tacgia;
    private String chuyennganh;
    private int namxuatban;

    public Sach(String tensach, String tacgia, String chuyennganh, int namxuatban) {
        this.masach = idCounter++;
        this.tensach = tensach;
        this.tacgia = tacgia;
        this.chuyennganh = chuyennganh;
        this.namxuatban = namxuatban;
    }

    public String getChuyennganh() {
        return chuyennganh;
    }

    public void setChuyennganh(String chuyennganh) {
        this.chuyennganh = chuyennganh;
    }

    public String getTacgia() {
        return tacgia;
    }

    public void setTacgia(String tacgia) {
        this.tacgia = tacgia;
    }

    public String getTensach() {
        return tensach;
    }

    public void setTensach(String tensach) {
        this.tensach = tensach;
    }

    public int getMasach() {
        return masach;
    }

    public void setMasach(int masach) {
        this.masach = masach;
    }

    public static int getIdCounter() {
        return idCounter;
    }

    public static void setIdCounter(int idCounter) {
        Sach.idCounter = idCounter;
    }

    public int getNamxuatban() {
        return namxuatban;
    }

    public void setNamxuatban(int namxuatban) {
        this.namxuatban = namxuatban;
    }

    @Override
    public String toString() {
        return "Sach{" +
                "masach=" + masach +
                ", tensach='" + tensach + '\'' +
                ", tacgia='" + tacgia + '\'' +
                ", chuyennganh='" + chuyennganh + '\'' +
                ", namxuatban=" + namxuatban +
                '}';
    }

}
