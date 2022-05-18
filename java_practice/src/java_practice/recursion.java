package java_practice;
public class recursion {

    public static void main(String[] args) {
        
System.out.println(recursion1(4));
    }
    int i=0;
    static int recursion1(int i){
        if(i<=0)
        return 1;
        return i*recursion1(i-1);
    }
    
}
