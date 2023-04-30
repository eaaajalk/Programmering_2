package dropoutstack;


import com.sun.source.tree.NewArrayTree;

public class StackDemo {
    public static void main(String[] args) {

        // Tester nodestack:
        NodeStack nodeStack = new NodeStack(5);
        nodeStack.push("a");
        nodeStack.push("b");
        nodeStack.push("c");
        nodeStack.push("d");
        nodeStack.push("e");


        System.out.println();
        System.out.println("Tilføjer 'f'");

        nodeStack.push("f");


        System.out.println();
        while (!nodeStack.isEmpty()) {
            System.out.println(nodeStack.pop());
        }


        // Tester arraystack
        System.out.println("Tester array drop out");
        StackI s = new ArrayStack(5);
        s.push("Tom");
        s.push("Diana");
        s.push("Harry");
        s.push("Thomas");
        s.push("Bob");

        s.push("Brian");

        System.out.println();
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }

        // Tester arrayList
        System.out.println("Tester arrayList");

        StackI sList = new ArrayListStack(5);
        sList.push("1");
        sList.push("2");
        sList.push("3");
        sList.push("4");
        sList.push("5");

        sList.push("6");

        System.out.println();
        while (!sList.isEmpty()) {
            System.out.println(sList.pop());
        }








    }
}




