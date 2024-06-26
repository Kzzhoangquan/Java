package StringHandling;

import java.util.Scanner;

public class bai3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] a = sc.nextLine().split("\\s+");
        String res = "";
        for(String i : a){
            res = res+Character.toUpperCase(i.charAt(0))+i.substring(1).toLowerCase()+" ";
        }
        System.out.println(res);

    }
}
