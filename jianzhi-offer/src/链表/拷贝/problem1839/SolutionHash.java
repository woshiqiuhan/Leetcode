package 链表.拷贝.problem1839;

import com.sun.security.auth.UnixNumericUserPrincipal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionHash {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }

        Node pMove = head;
        Map<Node, Node> mp = new HashMap<>();
        // 拷贝节点
        while (pMove != null) {
            mp.put(pMove, new Node(pMove.val));
            pMove = pMove.next;
        }

        pMove = head;
        while (pMove != null) {
            Node node = mp.get(pMove);
            if (pMove.next != null) {
                node.next = mp.get(mp.get(pMove.next));
            }
            if (pMove.random != null) {
                node.random = mp.get(mp.get(pMove.random));
            }
            pMove = pMove.next;
        }
        return mp.get(head);
    }
}
