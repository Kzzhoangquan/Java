package quanlygiangvien;

public class MonHoc {
    private static int idCounter = 100;
    private int mamh;
    private String tenmon;
    private int tongsotiet;
    private int sotietlythuyet;
    private double muckinhphi;

    public MonHoc(String tenmon, int tongsotiet, int sotietlythuyet, double muckinhphi) {
        this.mamh = idCounter++;
        this.tenmon = tenmon;
        this.tongsotiet = tongsotiet;
        this.sotietlythuyet = sotietlythuyet;
        this.muckinhphi = muckinhphi;
    }

    public double getMuckinhphi() {
        return muckinhphi;
    }

    public void setMuckinhphi(double muckinhphi) {
        this.muckinhphi = muckinhphi;
    }

    public int getSotietlythuyet() {
        return sotietlythuyet;
    }

    public void setSotietlythuyet(int sotietlythuyet) {
        this.sotietlythuyet = sotietlythuyet;
    }

    public int getTongsotiet() {
        return tongsotiet;
    }

    public void setTongsotiet(int tongsotiet) {
        this.tongsotiet = tongsotiet;
    }

    public String getTenmon() {
        return tenmon;
    }

    public void setTenmon(String tenmon) {
        this.tenmon = tenmon;
    }

    public int getMamh() {
        return mamh;
    }

    public void setMamh(int mamh) {
        this.mamh = mamh;
    }

    public static int getIdCounter() {
        return idCounter;
    }

    public static void setIdCounter(int idCounter) {
        MonHoc.idCounter = idCounter;
    }
    @Override
    public String toString() {
        return "Monhoc{" +
                "mamh=" + mamh +
                ", tenmon='" + tenmon + '\'' +
                ", tongsotiet=" + tongsotiet +
                ", sotietlythuyet=" + sotietlythuyet +
                ", muckinhphi=" + muckinhphi +
                '}';
    }
}
