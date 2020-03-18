package imooc.algo.sorts.selectionsort;

/**
 *
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {10, 3, 6, 32, 5, 4, 3};
        sortIt(arr);
        show(arr);
    }

    public static void sortIt(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }

            int tmp = arr[i];
            arr[i] = arr[min];
            arr[min] = tmp;
        }
    }

    public static void show(int[] arr) {
        for (int a: arr) {
            System.out.print(a + "\t");
        }
    }

}
