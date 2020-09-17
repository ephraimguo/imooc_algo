package self.algo.leetcode;

/*
*
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 * */

public class Leetcode_783_Solution {
    private class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    int ans;
    public int minDiffInBST(TreeNode root) {
        ans = root.val;
        inOrder(root);
        return ans;
    }

    public void inOrder(TreeNode node) {
        if(node == null) {
            return;
        }

        inOrder(node.left);
        process(node);
        inOrder(node.right);
    }

    public int process(TreeNode node) {
        if(node.left == null && node.right == null) {
            return ans;
        } else if (node.left == null && node.right != null) {
            int newAns = Math.abs(node.val - node.right.val);
            return Math.min(ans, newAns);

        } else if (node.left != null && node.right == null) {
            int newAns = Math.abs(node.val - node.left.val);
            return Math.min(ans, newAns);

        } else {
            int newAns1 = Math.abs(node.val - node.left.val);
            int newAns2 = Math.abs(node.val - node.right.val);

            int newAns = Math.min(newAns1, newAns2);
            return Math.min(ans, newAns);
        }

    }
}
