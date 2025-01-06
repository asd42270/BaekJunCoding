import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int big = 0;
        int small = 0;

        int sum = 0;

        for(int i = 0; i<10; i++) {
           int number = sc.nextInt();
           sum+=number;

           if (sum < 100) {
               small = 100-sum;
           } else if (sum > 100) {
               big = sum-100;

               if (small < big) {
                   System.out.println(sum-number);
                   break;
               }else {
                   System.out.println(sum);
                   break;
               }
           } else {
               System.out.println(100);
               break;
           }

           if ( i == 9 && big == 0) {
               System.out.println(sum);
           }
        }

    }
}