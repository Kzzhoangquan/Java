package CoreConcept.Array;

import java.util.Scanner;

public class bai3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap vao n : ");
        int n = sc.nextInt();
        int[] a= new int[n];
        int[] b= new int[100000];
        int phantuxhmax = 0;
        int solanxhmax = 0;
        for (int i = 0; i < b.length; i++) {
            b[i] = 0;
        }
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
            b[a[i]]++;
            if(b[a[i]]>solanxhmax){
                solanxhmax=b[a[i]];
                phantuxhmax=a[i];
            }
        }
       for(int i=0;i<n;i++){
           if(b[a[i]]!=0){
               System.out.println("Phan tu "+a[i]+" xuat hien "+b[a[i]]+" lan");
               b[a[i]] = 0;
           }
       }
        System.out.println("Phan tu xuat hien nhieu nhat la : "+phantuxhmax);

    }
}
