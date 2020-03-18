package imooc.algo.sorts.heapsort;

public class MaxHeap<T extends Comparable> {
    private T[] data;
    private int count;
    private int capacity;

    public MaxHeap(int cap) {
        capacity = cap;
        count = 0;
        this.data = (T[]) new Comparable[cap + 1]; // the index 0 is always empty, not used.
    }

    public MaxHeap(T[] arr) {
        int n = arr.length;
        count = capacity = n;
        data = (T[])new Comparable[count + 1];

        for (int i = 1; i < count + 1; i++) {
            data[i] = arr[i-1];
        }

        for (int i = count / 2; i >= 1; i--) {
            shiftDown(i);
        }
    }

    public int capacity() {
        return data.length - 1;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void show() {
        for (int i = 1; i <= count; i++) {
            System.out.print(this.data[i]==null ? "NULL " : this.data[i] + " ");
        }
        System.out.println();
    }

    public void insert(T t) {
        if (count >= capacity()) {
            T[] newData = (T[]) new Comparable[this.data.length + this.capacity()];
            System.arraycopy(this.data, 0, newData, 0, this.data.length);
            this.data = newData;
        }
        this.data[++count] = t;
        shiftUp(count);

    }

    public T remove() {
        T t = this.data[1];
        this.data[1] = null;
        swap(1, count--);
        shiftDown(1);
        return t;
    }

    private void shiftUp(int idx) {
        while (idx > 1 && data[idx / 2].compareTo(data[idx]) < 0) {
            swap(idx / 2, idx);
            idx /= 2;
        }
    }

    private void shiftDown(int idx) {
        while (idx * 2 <= count) {
            int l_child = idx * 2;
            int r_child = l_child + 1;
            int new_idx = l_child;
            if (r_child <= this.count && data[r_child].compareTo(data[l_child]) > 0) {
                new_idx = r_child;
            }

            if (data[new_idx].compareTo(data[idx]) > 0) {
                swap(new_idx, idx);
                idx = new_idx;

            } else {
                break;

            }

        }

    }


    private void swap(int parent, int idx) {
        T t = data[parent];
        data[parent] = data[idx];
        data[idx] = t;
    }
}
