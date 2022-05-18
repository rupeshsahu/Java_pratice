package java_practice;
import java.util.*;

public class palindrome {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter number for check palindrome");
        int number = sc.nextInt();
        if(number==reversenumber(number))
            {
                System.out.println(number +" is palindrome");
            }
        else{
            System.out.println(number+" is not a palindrome");
        }
        sc.close();
        
    }

    static int reversenumber(int n)
    {
        int sum=0,r,temp;
        temp=n;
        while(temp>0)
        {
            r=temp%10;
            sum=sum*10+r;
            temp=temp/10;

        }
        return sum;
    }
}
