package 树.二叉树.遍历.顺序遍历.problem1836;

import 树.common.TreeNode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;

/**
 * 剑指 Offer 32 - III. 从上到下打印二叉树 III
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new LinkedList<>();
        if (root == null) {
            return list;
        }

        ArrayDeque<TreeNode> queue = new ArrayDeque<>();

        int last = 1;
        // 标识是奇数行还是偶数行
        boolean isOdd = true;
        queue.offer(root);
        while (!queue.isEmpty()) {
            LinkedList<Integer> tmpList = new LinkedList<>();
            int tmpLast = 0;
            for (int i = 0; i < last; i++) {
                TreeNode node = queue.poll();
                if (isOdd) { // 如果是奇数行
                    tmpList.addLast(node.val);
                } else { // 如果是偶数行当
                    tmpList.addFirst(node.val);
                }

                if (node.left != null) {
                    queue.offer(node.left);
                    tmpLast++;
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    tmpLast++;
                }
            }
            isOdd = !isOdd;
            last = tmpLast;
            list.add(tmpList);
        }
        return list;
    }
}