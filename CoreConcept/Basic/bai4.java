package CoreConcept.Basic;

import java.util.Scanner;

public class bai4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap vao 2 so : ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        for(int i=a;i<b;i++)
            for(int j=i+1;j<=b;j++)
                if(UCLN(i,j)==1)
                    System.out.println(i+" "+j);

    }
    public static int UCLN(int a , int b) {
        if (b == 0)
            return a;
        return UCLN(b, a%b);
    }
}
