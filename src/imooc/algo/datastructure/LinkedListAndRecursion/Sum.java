package imooc.algo.datastructure.LinkedListAndRecursion;

public class Sum {
    public static void main(String args[]) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(sum(nums));
    }

    public static int sum(int[] arr) {
        return sum(arr, 0);
    }

    /**
     *
     * @param arr target array
     * @param l left boundary
     * @return sum of the array
     */
    private static int sum(int[] arr, int l) {
        if (l == arr.length) { // the most primitive problem
            return 0;
        }

        return arr[l] + sum(arr, l + 1); // convert the original problem to a smaller problem
    }
}
