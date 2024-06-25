package CoreConcept.Basic;

import java.util.Scanner;

public class bai1b {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap vao n : ");
        int n = sc.nextInt();
        System.out.println("Tong la:" + sum(n));
    }
    public static float sum(int n) {
        float sum = 0;
        for (int i=1;i<=n;i++){
            sum+=(float) 1/i;
        }
        return sum;
    }

}
