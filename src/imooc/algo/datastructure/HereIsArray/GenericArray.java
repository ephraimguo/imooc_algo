package imooc.algo.datastructure.HereIsArray;

// Generic is representing the type of the data
// hence the E here is E type of the data
public class GenericArray<E> {
    private E[] data; // capacity is the length of data
    private int size;

    // constructor, pass in the capacity of array
    // we need maintain size element
    public GenericArray(int capacity) {
        this.data = (E[]) new Object[capacity];
        this.size = 0;
    }

    // default constructor
    public GenericArray() {
        this(10);
    }

    // get how many element
    public int getSize() {
        return size;
    }

    // get capacity
    public int getCapacity() {
        return data.length;
    }

    // check if the array is empty
    public boolean isEmpty() {
        return this.size == 0;
    }

    // add new element to the last position
    public void addLast(E e) {
        add(size, e);
    }

    // add new element to the first position
    public void addFirst(E e) {
        add(0, e);
    }

    // add element to designated position
    // now:  [11,22,33,44,_,_,_,_,_,], insert 77 into index 1
    // then: [11,77,22,33,44,_,_,_,_]
    // move the element first -> assign the index with 77
    // no empty space, values must be continuous
    public void add(int index, E e) {
        if (size == data.length) {
            throw new IllegalArgumentException("add() failed. array is full");
        }

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("invalid index");
        }

        for (int i = size; i >= index ; i--) {
            data[i + 1] = data[i];
        }

        data[index] = e;
        size++;
    }

    // get index element
    // make sure the unused space is not accessible
    public E get(int index) {
        if (index < 0 || index >= this.size) {
            throw new IllegalArgumentException("get failed, invalid index");
        }
        return this.data[index];
    }

    // set index element
    public void set(int index, E e) {
        if (index < 0 || index >= this.size) {
            throw new IllegalArgumentException("set failed, invalid index");
        }
        this.data[index] = e;
    }

    // check if the data contains the element
    public boolean contains(E e ) {
        for (int i = 0; i < this.size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    // find element index
    // if not found return -1
    public int find(E e) {
        for (int i = 0; i < this.size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    // remove an element from an designated position
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("remove() failed. invalid index");
        }

        E removee = data[index];

        for (int i = index; i < size; i++) {
            data[i] = data[i + 1];
        }

        size--;
        return removee;
    }

    // remove index from the beginning
    public E removeFirst() {
        return this.remove(0);
    }

    // remove index from the end
    public E removeLast() {
        return this.remove(this.size - 1);
    }

    // remove the element(known)
    public void removeElement(E e) {
        int index = this.find(e);
        if (index != -1) {
            remove(index);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Size: ").append(this.size).append(", Capacity: ").append(this.data.length);
        sb.append("\n[");
        for (int i = 0; i < this.size; i++) {
            sb.append(data[i]);
            if (i != this.size - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');

        return sb.toString();
    }
}
