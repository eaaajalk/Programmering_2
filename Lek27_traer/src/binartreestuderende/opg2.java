package binartreestuderende;

public class opg2 {

    public static void main(String[] args) {

        //Venstre:
        BinaryTree<Integer> r = new BinaryTree<>(25);
        BinaryTree<Integer> r1 = new BinaryTree<>(30, r, null);
        BinaryTree<Integer> r3 = new BinaryTree<>(15);
        BinaryTree<Integer> r4 = new BinaryTree<>(11, null, r3);
        BinaryTree<Integer> r5 = new BinaryTree<>(22, r4, r1);


        //Højre:
        BinaryTree<Integer> r6 = new BinaryTree<>(88);
        BinaryTree<Integer> r7 = new BinaryTree<>(90, r6, null);
        BinaryTree<Integer> r8 = new BinaryTree<>(77, null, r7);
        BinaryTree<Integer> r9 = new BinaryTree<>(45, r5, r8);



        System.out.println("Height:");
        System.out.println(r9.height());


        //    OPGAVE 3:
        //    Hej


        // Opgave 4:

        System.out.println("preOrder:");
        r9.preorder();
        System.out.println();

        System.out.println("inOrder");
        r9.inorder();
        System.out.println();

        System.out.println("postOrder:");
        r9.postorder();
        System.out.println();
        System.out.println("Sum:");
        System.out.println(r9.sum());




    }
}
