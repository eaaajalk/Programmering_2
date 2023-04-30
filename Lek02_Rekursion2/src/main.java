import java.util.HashMap;
import java.util.TreeMap;

public class main {

    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();

        map.put(2, "Hej");
        map.put(1, "Yo");
        map.put(3, "HEst");

        TreeMap<Integer, String> tree = new TreeMap<>();
        tree.put(2, "Hej");
        tree.put(1, "Yo");
        tree.put(3, "HEst");

        System.out.println(map.toString());

        System.out.println(tree.toString());
    }
}
