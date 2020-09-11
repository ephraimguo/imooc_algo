package imooc.algo.datastructure.LinkedListAndRecursion;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        this.val = x;
    }

    // LinkedList Node contructor
    public ListNode(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Fail to run contructor, invalid arr");
        }

        this.val = arr[0];
        ListNode cur = this;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
    }

    // Use 'this' as head
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ListNode ").append("\nhead >|");

        for (ListNode cur = this; cur.next != null; cur = cur.next) {
            sb.append(cur.val).append("->");
        }

        sb.append("|< tail");
        return sb.toString();
    }
}
