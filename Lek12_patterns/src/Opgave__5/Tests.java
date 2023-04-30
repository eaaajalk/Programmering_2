package Opgave__5;

public class Tests {
    public static void main(String[] args) {
       ObservableBag bag = new ObservableBag();

        bag.add("Hej");
        bag.add("Hej");
        bag.add("Lol");
        bag.add("HEjsa");
        bag.remove("Hej");
        bag.add("Lol");
        for (String s : bag) {
            System.out.println(s + " = " + bag.getCount(s));
        }








    }
}
