package StringHandling;

import java.util.Arrays;
import java.util.Scanner;

public class bai6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập vào một câu không quá 20 từ: ");
        String sentence = sc.nextLine().trim(); // Đọc và loại bỏ khoảng trắng không cần thiết

        // Tách câu thành các từ dựa trên khoảng trắng
        String[] words = sentence.split("\\s+");

        // Sắp xếp các từ theo thứ tự alphabet
        Arrays.sort(words);

        // In ra các từ đã sắp xếp
        System.out.println("Các từ theo thứ tự alphabet:");
        for (String word : words) {
            System.out.println(word);
        }

        sc.close();
    }
}
