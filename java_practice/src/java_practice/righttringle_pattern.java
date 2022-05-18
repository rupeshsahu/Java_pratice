package java_practice;
public class righttringle_pattern {
    public static void main(String[] args) throws InterruptedException {
        for(int i=0;i<=4;i++)
        {
            for(int j=4;j>=i;j--)
            {
                System.out.print(" ");
                Thread.sleep(100);
            }
            //System.out.print(" *");
               // Thread.sleep(100);

            for(int k=0;k<=i;k++)
            {
                System.out.print("*");
                Thread.sleep(100);
            }
            //System.out.print(" *");
               // Thread.sleep(100);
            System.out.println("\n");
        }
        
    }
    
}
