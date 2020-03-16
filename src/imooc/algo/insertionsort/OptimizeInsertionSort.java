package imooc.algo.insertionsort;

import imooc.algo.helper.SortTestHelper;

public class OptimizeInsertionSort {

    public static void main(String[] args) {
        Integer[] arr = SortTestHelper.generateRandoArray(1000, 0, 1000);

        Integer[] arr2 = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr2[i] = arr[i];
        }

        SortTestHelper.testSort("imooc.algo.selectionsort.SelectionSortComparable", arr);
        System.out.println("=================");
        SortTestHelper.testSort("imooc.algo.insertionsort.OptimizeInsertionSort", arr2);

        for (Integer ar: arr
             ) {
            System.out.print(ar + " ");

        }
    }

    public static void sortIt(Comparable[] arr) {

        int n = arr.length;
        for (int i = 0; i < n; i++) {

            Comparable e = arr[i];
            int j;
            for (j = i; j > 0 ; j--) {
                if (arr[j-1].compareTo(e) > 0) {
                    arr[j] = arr[j - 1];
                } else {
                    break;
                }
            }

            arr[j] = e;
        }
    }

}
