package java_practice;
public class pattern_1array {
    

    public static void main(String[] args) {
        printarr(solution(4));
        
    }
    static int[][] solution(int A){

        int arr1[][]=new int[A][];

        for(int i=0;i<A;i++)
        {
            int temp[]=new int[i+1];
            for(int j=0;j<=i;j++)
            {
                temp[j]=j+1;

            }
            arr1[i]=temp;
        }
        return arr1;


    }

    static void printarr(int arr[][])
    {

        
        //System.out.println(arr[][]);

       for(int i=0;i<arr.length;i++)
        {
            for (int j=0;j<arr[i].length;j++){
                System.out.print(arr[i][j]+" ");
                
            }
            System.out.println();
        }
        


    }

}
