package binarysearchtreestuderende;
import java.util.ArrayList;

public class ArrayListBinarySearchTree<E extends Comparable<E>> {
    private ArrayList<E> elements;

    public ArrayListBinarySearchTree() {
        elements = new ArrayList<>();
    }

    public void add(E obj) {
        if (elements.isEmpty()) {
            elements.add(obj);
        } else {
            addNode(0, obj);
        }
    }

    private void addNode(int index, E obj) {
        E current = elements.get(index);
        int compare = obj.compareTo(current);

        if (compare < 0) {
            int leftChildIndex = 2 * index + 1;
            if (leftChildIndex >= elements.size()) {
                elements.add(leftChildIndex, obj);
            } else {
                addNode(leftChildIndex, obj);
            }
        } else if (compare > 0) {
            int rightChildIndex = 2 * index + 2;
            if (rightChildIndex >= elements.size()) {
                elements.add(rightChildIndex, obj);
            } else {
                addNode(rightChildIndex, obj);
            }
        }
    }

    public boolean find(E obj) {
        return findNode(0, obj);
    }

    private boolean findNode(int index, E obj) {
        if (index >= elements.size()) {
            return false;
        }

        E current = elements.get(index);
        int compare = obj.compareTo(current);

        if (compare == 0) {
            return true;
        } else if (compare < 0) {
            return findNode(2 * index + 1, obj);
        } else {
            return findNode(2 * index + 2, obj);
        }
    }

    public void remove(E obj) {
        removeNode(0, obj);
    }

    private void removeNode(int index, E obj) {
        if (index >= elements.size()) {
            return;
        }

        E current = elements.get(index);
        int compare = obj.compareTo(current);

        if (compare == 0) {
            if (isLeafNode(index)) {
                elements.remove(index);
            } else if (hasOnlyLeftChild(index)) {
                int leftChildIndex = 2 * index + 1;
                elements.set(index, elements.get(leftChildIndex));
                elements.remove(leftChildIndex);
            } else if (hasOnlyRightChild(index)) {
                int rightChildIndex = 2 * index + 2;
                elements.set(index, elements.get(rightChildIndex));
                elements.remove(rightChildIndex);
            } else {
                int successorIndex = findSuccessorIndex(index);
                E successor = elements.get(successorIndex);
                elements.set(index, successor);
                removeNode(successorIndex, successor);
            }
        } else if (compare < 0) {
            removeNode(2 * index + 1, obj);
        } else {
            removeNode(2 * index + 2, obj);
        }
    }

    private int findSuccessorIndex(int index) {
        int rightChildIndex = 2 * index + 2;
        while (2 * rightChildIndex + 1 < elements.size()) {
            rightChildIndex = 2 * rightChildIndex + 1;
        }
        return rightChildIndex;
    }

    private boolean isLeafNode(int index) {
        return 2 * index + 1 >= elements.size();
    }

    private boolean hasOnlyLeftChild(int index) {
        int leftChildIndex = 2 * index + 1;
        return leftChildIndex < elements.size() && 2 * leftChildIndex + 1 >= elements.size();
    }

    private boolean hasOnlyRightChild(int index) {
        int rightChildIndex = 2 * index + 2;
        return rightChildIndex < elements.size() && 2 * rightChildIndex + 1 >= elements.size();
    }

    public void print() {
        for (E element : elements) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
