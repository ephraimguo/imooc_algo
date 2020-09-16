package imooc.algo.datastructure.binarytree;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        BST<Integer> bst = new BST<>();

        int[] nums = {5, 3, 6, 8, 4, 2};
        for (int num: nums) {
            bst.add(num);
        }

//        bst.preorderTraversal();
//        bst.preorderTravelsalNR();
//        bst.inorderTraversal();
//        bst.inorderTraversalNR();
//        bst.postorderTraversal();
//        System.out.println(bst);

        System.out.println("---------");

        bst.levelOrder();
        System.out.println("---------");

        System.out.println(bst.minimum());
        System.out.println(bst.maximum());

        bst.removeMin();
        System.out.println(bst.minimum());
        System.out.println(bst.maximum());
        bst.levelOrder();

        bst.removeMin();
        System.out.println(bst.minimum());
        System.out.println(bst.maximum());
        bst.levelOrder();
    }
}
