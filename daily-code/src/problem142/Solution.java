package problem142;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode fast = head;
        ListNode low = head;

        while (fast != null && fast.next != null) {
            low = low.next;
            fast = fast.next.next;

            if (fast == low) {
                ListNode tmp = head;
                while (tmp != low) {
                    tmp = tmp.next;
                    low = low.next;
                }
                return tmp;
            }
        }
        return null;
    }
}