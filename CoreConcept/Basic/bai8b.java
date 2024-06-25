package CoreConcept.Basic;

public class bai8b {
    public static void main(String[] args) {

        for (int i = 100; i <= 999; i++) {
            int res=i;
            if( (2*tongchuso((res)) % 10) == 0)
            {
                System.out.print(res);
                while(res != 0){
                    System.out.print(res % 10);
                    res /= 10;
                }
                System.out.println();

            }
        }
    }
    public static int tongchuso(int n){
        int sum=0;
        while(n > 0){
            sum+= n % 10;
            n /= 10;
        }
        return sum;
    }

}
