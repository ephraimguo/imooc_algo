package imooc.algo.datastructure.heap;

public class MaxHeap<E extends Comparable<E>> {
    private DynamicArray<E> data;

    public MaxHeap(int capacity) {
        this.data = new DynamicArray<>(capacity);
    }

    public MaxHeap() {
        this.data = new DynamicArray<>();
    }

    public int size() {
        return this.data.getSize();
    }

    public boolean isEmpty() {
        return this.data.getSize() == 0;
    }

    // find the parent index of current index
    // in the nearly completed binary tree
    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("invalid index, 0 has no parent");
        }

        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    public void add(E e) {
        this.data.addLast(e);
        this.shiftUp(data.getSize() - 1);
    }

    private void shiftUp(int k) {
        while (k > 0 && data.get(this.parent(k)).compareTo(data.get(k)) < 0) {
            // swap the position
            this.data.swap(k, this.parent(k));
            k = parent(k);
        }
    }


}
