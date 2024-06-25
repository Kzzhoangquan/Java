package CoreConcept.Basic;

import java.util.Scanner;

public class bai6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap vao so nguyen : ");
        int a = sc.nextInt();
        int[] b= new int[100000];
        int res=2;
        int dem =0;
        while(a != 1 && a >= res)
        {
            while(a % res == 0)
            {
                a/=res;
                dem++;
                b[dem]=res;
            }
            res++;
        }
        for(int i=1;i<dem;i++)
            System.out.print(b[i]+"x");
        System.out.print(b[dem]);


    }
}
