package imooc.algo.structures.binarysearch;

import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        // System.out.println(System.getProperty("user.dir"));
        String bible = "/Users/ephraim/IntellijProj/imooc_algo_bobo/src/imooc/algo/structures/binarysearch/bible.txt";

        Vector<String> words = new Vector<>();

        if (FileOperation.readFile(bible, words)) {
            System.out.println("There are totally " + words.size() + " words in " + bible);
            System.out.println();

            long startTs = System.currentTimeMillis();


            BST<String, Integer> bst = new BST<>();

            for (String word : words) {
                Integer res = bst.search(word);
                if (res == null) {
                    bst.insert(word, 1);

                } else {
                    bst.insert(word, res + 1);

                }
            }

            if (bst.contain("god")) {
                System.out.println("'god' : " + bst.search("god"));

            } else {
                System.out.println("No word 'god' in " + bible);

            }

            long endTime = System.currentTimeMillis();

            System.out.println("SST , time: " + (endTime - startTs) + "ms.");

        } else {
            System.out.println("file not existing");

        }
        BST<Integer, Integer> bst = new BST<Integer, Integer>();

    }
}
