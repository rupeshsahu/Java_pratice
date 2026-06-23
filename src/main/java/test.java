import java.util.HashSet;

public class test {
    public static void main(String[] args) {
        HashSet seen=new HashSet<>();
        seen.add('a');
        System.out.println(seen.add('a'));
        System.out.println(seen.add('b'));

    }
}
