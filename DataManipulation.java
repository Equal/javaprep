import java.util.List;
import java.util.ArrayList;

public class DataManipulation {
    public static void main(String[] args) {
        List<Integer> orig = new ArrayList<Integer>();
        orig.add(1);
        orig.add(2);
        orig.add(3);
        orig.add(4);
        orig.add(5);
        System.out.println("The original list:");
        System.out.println(orig);
        System.out.println("The reversed list:");
        System.out.println(reverse(orig));
    }

    public static <T> List<T> reverse(List<T> l) {
        List<T> rev = new ArrayList<T>();
        int i = l.size() - 1;
        while (i >= 0) {
            rev.add(l.get(i));
            i--;
        }
        return rev;
    }
}
