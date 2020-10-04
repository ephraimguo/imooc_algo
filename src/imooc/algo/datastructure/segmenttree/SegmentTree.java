package imooc.algo.datastructure.segmenttree;

public class SegmentTree<E>{
    private E[] data;

    // we consider this tree as an completed binary tree
    // tree is the real structure for users
    private E[] tree;

    private Merger<E> merger;

    public SegmentTree(E[] arr, Merger<E> merger) {
        this.merger = merger;
        this.data = (E[]) new Object[arr.length];
        for (int  i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        this.tree = (E[]) new Object[4 * arr.length];

        buildSegmentTree(0, 0, this.data.length - 1);
    }

    private void buildSegmentTree(int treeIndex, int left, int right) {
        if (left == right) { // no more child. left = right alr.
            this.tree[treeIndex] = data[left];
            return;
        }

        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        int mid = left + (right - left) / 2;

        buildSegmentTree(leftTreeIndex, left, mid);
        buildSegmentTree(rightTreeIndex, mid + 1, right);

        this.tree[treeIndex] = merger.merge(this.tree[leftTreeIndex], this.tree[rightTreeIndex]);
    }

    public E get(int index) {
        if (index < 0 || index >= this.data.length) {
            throw new IllegalArgumentException("Fail to run get(), invalid index");
        }
        return data[index];
    }

    // return range [qleft, qright] value
    public E query(int qLeft, int qRight) {
        if (qLeft < 0 || qLeft > this.data.length ||
                qRight < 0 || qRight > this.data.length ||
                qLeft > qRight) {
            throw new IllegalArgumentException("Fail to run query(), invalid arguments");
        }

        return query(0, 0, this.data.length - 1, qLeft, qRight);
    }

    private E query(int treeIndex, int left, int right, int qLeft, int qRight) {
        if (left == qLeft && right == qRight) {
            return this.tree[treeIndex];
        }

        int mid = left + (right - left) / 2;
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        if (qLeft >= mid + 1) {
            return query(rightTreeIndex, mid + 1, right, qLeft, qRight);
        } else if (qRight <= mid) {
            return query(leftTreeIndex, left, mid, qLeft, qRight);
        }

        E leftRes = query(leftTreeIndex, left, mid, qLeft, mid);
        E rightRes = query(rightTreeIndex, mid + 1, right, mid + 1, qRight);

        return merger.merge(leftRes, rightRes);
    }

    public void update(int index, E e) {
        if (this.tree == null) {
            throw new IllegalArgumentException("Fail to run update(), invalid tree memeber");
        }
    }

    private void set(int treeIndex, int left, int right, int index, E e) {

    }

    // return complete binary tree array
    // left child of the index
    private int leftChild(int index) {
        return 2 * index + 1;
    }

    // return complete binary tree array
    // right child of the index
    private int rightChild(int index) {
        return 2 * index + 2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < this.tree.length; i++) {
            if (this.tree[i] != null) {
                sb.append(this.tree[i]);
            } else {
                sb.append("null");
            }

            if (i != this.tree.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");

        return sb.toString();
    }
}
