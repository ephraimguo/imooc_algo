package imooc.algo.datastructure.LinkedList;

public class LinkedListStack<E> implements Stack<E> {
    private LinkedList<E> list;

    public LinkedListStack() {
        list = new LinkedList<>();
    }

    @Override
    public int getSize() {
        return this.list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    @Override
    public void push(E e) {
        this.list.addFirst(e);
    }

    @Override
    public E pop() {
        return this.list.removeFirst();
    }

    @Override
    public E peek() {
        return this.list.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Stack: ").append("top -> ");
        sb.append(this.list);
        return sb.toString();
    }
}
