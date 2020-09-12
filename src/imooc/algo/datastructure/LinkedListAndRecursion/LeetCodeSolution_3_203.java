/**
 * Qn 203
 * Remove all elements from a linked list of integers that have value val.
 *
 * Example:
 *
 * Input:  1->2->6->3->4->5->6, val = 6
 * Output: 1->2->3->4->5
 */
package imooc.algo.datastructure.LinkedListAndRecursion;

/**
 * An recursive method implementation
 */
public class LeetCodeSolution_3_203 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }

//      ListNode res = removeElements(head.next, val);
        head.next = removeElements(head.next, val);
//        if (head.val == val) {
//            return res;
//        } else {
//            head.next = res;
//            return head;
//        }

        return head.val == val ? head.next : head;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 4, 5, 6, 7, 8, 9};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = (new LeetCodeSolution_2_203()).removeElements(head, 4);
        System.out.println(res);
    }
}
