package java_practice;
public class printspralmatrix {
    public static void main(String[] args) {
        printmatix(matix());
        
    }

    public static int[][] matix()
    {
        int count=0;
        int a[][]=new int[5][5];
        for(int i=0;i<5;i++)
        {
for(int j=0;j<5;j++)
{
count++;
a[i][j]=count;
}

        }
        return a;
    }

    public static void printmatix(int a[][]){
        for(int i=0;i<5;i++)
        {
for(int j=0;j<5;j++)
{

System.out.print("    "+a[i][j]+"    "); 
}
System.out.println("");

        }
        
    }
    
}
