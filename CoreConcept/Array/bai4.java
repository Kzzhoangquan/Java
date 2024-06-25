package CoreConcept.Array;

import java.util.Scanner;

public class bai4 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap vao n : ");
        int n = sc.nextInt();
        int[] a= new int[n];
        int phantunt = 0;
        int khoangcach = 0;
        System.out.println("Nhap mang:");
        for(int i=0;i<n;i++)
            a[i]=sc.nextInt();
        System.out.println("Nhap so X: ");
        int x = sc.nextInt();
        khoangcach = x;
        for(int i=0;i<n;i++){
            if(kiemtraguyento(a[i])){
                if(Math.abs(x-a[i])<khoangcach){
                    phantunt = a[i];
                    khoangcach = Math.abs(x-a[i]);
                }

            }
        }
        System.out.println("Phan tu can tim la: "+phantunt);




    }

    public static boolean kiemtraguyento(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
