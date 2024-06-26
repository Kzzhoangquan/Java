package StringHandling;

import java.util.Scanner;

public class bai4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập vào một xâu ký tự: ");
        String input = sc.nextLine().trim(); // Đọc và loại bỏ khoảng trắng ở đầu và cuối xâu

        // Tách xâu thành các từ dựa trên khoảng trắng
        String[] words = input.split("\\s+");

        // Biến lưu từ dài nhất và vị trí đầu tiên của từ đó
        String longestWord = "";
        int position = -1;

        // Duyệt qua từng từ để tìm từ dài nhất và vị trí của từ đó
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > longestWord.length()) {
                longestWord = words[i];
                position = input.indexOf(longestWord);
            }
        }

        // Xuất kết quả
        if (position != -1) {
            System.out.println("Từ dài nhất trong xâu là: " + longestWord);
            System.out.println("Nằm ở vị trí: " + (position + 1));
        } else {
            System.out.println("Không có từ nào trong xâu.");
        }

        sc.close();
    }
}
