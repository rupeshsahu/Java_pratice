package java_practice;
public class fibonacci_series {
    static int count = 0;

    public static void main(String[] args) {
        int i = 0, j = 1;
        System.out.print(i + "\n" + j + "\n");
        feb(i, j);

    }

    static void feb(int a, int b) {
        int k = a + b;
        if (count == 70) {
            System.exit(0);
        }
        System.out.println(k);
        a = b;
        b = k;
        count++;
        feb(a, b);
    }

}
