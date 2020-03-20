package imooc.algo.structures.binarysearch;

import java.util.LinkedList;
import java.util.Queue;

public class BST <Key extends Comparable<Key>, Value>{

    public Node root;
    private int count; // how many nodes

    private class Node{
        private Key key;
        private Value value;

        public Node left;
        public Node right;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }

    }

    public BST() {
        this.root = null;
        this.count = 0;

    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public Value search(Key key) {
        return __search(root, key);
    }

    public boolean contain(Key key) {
        return __contain(root, key);
    }

    public void insert(Key key, Value value) {
        root = __insert(root, key, value);
    }

    public void preorderTraverse() {
        __preorder(root);
    }

    private void __preorder(Node root) {
        if (root != null) {
            System.out.println(root.key);
            __preorder(root.left);
            __preorder(root.right);
        }

    }

    public void inorderTraverse() {
        __inorder(root);
    }

    private void __inorder(Node root) {
        if (root != null) {
            __inorder(root.left);
            System.out.println(root.key);
            __inorder(root.right);

        }

    }

    public void postorderTraverse(Node root) {
        __postorder(root);
    }

    private void __postorder(Node root) {
        if (root != null) {
            postorderTraverse(root.left);
            System.out.println(root.key);
            postorderTraverse(root.right);

        }
    }

    // Breadth First Search, level order
    public void levelOrder() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.peek();
            queue.poll();

            System.out.println(node.key);

            if (node.left != null) {
                queue.add(node.left);

            }

            if (node.right != null) {
                queue.add(node.right);

            }
        }

    }

    private Node __insert(Node node, Key key, Value value) {
        // if current node is null, can assign new node to this node
        if (node == null) {
            count++;
            return new Node(key, value);

        }

        if (key.equals(node.key)) {
            // if key is same as node key
            node.value = value;

        } else if (key.compareTo(node.key) < 0) {
            //
            node.left = __insert(node.left, key, value);

        } else {
            node.right = __insert(node.right, key, value);

        }

        // resturn relative node itself
        return node;
    }

    private boolean __contain(Node node, Key key) {

        if (node == null) {
            return false;
        }

        if (key.equals(node.key)) {
            return true;

        } else if (key.compareTo(node.key) < 0) {
            return __contain(node.left, key);

        } else {
            return __contain(node.right, key);

        }

    }

    private Value __search(Node node, Key key) {

        if (node == null) {
            return null;
        }

        if (key.equals(node.key)) {
            return node.value;
        } else if (key.compareTo(node.key) < 0) {
            return __search(node.left, key);
        } else {
            return __search(node.right, key);
        }

    }

}































