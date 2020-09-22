package imooc.algo.datastructure.setnmap;

import imooc.algo.datastructure.LinkedList.LinkedList;

public class LinkedListSet<E> implements Set<E> {
    private LinkedList<E> list;

    public LinkedListSet() {
        this.list = new LinkedList<>();
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
    public boolean contains(E e) {
        return this.list.contains(e);
    }

    @Override
    public void add(E e) {
        if (!this.list.contains(e)) {
            // add new element at head
            // time complexity is O(1)
            this.list.addFirst(e);
        }
    }

    @Override
    public void remove(E e) {
        this.list.removeElement(e);
    }
}
