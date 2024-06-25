package CoreConcept.Basic;

public class bai10 {
    public static void main(String[] args) {
        for (int i = 1000000; i <=9999999; i++) {
            if (chusonguyento(i) && kiemtranguyento(i) && daonguyento(i) ) {
                System.out.println(i);
            }
        }
    }

    public static boolean kiemtranguyento(int n) {
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

    public static boolean chusonguyento(int n) {
        String str = String.valueOf(n);
        for (char c : str.toCharArray()) {
            if (c != '2' && c != '3' && c != '5' && c != '7') {
                return false;
            }
        }
        return true;
    }

    // Hàm kiểm tra tổng các chữ số chia hết cho 10
    public static boolean daonguyento(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return kiemtranguyento(sum);
    }
}
