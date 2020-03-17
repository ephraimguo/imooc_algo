package imooc.algo.mergesort;

import imooc.algo.helper.SortTestHelper;

import java.util.Arrays;

public class MergeSortInt {

    public static void main(String[] args) {
        int[] arr = {1, 5, 4, 534, 234, 45, 8, 78, 5, 34, 2, 42, 4};

        sortIt(arr, 0, arr.length - 1);

        for (int a: arr) {
            System.out.print(a + " ");

        }

    }

    public static void sortIt(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }

        int mid = (l + r) / 2;
        sortIt(arr, l, mid);
        sortIt(arr, mid + 1, r);

        mergeIt(arr, l, mid, r);
    }

    public static void mergeIt(int[] arr, int l, int mid, int r) {
        int x = l;
        int y = mid + 1;

        int[] aux = Arrays.copyOfRange(arr, l, r + 1);

        for (int k = l; k <= r; k++) {
            if(x > mid) {
                arr[k] = aux[y-l];
                y++;

            } else if (y > r) {
                arr[k] = aux[x-l];
                x++;

            } else if (aux[x - l] < aux[y-l]) {
                arr[k] = aux[x - l];
                x++;

            } else {
                arr[k] = aux[y-l];
                y++;

            }
        }
    }
}
