package imooc.algo.structures.binarysearch;

public class PrintReverse {
    public static void main(String[] args) {
        String test = "abcdefg";

        System.out.println(test.length());

        int idx = 0;

        printR(test, 0);
    }

    public static void printR(String str, int idx) {
        if (idx >= str.length()) {
            System.out.println("done");
            return;
        }

        printR(str, idx+1 );
        System.out.println(str.charAt(idx));

    }

}
