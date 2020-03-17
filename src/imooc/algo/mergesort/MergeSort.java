package imooc.algo.mergesort;

import imooc.algo.helper.SortTestHelper;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        Integer[] aa = SortTestHelper.generateRandoArray(100000, 0, 1000);
        Integer[] aaa = Arrays.copyOfRange(aa, 0, aa.length);

//        SortTestHelper.showArr(aa);

        SortTestHelper.testSort("imooc.algo.insertionsort.InsertionSort",aa);
        SortTestHelper.testSort("imooc.algo.mergesort.MergeSort",aaa);

//        SortTestHelper.showArr(aa);

    }

    public static void mergeIt(Comparable[] arr, int l, int mid, int r) {
        Comparable[] aux = Arrays.copyOfRange(arr, l, r + 1);

        // i is left index
        // j is right index
        // k is the aux index
        int x = l, y = mid + 1;
        for (int k = l; k <= r; k++) {
            if (x > mid) {
                arr[k] = aux[y - l];
                y++;
            } else if (y > r) {
                arr[k] = aux[x - l];
                x++;
            } else if (aux[x - l].compareTo(aux[y - l]) < 0) {
                arr[k] = aux[x - l];
                x++;
            } else {
                arr[k] = aux[y - l];
                y++;
            }
        }

    }

    private static void sort(Comparable[] arr, int l, int r) {
        if (l >= r) {
            return;
        }

        int mid = (l + r) / 2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);

        if (arr[mid].compareTo(arr[mid + 1]) > 0) {
            mergeIt(arr, l, mid, r);
        }
    }

    public static void sortIt(Comparable[] arr) {
        int n = arr.length;

        sort(arr, 0, n - 1);
    }
}
