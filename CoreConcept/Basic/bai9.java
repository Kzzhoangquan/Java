package CoreConcept.Basic;

public class bai9 {
    public static void main(String[] args) {
        for (int i = 1000000; i < 1000000000; i++) {
            if (tongchiahetcho10(i) && sothuannghich(i) && chigom068(i) ) {
                System.out.println(i);
            }
        }
    }

    // Hàm kiểm tra số thuận nghịch
    public static boolean sothuannghich(int n) {
        String str = String.valueOf(n);
        String reversedStr = new StringBuilder(str).reverse().toString();
        return str.equals(reversedStr);
    }

    // Hàm kiểm tra chỉ bao gồm các chữ số 0, 6, 8
    public static boolean chigom068(int n) {
        String str = String.valueOf(n);
        for (char c : str.toCharArray()) {
            if (c != '0' && c != '6' && c != '8') {
                return false;
            }
        }
        return true;
    }

    // Hàm kiểm tra tổng các chữ số chia hết cho 10
    public static boolean tongchiahetcho10(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum % 10 == 0;
    }
}
