package self.algo.leetcode;

import java.util.Set;

public class Leetcode_141_Solution {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

        @Override
        public String toString() {
            return String.valueOf(this.val);
        }
    }

    public ListNode findTail(ListNode node, ListNode cur) {
        if (node == null) {
            return null;
        }

        if (node.next == null) {
            return null;
        }

        if (node.next.val == cur.val) {
            System.out.println("found!");
            return node;
        }

        return findTail(node.next, cur);
    }

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode cur = head;
        ListNode tail = null;
        while (cur.next != null) {
            tail = findTail(cur, cur);
            if (tail == null) {
                return false;
            }

            if (cur.val == tail.val) {
                return true;
            }

            cur = cur.next;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = head.next;

        System.out.println(new Leetcode_141_Solution().findTail(head, head));

    }
}
