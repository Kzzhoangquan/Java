package quanlylaixesqlserver;



import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MainDao {
    private static final String url = "jdbc:sqlserver://LAPTOP-FF387IJ3\\HOANGQUAN:1433;databaseName=ttjava;trustServerCertificate=true";

    private static final String user = "sa";
    private static final String password = "123";

    public static void main(String[] args) {


    }
    public static ArrayList<LaiXe> laydanhsachlaixe() {
        ArrayList<LaiXe> dslx = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String sql = "SELECT * FROM LaiXe";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {

                    int malx = resultSet.getInt("malx");
                    String hoten = resultSet.getString("hoten");
                    String diachi = resultSet.getString("diachi");
                    String sdt = resultSet.getString("sodt");
                    String trinhdo = resultSet.getString("trinhdo");
                    LaiXe res= new LaiXe(malx,hoten,diachi,sdt,trinhdo);
                    dslx.add(res);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dslx;
    }

    public static ArrayList<Tuyen> laydanhsachtuyen() {
        ArrayList<Tuyen> dstuyen = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String sql = "SELECT * FROM Tuyen";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {

                    int matuyen = resultSet.getInt("matuyen");
                    float khoangcach = resultSet.getFloat("khoangcach");
                    int sodiemdung = resultSet.getInt("sodiemdung");
                    Tuyen tuyen = new Tuyen(matuyen, khoangcach, sodiemdung);
                    dstuyen.add(tuyen);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dstuyen;
    }

    public static void luulaixe(LaiXe laixe) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String sql = "INSERT INTO LaiXe (malx, hoten, diachi, sodt, trinhdo) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, laixe.getMalx());
                statement.setString(2, laixe.getHoten());
                statement.setString(3, laixe.getDiachi());
                statement.setString(4, laixe.getSodt());
                statement.setString(5, laixe.getTrinhdo());

                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("Đã lưu thông tin lái xe thành công.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void luutuyen(Tuyen tuyen) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String sql = "INSERT INTO Tuyen (matuyen, khoangcach, sodiemdung) VALUES (?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, tuyen.getMatuyen());
                statement.setFloat(2, (float) tuyen.getKhoangcach()); // sử dụng setFloat với kiểu FLOAT trong SQL Server
                statement.setInt(3, tuyen.getSodiemdung());

                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("Đã lưu thông tin tuyến thành công.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static ArrayList<BangPhanCong> laydanhsachphancong() {
        ArrayList<BangPhanCong> dsphancong = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String sql = "SELECT * FROM BangPhanCong";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    int malx = resultSet.getInt("malx");
                    int matuyen = resultSet.getInt("matuyen");
                    int soluot = resultSet.getInt("soluot");

                    BangPhanCong phancong = new BangPhanCong(malx, matuyen, soluot);
                    dsphancong.add(phancong);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dsphancong;
    }

    public static void luuBangPhanCong(BangPhanCong bangPhanCong) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String sql = "INSERT INTO BangPhanCong (malx, matuyen, soluot) VALUES (?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, bangPhanCong.getMalx());
                statement.setInt(2, bangPhanCong.getMatuyen());
                statement.setInt(3, bangPhanCong.getSoluot());

                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("Đã lưu thông tin bảng phân công thành công.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}

