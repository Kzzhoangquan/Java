package CoreConcept.Basic;

public class bai7 {
    public static void main(String[] args) {
        // Duyệt qua tất cả các số có 6 chữ số lẻ từ 100001 đến 999999
        for (int i = 100001; i <= 999999; i += 2) {
            if (songuyento(i) && kiemtrasole(i)) {
                System.out.println(i);
            }
        }
    }

    // Hàm kiểm tra số nguyên tố
    public static boolean songuyento(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Hàm kiểm tra xem tất cả các chữ số của số n có phải là chữ số lẻ hay không
    public static boolean kiemtrasole(int n) {
        while (n > 0) {
            int digit = n % 10;
            if (digit % 2 == 0) { // Nếu gặp chữ số chẵn
                return false;
            }
            n /= 10;
        }
        return true;
    }
}
