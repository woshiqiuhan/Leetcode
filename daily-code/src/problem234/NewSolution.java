package problem234;

public class NewSolution {
    private boolean isOdd;

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        this.isOdd = false;
        ListNode l = head, r = findMid(head);

        r = reverse(r);
        ListNode lPMove = l, rPMove = r;
        while (rPMove != null) {
            System.out.println(lPMove.val + " " + rPMove.val);
            lPMove = lPMove.next;
            rPMove = rPMove.next;
        }
        return false;
    }

    private ListNode reverse(ListNode r) {
        if (r.next == null) return r;
        ListNode preMove = r, pMove = r.next;
        preMove.next = null;
        for (; ; ) {
            ListNode tmp = pMove.next;
            pMove.next = preMove;
            preMove = pMove;
            if (tmp == null) {
                break;
            }
            pMove = tmp;
        }
        return null;
    }

    private ListNode findMid(ListNode head) {
        ListNode solw = head, fast = head;
        while (fast != null) {
            solw = solw.next;
            fast = fast.next.next;
            if (fast.next == null) {
                this.isOdd = true;
                return solw.next;
            }
        }
        return solw;
    }
}