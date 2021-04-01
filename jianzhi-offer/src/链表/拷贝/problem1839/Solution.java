package 链表.拷贝.problem1839;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Node {
    public int val;
    public Node next;
    public Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

/**
 * 剑指 Offer 35. 复杂链表的复制
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，
 * 每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 */
class Solution {
    public Node copyRandomList(Node head) {
        // Node res = copyList(head);
        if (head == null) {
            return head;
        }
        List<Node> oldList = getNodeList(head);
        List<Node> resList = new ArrayList<>(oldList.size());
        int n = oldList.size();
        for (int i = 0; i < n; i++) {
            resList.add(new Node(oldList.get(i).val));
        }
        for (int i = 0; i < n; i++) {
            Node node = resList.get(i);
            node.next = i == n - 1 ? null : resList.get(i + 1);
            if (oldList.get(i).random == null) {
                continue;
            }
            node.random = resList.get(oldList.indexOf(oldList.get(i).random));
        }

        return resList.get(0);
    }

    // 普通神拷贝
    private Node copyList(Node head) {
        if (head == null) {
            return null;
        }
        // 新链表
        Node newHead = new Node(head.val);
        Node pMove = head.next; // 原链表的移动指针
        Node newPMove = newHead; // 新链表当移动指针
        while (pMove != null) {
            newPMove.next = new Node(pMove.val);

            newPMove = newPMove.next;
            pMove = pMove.next;
        }
        return newHead;
    }

    private List<Node> getNodeList(Node head) {
        List<Node> list = new ArrayList<>();

        while (head != null) {
            list.add(head);
            head = head.next;
        }
        return list;
    }
}