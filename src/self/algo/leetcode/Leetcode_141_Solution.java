package self.algo.leetcode;

import java.util.HashSet;
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

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        Set<ListNode> nodeSet = new HashSet<>();
        while (head.next != null) {
            if (nodeSet.contains(head.next)) {
                return true;
            } else {
                nodeSet.add(head.next);
            }

            head = head.next;
        }

        return false;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = head.next;
    }
}
