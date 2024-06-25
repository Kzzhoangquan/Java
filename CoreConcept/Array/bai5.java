package CoreConcept.Array;

import java.util.Scanner;

public class bai5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap vao n : ");
        int n = sc.nextInt();
        int[] a= new int[n];
        System.out.println("Nhap mang a:");
        for(int i=0;i<n;i++)
            a[i]=sc.nextInt();
        System.out.println("Nhap vao m : ");
        int m = sc.nextInt();
        int[] b= new int[m];
        System.out.println("Nhap mang b:");
        for(int i=0;i<m;i++)
            b[i]=sc.nextInt();
        System.out.println("Nhap so p: ");
        int p = sc.nextInt();
        for(int i=0;i<p;i++)
            System.out.print(a[i]+" ");
        for(int i=0;i<m;i++)
            System.out.print(b[i]+" ");
        for(int i=p;i<n;i++)
            System.out.print(a[i]+" ");

    }
}
