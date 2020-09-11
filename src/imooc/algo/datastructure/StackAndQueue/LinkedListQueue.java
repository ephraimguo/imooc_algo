package imooc.algo.datastructure.StackAndQueue;

public class LinkedListQueue<E> implements Queue<E> {
    private class Node {
        private E e;
        private Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public LinkedListQueue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public void enqueue(E e) {
        if (tail == null) { // there is no Node inside
            tail = new Node(e);
            head = tail;
        } else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        this.size++;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Faile to run dequeue(), queue is empty");
        }

        Node retNode = this.head;
        this.head = this.head.next;
        retNode.next = null;
        if (head == null) {
            tail = null;
        }

        this.size--;
        return retNode.e;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty");
        }
        return head.e;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Queue ").append("front >| ");
        for (Node n = this.head; n.next != null; n = n.next) {
            sb.append(n.e).append(" -> ");
        }

        return sb.append(" |< last").toString();
    }
}
