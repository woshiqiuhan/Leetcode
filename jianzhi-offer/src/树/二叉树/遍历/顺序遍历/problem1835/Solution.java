package 树.二叉树.遍历.顺序遍历.problem1835;

import 树.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 剑指 Offer 32 - II. 从上到下打印二叉树 II
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        int last = 1;
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> tmpList = new ArrayList<>();
            int tmpLast = 0;
            for (int i = 0; i < last; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    tmpList.add(node.val);

                    if (node.left != null) {
                        queue.offer(node.left);
                        tmpLast++;
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                        tmpLast++;
                    }
                }
            }
            last = tmpLast;
            list.add(tmpList);
        }
        return list;
    }
}