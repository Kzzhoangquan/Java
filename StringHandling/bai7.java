package StringHandling;

import java.util.Arrays;
import java.util.Scanner;

public class bai7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập xâu s1: ");
        String s1 = sc.nextLine();

        System.out.print("Nhập xâu s2: ");
        String s2 = sc.nextLine();

        int index;
        while ((index = s1.indexOf(s2)) != -1) {
            // Nếu tìm thấy s2 trong s1, loại bỏ s2 ra khỏi s1
            s1 = s1.substring(0, index) + s1.substring(index + s2.length());
        }

        // In kết quả sau khi loại bỏ
        System.out.println("Xâu s1 sau khi loại bỏ s2 là: " + s1);

        sc.close();
    }
}
