package imooc.algo.datastructure.setnmap;

public interface Set<E> {
    // get the size of the set
    int getSize();

    // check if the set is empty
    boolean isEmpty();

    // add new value to set
    void add(E e);

    // remove a value from set
    void remove(E e);

    // check if the
    boolean contains(E e);
}
