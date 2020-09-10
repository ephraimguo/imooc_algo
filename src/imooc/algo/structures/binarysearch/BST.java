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

        public Node(Node node) {
            this.key = node.key;
            this.value = node.value;
            this.left = node.left;
            this.right = node.right;
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

    public Key minimum() {
        assert (count != 0);
        Node min = __min(root);
        return min.key;
    }

    public Key maximum() {
        assert (count != 0);
        Node max = __max(root);
        return max.key;
    }

    public void removeMin() {
        root = __removeMin(root);
    }

    public void removeMax() {
        root = __removeMax(root);
    }

    public void remove(Key key) {
        root = __remove(root, key);
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

    private Node __min(Node node) {
        if (node.left == null) {
            return node;
        }

        return __min(node.left);
    }

    private Node __max(Node node){
        if (node.right == null) {
            return node;
        }

        return __min(node.right);
    }

    private Node __removeMin(Node node) {
        if (node.left == null) {
            return node.right;

        }

        node.left = __removeMin(node.left);
        return node;
    }

    private Node __removeMax(Node node) {
        if (node.right == null) {
            return node.left;

        }

        node.right = __removeMax(node.right);
        return node;
    }

    // delete the node of 'key'
    // return the new root node
    private Node __remove(Node node, Key key) {
        if (node == null) {
            return null;
        }

        if (key.compareTo(node.key) < 0) {
            node.left = __remove(node.left, key);
            return node;

        } else if (key.compareTo(node.key) > 0) {
            node.right = __remove(node.right, key);
            return node;

        } else { // key == node.key
            // if left child is null
            if (node.left == null) {
                Node rightNode = node.right;
                count--;
                return rightNode;
            }

            // if right child is null
            if (node.right == null) {
                Node leftNode = node.right;
                count--;
                return leftNode;
            }

            Node delNode = node; // node going to be deleted
            Node successor = new Node(__min(delNode.right)); // right child tree's minimum node
            count++;

            successor.right = __removeMin(node.right);
            successor.left = node.left;
            count--;

            return successor;
        }
    }

}































