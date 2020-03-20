package imooc.algo.structures.binarysearch;

public class Main2 {
    public static void main(String[] args) {
        BST<Integer, Integer> bst = new BST<>();

        int N = 10;
        int M = 100;

        for (int i = 0; i < N; i++) {
            Integer key = (int)(Math.random() * M);

            bst.insert(key, key);
            System.out.print(key + " ");
        }

        System.out.println();

        System.out.println("size: " + bst.size());
        System.out.println();

        System.out.println("preOrder");
        bst.preorderTraverse();
        System.out.println();

        System.out.println("inOrder");
        bst.inorderTraverse();
        System.out.println();

        System.out.println("postOrder");
        bst.preorderTraverse();
        System.out.println();

        System.out.println("level order");
        bst.levelOrder();
        System.out.println();
    }
}
