package imooc.algo.insertionsort;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.CompareGenerator;
import imooc.algo.helper.SortTestHelper;

public class InsertionSort {

    public static void main(String[] args) {
        Integer[] arr = SortTestHelper.generateRandoArray(10000, 0, 1000);

        SortTestHelper.testSort("imooc.algo.insertionsort.InsertionSort", arr);

        for (Integer ar: arr
             ) {
            System.out.print(ar + " ");
        }
    }

    public static void sortIt(Comparable[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i ; j > 0 && arr[j].compareTo(arr[j-1]) < 0; j--) {
                    swap(arr, j, j-1);
            }

        }
    }

    public static void swap(Object[] arr, int i, int j) {
        Object tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
