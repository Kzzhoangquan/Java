package CoreConcept.Basic;

import java.util.Scanner;

public class bai2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap vao n : ");
        int n = sc.nextInt();
        int dem = 0;
        for (int i=1;i<=n;i++){
            if(n%i==0) {
                System.out.print(i + " ");
                dem++;
            }
        }
        System.out.println();
        System.out.println("So luong uoc so:"+dem);


    }

}
