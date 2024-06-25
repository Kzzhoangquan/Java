package CoreConcept.Array;

import java.util.Scanner;

public class bai1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap vao n : ");
        int n = sc.nextInt();
        int[] a= new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        if(kiemtradoixung(a,n))
            System.out.println("Mang doi xung");
        else
            System.out.println("Mang khong doi xung");


    }
    public static boolean kiemtradoixung(int[] arr, int n) {
        for (int i = 0; i < n / 2; i++) {
            if (arr[i] != arr[n - 1 - i]) {
                return false;
            }
        }
        return true;
    }
}

