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
 * Solution WITHOUT dummyHead
 */
public class LeetCodeSolution_1_203 {
    public ListNode removeElements(ListNode head, int val) {
//        ListNode node;

        while (head != null && head.val == val) {
            /*node = head;
            head = head.next;
            node.next = null;*/

            head = head.next;
        }

        if (head == null) {
            return head;
        }

        for (ListNode cur = head; cur.next != null; ) {
            if (cur.next.val == val) {
                /*node = cur.next;
                cur.next = node.next;
                node.next = null;*/
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 4, 5, 6, 7, 8, 9};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = (new LeetCodeSolution_1_203()).removeElements(head, 4);
        System.out.println(res);
    }
}
