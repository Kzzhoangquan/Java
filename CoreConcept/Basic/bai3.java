package CoreConcept.Basic;

import java.util.Scanner;

public class bai3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap vao so thu nhat : ");
        int a = sc.nextInt();
        System.out.println("Nhap vao so thu hai : ");
        int b = sc.nextInt();
        System.out.println("UCLN la: " + UCLN(a,b));
        System.out.println("BCNN la: " + ((a*b)/UCLN(a,b)));

    }
    public static int UCLN(int a , int b) {
            if (b == 0)
                return a;
            return UCLN(b, a%b);
    }

}

