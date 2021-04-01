package 链表.拷贝.problem1839;

public class SolutionBetter {
    public Node copyRandomList(Node head) {
        /**
         * 首先将链表原地复制一遍
         * eg:
         *      old: 1 -> 2 -> 3 -> 5
         *      new: 1 -> 1 -> 2 -> 2 -> 3 -> 3 -> 5 -> 5
         */
        Node pMove = head;
        while (pMove != null) {
            Node node = new Node(pMove.val);
            node.next = pMove.next;
            pMove.next = node;
            pMove = node.next;
        }
        pMove = head;

        // 赋值 random 指针
        while (pMove != null) {
            Node next = pMove.next;
            if (pMove.random != null) {
                next.random = pMove.random.next;
            }
            pMove = next.next;
        }

        // 拆分链表
        Node copyHead = head.next;
        pMove = copyHead;
        while (pMove != null && pMove.next != null) {
            head.next = pMove;
            head = head.next;
            pMove.next = pMove.next.next;
            pMove = pMove.next;
        }

        return copyHead;
    }
}
