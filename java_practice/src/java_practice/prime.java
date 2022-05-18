package java_practice;
public class prime {
    public static void main(String[] args) {
        for(int i=1;i<100;i++)
        {
            
            if (isprime(i)){
                System.out.println(i);
            }

        
        }
    }
    

    static boolean isprime(int n)
    {
        int m=n/2;
        int flag=0;
        if(n==1 || n==2){
            //System.out.println(n+" is prime number");
            return true;
        }
        for (int i=2;i<=m;i++)
        {
            if(n%i==0)
            {

flag++;
            }

        }

        if (flag==0){
            //System.out.println(n+" is a prime number");
            return true;
        }
        else
{//System.out.println(n+" is not a prime number");
    return false;
}
    }
    
}

