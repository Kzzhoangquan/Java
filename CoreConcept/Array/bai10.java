package CoreConcept.Array;

import java.util.Scanner;

public class bai10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập kích thước ma trận n
        System.out.print("Nhập số chiều của ma trận vuông (n): ");
        int n = scanner.nextInt();

        // Khởi tạo ma trận A có kích thước n x n
        int[][] A = new int[n][n];

        // Nhập các phần tử cho ma trận A từ bàn phím
        System.out.println("Nhập các phần tử của ma trận A:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                A[i][j] = scanner.nextInt();
            }
        }

        // Tính tổng đường chéo chính
        int tongduongcheochinh = 0;
        for (int i = 0; i < n; i++) {
            tongduongcheochinh += A[i][i];
        }

        // Tính tổng đường chéo phụ
        int tongduongcheophu = 0;
        for (int i = 0; i < n; i++) {
            tongduongcheophu += A[i][n - 1 - i];
        }

        // In kết quả
        System.out.println("Tổng các phần tử trên đường chéo chính: " + tongduongcheochinh);
        System.out.println("Tổng các phần tử trên đường chéo phụ: " + tongduongcheophu);


    }
}
