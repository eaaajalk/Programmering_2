package hashsetstudent;

public class main {

    public static void main(String[] args) {
        String h = "Harry";

        int x = h.hashCode() % 13;
        System.out.println(x);
    }
}
