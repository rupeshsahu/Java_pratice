package java_practice;
public class do_while {
    public static void main(String[] args) {
        int i = 0;
        do {
            i++;
            System.out.println(i);

            if (i == 5) {
                System.out.println("I am breaking loop here" + i);
                break;

            }
            continue;

        } while (i < 10);

    }

}
