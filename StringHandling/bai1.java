package StringHandling;

import java.util.Scanner;

public class bai1 {
    public static void main(String[] args) {
        for(int i=100000;i<=999999;i++)
            if(kiemtrathuannghich(i))
                System.out.println(i);
    }
    public static boolean kiemtrathuannghich(int n){
        String str = String.valueOf(n);
        StringBuilder res = new StringBuilder(str).reverse();
        return str.equals(res.toString());
    }
}
