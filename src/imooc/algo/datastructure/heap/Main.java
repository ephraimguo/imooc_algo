package imooc.algo.datastructure.heap;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int n = 1000000;

//        MaxHeap<Integer> maxHeap = new MaxHeap<>();
//        Random random = new Random();
//        for (int i = 0; i < n; i++) {
//            maxHeap.add(random.nextInt(Integer.MAX_VALUE));
//        }
//
//        int[] arr = new int[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = maxHeap.extractMax();
//        }
//
//        for (int i = 1; i < arr.length; i++) {
//            if (arr[i - 1] < arr[i]) {
//                throw new IllegalArgumentException("Error");
//            }
//            System.out.println(arr[i]);
//        }

        Integer[] testData = new Integer[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            testData[i] = random.nextInt(Integer.MAX_VALUE);
        }
        double t1 = testHeap(testData, false);
        System.out.println("without heapify: " + t1 + " ms");
        double t2 = testHeap(testData, true);
        System.out.println("With heafipy: " + t2 + " ms");

    }

    private static double testHeap(Integer[] testData, boolean isHeapify) {
        long start = System.currentTimeMillis();

        MaxHeap<Integer> maxHeap;
        if (isHeapify) {
            maxHeap = new MaxHeap<>(testData);
        } else {
            maxHeap = new MaxHeap<>();
            for (Integer num: testData) {
                maxHeap.add(num);
            }
        }

        Integer[] arr = new Integer[testData.length];
        for (int i = 0; i < testData.length; i++) {
            arr[i] = maxHeap.extractMax();
        }

        for (int i = 1; i < testData.length; i++) {
            if (arr[i - 1] < arr[i]) {
                throw new IllegalArgumentException("Error");
            }
        }

        System.out.println("DONE");

        long end = System.currentTimeMillis();
        return end - start;
    }
}
