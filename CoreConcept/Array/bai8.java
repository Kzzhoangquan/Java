package CoreConcept.Array;

import java.util.Scanner;

public class bai8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập số hàng và cột của ma trận A
        System.out.print("Nhập số hàng của ma trận A: ");
        int m1 = scanner.nextInt();
        System.out.print("Nhập số cột của ma trận A: ");
        int n1 = scanner.nextInt();

        // Khởi tạo và nhập ma trận A từ bàn phím
        int[][] A = new int[m1][n1];
        System.out.println("Nhập các phần tử của ma trận A:");
        for (int i = 0; i < m1; i++) {
            for (int j = 0; j < n1; j++) {
                A[i][j] = scanner.nextInt();
            }
        }

        // Nhập số hàng và cột của ma trận B
        System.out.print("Nhập số hàng của ma trận B: ");
        int m2 = scanner.nextInt();
        System.out.print("Nhập số cột của ma trận B: ");
        int n2 = scanner.nextInt();

        // Kiểm tra nếu số cột của A khác số hàng của B, không thể nhân ma trận
        if (n1 != m2) {
            System.out.println("Không thể nhân hai ma trận này với nhau.");
            return;
        }

        // Khởi tạo và nhập ma trận B từ bàn phím
        int[][] B = new int[m2][n2];
        System.out.println("Nhập các phần tử của ma trận B:");
        for (int i = 0; i < m2; i++) {
            for (int j = 0; j < n2; j++) {
                B[i][j] = scanner.nextInt();
            }
        }

        // Khởi tạo ma trận kết quả C có kích thước m1 x n2
        int[][] C = new int[m1][n2];

        // Tính tích của hai ma trận A và B
        for (int i = 0; i < m1; i++) {
            for (int j = 0; j < n2; j++) {
                for (int p = 0; p < n1; p++) {
                    C[i][j] += A[i][p] * B[p][j];
                }
            }
        }

        // In ra ma trận kết quả C
        System.out.println("Ma trận kết quả C = ");
        for (int i = 0; i < m1; i++) {
            for (int j = 0; j < n2; j++) {
                System.out.print(C[i][j] + " ");
            }
            System.out.println();
        }


    }
}

