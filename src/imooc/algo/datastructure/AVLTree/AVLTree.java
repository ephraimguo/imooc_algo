package imooc.algo.datastructure.AVLTree;

public class AVLTree<K extends Comparable<K>, V> implements Map<K, V> {
    private class Node{
        public K key;
        public V value;
        public Node left;
        public Node right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    private int size;

    public AVLTree() {
        this.root = null;
        this.size = 0;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public boolean contains(K key) {
        return getNode(this.root, key) == null;
    }

    @Override
    public void add(K key, V value) {
        root = this.add(this.root, key, value);
    }

    private Node add(Node node, K key, V value) {
        if (node == null) {
            return new Node(key, value);
        }

        if (key.compareTo(node.key) < 0) {
            node.left = add(node.left, key, value);

        } else if (key.compareTo(node.key) > 0) {
            node.right = add(node.right, key, value);
        } else {
            node.value = value;

        }

        return node;
    }

    private Node getNode(Node node, K key) {
        if (node == null) {
            return null;
        }

        if (key.compareTo(node.key) < 0) {
            return getNode(node.left, key);

        } else if (key.compareTo(node.key) > 0) {
            return getNode(node.right, key);

        } else {
            return node;

        }
    }

    @Override
    public void set(K key, V newValue) {
        Node node = getNode(this.root, key);
        if (node == null) {
            throw new IllegalArgumentException(key + " does not exist");
        }

        node.value = newValue;
    }

    @Override
    public V get(K key) {
        Node node = getNode(this.root, key);
        return node == null ? null : node.value;
    }

    private Node minimum(Node node) {
        if (node == null) {
            return null;
        }

        if (node.left == null) {
            return node;
        }

        return minimum(node.left);
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

    // remove element from BST
    @Override
    public V remove(K key) {
/*
        Node node = getNode(this.root, key);
        if (node == null) {
            return null;
        }
        this.root = remove(this.root, key);
        return node.value;
*/

        Node node = getNode(this.root, key);
        if (node != null) {
            this.root = remove(this.root, key);
            return node.value;
        }

        return null;
    }

    private Node remove(Node node, K key) {
        if (node == null) {
            return null;
        }

        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            return node;

        } else if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            return node;

        } else { // key == node.key
            if (node.left == null) {
                Node right = node.right;
                node.right = null;
                this.size--;
                return right;
            }

            if (node.right == null) {
                Node left = node.left;
                node.left = null;
                this.size--;
                return left;
            }

            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            node.left = node.right = null;

            return successor;
        }
    }
}


























