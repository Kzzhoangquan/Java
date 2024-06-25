package CoreConcept.Array;

import java.util.Scanner;

public class bai6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap vao n : ");
        int n = sc.nextInt();
        int[] a= new int[n];
        System.out.println("Nhap vao mang a : ");
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        System.out.println("Nhap vao so x : ");
        int x = sc.nextInt();
        for(int i=0;i<n-1;i++)
            for(int j=i+1;j<n;j++)
                if(a[i] > a[j])
                {
                    int res =a [i];
                    a[i] = a[j];
                    a[j] = res;
                }

        for(int i=0;i<n-1;i++){
            if(a[i] <= x && x<=a[i+1])
                System.out.print(a[i]+" "+x+" ");
            else
                System.out.print(a[i]+" ");
        }
        if(x >= a[n-1])
            System.out.print(a[n-1]+" "+x);
        else
            System.out.print(a[n-1]);


    }
}
