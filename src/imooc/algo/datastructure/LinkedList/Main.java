package imooc.algo.datastructure.LinkedList;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();

        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }

        linkedList.add(2, 123, 's');
        System.out.println(linkedList);

        linkedList.remove(2);
        System.out.println(linkedList);

        linkedList.removeFirst();
        System.out.println(linkedList);

        linkedList.removeLast();
        System.out.println(linkedList);

        System.out.println("-------------------------------------------");

        // stack test
//        ArrayStack<Integer> arrayStack = new ArrayStack<>();
//        LinkedListStack<Integer> listStack = new LinkedListStack<>();
//        System.out.println(testStack(arrayStack, 100000) + "ms");
//        System.out.println(testStack(listStack, 100000) + "ms");
    }

    public static double testStack(Stack<Integer> stack, int opCount) {
        long start = System.currentTimeMillis();

        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            stack.pop();
        }
        long end = System.currentTimeMillis();
        return (end - start);
    }
}
