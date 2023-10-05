package binartreestuderende;

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
		BinaryTree<E> result = new BinaryTree<E>();
		result.root = root.left;
		return result;
	}
	/**
	 * Gets the right subtree of this tree.
	 *
	 * @return the right child of the root
	 */
	public BinaryTree<E> right() {
		// TODO exercise 1
		BinaryTree<E> result = new BinaryTree<E>();
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
		// TODO exercise 1
		E oldData = root.data;
		root.data = rootData;
		return oldData;
	}

	/**
	 *
	 * @param n
	 * @return true in n has no children
	 */
	private boolean isLeaf(Node n) {
		// TODO exercise 1
		return n.left == null && n.right == null;
	}

	/**
	 *
	 * @param n
	 * @return true in n has at least one child
	 */
	private boolean isInternal(Node n) {
		// TODO exercise 1
		return n.left != null || n.right != null;
	}
	/**
	 *
	 * @return the number of nodes in the tree
	 */
	public int size() {
		return size(root);
	}

	private int size(Node n) {
		if (n == null) return(0);
		else {
			return(size(n.left) + 1 + size(n.right));
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
	public void preorder() {
		preorder(root);
	}
	private void preorder(Node n) {
		if (n != null) {
			System.out.print(n.data + " ");
			preorder(n.left);
			preorder(n.right);
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
	public void postorder() {
		postorder(root);
	}
	private void postorder(Node n) {
		if (n != null) {
			inorder(n.right);
			inorder(n.left);
			System.out.print(n.data + " ");
		}
	}

	public int sum() {
		return sum(root);
	}

	private int sum(Node n) {
		if (n == null) {
			return 0;
		} else {
			int left = sum(n.left);
			int right = sum(n.right);
			return (int) n.data + left + right;
		}
	}

	private class Node {
		public E data;
		public Node left;
		public Node right;
	}
}
