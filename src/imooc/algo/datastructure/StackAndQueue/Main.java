package imooc.algo.datastructure.StackAndQueue;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
//        ArrayStack<Integer> stack = new ArrayStack<>();
//
//        for (int i = 0; i < 5; i++) {
//            stack.push(i);
//            System.out.println(stack);
//        }
//
//        stack.pop();
//        System.out.println(stack);

//        ArrayQueue<Integer> queue = new ArrayQueue<>();
//        for (int i = 0; i < 20; i++) {
//            queue.enqueue(i);
//            System.out.println(queue);
//
//            if (i % 3 == 2) {
//                queue.dequeue();
//                System.out.println(queue);
//            }
//        }

        int opCount = 1000000;
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double timeArrQ = testQueue(arrayQueue, opCount);

        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double timeLooQ = testQueue(loopQueue, opCount);

        System.out.println("ArrayQueue, time: " + timeArrQ + "s");
        System.out.println("LoopQueue, time: " + timeLooQ);

    }

    public static double testQueue(Queue<Integer> q, int opCount) {
        long start = System.currentTimeMillis();

        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        }

        for (int i = 0; i < opCount; i++) {
            q.dequeue();
        }

        long end = System.currentTimeMillis();
        return (end - start) / 1000000.0;
    }
}
