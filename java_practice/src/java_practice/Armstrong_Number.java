package java_practice;
import java.util.*;

public class Armstrong_Number {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("enter number for check its armstrong number or not:--");
        int number = sc.nextInt();
        if (chk_armstng(number)) {
            System.out.println("number is armstrong");

        } else {
            System.out.println("number is not armstrong");
        }

        sc.close();

    }

    static boolean chk_armstng(int n) {

        int temp = n, d, sum = 0;
        while (n > 0) {
            d = n % 10;
            sum = sum + (d * d * d);
            n = n / 10;
        }

        if (sum == temp) {
            return true;
        } else
            return false;

    }

}
