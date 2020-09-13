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

  // 1st implementation of recursive add
    // add new element to binary tree
/*    public void add(E e) {
        add(this.root, e);
    }

    private void add(Node node, E e) {
        //
        // end condition
        if (node == null){ // if node is null, then need assign value to node
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
    }*/

  // 2nd implementation of recursion add
    public void add(E e) {
        this.root = add(root, e);
    }

    public Node add(Node node, E e) {
        if (node == null) {
            this.size++;
            node = new Node(e);
            return node;
        }

        if (e.compareTo(node.e) < 0) { // newly added value e < root.e
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0){ // newly added value e > root.e
            node.right = add(node.right, e);
        }

        return node;
    }

    // search bst if the value exists
    public boolean contains(E e) {
        return contains(this.root, e);
    }

    // search though bst whose root is node
    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }

        if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            return contains(node.right, e);
        } else {
            return true;
        }
    }

    //
}



























