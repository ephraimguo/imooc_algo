package imooc.algo.datastructure.setnmap;

public class BSTSet<E extends Comparable<E>> implements Set<E> {
    private BST<E> bst;

    public BSTSet() {
        this.bst = new BST<>();
    }

    @Override

    public int getSize() {
        return this.bst.getSize();
    }

    @Override
    public boolean isEmpty() {
        return this.bst.isEmpty();
    }

    @Override
    public void add(E e) {
        this.bst.add(e);
    }

    @Override
    public void remove(E e) {
        this.bst.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return this.bst.contains(e);
    }
}
