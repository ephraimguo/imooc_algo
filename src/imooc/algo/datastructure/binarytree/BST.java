package imooc.algo.datastructure.binarytree;


import com.sun.org.apache.xpath.internal.objects.XNodeSet;
import sun.tools.jconsole.inspector.XNodeInfo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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

    private void process(Node node) {
        System.out.print(node.e + " ");
    }

    // preorder traversal
    public void preorderTraversal() {
        preorderTraversal(this.root);
        System.out.println();
    }

    private void preorderTraversal(Node node) {
//        if (node != null) {
//            process(node);
//            preorderTraversal(node.left);
//            preorderTraversal(node.right);
//        }

        if (node == null) {
            return;
        }

        process(node);
        preorderTraversal(node.left);
        preorderTraversal(node.right);
    }

    public void preorderTravelsalNR() {
        if (this.root == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(this.root);

        while (!stack.isEmpty()) {
            Node current = stack.pop();
            System.out.print(current.e + " ");

            if (current.right != null) {
                stack.push(current.right);
            }

            if (current.left != null) {
                stack.push(current.left);
            }
        }
        System.out.println();
    }

    // inorder traversal
    public void inorderTraversal() {
        inorderTraversal(this.root);
        System.out.println();
    }

    private void inorderTraversal(Node node) {
//        if (node != null) {
//            inorderTraversal(node.left);
//            process(node);
//            inorderTraversal(node.right);
//        }
        if (node == null) {
            return;
        }

        inorderTraversal(node.left);
        process(node);
        inorderTraversal(node.right);
    }

    public void inorderTraversalNR() {
        Stack<Node> stack = new Stack<>();
        Node current = this.root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            if (!stack.isEmpty()) {
                current = stack.peek();
                System.out.print(current.e + " ");
                stack.pop();
                current = current.right;
            }
        }
        System.out.println();
    }

    // postorder traversal
    public void postorderTraversal() {
        postorderTraversal(this.root);
        System.out.println();
    }

    private void postorderTraversal(Node node) {
//        if (node != null) {
//            postorderTraversal(node.left);
//            postorderTraversal(node.right);
//            process(node);
//        }

        if (node == null) {
            return;
        }

        postorderTraversal(node.left);
        postorderTraversal(node.right);
        process(node);
    }

    // level order
    public void levelOrder() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(this.root);

        while (!queue.isEmpty()) {
            Node current = queue.remove();
            System.out.print(current.e + " ");

            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }

        System.out.println();
    }

    // find the minimum value in bst
    public E minimum() {
        if (this.size == 0) {
            throw new IllegalArgumentException("Fail to run minimum(), empty bst");
        }

        return minimum(this.root).e;
    }

    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }

        return minimum(node.left);
    }

    public E maximum() {
        return maximum(this.root).e;
    }

    private Node maximum(Node node) {
        if (node == null) {
            return null;
        }

        if (node.right == null) {
            return node;
        }

        return maximum(node.right);
    }

    public E removeMin() {
        E min = minimum();

        removeMin(this.root);

        return min;
    }

    private Node removeMin(Node node) {
        if (node.left == null) {
            Node right = node.right;
            node.right = null;
            this.size--;
            return right;
        }

        node.left = removeMin(node.left);
        return node;
    }

    public E removeMax() {
        E max = maximum();

        removeMax(this.root);

        return max;
    }

    private Node removeMax(Node node) {
        if (node.right == null) {
            Node left = node.left;
            node.left = null;
            this.size--;
            return left;
        }

        node.right = removeMax(node.right);
        return node;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        generateBSTString(root, 0, sb);
        return sb.toString();
    }

    private void generateBSTString(Node node, int depth, StringBuilder sb) {
        if (node == null) {
            sb.append(generateDepthString(depth) + "null\n");
            return;
        }

        sb.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, sb);
        generateBSTString(node.right, depth + 1, sb);
    }

    private String generateDepthString(int depth) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            sb.append("--");
        }
        return sb.toString();
    }
}



























