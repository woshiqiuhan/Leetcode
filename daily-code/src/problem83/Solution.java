package problem83;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode pMove = head;
        while (pMove != null) {
            ListNode tmp = pMove;
            while (tmp != null && tmp.val == pMove.val) {
                tmp = tmp.next;
            }
            pMove.next = tmp;
            pMove = pMove.next;
        }
        return head;
    }
}