package 树链表.problem1840;

import java.util.ArrayDeque;
import java.util.Queue;

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}

class Solution {
    public Node treeToDoublyList(Node root) {
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.addLast(root);

        while (!queue.isEmpty()) {
            Node last = queue.getLast();
            Node left = last.left;
            if (left != null) {

            }
        }
        return null;
    }
}