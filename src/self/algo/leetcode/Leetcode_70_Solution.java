package self.algo.leetcode;

import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * <p>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * <p>
 * Example 1:
 * <p>
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 * <p>
 * Input: 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 */

public class Leetcode_70_Solution {
    public static Vector<Integer> cache;

    // return how many distinct ways of climbing the stairs
    public static int climbStairs(int n) {
        cache = new Vector<>(n + 1, -1);
        return waysDP(n);
    }

    private int ways(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        if (cache.get(n) == -1) {
            cache.set(n, ways(n - 1) + ways(n - 2));
        }
        return cache.get(n);
    }

    private static int waysDP(int n) {
        Map<Integer, Integer> memory = new TreeMap<>();

        memory.put(0, 1);
        memory.put(1, 1);

        for (int i = 2; i <= n; i++) {
            memory.put(i, memory.get(i - 1) + memory.get(i - 2));
        }

        return memory.get(n);
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }
}
