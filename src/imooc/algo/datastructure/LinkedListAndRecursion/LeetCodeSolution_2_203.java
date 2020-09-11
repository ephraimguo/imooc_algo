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
 * Solution WITH dummyHead
 */
public class LeetCodeSolution_2_203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-999);

        dummyHead.next = head;
        for (ListNode cur = dummyHead; cur.next != null; ) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 4, 5, 6, 7, 8, 9};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = (new LeetCodeSolution_2_203()).removeElements(head, 4);
        System.out.println(res);
    }
}
