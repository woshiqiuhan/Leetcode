package problem160;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

/**
 * 要点：  A + B = B + A
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pMoveA = headA;
        ListNode pMoveB = headB;
        while (pMoveA != pMoveB) {
            pMoveA = pMoveA != null ? pMoveA.next : headB;
            pMoveB = pMoveB != null ? pMoveB.next : headA;
        }
        return pMoveA;
    }
}