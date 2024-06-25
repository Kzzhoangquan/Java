package CoreConcept.Basic;

import java.util.Scanner;

public class bai1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap vao n : ");
        int n = sc.nextInt();
        System.out.println("Tong la:" + sum(n));
    }
    public static int sum(int n) {
        if (n % 2 == 0){
            return ((n+2)*((n-2)/2+1))/2;
        }
        else{
            return ((n+1)*((n-1)/2+1))/2;
        }
    }

}