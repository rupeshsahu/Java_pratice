package java_practice;
public class excel_column {
    public static void main(String[] args) {
        System.out.println(solve(25));
        // System.out.println(1/27);

    }

    public static String solve(int A) {
        String str = "";
        while (A > 0) {
            if (A == 26) {
                str = ((char) (64 + A)) + str;
            } else {
                str = (char) (65 + (A % 26)) + str;
            }
            A = A / 26;

        }
        return str;

    }
}
