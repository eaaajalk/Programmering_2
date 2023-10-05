package rekursion;

public class Main {
    public static void main(String[] args) {
        System.out.println(reverse("hello"));
    }

    public static String reverse(String s) {
        return reverseHelper(s, s.length() - 1);
    }
    private static String reverseHelper(String s, int index) {
        if (index == 0) {
            return String.valueOf(s.charAt(0));
        } else {
            return s.charAt(index) + reverseHelper(s, index - 1);
        }
    }



}
