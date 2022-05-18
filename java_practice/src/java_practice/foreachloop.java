package java_practice;
public class foreachloop {
    public static void main(String[] args) {
    int i[];
i=new int[10];
int k=0;
for(int j=0;j<10;j++)
{
    k++;
    i[j]=k;
    
}
for(int l:i){
    if (l==5){
        break;
    }
    System.out.println(l);
}

    }
    
}
