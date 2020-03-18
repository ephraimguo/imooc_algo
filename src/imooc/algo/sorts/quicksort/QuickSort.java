package imooc.algo.sorts.quicksort;

import imooc.algo.sorts.helper.SortTestHelper;

public class QuickSort {
    public static void main(String[] args) {
        Integer[] arr = SortTestHelper.generateRandoArray(10000, 0, 100);

        SortTestHelper.testSort("imooc.algo.sorts.quicksort.QuickSort", arr);

//        SortTestHelper.showArr(arr);
    }

    public static void sortIt(Comparable[] arr) {
        sort(arr, 0, arr.length - 1);

    }

    public static void sort(Comparable[] arr, int l, int r) {
        if (l >= r) {
            return;
        }

        int p = partition(arr, l, r);
        sort(arr, l, p - 1);
        sort(arr, p + 1, r);

    }

    public static int partition(Comparable[] arr, int l, int r) {
        Comparable pivot = arr[l];
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (arr[i].compareTo(pivot) < 0) {
                j++;
                swap(arr, j, i);
            }
        }
        swap(arr, l, j);

        return j;
    }

    public static void swap(Comparable[] arr, int i, int j) {
        Comparable tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
