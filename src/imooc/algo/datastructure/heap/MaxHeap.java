package imooc.algo.datastructure.heap;

public class MaxHeap<E extends Comparable<E>> {
    private DynamicArray<E> data;

    public MaxHeap(int capacity) {
        this.data = new DynamicArray<>(capacity);
    }

    public MaxHeap() {
        this.data = new DynamicArray<>();
    }

    // heapify constructor
    public MaxHeap(E[] arr) {
        this.data = new DynamicArray<E>(arr);

        for (int i = parent(arr.length - 1); i >= 0; i--) {
            shiftDown(i);
        }
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

    public E findMax() {
        if (data.getSize() == 0) {
            throw new IllegalArgumentException("Fail to run findMax(), heap is empty");
        }
        return data.get(0);
    }

    public E extractMax() {
        E ret = this.findMax();
        data.swap(0, data.getSize() - 1);
        data.removeLast();

        this.shiftDown(0);

        return ret;
    }

    private void shiftDown(int k) {
        while (leftChild(k) < this.data.getSize()) {
            // k's left child's index is smaller than the size of data
            // that means k is not yet the leaf node
            int j = leftChild(k);

            // j + 1 -> right child
            if (j + 1 < this.data.getSize()
                    && this.data.get(j + 1).compareTo(this.data.get(j)) > 0) {
                j = rightChild(k);
            }

            if (this.data.get(k).compareTo(this.data.get(j)) >= 0) {
                break;
            }

            this.data.swap(k, j);
            k = j;
        }
    }

    // replace
    // remove the max and add a new element
    public E replace(E e) {
        E ret = this.findMax();
        this.data.set(0, e);
        shiftDown(0);
        return ret;
    }

}




























