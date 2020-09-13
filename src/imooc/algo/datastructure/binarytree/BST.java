package imooc.algo.datastructure.binarytree;

public class BST<E extends Comparable<E>> {
    private class Node {
        E e;
        Node left;
        Node right;

        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
        this.root = null;
        this.size = 0;
    }

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    // add new element to binary tree
    public void add(E e) {
        add(this.root, e);
    }

    private void add(Node node, E e) {
        // end condition
        if (node == null){
            node = new Node(e);
        } else if (node.e.equals(e)) { // if node value is same as the newly added value
            return;
        } else if (e.compareTo(node.e) > 0 && null == node.right) {
            // newly added value is greater than current node value
            // && node's right child is null
            node.right = new Node(e);
        } else if (e.compareTo(node.e) < 0 && null == node.left) {
            // newly added value is less than current node's value
            // && node's left child is null
        }

        // if no end conditions are satisfied
        if (e.compareTo(node.e) < 0) {
            // if newly added value is less than node's value
            // use node.left as the root and run again
            add(node.left, e);
        } else {
            // if newly added value is greater than node's value
            // user node.right as root and run again
            add(node.right, e);
        }
    }
}
