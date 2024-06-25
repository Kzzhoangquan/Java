package CoreConcept.Basic;

public class bai8a {
    public static void main(String[] args) {

        for (int i = 100; i <= 999; i++) {
            int res=i;
            System.out.print(res);
            while(res != 0){
                System.out.print(res % 10);
                res /= 10;
            }
            System.out.println();
        }
    }

}
