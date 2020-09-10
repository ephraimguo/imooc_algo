package imooc.algo.datastructure.HereIsArray;

public class Main {
    public static void main(String[] args) {
        DynamicArray<Integer> arr = new DynamicArray<>();
        for (int i = 0; i < 10; i++) {
            arr.addLast(i);
        }

        System.out.println(arr);

        for (int i = 0; i < 100; i++) {
            arr.addLast(i);
        }
        System.out.println(arr);

        for (int i = 0; i < 100; i++) {
            arr.removeLast();
        }
        System.out.println(arr);

    }
}
