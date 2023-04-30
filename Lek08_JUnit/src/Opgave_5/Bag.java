package Opgave_5;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Bag implements BagInterface {

    private Map<String, Integer> map = new HashMap<>();

    @Override
    public void add(String s) {
        if (!map.containsKey(s)) {
            map.put(s, 1);
        } else {
            int i = map.get(s);
            map.put(s, i + 1);
        }
    }

    @Override
    public void remove(String s) {
        int i = map.get(s);
        if (i > 1) {
            map.put(s, i - 1);
        } else if (i == 1) {
            map.remove(s, 1);
        }
    }

    @Override
    public int getCount(String s) {
        if (map.get(s) == null) {
            return 0;
        } else {
            return map.get(s);
        }
    }

    @Override
    public Iterator<String> iterator() {
        return new Bag().iterator();
    }

    public static void main(String[] args) {
        BagInterface bagInterface = new Bag();
        bagInterface.add("hej");
        bagInterface.add("hej");
        bagInterface.add("lol");
        bagInterface.add("hej");
        System.out.println(bagInterface.getCount("hej"));
        bagInterface.remove("hej");
        System.out.println(bagInterface.getCount("hej"));


    }
}
