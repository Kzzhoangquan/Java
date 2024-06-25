package CoreConcept.Array;

import java.util.Scanner;

public class bai7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap vao n : ");
        int n = sc.nextInt();
        int[] a = new int[n];
        int dayconmax = 1;
        int phantudau = 0;
        System.out.println("Nhap mang a:");
        for(int i=0;i<n;i++)
            a[i]=sc.nextInt();
        int res = 1;
        for (int i=1; i<n; i++) {
            if(a[i]>=a[i-1]){
                res++;
                if(res > dayconmax) {
                    dayconmax = res;
                    phantudau = i - dayconmax + 1;
                }
            }
            else{
                res=1;
            }

        }
        System.out.println("Vi tri bat dau "+phantudau+" do dai "+dayconmax);



    }
}
