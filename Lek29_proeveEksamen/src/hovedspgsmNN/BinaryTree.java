package hovedspgsmNN;

/**
 * A binary tree in which each node has two children.
 */
public class BinaryTree<E> {
    private Node root;
    
    /**
     * Constructs an empty tree.
     */
    public BinaryTree() {
        root = null;
    }
    
    /**
     * Constructs a tree with one node and no children.
     *
     * @param rootData
     *            the data for the root
     */
    public BinaryTree(E rootData) {
        root = new Node();
        root.data = rootData;
        root.left = null;
        root.right = null;
    }
    
    /**
     * Constructs a binary tree.
     *
     * @param rootData
     *            the data for the root
     * @param left
     *            the left subtree
     * @param right
     *            the right subtree
     */
    public BinaryTree(E rootData, BinaryTree<E> left, BinaryTree<E> right) {
        root = new Node();
        root.data = rootData;
        if (left != null) {
            root.left = left.root;
        }
        if (right != null) {
            root.right = right.root;
        }
    }
    
    /**
     * Checks whether this tree is empty.
     *
     * @return true if this tree is empty
     */
    public boolean isEmpty() {
        return root == null;
    }
    
    /**
     * Gets the data at the root of this tree.
     *
     * @return the root data
     */
    public E data() {
        return root.data;
    }
    
    /**
     * Gets the left subtree of this tree.
     *
     * @return the left child of the root
     */
    public BinaryTree<E> left() {
        BinaryTree<E> result = new BinaryTree<>();
        result.root = root.left;
        return result;
    }
    
    /**
     * Gets the right subtree of this tree.
     *
     * @return the right child of the root
     */
    public BinaryTree<E> right() {
        BinaryTree<E> result = new BinaryTree<>();
        result.root = root.right;
        return result;
    }
    
    /**
     *
     * @param rootData
     *            the new data for the root
     *
     * @return the data previous in the root
     */
    public E replace(E rootData) {
        E toReturn = root.data;
        root.data = rootData;
        return toReturn;
    }
    
    public int size() {
        return size(root);
    }
    
    private int size(Node n) {
        if (n != null) {
            return 1 + size(n.left) + size(n.right);
        }
        else {
            return 0;
        }
    }

    public int countElement(E element) {
        return countElement(root, element);
    }
    private int countElement(Node current, E element) {
        if (current == null) {
            return 0;
        }

        int counter = 0;
        if (current.data.equals(element)) {
            counter++;
        }
        counter += countElement(current.left, element);
        counter += countElement(current.right, element);

        return counter;
    }
    private int value(Node n) {
        if (n.right == null && n.left == null) {
            return (int) n.data;
        } else {
            return 0;
        }
    }
    public void inorder() {
        inorder(root);
    }
    private void inorder(Node n) {
        if (n != null) {
            inorder(n.left);
            System.out.print(n.data + " ");
            inorder(n.right);
        }
    }
    public int height() {
        return height(root);
    }
    private int height(Node n) {
        if (n == null) {
            return 0;
        } else {
            int left = height(n.left);
            int right = height(n.right);
            return Math.max(left, right) + 1;
        }
    }
    private class Node {
        public E data;
        public Node left;
        public Node right;
    }
}
