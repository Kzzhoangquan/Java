package StringHandling;

import java.util.Scanner;

public class bai5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] a = sc.nextLine().split("\\s+");
        String res = a[a.length-1] + " " + a[0] + " ";
        for(int i = a.length-2; i > 0 ; i--){
            res = res + a[i] + " ";
        }
        System.out.println(res);

    }
}
