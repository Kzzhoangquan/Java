package CoreConcept.Basic;

import java.util.Scanner;

public class bai5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap vao so nguyen : ");
        String a = sc.next();
        System.out.println("Tong cac chu so la: "+sum(a));

    }
    public static int sum(String a){
        int tong = 0;
        for(int i=0;i<a.length();i++)
        {
            int res= a.charAt(i)-48;
            tong+=res;
        }
        return tong;
    }
}
