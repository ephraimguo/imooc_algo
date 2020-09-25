package self.algo.leetcode;

import java.util.ArrayList;
import java.util.TreeSet;

public class Leetcode_349_Solution {
    public static int[] intersection(int[] nums1, int[] nums2) {
        TreeSet<Integer> s = new TreeSet<>();
        for (int num: nums1) {
            s.add(num);
        }

        ArrayList<Integer> arr = new ArrayList<>();
        for (int num : nums2) {
            if (s.contains(num)) {
                s.remove(num);
                arr.add(num);
            }
        }

        int[] res = new int[arr.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = arr.get(i);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = intersection(new int[]{1, 2, 2, 1}, new int[]{1, 2});
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}


