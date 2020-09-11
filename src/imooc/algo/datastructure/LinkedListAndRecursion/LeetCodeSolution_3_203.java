package imooc.algo.datastructure.LinkedListAndRecursion;

public class LeetCodeSolution_3_203 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        ListNode res = removeElements(head.next, val);
        if (head.val == val) {
            return res;
        } else {
            head.next = res;
            return head;
        }
    }

    public static void main(String[] args) {

    }
}
