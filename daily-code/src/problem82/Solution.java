package problem82;

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

        ListNode res = new ListNode(-1);
        ListNode resMove = res;
        ListNode pMove = head;

        while (pMove != null) {
            int cnt = 1;
            ListNode tmp = pMove;
            while (pMove.next != null && pMove.val == pMove.next.val) {
                pMove = pMove.next;
                cnt++;
            }
            System.out.println(cnt);
            if (cnt == 1) {
                resMove.next = tmp;
                resMove = resMove.next;
            }
            pMove = pMove.next;
        }
        return res.next;
    }
}