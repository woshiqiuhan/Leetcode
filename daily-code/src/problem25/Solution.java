package problem25;

/**
 * @Description: TODO
 * @author: qiuhan
 * @date: 2021/07/11 6:20 下午
 */
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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        int len = 0;
        ListNode pMove = head;
        while (pMove != null) {
            pMove = pMove.next;
            len++;
        }

        if (k > len || k == 1) {
            return head;
        }
        // 分 n 段，然后剩余 m 个元素保持原样
        int n = len / k, m = len % k;

        pMove = head;
        ListNode resultList = null, resultPMove = null;
        // 截出每段单独反转
        for (int i = 0; i < n; i++) {
            ListNode presentList = pMove;
            for (int j = 0; j < k - 1; j++) {
                pMove = pMove.next;
            }
            ListNode tmp = pMove.next;
            pMove.next = null;
            pMove = tmp;
            presentList = reverseList(presentList);
            if (i == 0) {
                resultList = presentList;
                resultPMove = resultList;
            } else {
                resultPMove.next = presentList;
            }
            while (resultPMove.next != null) {
                resultPMove = resultPMove.next;
            }
            if (i == n - 1) {
                resultPMove.next = pMove;
                pMove.next = null;
            }
        }
        return resultList;
    }

    // 链表反转
    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prePMove = head, pMove = head.next, postPMove = pMove.next;
        pMove.next = prePMove;
        prePMove.next = null;

        if (postPMove == null) {
            return pMove;
        }

        prePMove = pMove;
        pMove = postPMove;
        postPMove = postPMove.next;

        while (pMove != null) {
            pMove.next = prePMove;
            prePMove = pMove;
            pMove = postPMove;
            if (postPMove != null) {
                postPMove = postPMove.next;
            }
        }
        return prePMove;
    }

    private void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        Solution solution = new Solution();
        head = solution.reverseKGroup(head, 2);

        // head = solution.reverseList(head);
        solution.printList(head);
    }
}