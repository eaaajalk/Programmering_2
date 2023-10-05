package hovedspgsmNN;

public class App {

    public static void main(String[] args) {
        BinaryTree<String> b1 = new BinaryTree<>("2");
        BinaryTree<String> b2 = new BinaryTree<>("4");
        BinaryTree<String> b3 = new BinaryTree<>("+", b1, b2);
        BinaryTree<String> b4 = new BinaryTree<>("7");
        BinaryTree<String> b5 = new BinaryTree<>("*", b3, b4);

        BinaryTree<String> b6 = new BinaryTree<>("3");
        BinaryTree<String> b7 = new BinaryTree<>("8");
        BinaryTree<String> b8 = new BinaryTree<>("+", b6, b7);

        BinaryTree<String> b9 = new BinaryTree<>("+", b5, b8);

        System.out.println(b9.countElement("+"));

        b9.inorder();






    }
}
