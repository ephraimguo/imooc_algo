package imooc.algo.datastructure.LinkedList;

public class LinkedList<E> {
    private class Node{
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this.e = e;
            this.next = null;
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return this.e.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedList() {
        this.dummyHead = new Node(null, null);
        this.size = 0;
    }

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    // insert an element
    // it is NOT a regular function in linked list
    public void add(int index, E e) {
        if (index < 0 || index > this.size) {
            throw new IllegalArgumentException("Fail to add, invalid index");
        }
        Node prev = this.dummyHead;

        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
//            Node node = new Node(e);
//            node.next = prev.next;
//            prev.next = node;

        prev.next = new Node(e, prev.next);
        this.size++;
    }

    // recursion add new element
    public void add(int index, E e, char flag) {
        if (index < 0 || index > this.size) {
            throw new IllegalArgumentException("Fail to run add recursive, invalid index");
        }
        System.out.println(flag);
        add(this.dummyHead, e, index, 0);
    }

    private void add(Node dummyHead, E e, int index, int position) {
        if (index == position) {
            dummyHead.next = new Node(e, dummyHead.next);
        } else {
            add(dummyHead.next, e, index, position + 1);
        }
    }

    public void addFirst(E e) {
        this.add(0, e);
    }

    public void addLast(E e) {
        this.add(size, e);
    }

    // get element
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Fail to run get(). Invalid index");
        }

        Node cur = this.dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    // get first
    public E getFirst() {
        return this.get(0);
    }

    // get last
    public E getLast() {
        return this.get(size - 1);
    }

    // update an element
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Fail to run get(). Invalid index");
        }

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }

        cur.e = e;
    }

    // find if element exist
    public boolean contains(E e) {
        Node cur = this.dummyHead.next;
        while (cur != null) {
            if (cur.e.equals(e)) {
                return true;
            }
        }
        return false;
    }

    // remove element at position 'index' where index is 0-based
    // remove operation is not an normal operation in linked list
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Fail to run remove(). Invalid index");
        }

        Node prev = this.dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        this.size--;

        return retNode.e;
    }

    // remove first Node
    public E removeFirst() {
        return remove(0);
    }

    // remove last Node
    public E removeLast() {
        return remove(size - 1);
    }

    // remove certain element from linked list
    public void removeElement(E e){

        Node prev = dummyHead;
        while(prev.next != null){
            if(prev.next.e.equals(e))
                break;
            prev = prev.next;
        }

        if(prev.next != null){
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size --;
        }
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
//        Node cur = dummyHead.next;
//
//        while (cur != null) {
//            sb.append(cur).append("->");
//            cur = cur.next;
//        }

        for (Node cur = dummyHead.next; cur != null ; cur = cur.next) {
            sb.append(cur).append("->");
        }
        sb.append("NULL");
        return sb.toString();
    }
}




















