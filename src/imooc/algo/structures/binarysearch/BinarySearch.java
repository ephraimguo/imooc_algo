package imooc.algo.structures.binarysearch;

import imooc.algo.sorts.helper.SortTestHelper;
import imooc.algo.sorts.quicksort.QuickSort;

import javax.xml.bind.annotation.XmlID;

// binary search -> ordered arr, search target
// if find target -> return index
// if not found -> return -1
public class BinarySearch {
    public static int binarySearchIterate(Comparable[] arr, Comparable target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;//(left + right) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (target.compareTo(arr[mid]) < 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }

        return -1;
    }

    public static int binarySearchRecursive(Comparable[] arr, Comparable target, int left, int right) {
        if (left >= right) {
            if (arr[left] != target) {
                return -1;
            } else {
                return left;
            }
        }

        int mid = left + (right - left) / 2;
        if (arr[mid] == target) {
            return mid;
        } else if (target.compareTo(arr[mid]) < 0) {
            return binarySearchRecursive(arr, target, left, mid - 1);
        } else {
            return binarySearchRecursive(arr, target, mid+1, right);
        }

    }

    public static int floor(Comparable[] arr, Comparable target) {
        if (binarySearchRecursive(arr, target, 0, arr.length - 1) == -1) {
            return -1;
        }

        int idx = binarySearchRecursive(arr, target, 0, arr.length - 1);

        for (int i = idx; arr[i] == target;) {
            i--;
            if (arr[i] == target) {
                idx = i;
            }

        }

        return idx;
    }

    public static int ceil(Comparable[] arr, Comparable target) {
        if (floor(arr, target) == -1) {
            return -1;
        }

        int idx = floor(arr, target);

        for (int i = idx; arr[i] == target;) {
            i++;
            if (arr[i] == target) {
                idx = i;
            }

        }

        return idx ;
    }


    public static void main(String[] args) {
        Integer[] arr = SortTestHelper.generateRandoArray(50, 0, 10);
        QuickSort.sortIt(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(i + " " + arr[i]);
        }

        int f = floor(arr, 3);
        int c = ceil(arr, 3);
        System.out.println("floor of 3 :" + f);
        System.out.println("ceil of 3 :" + c);

    }
}
