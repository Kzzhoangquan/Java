package CoreConcept.Array;

import java.util.Scanner;

public class bai9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập số hàng và cột của ma trận A
        System.out.print("Nhập số hàng của ma trận A: ");
        int n = scanner.nextInt();
        System.out.print("Nhập số cột của ma trận A: ");
        int m = scanner.nextInt();

        // Khởi tạo và nhập ma trận A từ bàn phím
        int[][] A = new int[n][m];
        int[] a = new int[n*m];
        int res=0;
        System.out.println("Nhập các phần tử của ma trận A:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                A[i][j] = scanner.nextInt();
                a[res]=A[i][j];
                res++;
            }
        }
        for(int i=0;i<n*m-1;i++)
            for(int j=i+1;j<n*m;j++)
                if(a[i] > a[j])
                {
                    int res1 =a [i];
                    a[i] = a[j];
                    a[j] = res1;
                }
        for(int i=0;i<n*m-1;i=i+m){
            for(int j=i;j<i+m;j++)
                System.out.print(a[j]+" ");
            System.out.println();
        }

    }
}
