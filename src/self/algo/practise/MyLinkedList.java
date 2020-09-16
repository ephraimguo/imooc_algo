package self.algo.practise;

import imooc.algo.datastructure.LinkedList.LinkedList;

public class MyLinkedList<E> {
    private class Node{
        E e;
        Node next;
        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }
        public Node() {
            this.e = null;
            this.next = null;
        }
    }

    private int size;
    private Node dummyHead;

    public MyLinkedList() {
        this.dummyHead = new Node(null, null);
    }

    public void add(E e) {
        add(this.dummyHead, e);
    }
    public void add(Node node, E e) {
        if (node.next == null) {
            node.next = new Node(e, null);
            return;
        }

        add(node.next, e);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LinkedList: ").append("head ->");

        Node cur = this.dummyHead.next;

        if (cur != null) {
            while (cur != null) {
                sb.append(" ").append(cur.e);
                cur = cur.next;
            }

        }

        sb.append(" <- tail | ");
        sb.append(" head is ").append(this.dummyHead.next.e);

        return sb.toString();
    }

    public static void main(String[] args) {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        for (int i = 0; i < 10; i++) {
            linkedList.add(i);
        }
         System.out.println(linkedList);
    }
}
