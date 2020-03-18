package imooc.algo.sorts.heapsort;

import imooc.algo.sorts.helper.SortTestHelper;

public class Main {
    public static void main(String[] args) {

        Integer[] arr = SortTestHelper.generateRandoArray(100, 0, 50);
        //MaxHeap maxHeap = new MaxHeap(arr);
        heapSort(arr);

        SortTestHelper.showArr(arr);
    }

    public static void heapSort2(Comparable[] arr) {
        MaxHeap maxHeap = new MaxHeap(arr);

        for (int i = maxHeap.size(); i >= 1; i--) {
            arr[i - 1] = maxHeap.remove();
        }
    }

    public static void heapSort(Comparable[] arr) {
        int n = arr.length;
        for (int i = n - 2 / 2; i >= 0; i--) {
            __shiftDown(arr, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i);
            __shiftDown(arr, i, 0);
        }

    }

    private static void __shiftDown(Comparable[] arr, int count, int idx) {
        while (idx * 2 + 1< count) {
            int l_child = idx * 2 + 1;
            int r_child = l_child + 1;
            int new_idx = l_child;
            if (r_child <= count-1 && arr[r_child].compareTo(arr[l_child]) > 0) {
                new_idx = r_child;
            }

            if (arr[new_idx].compareTo(arr[idx]) > 0) {
                swap(arr, new_idx, idx);
                idx = new_idx;

            } else {
                break;

            }

        }

    }

    private static void swap(Comparable[] arr, int n, int k) {
        Comparable temp = arr[n];
        arr[n] = arr[k];
        arr[k] = temp;

    }

}
