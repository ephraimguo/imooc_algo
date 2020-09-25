package imooc.algo.datastructure.setnmap;

public class LinkedListMap<K, V> implements Map<K, V> {
    private class Node{
        public K key;
        public V value;
        public Node next;

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node(K key) {
            this(key, null, null);
        }

        public Node() {
            this(null, null, null);
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.key.toString()).append(": ").append(this.value.toString());
            return sb.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedListMap() {
        this.dummyHead = new Node();
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

    // assisting function
    private Node getNode(K key) {
        Node cur = this.dummyHead.next;
        while (cur != null) {
            if (cur.key.equals(key)) {
                return cur;
            }

            cur = cur.next;
        }

        return null;
    }

    @Override
    public boolean contains(K key) {
        return this.getNode(key) != null;
    }

    @Override
    public V get(K key) {
        Node node = this.getNode(key);
        return node == null ? null : node.value;
    }

    @Override
    public void add(K key, V value) {
        // in map, there is ONLY key existing
        Node node = this.getNode(key);
        if (node == null) {
            // add to head
            dummyHead.next = new Node(key, value, dummyHead.next);
        } else {
            node.value = value;
        }
    }

    @Override
    public void set(K key, V newValue) {
        Node node = getNode(key);
        if (node == null) {
            throw new IllegalArgumentException(key + " does not exist");
        }

        node.value = newValue;
    }

    @Override
    public V remove(K key) {
        Node node = this.getNode(key);
        if (node == null) {
            return null;
        }

        Node prev = this.dummyHead;
        while (prev.next != null) {
            if (prev.next.key.equals(key)) {
                break;
            }

            prev = prev.next;
        }

        if (prev.next != null) {
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;

            this.size--;
            return delNode.value;
        }

        return null;
    }
}































